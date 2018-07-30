package com.jyd.bms.tool.hui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIUtil {
	private XSSFWorkbook workbook2007 = null; // WorkBook对象
	private XSSFSheet sheet2007 = null; // Sheet对象

	private HSSFWorkbook workbook2003 = null;
	private HSSFSheet sheet2003 = null;

	public boolean type = false;

	private String filePath = null;

	/**
	 * 创建工作薄
	 * 
	 * @param filePath
	 *            文件路径
	 */
	public void createWorkbook(String filePath) {
		if (isExcel2007(filePath))
			type = true;
		this.filePath = filePath;
		if (type) {
			workbook2007 = new XSSFWorkbook();
			sheet2007 = workbook2007.createSheet();
		} else {
			workbook2003 = new HSSFWorkbook();
			sheet2003 = workbook2003.createSheet();
		}
	}

	
	
	
	
	/**
	 * 保存数据
	 * 
	 * @param filePath
	 *            路径
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void save() throws FileNotFoundException, IOException {
		if (type)
			workbook2007.write(new FileOutputStream(filePath));
		else
			workbook2003.write(new FileOutputStream(filePath));
	}

	public int getTotalSheet() {
		return type ? workbook2007.getNumberOfSheets() : workbook2003.getNumberOfSheets();
	}

	public XSSFWorkbook getWorkbook() {
		return workbook2007;
	}

	public void setWorkbook(XSSFWorkbook workbook) {
		this.workbook2007 = workbook;
	}

	public XSSFSheet getSheet2007() {
		return sheet2007;
	}

	public void setSheet2007(XSSFSheet sheet) {
		this.sheet2007 = sheet;
	}

	public HSSFSheet getSheet2003() {
		return sheet2003;
	}

	public void setSheet2003(HSSFSheet sheet) {
		this.sheet2003 = sheet;
	}

	/**
	 * 打开文件
	 * 
	 * @param Excel文件路径
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public void openFile(String filePath) throws InvalidFormatException, IOException {
		if (isExcel2007(filePath)) {
			workbook2007 = new XSSFWorkbook(OPCPackage.open(filePath));
			sheet2007 = workbook2007.getSheetAt(0);
			type = true;
		} else if (isExcel2003(filePath)) {
			workbook2003 = new HSSFWorkbook(new FileInputStream(filePath));
			sheet2003 = workbook2003.getSheetAt(0);
		}
	}

	/**
	 * 
	 * @描述：是否是2003的excel，返回true是2003
	 * 
	 * @返回值：boolean
	 */
	public static boolean isExcel2003(String filePath) {
		return filePath.matches("^.+\\.(?i)(xls)$");
	}

	/**
	 * 
	 * @描述：是否是2007的excel，返回true是2007
	 * 
	 * @返回值：boolean
	 */

	public static boolean isExcel2007(String filePath) {
		return filePath.matches("^.+\\.(?i)(xlsx)$");
	}

	/**
	 * 按序号选择表格
	 * 
	 * @param index
	 */
	public void setSheet(int index) {
		if (type)
			sheet2007 = workbook2007.getSheetAt(index);
		else
			sheet2003 = workbook2003.getSheetAt(index);
	}

	/**
	 * 按名称选择表格
	 * 
	 * @param name
	 */
	public void setSheet(String name) {
		if (type)
			sheet2007 = workbook2007.getSheet(name);
		else
			sheet2003 = workbook2003.getSheet(name);
	}

	/**
	 * 获取表格名称
	 * 
	 * @return
	 */
	public String getSheetName() {
		if (type) {
			if (sheet2007 != null)
				return sheet2007.getSheetName();
			else
				return "";
		} else {
			if (sheet2003 != null)
				return sheet2003.getSheetName();
			else
				return "";
		}
	}

	public Row getRow(int rowIndex) {
		Row row = type == true ? sheet2007.getRow(rowIndex) : sheet2003.getRow(rowIndex);
		return row;
	}

	public Row createRow(int rowIndex) {
		Row row = null;
		if (type)
			row = sheet2007.createRow(rowIndex);
		else
			row = sheet2003.createRow(rowIndex);
		return row;
	}

	/**
	 * 获取Boolean数据
	 * 
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 */
	public Boolean getBooleanValue(int rowIndex, int columnIndex) {
		Row row = type == true ? sheet2007.getRow(rowIndex) : sheet2003.getRow(rowIndex);
		if (row == null)
			return null;
		Cell cell = row.getCell(columnIndex);
		if (cell == null)
			return null;

		return cell.getBooleanCellValue();
	}

	/**
	 * 获取时间数据
	 * 
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 */
	public Date getDateValue(int rowIndex, int columnIndex) {
		Row row = type == true ? sheet2007.getRow(rowIndex) : sheet2003.getRow(rowIndex);
		if (row == null)
			return null;
		Cell cell = row.getCell(columnIndex);
		if (cell == null)
			return null;

		return cell.getDateCellValue();
	}

	public Map<String, Object> getNumericValueOrTextValue(int rowIndex, int columnIndex){
		Map<String, Object> map = new HashMap<>();
		Row row = type == true ? sheet2007.getRow(rowIndex) : sheet2003.getRow(rowIndex);
		if (row == null)
			return null;
		Cell cell = row.getCell(columnIndex);
		if (cell == null) {
			return null;
		}else {
			if(cell.getCellType()==cell.CELL_TYPE_NUMERIC) {
				map.put("typeKey", cell.getDateCellValue());
			}else
			if(cell.getCellType()==cell.CELL_TYPE_STRING) {
				map.put("typeKey", cell.getStringCellValue());
			}else {
				map = null;
			}
		}
		return map;
	}
	
	
	
	/**
	 * 获取文本数据
	 * 
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 */
	public String getStringValue(int rowIndex, int columnIndex) {
		Row row = type == true ? sheet2007.getRow(rowIndex) : sheet2003.getRow(rowIndex);
		if (row == null)
			return null;
		Cell cell = row.getCell(columnIndex);
		if (cell == null)
			return null;

		return cell.getStringCellValue();
	}

	/**
	 * 获取数字类型数据
	 * 
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 */
	public Double getDoubleValue(int rowIndex, int columnIndex) {
		Row row = type == true ? sheet2007.getRow(rowIndex) : sheet2003.getRow(rowIndex);
		if (row == null)
			return null;
		Cell cell = row.getCell(columnIndex);
		if (cell == null)
			return null;

		return cell.getNumericCellValue();
	}

	/**
	 * 获取富文本类型数据
	 * 
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 */
	public RichTextString getRichTextStringValue(int rowIndex, int columnIndex) {
		Row row = type == true ? sheet2007.getRow(rowIndex) : sheet2003.getRow(rowIndex);
		if (row == null)
			return null;
		Cell cell = row.getCell(columnIndex);
		if (cell == null)
			return null;

		return cell.getRichStringCellValue();
	}

	/**
	 * 关闭Excel
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException {
		if (type)
			workbook2007.close();
		else
			workbook2003.close();
	}
}
