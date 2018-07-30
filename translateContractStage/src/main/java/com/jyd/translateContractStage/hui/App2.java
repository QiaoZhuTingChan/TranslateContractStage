package com.jyd.translateContractStage.hui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jyd.bms.bean.ContractGpsLateFee;
import com.jyd.bms.bean.ContractLateFee;
import com.jyd.bms.bean.ContractLender;
import com.jyd.bms.bean.ContractPara;
import com.jyd.bms.bean.ContractRepayment;
import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.CusContractCost;
import com.jyd.bms.bean.CusContractRepaymentOtherFee;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.service.ContractGpsLateFeeService;
import com.jyd.bms.service.ContractLateFeeService;
import com.jyd.bms.service.ContractLenderService;
import com.jyd.bms.service.ContractParaService;
import com.jyd.bms.service.ContractRepaymentService;
import com.jyd.bms.service.ContractStageFeeService;
import com.jyd.bms.service.ContractStageService;
import com.jyd.bms.service.ContractVersionService;
import com.jyd.bms.service.CusContractCostService;
import com.jyd.bms.service.CusContractRepaymentOtherFeeService;
import com.jyd.bms.service.CustomerContractService;
import com.jyd.bms.service.DeleteDataService;
import com.jyd.bms.service.GpsCostTypeService;
import com.jyd.bms.service.MortgagerService;
import com.jyd.bms.service.ParkingFeeService;
import com.jyd.bms.service.ProductService;
import com.jyd.bms.service.RepaymentAccountService;
import com.jyd.bms.service.RepaymentStageService;
import com.jyd.bms.service.StoreLenderService;
import com.jyd.bms.service.StoreRepaymentAccountService;
import com.jyd.bms.service.StoreService;
import com.jyd.translateContractStage.POIUtil;

public class App2 {

	private static ClassPathXmlApplicationContext context;
	private static final String path = "/home/aa/Desktop/laoda/xuchang1.xls";

	//bean
	private static ContractStage contractStage;
	private static CustomerContract customerContract;
	private static ContractPara contractPara;
	
	// 集合
	private List<CustomerContract> customerContractList = new ArrayList<>();// 合同
	private List<ContractLender> contractLenderList = new ArrayList<>();
	private List<ContractPara> contractParaList = new ArrayList<>();// 参数
	private List<CusContractCost> cusContractCostList = new ArrayList<>();// 费用
	private List<ContractStage> contractStageList = new ArrayList<>();// 分期
	private List<ContractRepayment> contractRepaymentList = new ArrayList<>();// 还款
	private List<CusContractRepaymentOtherFee> cusContractRepaymentOtherFeeList = new ArrayList<>();
	private List<ContractGpsLateFee> contractGpsLateFeeList = new ArrayList<>();
	private List<ContractLateFee> contractLateFeeList = new ArrayList<>();

	// service
	private static CustomerContractService customerContractService;
	private static ContractStageService contractStageService;
	private static CusContractCostService cusContractCostService;
	private static ProductService productService;
	private static ContractParaService contractParaService;

	private static RepaymentStageService repaymentStageService;
	private static GpsCostTypeService gpsCostTypeService;
	private static ParkingFeeService parkingFeeService;
	private static ContractGpsLateFeeService contractGpsLateFeeService;
	private static StoreService storeService;
	private static ContractVersionService contractVersionService;

	private static StoreRepaymentAccountService storeRepaymentAccountService;
	private static ContractLateFeeService contractLateFeeService;
	private static ContractRepaymentService contractRepaymentService;

	private static ContractStageFeeService contractStageFeeService;
	private static MortgagerService mortgagerService;
	private static StoreLenderService storeLenderService;
	private static ContractLenderService contractLenderService;

	private static CusContractRepaymentOtherFeeService cusContractRepaymentOtherFeeService;
	private static RepaymentAccountService repaymentAccountService;
	private static DeleteDataService deleteDataService;

	static {
		// context = new ClassPathXmlApplicationContext("config/spring.xml");
	}

