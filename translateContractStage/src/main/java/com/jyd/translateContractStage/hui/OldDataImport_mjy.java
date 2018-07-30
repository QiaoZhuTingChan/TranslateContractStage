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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
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
import com.jyd.bms.bean.Lender;
import com.jyd.bms.bean.Mortgager;
import com.jyd.bms.bean.ParkingFee;
import com.jyd.bms.bean.ProductParameter;
import com.jyd.bms.bean.RepaymentStage;
import com.jyd.bms.bean.Store;

public class OldDataImport_mjy {
	private static final String path = "/home/mjy/Desktop/file/";
	private static ContractStage contractStage;
	private static CustomerContract customerContract;
	private static ContractPara contractPara;
	private static ClassPathXmlApplicationContext context;
//	private static final Logger log = Logger.getLogger(OldDataImport_mjy.class);
	private static List<CustomerContract> contractList = new ArrayList<CustomerContract>();// 合同
	private Set<ContractPara> paras = new HashSet<ContractPara>();// 参数
	private Set<ContractStage> stages = new HashSet<ContractStage>();// 分期
	private Set<CusContractCost> costs = new HashSet<CusContractCost>();// 费用
	private Set<ContractRepayment> reps = new HashSet<ContractRepayment>();// 还款
	private Set<CusContractRepaymentOtherFee> otherFees = new HashSet<CusContractRepaymentOtherFee>();
	private Set<ContractGpsLateFee> gpsFees = new HashSet<ContractGpsLateFee>();// 多次收费用
	private Set<ContractStageFee> stageFees = new HashSet<ContractStageFee>();
	private Set<ContractLender> lenders = new HashSet<ContractLender>();
	private static Map<String, String[]> mortgager = new HashMap<String, String[]>();
	private static Map<String, String[]> repayAccount = new HashMap<String, String[]>();
	private static Map stage = new HashMap();
	public static StringBuffer hql = new StringBuffer();

	public static void main(String[] args) throws InvalidFormatException, IOException {
		// context = new ClassPathXmlApplicationContext("config/spring.xml");
		OldDataImport_mjy OldDataImport_A = new OldDataImport_mjy();
		OldDataImport_A.get(path);
	}

	static {
		stage.put("1", 1);
		stage.put("2", 2);
		stage.put("3", 3);
		stage.put("6", 4);
		stage.put("12", 5);
		stage.put("18", 6);
		stage.put("24", 7);
		stage.put("9", 8);
		stage.put("15", 9);
		stage.put("5", 10);
		stage.put("27", 11);
		stage.put("4", 12);
		stage.put("7", 13);
		stage.put("8", 14);

		String[] arrs3 = { "3", "91440300MA5DA69B6U", "深圳市前海深港合作区前湾一路1号A栋201室", "国标融资租赁（深圳）有限公司" };
		mortgager.put("国标", arrs3);

		String[] acount = { "4", "李健康", "工行太原三营盘支行", "6222 0805 0200 2890 632" };
		repayAccount.put("太原一店", acount);

	}

