package com.jyd.translateContractStage.hui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jyd.bms.bean.ContractGpsLateFee;
import com.jyd.bms.bean.ContractLender;
import com.jyd.bms.bean.ContractPara;
import com.jyd.bms.bean.ContractRepayment;
import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.ContractStageFee;
import com.jyd.bms.bean.ContractVersion;
import com.jyd.bms.bean.CostType;
import com.jyd.bms.bean.CusContractCost;
import com.jyd.bms.bean.CusContractRepaymentOtherFee;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.GpsCostType;
import com.jyd.bms.bean.Lender;
import com.jyd.bms.bean.Mortgager;
import com.jyd.bms.bean.ParkingFee;
import com.jyd.bms.bean.ProductParameter;
import com.jyd.bms.bean.RepaymentStage;
import com.jyd.bms.bean.RepaymentType;
import com.jyd.bms.bean.Store;
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
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.translateContractStage.POIUtil;

public class App {

	private static final String logpath = "/home/aa/Desktop/laoda/logerror_zhengzhou2.txt";
	private static ClassPathXmlApplicationContext context;
	// private static final String path = "/home/aa/Desktop/laoda/xuchang1.xls";
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static final StringBuilder sb = new StringBuilder();
	private static final App app = new App();

	private String dateRegexp = "[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])";
	private String idCardRegexp = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";

	// bean
	private static CustomerContract customerContract;
	private static ContractStage contractStage;
	private static ContractPara contractPara;

	private static Map<String, Object> map = new HashMap<>();
	// 集合
	private static Set<CustomerContract> customerContractList = new HashSet<>();// 合同
	private static Set<ContractLender> contractLenderList = new HashSet<>();
	private static Set<ContractPara> contractParaList = new HashSet<>();// 参数
	private static Set<CusContractCost> cusContractCostList = new HashSet<>();// 费用
	private static Set<ContractStage> contractStageList = new HashSet<>();// 分期
	private static Set<ContractRepayment> contractRepaymentList = new HashSet<>();// 还款
	private static Set<CusContractRepaymentOtherFee> cusContractRepaymentOtherFeeList = new HashSet<>();
	private static Set<ContractGpsLateFee> contractGpsLateFeeList = new HashSet<>();
	private static Set<ContractStageFee> contractStageFeeList = new HashSet<>();// 合同分期费

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

	// 抽出数据库的数据
	// 还款类型
	private static int[] repaymentTypeArr = new int[] { 6, 7 };// 6:等额本息， 7：先息后本

	// 取费用id的数组
	private static int[] fee = new int[] { 1, 4, 13, 9, 3, 2, 8, 6, 7 };
	private static List<Double> feeValue = new ArrayList<>();

