package com.jyd.translateContractStage.hui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jyd.bms.bean.ContractGpsLateFee;
import com.jyd.bms.bean.ContractLateFee;
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
import com.jyd.bms.bean.Mortgager;
import com.jyd.bms.bean.ParkingFee;
import com.jyd.bms.bean.ProductParameter;
import com.jyd.bms.bean.RepaymentAccount;
import com.jyd.bms.bean.RepaymentStage;
import com.jyd.bms.bean.Store;
import com.jyd.bms.bean.StoreLender;
import com.jyd.bms.bean.StoreRepaymentAccount;
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

public class OldDataImport_A {
//	private static final Logger logger = Logger.getLogger(OldDataImport_A.class);
	/**
	 * 
	 */
	private static final String path = "/home/aa/Desktop/zhengzhou";
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

	private static ContractStage contractStage;
	private static CustomerContract customerContract;
	private static ContractPara contractPara;
	private static ClassPathXmlApplicationContext context;

	private static ContractStageFeeService contractStageFeeService;
	private static MortgagerService mortgagerService;
	private static StoreLenderService storeLenderService;
	private static ContractLenderService contractLenderService;

	private static CusContractRepaymentOtherFeeService cusContractRepaymentOtherFeeService;

	private static RepaymentAccountService repaymentAccountService;

	private static DeleteDataService deleteDataService;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	static {
		context = new ClassPathXmlApplicationContext("config/spring.xml");
	}

	/*
	 * @Override public void initUI() { customerContractService =
	 * getBean("CustomerContractService"); contractStageService =
	 * getBean("ContractStageService"); cusContractCostService =
	 * getBean("CusContractCostService"); productService =
	 * getBean("ProductService"); contractParaService =
	 * getBean("ContractParaService"); repaymentStageService =
	 * getBean("RepaymentStageService"); gpsCostTypeService =
	 * getBean("GpsCostTypeService"); parkingFeeService =
	 * getBean("ParkingFeeService"); contractGpsLateFeeService =
	 * getBean("ContractGpsLateFeeService"); storeService = getBean("StoreService");
	 * contractVersionService = getBean("ContractVersionService"); mortgagerService
	 * = getBean("MortgagerService"); storeRepaymentAccountService =
	 * getBean("StoreRepaymentAccountService"); contractLateFeeService =
	 * getBean("ContractLateFeeService"); contractRepaymentService =
	 * getBean("ContractRepaymentService"); storeLenderService =
	 * getBean("StoreLenderService"); contractLenderService =
	 * getBean("ContractLenderService"); repaymentAccountService =
	 * getBean("RepaymentAccountService"); contractStageFeeService =
	 * getBean("ContractStageFeeService"); cusContractRepaymentOtherFeeService =
	 * getBean("CusContractRepaymentOtherFeeService");
	 * 
	 * deleteDataService = getBean("DeleteDataService"); }
	 * 
	 * @Override public void initData() throws DAOException { }
	 */
	public static void main(String[] args) throws InvalidFormatException, IOException {
		OldDataImport_A OldDataImport_A = new OldDataImport_A();

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

		deleteData();

		OldDataImport_A.get(path);

	}

	private static void deleteData() {
		Date date = new Date();
		int storeId = 18;// 郑州门店
		int count1 = deleteDataService.deleteDateByStoreAndDate(storeId, date);
		int count2 = deleteDataService.deleteDateByStoreAndDate1(storeId, date);

		System.out.println("分别删除数据是条数是：");
		System.out.println("count1= " + count1);
		System.out.println("count2= " + count2);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("======================================");
		System.out.println();

	}

	@SuppressWarnings("unlikely-arg-type")
	public void getDataByXls(File path) throws IOException {
		String hql = "";
		InputStream is = new FileInputStream(path);
		@SuppressWarnings("resource")
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		Store stores = null;
		Calendar c = new GregorianCalendar(1900, 0, -1);
		Date d = c.getTime();
		int parkingType = 0;
		CustomerContract customerContractID = null;
		int gpsType = 0;

		HSSFRow contractNumRows = null;
		HSSFRow contractNumRowx = null;
		HSSFCell contractNum = null;
		int Eachissue = 0;
		Timestamp t = new Timestamp(new Date().getTime());
		// 取费用的数组
		int[] fee = new int[] { 1, 4, 13, 9, 3, 2, 8, 6, 7 };
		DecimalFormat df = new DecimalFormat("#");

		// 获取每一个工作薄
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);

