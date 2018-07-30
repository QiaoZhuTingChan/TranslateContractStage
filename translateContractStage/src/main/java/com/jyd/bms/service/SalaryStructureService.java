package com.jyd.bms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.SalaryItem;
import com.jyd.bms.bean.SalaryStructure;
import com.jyd.bms.dao.SalaryItemDAO;
import com.jyd.bms.dao.SalaryStructureDAO;
import com.jyd.bms.tool.GenerateCode;
import com.jyd.bms.tool.exception.DAOException;

@Service("SalaryStructureService")
public class SalaryStructureService extends BaseService<SalaryStructure> {

	private SalaryStructure salaryStructure;

	@Autowired(required = true)
	private SalaryStructureDAO salaryStructureDAO;
	@Autowired(required = true)
	private SalaryItemDAO salaryItemDAO;

	// 获取记录条数
	public int getSalaryStructureCount(String condition) throws DAOException {
		return salaryStructureDAO.getSalaryStructureCount(condition);
	}

	// 分页
	public List<SalaryStructure> getPagingSalaryStructure(int firstResult, int maxResults, String condition)
			throws DAOException {
		return salaryStructureDAO.getPagingSalaryStructure(firstResult, maxResults, condition);
	}

	// 获取所有记录
	public List<SalaryStructure> getAllSalaryStructure() throws DAOException {
		return salaryStructureDAO.getAllSalaryStructure();
	}

	/*
	 * 导出excel表
	 */
	public List<SalaryItem> getSalaryItemByformula(SalaryStructure salaryStructure) throws DAOException {
		List<SalaryItem> listAllSalaryItem = salaryItemDAO.getAll();
		Map<String, SalaryItem> mapSalaryItem = new HashMap<String, SalaryItem>();
		for (SalaryItem salaryItem : listAllSalaryItem) {
			mapSalaryItem.put(salaryItem.getCode(), salaryItem);
		}
		List<SalaryItem> listResult = new ArrayList<SalaryItem>();
		/* 取薪资算法公式 */
		String formula = salaryStructure.getFormula();

		Map<String, SalaryItemDTO> mapSalaryItemDTO = new HashMap<String, SalaryItemDTO>();
		Map<String, String> mapCode = new HashMap<String, String>();
		List<String> listCode = GenerateCode.analyzeSpecialCode(formula);

		/* 分析算法包括的薪资项目,展开到最底层 */
		for (String code : listCode) {
			findChildCode(code, mapSalaryItem, mapSalaryItemDTO, mapCode);
		}
		/* 分析出计算优先级 */
		Map<String, SalaryItemPriority> mapSalaryItemPriority = new HashMap<String, SalaryItemPriority>();
		for (String code : mapCode.keySet()) {
			SalaryItemPriority salaryItemPriority = new SalaryItemPriority();
			salaryItemPriority.setCode(code);
			salaryItemPriority.setIndex(0);
			mapSalaryItemPriority.put(code, salaryItemPriority);
		}

		int index = 1;
		while (index < 100) {
			boolean find = false;
			String tempCode = "";
			for (String code : mapCode.keySet()) {
				tempCode = code;
				if (mapSalaryItem.get(code).getOperation() == 0) {
					find = true;
					mapCode.remove(code);
					if (mapSalaryItemDTO.containsKey(code))
						mapSalaryItemDTO.remove(code);
					break;
				}

				if (mapSalaryItemDTO.get(code).getMapCode().size() == 0) {
					find = true;
					mapCode.remove(code);
					if (mapSalaryItemDTO.containsKey(code)) {
						mapSalaryItemDTO.remove(code);
					}
					break;
				}
			}

			mapSalaryItemPriority.get(tempCode).setIndex(index);

			listResult.add(mapSalaryItem.get(tempCode));

			for (String code : mapCode.keySet()) {
				if (mapSalaryItemDTO.get(code) != null)
					if (mapSalaryItemDTO.get(code).getMapCode().containsKey(tempCode)) {
						SalaryItemDTO salaryItemDTO = mapSalaryItemDTO.get(code);
						salaryItemDTO.getMapCode().remove(tempCode);
					}
			}

			index++;
			if (mapSalaryItemDTO.isEmpty() == true)
				break;
		}

		return listResult;
	}

	@Override
	public void setDAO() {
		this.baseDAO = salaryStructureDAO;
	}

	class SalaryItemDTO {
		private String code;
		private Map<String, String> mapCode = new HashMap<String, String>();

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public Map<String, String> getMapCode() {
			return mapCode;
		}

		public void setMapCode(Map<String, String> mapCode) {
			this.mapCode = mapCode;
		}
	}

	private void findChildCode(String code, Map<String, SalaryItem> mapSalaryItem,
			Map<String, SalaryItemDTO> mapSalaryItemDTO, Map<String, String> mapCode) {
		SalaryItem salaryItem = mapSalaryItem.get(code);

		List<String> listCode = GenerateCode
				.analyzeSpecialCode(salaryItem.getFormula() == null ? "" : salaryItem.getFormula());

		SalaryItemDTO salaryItemDTO = new SalaryItemDTO();
		salaryItemDTO.setCode(code);

		Map<String, String> mapTempSalaryItemDTO = new HashMap<String, String>();
		for (String tempCode : listCode) {
			mapTempSalaryItemDTO.put(tempCode, tempCode);
		}

		salaryItemDTO.setMapCode(mapTempSalaryItemDTO);

		mapSalaryItemDTO.put(code, salaryItemDTO);

		mapCode.put(code, code);

		for (String tempCode : listCode) {
			if (mapCode.containsKey(tempCode))
				continue;
			else
				mapCode.put(tempCode, tempCode);

			if (mapSalaryItem.get(tempCode).getOperation() == 0) {
				continue;
			}
			findChildCode(tempCode, mapSalaryItem, mapSalaryItemDTO, mapCode);
		}
	}

	class SalaryItemValue {
		private String code;
		private double value;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public double getValue() {
			return value;
		}

		public void setValue(double value) {
			this.value = value;
		}
	}

	class SalaryItemPriority {
		private String code;
		private int index;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}
	}

}