	private static void initService() {
		customerContractService = context.getBean(CustomerContractService.class);
		contractStageService = context.getBean(ContractStageService.class);
		cusContractCostService = context.getBean(CusContractCostService.class);
		productService = context.getBean(ProductService.class);
		contractParaService = context.getBean(ContractParaService.class);
		repaymentStageService = context.getBean(RepaymentStageService.class);
		gpsCostTypeService = context.getBean(GpsCostTypeService.class);
		parkingFeeService = context.getBean(ParkingFeeService.class);
		contractGpsLateFeeService = context.getBean(ContractGpsLateFeeService.class);
		contractVersionService = context.getBean(ContractVersionService.class);
		storeService = context.getBean(StoreService.class);
		mortgagerService = context.getBean(MortgagerService.class);
		storeRepaymentAccountService = context.getBean(StoreRepaymentAccountService.class);
		contractLateFeeService = context.getBean(ContractLateFeeService.class);
		contractRepaymentService = context.getBean(ContractRepaymentService.class);
		storeLenderService = context.getBean(StoreLenderService.class);
		contractLenderService = context.getBean(ContractLenderService.class);
		repaymentAccountService = context.getBean(RepaymentAccountService.class);
		contractStageFeeService = context.getBean(ContractStageFeeService.class);
		cusContractRepaymentOtherFeeService = context.getBean(CusContractRepaymentOtherFeeService.class);

		deleteDataService = context.getBean(DeleteDataService.class);
	}