	private static Map<String, Integer> storeMap = new HashMap<>();
	private static Map<String, String[]> mortgager = new HashMap<String, String[]>();// 抵押人
	private static Map<String, String[]> repayAccount = new HashMap<String, String[]>();
	private static Map<Integer, Integer> stageMap = new HashMap();
	private static Map<Integer, Integer> lenderMap = new HashMap();// 出借人
	static {
		packagestoreMap();
		packagerepayAccount();
		packagemortgager();
		packagestageMap();
		packagelenderMap();

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

	private static void packagelenderMap() {
		// 门店id， 出借人id
		lenderMap.put(7, 1);
		// lenderMap.put(16, 1);//16：立刻贷二店 有两个出借人，这里先忽略
		// lenderMap.put(16, 2);
		lenderMap.put(9, 3);
		lenderMap.put(20, 1);
		lenderMap.put(18, 3);
		lenderMap.put(5, 2);
		lenderMap.put(10, 4);
		lenderMap.put(2, 4);
		lenderMap.put(4, 3);
		lenderMap.put(15, 3);
		lenderMap.put(12, 3);
		lenderMap.put(13, 3);
		lenderMap.put(3, 3);
		lenderMap.put(14, 3);
		lenderMap.put(8, 3);
		lenderMap.put(6, 3);
		lenderMap.put(21, 1);
		lenderMap.put(22, 1);
	}

	private static void packagestageMap() {
		stageMap.put(1, 1);// 期数， id
		stageMap.put(2, 2);
		stageMap.put(3, 3);
		stageMap.put(6, 4);
		stageMap.put(12, 5);
		stageMap.put(18, 6);
		stageMap.put(24, 7);
		stageMap.put(9, 8);
		stageMap.put(15, 9);
		stageMap.put(5, 10);
		stageMap.put(27, 11);
		stageMap.put(4, 12);
		stageMap.put(7, 13);
		stageMap.put(8, 14);
	}

	private static void packagemortgager() {
		String[] arr_guobiao = { "3", "91440300MA5DA69B6U", "深圳市前海深港合作区前湾一路1号A栋201室", "国标融资租赁（深圳）有限公司" };
		mortgager.put("国标", arr_guobiao);
	}

	private static void packagerepayAccount() {
		String[] acount_taiyuan = { "4", "李健康", "工行太原三营盘支行", "6222 0805 0200 2890 632" };
		String[] acount_xuchang = { "3", "李秀丽", "工行许昌分行", "6222 0817 0800 0231 484" };
		String[] acount_zhengzhou2 = { "5", "杨海峰", "工行郑州农业路支行", "6212261702030020440" };
		repayAccount.put("太原一店", acount_taiyuan);
		repayAccount.put("许昌一店", acount_xuchang);
		repayAccount.put("郑州二店", acount_zhengzhou2);
	}

	private static void packagestoreMap() {
		storeMap.put("联融公司", 1);
		storeMap.put("东莞二店", 2);
		storeMap.put("许昌一店", 3);
		storeMap.put("太原一店", 4);
		storeMap.put("广州一店", 5);
		storeMap.put("平顶山一店", 6);
		storeMap.put("立刻贷广州一店", 7);
		storeMap.put("南阳一店", 8);
		storeMap.put("郑州一店", 9);
		storeMap.put("东莞一店", 10);
		storeMap.put("p2p", 11);
		storeMap.put("驻马店一店", 12);
		storeMap.put("新乡一店", 13);
		storeMap.put("信阳一店", 14);
		storeMap.put("洛阳一店", 15);
		storeMap.put("立刻贷二店", 16);
		storeMap.put("总部", 17);
		storeMap.put("郑州二店", 18);
		storeMap.put("河南分中心", 19);
		storeMap.put("南宁一店", 20);
		storeMap.put("广州分中心", 21);
		storeMap.put("东莞分中心", 22);
	}

	public static boolean isExcelOk(String path) {
		boolean flag = false;
		try {
			String contractFilePath = path;
			POIUtil input = app.initContractPOIUtil(contractFilePath);
			// 处理数据
			flag = app.checkContractData(input);
			input.close();

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(logpath))));
			bw.write("===================需要校验内容：==============");
			bw.newLine();
			bw.write(sb.toString());
			bw.flush();
			bw.close();