	@SuppressWarnings({ "unused" })
	public void getDataByXls(File path) throws IOException {
		InputStream is = new FileInputStream(path);
		@SuppressWarnings("resource")
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		Store stores = null;
		Calendar c = new GregorianCalendar(1900, 0, -1);
		Date d = c.getTime();
		int parkingType = 0;
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

							HSSFCell products = contractNumRow.getCell(3);//查还款类型
							// customerContract.setProduct(productService.getProductByName(getValue(products)));

							HSSFCell store = contractNumRow.getCell(4);
							// stores = storeService.getStoreByName(getValue(store));

							String[] storeAccount = repayAccount.get("太原一店");

							Store storeA = new Store();
							storeA.setId(Integer.parseInt(storeAccount[0]));
							customerContract.setStore(storeA);

							// 还款账户
							customerContract.setRepayName(storeAccount[1]);
							customerContract.setRepaymentBankName(storeAccount[2]);
							customerContract.setRepayAccount(storeAccount[3]);

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

							RepaymentStage stageA = new RepaymentStage();

							int sid = (int) stage.get(String.valueOf(Eachissue));
							stageA.setId(sid);
							customerContract.setStage(stageA);

							HSSFCell amount = contractNumRows.getCell(8);
							customerContract.setAmount(Double.valueOf(getValue(amount)));

							HSSFCell principal = contractNumRows.getCell(9);
							if (getValue(principal) != null && !getValue(principal).equals("")) {
								customerContract.setPrincipal(Double.valueOf(getValue(principal)));
							}

							HSSFCell startDates = contractNumRows.getCell(10);

							int date = (int) startDates.getNumericCellValue();

							Date startDate = DateUtils.addDays(d, date);
							customerContract.setStartDate(startDate);

							HSSFCell endDates = contractNumRows.getCell(11);
							int dates = (int) endDates.getNumericCellValue();

							Date endDate = DateUtils.addDays(d, dates);
							customerContract.setEndDate(endDate);

							HSSFCell interest = contractNumRows.getCell(12);
							HSSFCell capital = contractNumRows.getCell(13);
							HSSFCell reimbursement = contractNumRows.getCell(14);
							HSSFCell mortgagor = contractNumRows.getCell(15);

							// 抵押人信息
							String[] mortgagors = mortgager.get(getValue(mortgagor).replaceAll(" ", ""));
							customerContract.setMortgagor(mortgagors[3]);
							Mortgager mo = new Mortgager();
							mo.setId(Integer.parseInt(mortgagors[0]));
							customerContract.setMortgager(mo);
							customerContract.setMortgagorIdcard(mortgagors[1]);
							customerContract.setMortgagorAdress(mortgagors[2]);

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
							ContractVersion contractVersion = new ContractVersion();
							contractVersion.setId(3);
							customerContract.setVersion(contractVersion);
							customerContract.setContractManageValue(0.0);
							customerContract.setBidAmount(0.0);
							customerContract.setLateFee(0.0);
							customerContract.setCreateDate(t);
							customerContract.setUpdateDate(t);
							customerContract.setCreateUser("admin");
							customerContract.setUpdateUser("admin");

							ContractLender contractLender = new ContractLender();

							Lender lender = new Lender();
							lender.setId(3);

							contractLender.setLender(lender);
							contractLender.setContract(customerContract);
							contractLender.setCreateDate(t);
							contractLender.setUpdateDate(t);
							contractLender.setCreateUser("admin");
							contractLender.setUpdateUser("admin");
							lenders.add(contractLender);

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
									contractPara.setContract(customerContract);
									paras.add(contractPara);
									// contractParaService.add(contractPara);
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
									contractPara.setContract(customerContract);
									contractPara.setRemark(" ");
									paras.add(contractPara);
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
								cusContractCosts.setContract(customerContract);
								costs.add(cusContractCosts);
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
								if (getValue(stage).equals("还款明细")) {
									break;
								}
								if (getValue(stage) == null || getValue(stage).equals("")) {
									break;
								}
								ContractStageFee contractStageFee = new ContractStageFee();
								contractStage.setStage((int) stage.getNumericCellValue());

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

								contractStage.setContract(customerContract);
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
									int date = (int) repaymentDate.getNumericCellValue();
									if (date > 0) {
										Date rDate = DateUtils.addDays(d, date);
										contractStage.setRepaymentDate(rDate);
									}
								}
								contractStage.setCreateDate(t);
								contractStage.setUpdateDate(t);
								contractStage.setCreateUser("admin");
								contractStage.setUpdateUser("admin");