	public static void main(String[] args) {
		App2 app = new App2();

		// initService();

		try {
			String contractFilePath = path;
			POIUtil input = app.initContractPOIUtil(contractFilePath);
			// 处理数据
			app.readContractData(input);
			input.close();
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public POIUtil initContractPOIUtil(String contractFilePath) throws InvalidFormatException, IOException {
		POIUtil poiUtil = new POIUtil();
		poiUtil.openFile(contractFilePath);
		return poiUtil;
	}

	public POIUtil initOutputPOIUtil(String outPutFilePath) {
		POIUtil poiUtil = new POIUtil();
		poiUtil.createWorkbook(outPutFilePath);
		return poiUtil;
	}

	public void readContractData(POIUtil input) throws InvalidFormatException, IOException {
		int totalSheet = input.getTotalSheet();
		int rowIndex = 0;

		for (int sheetNumber = 0; sheetNumber < totalSheet; sheetNumber++) {
			input.setSheet(sheetNumber);
			String sheetName = input.getSheetName();

			rowIndex = 0;

			String nowPosition = "";
			String contractNumber = "";
			int stage = 0;
			String contractno = "";// 合同编号

			int countstage = 0;// 校验分期

			for (; rowIndex < 5000; rowIndex++) {
				Row row = input.getRow(rowIndex);
				if (row == null) {
					continue;
				}
				/*
				 * System.out.print(sheetName+" 第"+rowIndex+"行"); for (int c = 0; c <
				 * row.getPhysicalNumberOfCells(); c++) {
				 * System.out.print("\t"+input.getValue(rowIndex, c)); } System.out.println();
				 */

				/**
				 * 封装数据
				 */
				String value = input.getValue(rowIndex, 0);
				if (value == null || value.equals("")) {
					continue;
				}

				// 找到合同编号位置，代表一个合同的开始
				if (value.trim().equals("合同编号")) {
					nowPosition = "合同编号";
					countstage = 0;
				} else if (value.trim().equals("合同分期")) {
					nowPosition = "合同分期";
					rowIndex += 2;
				} else if (value.trim().equals("还款明细")) {
					nowPosition = "还款明细";
					rowIndex += 2;

					if (stage != (countstage - 1)) {
						throw new RuntimeException("分期期数不匹配: " + stage + "--" + (countstage - 1));
					}
				}

				if (!nowPosition.equals("") && nowPosition.equals("合同编号")) {
					int contractnoRow = rowIndex + 1;
					int phoneRow = contractnoRow + 2;
					int brandRow = phoneRow + 2;

					// 封装数据////////////////////////////////////////////////////////
					System.out.print(sheetName + " " + contractnoRow + "\t" + nowPosition);
					for (int i = 0; i < 20; i++) {
						contractno = input.getValue(contractnoRow, 0);
						System.out.print("\t" + input.getValue(contractnoRow, i));
					}
					System.out.println();
					for (int i = 0; i < 20; i++) {
						stage = Integer.parseInt(input.getValue(phoneRow, 7));
						// stage = (int) Double.parseDouble(input.getValue(phoneRow, 7));
						System.out.print("\t" + input.getValue(phoneRow, i));
					}
					System.out.println();
					for (int i = 0; i < 20; i++) {
						System.out.print("\t" + input.getValue(brandRow, i));
					}
					System.out.println();
					
					/////////////////////////////////////////////////////////////////////

					rowIndex += 5;
				} else if (!nowPosition.equals("") && nowPosition.equals("合同分期")) {

					// 封装数据////////////////////////////////////////////////////////
					System.out.print(sheetName + " " + contractno + " " + rowIndex + "\t" + nowPosition);
					for (int j = 0; j < 10; j++) {
						System.out.print("\t" + input.getValue(rowIndex, j));
					}
					System.out.println();
					/////////////////////////////////////////////////////////////////////
					
					++countstage;

				} else if (!nowPosition.equals("") && nowPosition.equals("还款明细")) {
					System.out.print(sheetName + " " + contractno + " " + rowIndex + "\t" + nowPosition);

					// 封装数据////////////////////////////////////////////////////////
					for (int i = 0; i < 6; i++) {
						if(contractno.equals("03742020170821-1")) {
							System.out.print("");
						}
						System.out.print("\t" + input.getValue(rowIndex, i));
					}
					/////////////////////////////////////////////////////////////////////
					System.out.println();
				}

				/**
				 * 测试数据
				 */
				/*
				 * if (!nowPosition.equals("") && nowPosition.equals("合同编号")) { int
				 * contractnoRow = rowIndex + 1; int phoneRow = contractnoRow + 2; int brandRow
				 * = phoneRow + 2;
				 * 
				 * //封装数据 System.out.print(sheetName+" "+contractnoRow+"\t"+nowPosition); for
				 * (int i = 0; i < 20; i++) { contractno = input.getValue(contractnoRow, 0);
				 * System.out.print("\t" + input.getValue(contractnoRow, i)); }
				 * System.out.println(); for (int i = 0; i < 20; i++) { stage =
				 * Integer.parseInt(input.getValue(phoneRow, 7)); // stage = (int)
				 * Double.parseDouble(input.getValue(phoneRow, 7)); System.out.print("\t" +
				 * input.getValue(phoneRow, i)); } System.out.println(); for (int i = 0; i < 20;
				 * i++) { System.out.print("\t" + input.getValue(brandRow, i)); }
				 * System.out.println(); //
				 * 
				 * rowIndex += 5; } else if (!nowPosition.equals("") &&
				 * nowPosition.equals("合同分期")) {
				 * 
				 * 
				 * System.out.print(sheetName+" "+contractno+" "+rowIndex+"\t"+nowPosition); for
				 * (int j = 0; j < 10; j++) { System.out.print("\t" + input.getValue(rowIndex,
				 * j)); } System.out.println();
				 * 
				 * ++countstage;
				 * 
				 * int stageFirstRow = rowIndex + 2;
				 * 
				 * for (int i = 0; i <= stage; i++) { //封装数据
				 * System.out.print(sheetName+" "+contractno+" "+(stageFirstRow+i)+"\t"+
				 * nowPosition); for (int j = 0; j < 10; j++) { System.out.print("\t" +
				 * input.getValue(stageFirstRow + i, j)); } System.out.println(); // }
				 * System.out.println();
				 * 
				 * rowIndex += 2 + stage; } else if (!nowPosition.equals("") &&
				 * nowPosition.equals("还款明细")) {
				 * System.out.print(sheetName+" "+contractno+" "+rowIndex+"\t"+nowPosition);
				 * 
				 * //封装数据 for (int i = 0; i < 6; i++) { System.out.print("\t" +
				 * input.getValue(rowIndex, i)); } // System.out.println(); }
				 */

			}

			// break;

			System.out.println("结束， 恭喜你没问题！！");
		}
	}
}