			// System.out.println();
			// System.out.println();
			// System.out.println();
			// System.out.println();
			// System.out.println();
			// System.out.println();
			// System.out.println("===================需要校验内容：==============");
			// System.err.println(sb.toString());
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}

		return flag;
	}

	private boolean checkContractData(POIUtil input) {
		int countContract = 0;

		boolean flag = false;
		try {
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

					/**
					 * 封装数据
					 */
					String value = input.getValue(rowIndex, 0);
					if (value == null || value.equals("")) {
						continue;
					}

					// 找到合同编号位置，代表一个合同的开始
					if (value.trim().equals("合同编号")) {
						countContract++;

						nowPosition = "合同编号";
						countstage = 0;
					} else if (value.trim().equals("合同分期")) {
						nowPosition = "合同分期";
						rowIndex += 2;
					} else if (value.trim().equals("还款明细")) {
						nowPosition = "还款明细";
						rowIndex += 2;

						
						/////////////////////////////////////////////////////////////////////////////////////////
						if (stage != (countstage - 1)) {
							throw new RuntimeException("借款期限跟分期期数不匹配: " + stage + "--" + (countstage - 1));
						}
						
						
					}

					if (!nowPosition.equals("") && nowPosition.equals("合同编号")) {
						int contractnoRow = rowIndex + 1;
						int phoneRow = contractnoRow + 2;
						int brandRow = phoneRow + 2;

						/**
						 * contractnoRow
						 */
						// 封装数据////////////////////////////////////////////////////////
						System.out.print(sheetName + " " + contractnoRow + "\t" + nowPosition);

						
						
						
						for (int i = 0; i < 20; i++) {
							contractno = input.getValue(contractnoRow, 0);
							System.out.print("\t" + input.getValue(contractnoRow, i));
						}
						System.out.println();
						/**
						 * phoneRow
						 */
						for (int i = 0; i < 20; i++) {
							// stage = Integer.parseInt(input.getValue(phoneRow, 7));
							stage = (int) Double.parseDouble(input.getValue(phoneRow, 7));

							// if(input.getValue(phoneRow, 15).equals("")) {
							// System.out.println();
							// System.out.println(sheetName + " " + nowPosition + "\t" +
							// (phoneRow+1)+"\t"+contractno+" 的抵押权人不能为空！！");
							// throw new RuntimeException(sheetName + " " + nowPosition + "\t" +
							// (phoneRow+1)+"\t"+contractno+" 的抵押权人不能为空！！");
							// }
							System.out.print("\t" + input.getValue(phoneRow, i));
						}
						System.out.println();

						if (!input.getValue(phoneRow, 1).matches(idCardRegexp)) {

							sb.append(sheetName + "\t" + (phoneRow + 1) + "\t" + contractno + " 的身份证格式不对！！" + "\t"
									+ input.getValue(phoneRow, 1)).append("\n");
						}

						if (!input.getValue(phoneRow, 10).matches(dateRegexp)) {
							sb.append(sheetName + "\t" + (phoneRow + 1) + "\t" + contractno + " 的合同开始时间格式不对！！" + "\t"
									+ input.getValue(phoneRow, 10)).append("\n");
						}
						if (!input.getValue(phoneRow, 11).matches(dateRegexp)) {
							sb.append(sheetName + "\t" + (phoneRow + 1) + "\t" + contractno + " 的合同结束时间格式不对！！" + "\t"
									+ input.getValue(phoneRow, 11)).append("\n");
						}

						/**
						 * brandRow
						 */
						for (int i = 0; i < 20; i++) {
							System.out.print("\t" + input.getValue(brandRow, i));
						}
						System.out.println();

						if (!input.getValue(brandRow, 5).equals("")
								&& !input.getValue(brandRow, 5).matches("\\d+.\\d+")) {
							sb.append(sheetName + "\t" + (brandRow + 1) + "\t" + contractno + " 汽车购买价格格式不对！！" + "\t"
									+ input.getValue(brandRow, 5)).append("\n");
						}
						if (input.getValue(brandRow, 10).matches("(\\d{4})-(\\d{1,2})-(\\d{1,2})")) {
							sb.append(sheetName + "\t" + (brandRow + 1) + "\t" + contractno + " 的停车费为日期！！" + "\t"
									+ input.getValue(brandRow, 10)).append("\n");
						}
						if (input.getValue(brandRow, 11).matches("(\\d{4})-(\\d{1,2})-(\\d{1,2})")) {
							sb.append(sheetName + "\t" + (brandRow + 1) + "\t" + contractno + " 的查档费为日期！！" + "\t"
									+ input.getValue(brandRow, 11)).append("\n");
						}
						/////////////////////////////////////////////////////////////////////

						rowIndex += 5;
					} else if (!nowPosition.equals("") && nowPosition.equals("合同分期")) {

						// 封装数据////////////////////////////////////////////////////////
						System.out.print(sheetName + " " + contractno + " " + rowIndex + "\t" + nowPosition);
						for (int j = 0; j < 10; j++) {
							System.out.print("\t" + input.getValue(rowIndex, j));
						}
						System.out.println();
						
						if(roundHalfUp(input.getValue(rowIndex, 0))==stage) {
							if(roundHalfUp(input.getValue(rowIndex, 1))!=0) {
								sb.append(sheetName + "\t" + (rowIndex + 1) + "\t" + contractno + " 此合同编号的分期最后一期gps费不为0！！" + "\t"
										+ input.getValue(rowIndex, 1)).append("\n");
							}
							if(roundHalfUp(input.getValue(rowIndex, 2))!=0) {
								sb.append(sheetName + "\t" + (rowIndex + 1) + "\t" + contractno + " 此合同编号的分期最后一期停车费费不为0！！" + "\t"
										+ input.getValue(rowIndex, 2)).append("\n");
							}
						}
						/////////////////////////////////////////////////////////////////////

						++countstage;

					} else if (!nowPosition.equals("") && nowPosition.equals("还款明细")) {
						System.out.print(sheetName + " " + contractno + " " + rowIndex + "\t" + nowPosition);

						// 封装数据////////////////////////////////////////////////////////
						if (!input.getValue(rowIndex, 2).equals("")
								&& !input.getValue(rowIndex, 2).matches("\\d+.\\d+")) {
							sb.append(sheetName + "\t" + (rowIndex + 1) + "\t" + contractno + " 实还款金额格式不对！！" + "\t"
									+ input.getValue(rowIndex, 2)).append("\n");
						}
						for (int i = 0; i < 6; i++) {
							System.out.print("\t" + input.getValue(rowIndex, i));
						}
						/////////////////////////////////////////////////////////////////////
						System.out.println();
					}

				}

				// break;
			}
			System.out.println("结束， 恭喜你没问题！！");
			flag = true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		System.out.println("合同数：" + countContract);
		return flag;
	}

	/**
	 * @category map.put("customerContractList", customerContractList);
	 *           map.put("contractLenderList", contractLenderList);
	 *           map.put("contractParaList", contractParaList);
	 *           map.put("cusContractCostList", cusContractCostList);
	 *           map.put("contractStageList", contractStageList);
	 *           map.put("contractRepaymentList", contractRepaymentList);
	 *           map.put("cusContractRepaymentOtherFeeList",
	 *           cusContractRepaymentOtherFeeList);
	 *           map.put("contractGpsLateFeeList", contractGpsLateFeeList);
	 *           map.put("contractStageFeeList", contractStageFeeList);
	 * @return
	 * @throws DAOException
	 */
	public static Map<String, Object> getDateList(String path) throws DAOException {

		if (app != null) {
			try {
				String contractFilePath = path;
				POIUtil input = app.initContractPOIUtil(contractFilePath);
				// 处理数据
				app.readContractData(input);
				input.close();
			} catch (InvalidFormatException | IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		map.put("customerContractList", customerContractList);
		map.put("contractLenderList", contractLenderList);
		map.put("contractParaList", contractParaList);
		map.put("cusContractCostList", cusContractCostList);
		map.put("contractStageList", contractStageList);
		map.put("contractRepaymentList", contractRepaymentList);
		map.put("cusContractRepaymentOtherFeeList", cusContractRepaymentOtherFeeList);
		map.put("contractGpsLateFeeList", contractGpsLateFeeList);
		map.put("contractStageFeeList", contractStageFeeList);

		return map;

	}

	public static void main(String[] args) throws DAOException {

		// initService();
		if (app != null) {
			try {
				String contractFilePath = "";// = path;
				POIUtil input = app.initContractPOIUtil(contractFilePath);
				// 处理数据
				app.readContractData(input);
				input.close();
			} catch (InvalidFormatException | IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
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

	public void readContractData(POIUtil input)
			throws InvalidFormatException, IOException, ParseException, DAOException {
		int totalSheet = input.getTotalSheet();
		int rowIndex = 0;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		for (int sheetNumber = 0; sheetNumber < totalSheet; sheetNumber++) {
			input.setSheet(sheetNumber);
			String sheetName = input.getSheetName();

			rowIndex = 0;

			String nowPosition = "";
			String contractNumber = "";
			int stage = 0;// 合同还款期数
			String contractno = "";// 合同编号

			int countstage = 0;// 校验分期期数

			for (; rowIndex < 5000; rowIndex++) {
				Row row = input.getRow(rowIndex);
				if (row == null) {
					continue;
				}

				// Set<ContractPara> contractParaList1 = new HashSet<>();
				// Set<ContractLender> contractLenderList1 = new HashSet<>();
				// Set<ContractStage> contractStageList1 = new HashSet<>();
				// Set<ContractGpsLateFee> contractGpsLateFeeList1 = new HashSet<>();

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

					feeValue.clear();// 清空一个合同的feeValue
					if (stage != (countstage - 1)) {
						throw new RuntimeException("分期期数不匹配: " + stage + "--" + (countstage - 1));
					}
				}

				if (!nowPosition.equals("") && nowPosition.equals("合同编号")) {
					customerContract = new CustomerContract();
					int contractnoRow = rowIndex + 1;
					int phoneRow = contractnoRow + 2;
					int brandRow = phoneRow + 2;

					stage = (int) Double.parseDouble(input.getValue(phoneRow, 7));

					// 封装数据////////////////////////////////////////////////////////

					/**
					 * contractnoRow
					 */
					customerContract.setContractNum(input.getValue(contractnoRow, 0));
					customerContract.setName(input.getValue(contractnoRow, 2));
					RepaymentType repaymentType = new RepaymentType();
					repaymentType.setId(input.getValue(contractnoRow, 3).contains("等额") == true ? repaymentTypeArr[0]
							: repaymentTypeArr[1]);
					customerContract.setRepaymentType(repaymentType);
					customerContract.setProType(input.getValue(contractnoRow, 3));

					String[] storeAccount = repayAccount.get(input.getValue(contractnoRow, 4));
					Store store = new Store();
					store.setId(Integer.parseInt(storeAccount[0]));
					customerContract.setStore(store);
					// 还款账户
					customerContract.setRepayName(storeAccount[1]);
					customerContract.setRepaymentBankName(storeAccount[2]);
					customerContract.setRepayAccount(storeAccount[3]);

					/**
					 * phoneRow
					 */
					customerContract.setPhone(input.getValue(phoneRow, 0).matches("\\d+\\.\\d+") == true
							? input.getValue(phoneRow, 0).replaceAll("(\\d+)\\.\\d+", "$1")
							: input.getValue(phoneRow, 0));
					customerContract.setIDNo(input.getValue(phoneRow, 1));
					customerContract.setAddress(input.getValue(phoneRow, 2));
					customerContract.setBankName(input.getValue(phoneRow, 3));
					customerContract.setBankNo(input.getValue(phoneRow, 4));

					// 出借人
					ContractLender contractLender = new ContractLender();
					Lender lender = new Lender();
					lender.setId(lenderMap.get(customerContract.getStore().getId()));// 出借人
					contractLender.setLender(lender);
					contractLender.setContract(customerContract);
					contractLender.setRemark("");
					contractLender.setCreateDate(timestamp);
					contractLender.setUpdateDate(timestamp);
					contractLender.setCreateUser("admin");
					contractLender.setUpdateUser("admin");
					contractLenderList.add(contractLender);
					// 合同参数
					for (int i = 0; i < 2; i++) {
						contractPara = new ContractPara();

						ProductParameter productParameters = new ProductParameter();

						contractPara.setCreateDate(timestamp);
						contractPara.setUpdateDate(timestamp);
						contractPara.setCreateUser("admin");
						contractPara.setUpdateUser("admin");
						if (i == 0) {// 前置
							productParameters.setId(1);
							contractPara.setPara(productParameters);
							DecimalFormat dfss = new DecimalFormat(".####");
							String str = dfss.format(Double.parseDouble(input.getValue(phoneRow, 5)));
							double ids = Double.valueOf(str);
							if (ids > 0.0) {
								contractPara.setValue(ids);
								contractPara.setContract(customerContract);
								contractPara.setRemark("");
								contractParaList.add(contractPara);
							}
						}
						if (i == 1) {// 利息
							productParameters.setId(2);
							contractPara.setPara(productParameters);
							DecimalFormat dfss = new DecimalFormat(".####");
							String str = dfss.format(Double.parseDouble(input.getValue(phoneRow, 6)));
							double ids = Double.valueOf(str);
							if (ids > 0.0) {
								contractPara.setValue(ids);
								contractPara.setContract(customerContract);
								contractPara.setRemark("excel表数据导入");
								contractParaList.add(contractPara);
							}
						}
					}

					RepaymentStage stage1 = new RepaymentStage();
					stage1.setId(stageMap.get((int) Double.parseDouble(input.getValue(phoneRow, 7))));
					customerContract.setStage(stage1);
					customerContract.setAmount(roundHalfUp(input.getValue(phoneRow, 8)));
					customerContract.setPrincipal(roundHalfUp(input.getValue(phoneRow, 9)));
					customerContract.setStartDate(sdf.parse(input.getValue(phoneRow, 10)));
					customerContract.setEndDate(sdf.parse(input.getValue(phoneRow, 11)));

					// HSSFCell interest = contractNumRows.getCell(12);
					// HSSFCell capital = contractNumRows.getCell(13);
					// HSSFCell reimbursement = contractNumRows.getCell(14);
					// HSSFCell mortgagor = contractNumRows.getCell(15);

					// 抵押人信息
					if (!input.getValue(phoneRow, 15).equals("")) {
						String[] mortgagors = getMortgager(input.getValue(phoneRow, 15));
						// String[] mortgagors = mortgager.get(input.getValue(phoneRow, 15));
						customerContract.setMortgagor(mortgagors[3]);
						Mortgager mo = new Mortgager();
						mo.setId(Integer.parseInt(mortgagors[0]));
						customerContract.setMortgager(mo);
						customerContract.setMortgagorIdcard(mortgagors[1]);
						customerContract.setMortgagorAdress(mortgagors[2]);
					}

					/**
					 * brandRow
					 */
					customerContract.setBrand(input.getValue(brandRow, 0));
					customerContract.setVehicleModel(input.getValue(brandRow, 1));
					customerContract.setPlate(input.getValue(brandRow, 2));
					if (input.getValue(brandRow, 3).matches("\\w+\\.\\d+")) {
						customerContract.setEngineNo(input.getValue(brandRow, 3).replaceAll("(\\w+)\\.\\d+", "$1"));
					} else {
						customerContract.setEngineNo(input.getValue(brandRow, 3));
					}
					customerContract.setVin(input.getValue(brandRow, 4));
					customerContract.setPurchasePrice(roundHalfUp(input.getValue(brandRow, 5)));
					ContractVersion contractVersion = new ContractVersion();
					contractVersion.setId(3);// v3版本
					customerContract.setVersion(contractVersion);
					customerContract.setContractManageValue(0.0);
					customerContract.setBidAmount(0.0);
					customerContract.setLateFee(0.0);
					customerContract.setRemark("excel表数据导入");
					customerContract.setCreateDate(timestamp);
					customerContract.setUpdateDate(timestamp);
					customerContract.setCreateUser("admin");
					customerContract.setUpdateUser("admin");
					customerContractList.add(customerContract);

					// 费用类型
					for (int j = 0; j < fee.length; j++) {// 不需要gps流量费和停车费
						feeValue.add(roundHalfUp(input.getValue(brandRow, 6 + j)));
						if (fee[j] != 9 && fee[j] != 3) {
							CostType costType = new CostType();
							costType.setId(fee[j]);
							CusContractCost cusContractCosts = new CusContractCost();
							cusContractCosts.setValue(roundHalfUp(input.getValue(brandRow, 6 + j)));
							cusContractCosts.setCostType(costType);
							cusContractCosts.setRemark("excel表数据导入");
							cusContractCosts.setCreateDate(timestamp);
							cusContractCosts.setUpdateDate(timestamp);
							cusContractCosts.setCreateUser("admin");
							cusContractCosts.setUpdateUser("admin");
							cusContractCosts.setContract(customerContract);
							cusContractCostList.add(cusContractCosts);
						}

					}

					/////////////////////////////////////////////////////////////////////

					rowIndex += 5;
				} else if (!nowPosition.equals("") && nowPosition.equals("合同分期")) {

					// 封装数据////////////////////////////////////////////////////////

					contractStage = new ContractStage();

					contractStage.setStage((int) Double.parseDouble(input.getValue(rowIndex, 0)));

					double gpsFee = roundHalfUp(input.getValue(rowIndex, 1));
					double parkingFee = roundHalfUp(input.getValue(rowIndex, 2));
					double serviceFee = roundHalfUp(input.getValue(rowIndex, 3));
					Double extraCharges = gpsFee + parkingFee;
					contractStage.setExtraCharges(extraCharges);
					contractStage.setContract(customerContract);
					double interest = roundHalfUp(input.getValue(rowIndex, 4));
					contractStage.setInterest(interest + serviceFee);
					double capital = roundHalfUp(input.getValue(rowIndex, 5));
					contractStage.setCapital(capital);

					if (!input.getValue(rowIndex, 9).equals("")) {
						contractStage.setRepaymentDate(sdf.parse(input.getValue(rowIndex, 9)));
					}
					contractStage.setRemark("excel表数据导入");
					contractStage.setCreateDate(timestamp);
					contractStage.setUpdateDate(timestamp);
					contractStage.setCreateUser("admin");
					contractStage.setUpdateUser("admin");

					// 合同分期，默认0期收款
					if (contractStage.getStage() == 0) {
						contractStage.setState(1);
						ContractRepayment contractRepayment = new ContractRepayment();
						contractRepayment.setRemark("excel表数据导入");
						contractRepayment.setCapital(contractStage.getCapital());
						contractRepayment.setInterest(contractStage.getInterest());
						contractRepayment.setExtraCharges(contractStage.getExtraCharges());
						contractRepayment.setStage(contractStage);
						contractRepayment.setCreateDate(timestamp);
						contractRepayment.setUpdateDate(timestamp);
						contractRepayment.setCreateUser("admin");
						contractRepayment.setUpdateUser("admin");

						for (int i = 0; i < fee.length; i++) {
							CusContractRepaymentOtherFee gpsOtherFee = new CusContractRepaymentOtherFee();
							CostType costP = new CostType();

							if (fee[i] == 3) {
								if (parkingFee > 0 && gpsFee == 0) {
									costP.setId(3);// 停车费
									gpsOtherFee.setCostType(costP);
									gpsOtherFee.setRemark("excelDataInput");
									gpsOtherFee.setCreateDate(contractRepayment.getCreateDate());
									gpsOtherFee.setUpdateDate(contractRepayment.getUpdateDate());
									gpsOtherFee.setRepayment(contractRepayment);
									gpsOtherFee.setCreateUser(contractRepayment.getCreateUser());
									gpsOtherFee.setUpdateUser(contractRepayment.getUpdateUser());
									cusContractRepaymentOtherFeeList.add(gpsOtherFee);// 合同其他费用list
								}
							} else if (fee[i] == 9) {
								if (gpsFee > 0 && parkingFee == 0) {
									costP.setId(9);// gps费
									gpsOtherFee.setCostType(costP);
									gpsOtherFee.setRemark("excelDataInput");
									gpsOtherFee.setCreateDate(contractRepayment.getCreateDate());
									gpsOtherFee.setUpdateDate(contractRepayment.getUpdateDate());
									gpsOtherFee.setRepayment(contractRepayment);
									gpsOtherFee.setCreateUser(contractRepayment.getCreateUser());
									gpsOtherFee.setUpdateUser(contractRepayment.getUpdateUser());
									cusContractRepaymentOtherFeeList.add(gpsOtherFee);// 合同其他费用list
								}
							} else {
								costP.setId(fee[i]);
								gpsOtherFee.setCostType(costP);
								gpsOtherFee.setRemark("excelDataInput");
								gpsOtherFee.setCreateDate(contractRepayment.getCreateDate());
								gpsOtherFee.setUpdateDate(contractRepayment.getUpdateDate());
								gpsOtherFee.setRepayment(contractRepayment);
								gpsOtherFee.setCreateUser(contractRepayment.getCreateUser());
								gpsOtherFee.setUpdateUser(contractRepayment.getUpdateUser());
								cusContractRepaymentOtherFeeList.add(gpsOtherFee);// 合同其他费用list
							}
						}

						// contractRepayment.setOtherFees(cusContractRepaymentOtherFeeList);
						// Set<CusContractRepaymentOtherFee> otherFees = new HashSet<>();
						// otherFees.add(gpsOtherFee);
						// contractRepayment.setOtherFees(otherFees);
						contractRepaymentList.add(contractRepayment);// 合同还款list

						ContractGpsLateFee contractGpsLateFee = new ContractGpsLateFee();
						int gpsType = 0;
						int parkingType = 0;

						if (gpsFee >= 1000) {
							gpsType = 10;
						} else if (gpsFee >= 150) {
							gpsType = 9;
						}

						if (parkingFee >= 2000) {
							parkingType = 3;
						} else if (parkingFee >= 200) {
							parkingType = 2;
						} else if (parkingFee >= 60) {
							parkingType = 1;
						}

						if (parkingFee > 0) {
							ParkingFee park = new ParkingFee();
							park.setId(parkingType);
							contractGpsLateFee.setParkingFee(park);
							contractGpsLateFee.setCostValue(parkingFee);
							contractStage.setExtraCharges(parkingFee);
						} else if (gpsFee > 0) {
							GpsCostType gpsCostType = new GpsCostType();
							gpsCostType.setId(gpsType);
							contractGpsLateFee.setType(gpsCostType);
							contractGpsLateFee.setCostValue(gpsFee);
							contractStage.setExtraCharges(gpsFee);
						}
						contractGpsLateFee.setContract(customerContract);
						contractGpsLateFee.setRemark("excel表数据导入");
						contractGpsLateFee.setUpdateDate(timestamp);
						contractGpsLateFee.setCreateDate(timestamp);
						contractGpsLateFee.setCreateUser("admin");
						contractGpsLateFee.setUpdateUser("admin");
						contractGpsLateFeeList.add(contractGpsLateFee);// 合同gps费用list

						// 合同分期费用 0期
						for (int i = 0; i < fee.length; i++) {
							if (fee[i] == 3 || fee[i] == 9) {
								continue;
							} else {
								ContractStageFee contractStageFee = new ContractStageFee();
								CostType costType = new CostType();
								costType.setId(fee[i]);
								contractStageFee.setCostType(costType);
								contractStageFee.setRemark("excel表数据导入");
								contractStageFee.setCreateDate(timestamp);
								contractStageFee.setUpdateDate(timestamp);
								contractStageFee.setCreateUser("admin");
								contractStageFee.setUpdateUser("admin");
								contractStageFee.setFee(feeValue.get(i));
								contractStageFee.setStage(contractStage);
								contractStageFeeList.add(contractStageFee);// 合同分期费用
							}
						}

					}

					if (gpsFee > 0) {
						ContractStageFee contractStageFee = new ContractStageFee();

						CostType costType = new CostType();
						costType.setId(fee[3]);
						contractStageFee.setCostType(costType);
						contractStageFee.setRemark("excel表数据导入");
						contractStageFee.setCreateDate(timestamp);
						contractStageFee.setUpdateDate(timestamp);
						contractStageFee.setCreateUser("admin");
						contractStageFee.setUpdateUser("admin");
						contractStageFee.setFee(gpsFee);
						contractStageFee.setStage(contractStage);
						contractStageFeeList.add(contractStageFee);// 合同分期费用
					}
					if (parkingFee > 0) {
						ContractStageFee contractStageFee = new ContractStageFee();
						ContractStage contractSta = new ContractStage();
						contractSta.setStage(contractStage.getStage());
						CostType costType = new CostType();
						costType.setId(fee[4]);
						contractStageFee.setCostType(costType);
						contractStageFee.setRemark("excel表数据导入");
						contractStageFee.setCreateDate(timestamp);
						contractStageFee.setUpdateDate(timestamp);
						contractStageFee.setCreateUser("admin");
						contractStageFee.setUpdateUser("admin");
						contractStageFee.setFee(parkingFee);
						contractStageFee.setStage(contractStage);
						contractStageFeeList.add(contractStageFee);
					}

					contractStageList.add(contractStage);// 合同分期list

					/////////////////////////////////////////////////////////////////////

					++countstage;

				} else if (!nowPosition.equals("") && nowPosition.equals("还款明细")) {
					// 封装数据////////////////////////////////////////////////////////

					int repaymentstage = (int) Double.parseDouble(input.getValue(rowIndex, 0));
					if (repaymentstage == 0) {
						continue;
					}
					String repaymentDate = input.getValue(rowIndex, 3);
					if (repaymentDate.equals("")) {
						continue;
					}

					ContractStage contractStages = findContractStage(customerContract, repaymentstage);

					if (contractStages != null) {
						contractStages.setState(1);// 分期还款

						if (repaymentstage == stage) {
							customerContract.setState(1);// 合同结清
						}

						ContractRepayment contractRepayment = new ContractRepayment();
						contractRepayment.setPayment(customerContract.getName());
						// double actualRepaymentAmount = roundHalfUp(input.getValue(rowIndex, 2));
						// contractRepayment.setRepaymentFee(actualRepaymentAmount);
						double extract = contractStages.getExtraCharges();
						double interest = contractStages.getInterest();

						// actualRepaymentAmount = actualRepaymentAmount - extract - interest;

						contractRepayment.setInterest(interest);
						contractRepayment.setExtraCharges(extract);
						contractRepayment.setCapital(contractStages.getCapital());
						contractRepayment.setRepaymentFee(contractStages.getCapital() + extract + interest);//
						// contractRepayment.setCapital(actualRepaymentAmount);
						// if (actualRepaymentAmount - contractStages.getCapital() >= 0) {
						// contractRepayment.setMuchMore(actualRepaymentAmount -
						// contractStages.getCapital());
						// } else {
						// contractRepayment.setMuchMore(-(actualRepaymentAmount -
						// contractStages.getCapital()));
						// }
						// if (actualRepaymentAmount > 0.0) {
						// contractStages.setState(1);
						// }

						contractRepayment.setRepaymentDate(sdf.parse(repaymentDate));
						double overduePaymentss = roundHalfUp(input.getValue(rowIndex, 5));// 实收逾期费
						contractRepayment.setRemark("excel表数据导入");
						contractRepayment.setStage(contractStages);
						contractRepayment.setLateFee(overduePaymentss);
						contractRepayment.setCreateDate(timestamp);
						contractRepayment.setUpdateDate(timestamp);
						contractRepayment.setCreateUser("admin");
						contractRepayment.setUpdateUser("admin");
						contractRepaymentList.add(contractRepayment);

					}
					/////////////////////////////////////////////////////////////////////
				}

				// customerContract.setContractParas(contractParaList1);
				// customerContract.setContractLenders(contractLenderList1);
				// customerContract.setContractStages(contractStageList1);
				// customerContract.setGpsLatefes(contractGpsLateFeeList1);
				// customerContractList.add(customerContract);

			}

			// break;

		}
		System.out.println("结束， 恭喜你没问题！！");
	}

	private String[] getMortgager(String value) {
		if (value.equals("国标融资租赁有限公司")) {
			System.out.println();
		}
		for (String name : mortgager.keySet()) {
			if (value.contains(name) || name.equals(value)) {
				return mortgager.get(name);
			}
		}

		return null;
	}

	/**
	 * 根据合同跟期数，查找分期
	 * 
	 * @param customerContract2
	 * @param stage
	 * @return
	 */
	private ContractStage findContractStage(CustomerContract customerContract2, int stage) {
		int contractId = customerContract2.getId();
		String contractNum = customerContract2.getContractNum();
		for (ContractStage contractStage : contractStageList) {
			if (contractStage.getContract().getId() == contractId && contractStage.getStage() == stage
					&& contractStage.getContract().getContractNum().equals(contractNum)) {
				return contractStage;
			}

		}

		return null;
	}

	/**
	 * 四舍五入返回doubl值, 输入空串 返回 0.00
	 * 
	 * @param string
	 * @return
	 */
	private double roundHalfUp(String value) {
		double doubleValue = 0.00;
		if (!value.equals("")) {

			System.out.println(customerContract.getContractNum() + " " + customerContract.getName());
			BigDecimal bigDecimal = new BigDecimal(value);
			doubleValue = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		return doubleValue;
	}

	private Integer getStoreId(String value) {

		for (String storeName : storeMap.keySet()) {
			if (storeName.equals(value)) {
				return storeMap.get(storeName);
			}

		}

		return null;
	}
}