								// TODO 0期还款有问题
								if ((int) stage.getNumericCellValue() == 0) {
									contractStage.setState(1);
									ContractRepayment contractRepayment = new ContractRepayment();
									contractRepayment.setCapital(capitalss);
									contractRepayment.setInterest(Double.valueOf(interests) + serviceFes);
									contractRepayment.setExtraCharges(extraCharges);
									contractRepayment.setStage(contractStage);
									CusContractRepaymentOtherFee gpsOtherFee = new CusContractRepaymentOtherFee();
									CostType costP = new CostType();
									costP.setId(3);
									gpsOtherFee.setCostType(costP);
									// gpsOtherFee.setValue(co.getValue());
									// gpsOtherFee.setDefaultValue(co.getValue());
									gpsOtherFee.setCreateDate(contractRepayment.getCreateDate());
									gpsOtherFee.setUpdateDate(contractRepayment.getUpdateDate());
									gpsOtherFee.setRepayment(contractRepayment);
									gpsOtherFee.setCreateUser(contractRepayment.getCreateUser());
									gpsOtherFee.setUpdateUser(contractRepayment.getUpdateUser());
									otherFees.add(gpsOtherFee);
									contractRepayment.setOtherFees(otherFees);
									reps.add(contractRepayment);
								}
								if (j == 0) {
									contractNumRow = hssfSheet.getRow(rowNum + 2);
									HSSFCell gps = contractNumRow.getCell(1);
									Double gpss = Double.valueOf(getValue(gps));

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
										ParkingFee park = new ParkingFee();
										park.setId(parkingType);
										contractGpsLateFee.setParkingFee(park);
										contractGpsLateFee.setCostValue(parkingss);
										contractStage.setExtraCharges(parkingss);
									} else if (gpss > 0) {
										GpsCostType gpsCostType = new GpsCostType();
										gpsCostType.setId(gpsType);
										contractGpsLateFee.setType(gpsCostType);
										contractGpsLateFee.setCostValue(gpss);
										contractStage.setExtraCharges(gpss);
									}
									contractGpsLateFee.setContract(customerContract);
									contractGpsLateFee.setUpdateDate(t);
									contractGpsLateFee.setCreateDate(t);
									contractGpsLateFee.setCreateUser("admin");
									contractGpsLateFee.setUpdateUser("admin");
									gpsFees.add(contractGpsLateFee);
								}
								if (gpef > 0) {
									CostType costType = new CostType();
									costType.setId(fee[3]);
									contractStageFee.setCostType(costType);
									contractStageFee.setCreateDate(t);
									contractStageFee.setUpdateDate(t);
									contractStageFee.setCreateUser("admin");
									contractStageFee.setUpdateUser("admin");
									contractStageFee.setFee(gpef);
									contractStageFee.setStage(contractStage);
									stageFees.add(contractStageFee);
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
									contractStageFee.setStage(contractStage);
									stageFees.add(contractStageFee);
								}
								stages.add(contractStage);
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
//									ContractStage contractStages = contractStageService
//									 .findContractStageByContractAndStage(customerContract, stage);
//									contractLateFee.setContract(customerContract);
//									contractLateFee.setContractStage(contractStages);

									contractRepayment.setPayment(customerContract.getName());

									HSSFCell actualRepaymentAmount = repaymentRow.getCell(2);// 实还款金额
									String actualRepaymentAmounts = getValue(actualRepaymentAmount);
									if (actualRepaymentAmounts == null || actualRepaymentAmounts.equals("")) {
										actualRepaymentAmounts = "0.0";
									}
									Double actualRepaymentAmountss = Double.valueOf(actualRepaymentAmounts);
									contractRepayment.setRepaymentFee(actualRepaymentAmountss);
									Double extract = 0.0;
									extract = contractStage.getExtraCharges();
									if (extract == null) {
										extract = 0.0;
									}
									Double interest = contractStage.getInterest();
									if (interest == null) {
										interest = 0.0;
									}
									actualRepaymentAmountss = actualRepaymentAmountss - extract - interest;

									HSSFCell repaymentDate = repaymentRow.getCell(3);// 还款日期
									if (getValue(repaymentDate) == null || getValue(repaymentDate).equals("")) {
										break;
									}
									contractRepayment.setCapital(interest);
									contractRepayment.setExtraCharges(extract);
									contractRepayment.setCapital(actualRepaymentAmountss);
									if (actualRepaymentAmountss - contractStage.getCapital() >= 0) {
										contractRepayment
												.setMuchMore(actualRepaymentAmountss - contractStage.getCapital());
									} else {
										contractRepayment
												.setLessStill(-(actualRepaymentAmountss - contractStage.getCapital()));
									}
									int date = (int) repaymentDate.getNumericCellValue();
									if (date > 0) {
										Date rDate = DateUtils.addDays(d, date);
										contractRepayment.setRepaymentDate(rDate);
										contractLateFee.setOverDueTime(rDate);
									}
									if (actualRepaymentAmountss > 0.0) {
										contractStage.setState(1);
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
									
//									 contractLateFeeService.add(contractLateFee);
								
									contractRepayment.setLateFee(adp);
									// contractRepaymentService.add(contractRepayment);
								}
							}
						/*	DecimalFormat dfss = new DecimalFormat(".####");
							String str = dfss.format(latefee - latefees);
							customerContract.setLateFee(Double.valueOf(str));*/
							// customerContractService.update(customerContractID);
						} else {
							continue;
						}
					} catch (Exception e) {
						hql.append(e.getMessage());
						hql.append("\n");
						for (StackTraceElement stackTrace : e.getStackTrace()) {
							hql.append(stackTrace);
							hql.append("\n");
						}
					}
				}
				customerContract.setContractParas(paras);
				customerContract.setContractLenders(lenders);
				customerContract.setContractStages(stages);
				customerContract.setGpsLatefes(gpsFees);
				contractList.add(customerContract);
			}
		}
		FileOutputStream fs = new FileOutputStream(new File("/home/mjy/Desktop/file/aa.log"));
		PrintStream p = new PrintStream(fs);
		p.println(hql);
		p.close();
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