			if (hssfSheet == null) {
				continue;
			}

			// 获取当前工作薄的每一行
			for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow == null) {
					continue;
				} else {
					HSSFCell oneCols = hssfRow.getCell(0);
					try {

						if (getValue(oneCols).equals("合同编号")) {

							customerContract = new CustomerContract();

							HSSFRow contractNumRow = hssfSheet.getRow(rowNum + 1);

							contractNum = contractNumRow.getCell(0);
							customerContract.setContractNum(getValue(contractNum));

							HSSFCell name = contractNumRow.getCell(2);
							customerContract.setName(getValue(name).replaceAll(" ", ""));

							HSSFCell products = contractNumRow.getCell(3);
							customerContract.setProduct(productService.getProductByName(getValue(products)));

							HSSFCell store = contractNumRow.getCell(4);
							stores = storeService.getStoreByName(getValue(store));

							customerContract.setStore(stores);
							// 还款账户
							List<StoreRepaymentAccount> list = storeRepaymentAccountService
									.getStoreRepaymentAccountByStore(stores);
							for (StoreRepaymentAccount sra : list) {
								RepaymentAccount repaymentAccount = repaymentAccountService
										.getById(sra.getRepaymentAccount().getId());
								customerContract.setRepayName(repaymentAccount.getName());
								customerContract.setRepaymentBankName(repaymentAccount.getBank());
								customerContract.setRepayAccount(repaymentAccount.getAccountNo());
							}

							contractNumRows = hssfSheet.getRow(rowNum + 3);
							HSSFCell phone = contractNumRows.getCell(0);
							phone.setCellType(Cell.CELL_TYPE_STRING);
							customerContract.setPhone(phone.getStringCellValue().replaceAll(" ", ""));
							HSSFCell IDNo = contractNumRows.getCell(1);
							IDNo.setCellType(Cell.CELL_TYPE_STRING);
							customerContract.setIDNo(IDNo.getStringCellValue().replaceAll(" ", ""));
							HSSFCell address = contractNumRows.getCell(2);
							customerContract.setAddress(getValue(address).replaceAll(" ", ""));
							HSSFCell bankName = contractNumRows.getCell(3);
							customerContract.setBankName(getValue(bankName).replaceAll(" ", ""));
							HSSFCell bankNo = contractNumRows.getCell(4);
							customerContract.setBankNo(getValue(bankNo).replaceAll(" ", ""));

							HSSFCell stages = contractNumRows.getCell(7);

							Eachissue = (int) stages.getNumericCellValue();
							RepaymentStage stage = repaymentStageService.getRepaymentStageById(Eachissue);
							customerContract.setStage(stage);

							HSSFCell amount = contractNumRows.getCell(8);
							customerContract.setAmount(Double.valueOf(getValue(amount)));

							HSSFCell principal = contractNumRows.getCell(9);
							if (getValue(principal) != null && !getValue(principal).equals("")) {
								customerContract.setPrincipal(Double.valueOf(getValue(principal)));
							}

							HSSFCell startDates = contractNumRows.getCell(10);
							int date = 0;
							if(startDates.getCellType() == startDates.CELL_TYPE_NUMERIC) {
								 date = (int) startDates.getNumericCellValue();
							}
							if(startDates.getCellType() == startDates.CELL_TYPE_STRING) {
								date = (int)sdf.parse(startDates.getStringCellValue()).getTime();
							}

							Date startDate = DateUtils.addDays(d, date);
							customerContract.setStartDate(startDate);

							HSSFCell endDates = contractNumRows.getCell(11);
							int dates = 0;
							if(endDates.getCellType() == endDates.CELL_TYPE_NUMERIC) {
								dates = (int) endDates.getNumericCellValue();
							}
							if(endDates.getCellType() == endDates.CELL_TYPE_STRING) {
								dates = (int)sdf.parse(endDates.getStringCellValue()).getTime();
							}
							
							Date endDate = DateUtils.addDays(d, dates);
							customerContract.setEndDate(endDate);

							HSSFCell interest = contractNumRows.getCell(12);
							HSSFCell capital = contractNumRows.getCell(13);
							HSSFCell reimbursement = contractNumRows.getCell(14);
							HSSFCell mortgagor = contractNumRows.getCell(15);

							// 抵押人信息
							Mortgager mortgagers = mortgagerService
									.getMortgagerByName(getValue(mortgagor).replaceAll(" ", ""));
							if (mortgagers != null) {
								customerContract.setMortgagor(mortgagers.getName());
								customerContract.setMortgager(mortgagers);
								customerContract.setMortgagorIdcard(mortgagers.getIdCard());
								customerContract.setMortgagorAdress(mortgagers.getAddress());
							}
							contractNumRowx = hssfSheet.getRow(rowNum + 5);
							HSSFCell brand = contractNumRowx.getCell(0);
							customerContract.setBrand(getValue(brand));
							HSSFCell vehicleModel = contractNumRowx.getCell(1);
							customerContract.setVehicleModel(getValue(vehicleModel));
							HSSFCell plate = contractNumRowx.getCell(2);
							customerContract.setPlate(getValue(plate));
							HSSFCell engineNo = contractNumRowx.getCell(3);
							engineNo.setCellType(HSSFCell.CELL_TYPE_STRING);
							customerContract.setEngineNo(engineNo.getStringCellValue());
							HSSFCell vin = contractNumRowx.getCell(4);
							customerContract.setVin(getValue(vin));
							HSSFCell purchasePrice = contractNumRowx.getCell(5);
							String pur = getValue(purchasePrice);
							if (pur == null || pur.equals("")) {
								pur = "0.0";
							}
							customerContract.setPurchasePrice(Double.valueOf(pur));
							ContractVersion contractVersion = contractVersionService.getById(3);
							customerContract.setVersion(contractVersion);
							customerContract.setContractManageValue(0.0);
							customerContract.setBidAmount(0.0);
							customerContract.setLateFee(0.0);
							customerContract.setCreateDate(t);
							customerContract.setUpdateDate(t);
							customerContract.setCreateUser("admin");
							customerContract.setUpdateUser("admin");
							customerContractService.add(customerContract);
							customerContractID = customerContractService
									.getContractByNum(getValue(contractNum).replaceAll(" ", ""));

							ContractLender ContractLender = new ContractLender();
							List<StoreLender> storeList = storeLenderService.getStoreLenderByStore(stores);
							for (StoreLender storeLender : storeList) {
								ContractLender.setLender(storeLender.getLender());
								ContractLender.setContract(customerContractID);
								ContractLender.setRemark("");
								ContractLender.setCreateDate(t);
								ContractLender.setUpdateDate(t);
								ContractLender.setCreateUser("admin");
								ContractLender.setUpdateUser("admin");
								contractLenderService.add(ContractLender);
							}

							contractPara = new ContractPara();

							ProductParameter productParameters = new ProductParameter();
							contractPara.setCreateDate(t);
							contractPara.setUpdateDate(t);
							contractPara.setCreateUser("admin");
							contractPara.setUpdateUser("admin");
							HSSFCell id = contractNumRows.getCell(5);
							if (id != null && !getValue(id).equals("")) {

								productParameters.setId(1);
								contractPara.setPara(productParameters);
								DecimalFormat dfss = new DecimalFormat(".####");
								String str = dfss.format(Double.valueOf(getValue(id)));
								double ids = Double.valueOf(str);
								if (ids > 0.0) {
									contractPara.setValue(ids);
									contractPara.setContract(customerContractID);
									contractPara.setRemark(" ");
									contractParaService.add(contractPara);
								}

							}

							HSSFCell value = contractNumRows.getCell(6);
							if (value != null && !getValue(value).equals("")) {
								productParameters.setId(2);
								contractPara.setPara(productParameters);
								DecimalFormat dfss = new DecimalFormat(".####");
								String str = dfss.format(Double.valueOf(getValue(value)));
								double ids = Double.valueOf(str);
								if (ids > 0.0) {
									contractPara.setValue(ids);
									contractPara.setContract(customerContractID);
									contractPara.setRemark(" ");
									contractParaService.add(contractPara);
								}
							}

							for (int j = 0; j < fee.length; j++) {
								CostType costType = new CostType();
								costType.setId(fee[j]);
								CusContractCost cusContractCosts = new CusContractCost();
								HSSFCell values = contractNumRowx.getCell(6 + j);
								String valuec = getValue(values).replaceAll(" ", "");
								if (valuec.equals("") || valuec == null) {
									valuec = "0.0";
									cusContractCosts.setValue(Double.valueOf(valuec));
								} else {
									cusContractCosts.setValue(Double.valueOf(valuec));
								}
								cusContractCosts.setCostType(costType);
								cusContractCosts.setCreateDate(t);
								cusContractCosts.setUpdateDate(t);
								cusContractCosts.setCreateUser("admin");
								cusContractCosts.setUpdateUser("admin");
								cusContractCosts.setContract(customerContractID);
								cusContractCostService.add(cusContractCosts);
							}

						}

						if (getValue(oneCols).equals("合同分期")) {
							for (int j = 0; j <= Eachissue + 5; j++) {
								contractStage = new ContractStage();
								HSSFRow contractNumRow = hssfSheet.getRow(rowNum + j + 2);
								if (contractNumRow == null) {
									break;
								}
								HSSFCell stage = contractNumRow.getCell(0);
//								stage.setCellType(Cell.CELL_TYPE_NUMERIC);
								if (getValue(stage).equals("还款明细")) {
									break;
								}
								if (getValue(stage) == null || getValue(stage).equals("")) {
									break;
								}
								ContractStageFee contractStageFee = new ContractStageFee();
								
								if(stage.getCellType() == stage.CELL_TYPE_NUMERIC) {
									contractStage.setStage((int)stage.getNumericCellValue());
								}
								if(stage.getCellType() == stage.CELL_TYPE_STRING) {
									contractStage.setStage(Integer.parseInt(stage.getStringCellValue()));
								}

								HSSFCell gpsFee = contractNumRow.getCell(1);
								String gpsFe = getValue(gpsFee);
								if (gpsFe == null || gpsFe.equals("")) {
									gpsFe = "0.0";
								}
								Double gpef = Double.valueOf(gpsFe);

								HSSFCell parkingFee = contractNumRow.getCell(2);
								String parkingFe = getValue(parkingFee);
								if (parkingFe == null || parkingFe.equals("")) {
									parkingFe = "0.0";
								}
								Double parkingFes = Double.valueOf(parkingFe);

								HSSFCell serviceFee = contractNumRow.getCell(3);
								String serviceFe = getValue(serviceFee);
								if (serviceFe == null || serviceFe.equals("")) {
									serviceFe = "0.0";
								}
								Double serviceFes = Double.valueOf(serviceFe);
								Double extraCharges = gpef + parkingFes;
								contractStage.setExtraCharges(extraCharges);

								contractStage.setContract(customerContractID);
								HSSFCell interest = contractNumRow.getCell(4);
								String interests = getValue(interest);
								if (interests == null || interests.equals("")) {
									interests = "0.0";
								}
								contractStage.setInterest(Double.valueOf(interests) + serviceFes);

								HSSFCell capital = contractNumRow.getCell(5);
								String capitals = getValue(capital);
								if (capitals == null || capitals.equals("")) {
									capitals = "0.0";
								}
								Double capitalss = Double.valueOf(capitals);
								contractStage.setCapital(capitalss);
								HSSFCell trt = contractNumRow.getCell(6);
								HSSFCell gdg = contractNumRow.getCell(7);
								HSSFCell sfd = contractNumRow.getCell(8);
								HSSFCell repaymentDate = contractNumRow.getCell(9);
								if (getValue(repaymentDate) != null && !getValue(repaymentDate).equals("")) {
									System.out.println(repaymentDate.getNumericCellValue());
//									int date = (int) repaymentDate.getNumericCellValue();
									
									int date = 0;
									date = dateProcess(repaymentDate, date);
									
									System.out.println(date);
									if (date > 0) {
										Date rDate = DateUtils.addDays(d, date);
										contractStage.setRepaymentDate(rDate);

									}
								}

								contractStage.setCreateDate(t);
								contractStage.setUpdateDate(t);
								contractStage.setCreateUser("admin");
								contractStage.setUpdateUser("admin");
								contractStageService.add(contractStage);
								if ((int) stage.getNumericCellValue() == 0) {
									contractStage.setState(1);
									ContractRepayment contractRepayment = new ContractRepayment();
									contractRepayment.setCapital(capitalss);
									contractRepayment.setInterest(Double.valueOf(interests) + serviceFes);
									contractRepayment.setExtraCharges(extraCharges);
									List<ContractStage> lists = contractStageService
											.findContractStageByContract(customerContractID);
									ContractStage sc = new ContractStage();
									for (ContractStage s : lists) {
										if (s != null) {
											if (s.getStage() == 0) {
												sc = s;
												break;
											}
										}
									}
									contractRepayment.setStage(sc);
									contractRepaymentService.add(contractRepayment);
									List<ContractRepayment> lism = contractRepaymentService
											.findContractRepaymentByStageAll(sc);
									ContractRepayment ment = new ContractRepayment();
									for (ContractRepayment m : lism) {
										if (m != null) {
											ment = m;
										}
									}
									List<CusContractCost> cost = cusContractCostService
											.getCusContractCostByContract(customerContractID);
									for (CusContractCost co : cost) {
										if (co != null) {
											if (co.getValue() > 0) {
												CusContractRepaymentOtherFee cfee = new CusContractRepaymentOtherFee();
												cfee.setCostType(co.getCostType());
												cfee.setValue(co.getValue());
												cfee.setDefaultValue(co.getValue());
												cfee.setCreateDate(sc.getCreateDate());
												cfee.setUpdateDate(sc.getUpdateDate());
												cfee.setRepayment(ment);
												cfee.setCreateUser(sc.getCreateUser());
												cfee.setUpdateUser(sc.getUpdateUser());
												cusContractRepaymentOtherFeeService.add(cfee);
											}
										}
									}
								}
								if (j == 0) {
									contractNumRow = hssfSheet.getRow(rowNum + 2);
									HSSFCell gps = contractNumRow.getCell(1);
									Double gpss = Double.valueOf(getValue(gps).equals("") ? "0.00" : getValue(gps));
									ContractGpsLateFee contractGpsLateFee = new ContractGpsLateFee();

									if (gpss >= 1000) {
										gpsType = 10;
									} else if (gpss >= 150) {
										gpsType = 9;
									}

									HSSFCell parking = contractNumRow.getCell(2);
									String parkings = getValue(parking);
									if (getValue(parking) == null || getValue(parking).equals("")) {
										parkings = "0.0";
									}
									Double parkingss = Double.valueOf(parkings);
									if (parkingss >= 2000) {
										parkingType = 3;
									} else if (parkingss >= 200) {
										parkingType = 2;
									} else if (parkingss >= 60) {
										parkingType = 1;
									}

									if (parkingss > 0) {
										ParkingFee parkingFees = parkingFeeService.getById(parkingType);
										contractGpsLateFee.setParkingFee(parkingFees);
										contractGpsLateFee.setCostValue(parkingss);
										contractStage.setExtraCharges(parkingss);
									} else if (gpss > 0) {
										GpsCostType gpsCostType = gpsCostTypeService.getById(gpsType);
										contractGpsLateFee.setType(gpsCostType);
										contractGpsLateFee.setCostValue(gpss);
										contractStage.setExtraCharges(gpss);
									}
									contractGpsLateFee.setContract(customerContractID);
									contractGpsLateFee.setUpdateDate(t);
									contractGpsLateFee.setCreateDate(t);
									contractGpsLateFee.setCreateUser("admin");
									contractGpsLateFee.setUpdateUser("admin");
									contractGpsLateFeeService.add(contractGpsLateFee);

								}
								ContractStage contractStages = contractStageService.findContractStageByContractAndStage(
										customerContractID, (int) stage.getNumericCellValue());
								if (gpef > 0) {
									CostType costType = new CostType();
									costType.setId(fee[3]);
									contractStageFee.setCostType(costType);
									contractStageFee.setCreateDate(t);
									contractStageFee.setUpdateDate(t);
									contractStageFee.setCreateUser("admin");
									contractStageFee.setUpdateUser("admin");
									contractStageFee.setFee(gpef);
									contractStageFee.setRemark("");
									contractStageFee.setStage(contractStages);
									contractStageFeeService.add(contractStageFee);
								}
								if (parkingFes > 0) {
									ContractStage contractSta = new ContractStage();
									contractSta.setStage((int) stage.getNumericCellValue());
									CostType costType = new CostType();
									costType.setId(fee[4]);
									contractStageFee.setCostType(costType);
									contractStageFee.setCreateDate(t);
									contractStageFee.setUpdateDate(t);
									contractStageFee.setCreateUser("admin");
									contractStageFee.setUpdateUser("admin");
									contractStageFee.setFee(parkingFes);
									contractStageFee.setRemark("");
									contractStageFee.setStage(contractStages);
									contractStageFeeService.add(contractStageFee);
								}

							}

						}

						Double latefee = 0.00;
						Double latefees = 0.00;

						if (getValue(oneCols).equals("还款明细")) {
							for (int j = 0; j <= Eachissue + 5; j++) {
								ContractRepayment contractRepayment = new ContractRepayment();

								ContractLateFee contractLateFee = new ContractLateFee();
								HSSFRow repaymentRow = hssfSheet.getRow(rowNum + j + 2);
								if (repaymentRow == null) {
									break;
								}
								HSSFCell repaymentPeriods = repaymentRow.getCell(0);
								// HSSFCell amountDue = repaymentRow.getCell(1);// 应还款金额
								if (repaymentPeriods == null || getValue(repaymentPeriods).equals("")) {
									break;
								} else {
									if (getValue(repaymentPeriods).equals("合同编号")) {
										break;
									}
									// contractStage = new ContractStage();
									int stage = (int) repaymentPeriods.getNumericCellValue();
									if (stage == 0) {
										continue;
									}
									ContractStage contractStages = contractStageService
											.findContractStageByContractAndStage(customerContractID, stage);
									if (contractStages != null) {

										contractLateFee.setContract(customerContractID);
										contractLateFee.setContractStage(contractStages);

										contractRepayment.setPayment(customerContractID.getName());

										HSSFCell actualRepaymentAmount = repaymentRow.getCell(2);// 实还款金额
										String actualRepaymentAmounts = getValue(actualRepaymentAmount);
										if (actualRepaymentAmounts == null || actualRepaymentAmounts.equals("")) {
											actualRepaymentAmounts = "0.0";
										}
										Double actualRepaymentAmountss = Double.valueOf(actualRepaymentAmounts);
										contractRepayment.setRepaymentFee(actualRepaymentAmountss);
										Double extract = 0.0;
										extract = contractStages.getExtraCharges();
										if (extract == null) {
											extract = 0.0;
										}
										Double interest = contractStages.getInterest();
										if (interest == null) {
											interest = 0.0;
										}
										actualRepaymentAmountss = actualRepaymentAmountss - extract - interest;

										HSSFCell repaymentDate = repaymentRow.getCell(3);// 还款日期
										repaymentDate.setCellType(Cell.CELL_TYPE_NUMERIC);
										if (getValue(repaymentDate) == null || getValue(repaymentDate).equals("")) {
											break;
										}
										contractRepayment.setCapital(interest);
										contractRepayment.setExtraCharges(extract);

										contractRepayment.setCapital(actualRepaymentAmountss);
										if (actualRepaymentAmountss - contractStages.getCapital() >= 0) {
											contractRepayment
													.setMuchMore(actualRepaymentAmountss - contractStages.getCapital());
										} else {
											contractRepayment.setMuchMore(
													-(actualRepaymentAmountss - contractStages.getCapital()));
										}
//										int date = (int) repaymentDate.getNumericCellValue();
										int date = 0;
										date = dateProcess(repaymentDate, date);
										if (date > 0) {
											Date rDate = DateUtils.addDays(d, date);
											contractRepayment.setRepaymentDate(rDate);
											contractLateFee.setOverDueTime(rDate);
										} else {

										}
										if (actualRepaymentAmountss > 0.0) {

											contractStages.setState(1);
											contractStageService.update(contractStages);

										}

										HSSFCell overduePayment = repaymentRow.getCell(4);// 应收逾期费
										String overduePayments = getValue(overduePayment);
										Double over = 0.0;
										if (overduePayments != null && !overduePayments.equals("")) {
											over = Double.valueOf(overduePayments);
										}

										HSSFCell overduePaymentss = repaymentRow.getCell(5);// 实收逾期费
										String overduePaymen = getValue(overduePaymentss);
										Double adp = 0.0;
										if (overduePaymen != null && !overduePaymen.equals("")) {
											adp = Double.valueOf(overduePaymen);

										} else {
											overduePaymen = "0.0";
											adp = Double.valueOf(overduePaymen);
										}
										latefee += over;
										contractLateFee.setUnitTimeLateFee(over - adp);
										contractLateFee.setCreateDate(contractStages.getCreateDate());
										contractLateFee.setUpdateDate(contractStages.getUpdateDate());
										contractLateFee.setCreateUser("admin");
										contractLateFee.setUpdateUser("admin");
										contractLateFeeService.add(contractLateFee);
										latefees += adp;

										int dates = (int) repaymentDate.getNumericCellValue();
										if (dates > 0) {
											Date rDate = DateUtils.addDays(d, dates);
											contractRepayment.setRepaymentDate(rDate);
											contractLateFee.setOverDueTime(rDate);

										} else {
											contractRepayment.setRepaymentDate(t);
											contractLateFee.setOverDueTime(t);
										}
										contractRepayment.setLateFee(adp);
										
										contractRepaymentService.add(contractRepayment);
									}
								}
							}
							DecimalFormat dfss = new DecimalFormat(".####");
							String str = dfss.format(latefee - latefees);
							customerContractID.setLateFee(Double.valueOf(str));
							customerContractService.update(customerContractID);
						} else {
							continue;
						}

					} catch (Exception e) {
//						logger.error(getTrace(e));
						hql += numSheet + "," + rowNum + "," + customerContractID.getContractNum() + "\n" + getTrace(e)
								+ "   \n";
					}
				}
			}
		}
		FileOutputStream fs = new FileOutputStream(new File("/home/aa/Desktop/zhengzhou/log"));
		PrintStream p = new PrintStream(fs);
		p.println(hql);
		p.close();
	}

	/**
	 * 日期处理，目前只做对两个cell类型的判断处理
	 * @param date
	 * @param datenum
	 * @return
	 * @throws ParseException
	 */
	private int dateProcess(HSSFCell date, int datenum) throws ParseException {
		if(date.getCellType() == date.CELL_TYPE_NUMERIC) {
			datenum = (int) date.getNumericCellValue();
		}
		if(date.getCellType() == date.CELL_TYPE_STRING) {
			String dataFormatString = date.getCellStyle().getDataFormatString();
			String repaymentDateStr = date.getStringCellValue();
			if(dataFormatString.contains("/")) {
				StringBuilder sb = new StringBuilder();
				String[] split = repaymentDateStr.split("/");
				
				sb.append(split[0]);//年
				sb.append("-");
				if(!split[1].matches("\\d{2}")) {//月
					sb.append("0"+split[1]);
				}else {
					sb.append(split[1]);
				}
				
				if(!split[2].matches("\\d{2}")) {//日
					sb.append("0"+split[2]);
				}else {
					sb.append(split[2]);
				}
				repaymentDateStr = sb.toString();
			}
		
			datenum = (int)sdf.parse(repaymentDateStr).getTime();
		}
		return datenum;
	}

	public static String getTrace(Throwable t) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		t.printStackTrace(writer);
		StringBuffer buffer = stringWriter.getBuffer();
		return buffer.toString();
	}

	public void get(String path) throws IOException {
		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			for (File fileChild : files) {
				if (fileChild.isDirectory()) {
					System.out.println("文件夹:" + fileChild.getAbsolutePath());
				} else {
					if (!fileChild.exists()) {
						System.err.println("当前文件不存在!");
					}
					String fileType = fileChild.getName();
					fileType = fileType.substring(fileType.indexOf("."));
					if (fileType.equals(".xls")) {
						getDataByXls(fileChild);
					} else {
						continue;
						// System.err.println("没有发现当前文件!");
					}
				}
			}
		}

	}

	/**
	 * @category xls
	 * @param hssfCell
	 * @return
	 */
	private String getValue(HSSFCell hssfCell) {

		if (hssfCell == null) {
			return String.valueOf("");
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			return String.valueOf(hssfCell.getNumericCellValue());
		} else {
			try {
				return String.valueOf(hssfCell.getStringCellValue());
			} catch (IllegalStateException e) {
				return String.valueOf(hssfCell.getNumericCellValue());
			}
		}
	}
	

	private String getValue(XSSFCell xssfRow) {

		if (xssfRow == null) {
			return String.valueOf("");
		} else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
			return String.valueOf(xssfRow.getBooleanCellValue());
		} else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
			return String.valueOf(xssfRow.getNumericCellValue());
		} else {
			try {
				return String.valueOf(xssfRow.getStringCellValue());
			} catch (IllegalStateException e) {
				return String.valueOf(xssfRow.getNumericCellValue());
			}
		}
	}
}