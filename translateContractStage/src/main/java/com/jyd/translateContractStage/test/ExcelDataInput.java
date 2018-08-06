package com.jyd.translateContractStage.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jyd.bms.bean.ContractGpsLateFee;
import com.jyd.bms.bean.ContractLender;
import com.jyd.bms.bean.ContractPara;
import com.jyd.bms.bean.ContractRepayment;
import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.ContractStageFee;
import com.jyd.bms.bean.CusContractCost;
import com.jyd.bms.bean.CusContractRepaymentOtherFee;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.service.DeleteDataService;
import com.jyd.bms.service.ExcelBatchInsertDataService;
import com.jyd.translateContractStage.hui.App;

/**
 * storeMap.put("联融公司", 1); storeMap.put("东莞二店", 2); storeMap.put("许昌一店", 3);
 * storeMap.put("太原一店", 4); storeMap.put("广州一店", 5); storeMap.put("平顶山一店", 6);
 * storeMap.put("立刻贷广州一店", 7); storeMap.put("南阳一店", 8); storeMap.put("郑州一店", 9);
 * storeMap.put("东莞一店", 10); storeMap.put("p2p", 11); storeMap.put("驻马店一店", 12);
 * storeMap.put("新乡一店", 13); storeMap.put("信阳一店", 14); storeMap.put("洛阳一店", 15);
 * storeMap.put("立刻贷二店", 16); storeMap.put("总部", 17); storeMap.put("郑州二店", 18);
 * storeMap.put("河南分中心", 19); storeMap.put("南宁一店", 20); storeMap.put("广州分中心",
 * 21); storeMap.put("东莞分中心", 22);
 * 
 * 
 * CusContractCost 提交吧
 * 
 * @author aa
 *
 */
public class ExcelDataInput {

//	private static final int storeId = 3;// 许昌一店
//	private static final String path = "/home/aa/Desktop/laoda/许昌一店旧系统导入模板-许昌一店+(4)7.17 (1).xls";
	private static final int storeId = 18;// 郑州2店
	private static final String path = "/home/aa/Desktop/laoda/zhengzhou2/zhengzhou2(2).xls";

	private static final String deleteSqlFilePath = "/home/aa/Desktop/laoda/zhengzhou2/sql/";
	private static final Map<Integer, String> storeMap = new HashMap<>();
	// private static final String path = "/home/aa/Desktop/laoda/zhengzhou2.xls";
	private static int deletecount = 0;
	private static int count1 = 0;
	private static int count2 = 0;
	private static int count3 = 0;

	private static ClassPathXmlApplicationContext context;

	private static DeleteDataService deleteDataService;
	private static ExcelBatchInsertDataService excelBatchInsertDataService;

	private static Set<CustomerContract> customerContractList = new HashSet<>();// 合同
	private static Set<ContractLender> contractLenderList = new HashSet<>();
	private static Set<ContractPara> contractParaList = new HashSet<>();// 参数
	private static Set<CusContractCost> cusContractCostList = new HashSet<>();// 费用
	private static Set<ContractStage> contractStageList = new HashSet<>();// 分期
	private static Set<ContractRepayment> contractRepaymentList = new HashSet<>();// 还款
	private static Set<CusContractRepaymentOtherFee> cusContractRepaymentOtherFeeList = new HashSet<>();
	private static Set<ContractGpsLateFee> contractGpsLateFeeList = new HashSet<>();
	private static Set<ContractStageFee> contractStageFeeList = new HashSet<>();// 合同分期费

	static {
//		 context = new ClassPathXmlApplicationContext("config/spring.xml");
	}

	// @Before
	public void init() {

		deleteDataService = context.getBean(DeleteDataService.class);
		excelBatchInsertDataService = context.getBean(ExcelBatchInsertDataService.class);

	}

	private void packageStoreMap() {
		storeMap.put(1, "联融公司");
		storeMap.put(2, "东莞二店");
		storeMap.put(3, "许昌一店");
		storeMap.put(4, "太原一店");
		storeMap.put(5, "广州一店");
		storeMap.put(6, "平顶山一店");
		storeMap.put(7, "立刻贷广州一店");
		storeMap.put(8, "南阳一店");
		storeMap.put(9, "郑州一店");
		storeMap.put(10, "东莞一店");
		storeMap.put(11, "p2p");
		storeMap.put(12, "驻马店一店");
		storeMap.put(13, "新乡一店");
		storeMap.put(14, "信阳一店");
		storeMap.put(15, "洛阳一店");
		storeMap.put(16, "立刻贷二店");
		storeMap.put(17, "总部");
		storeMap.put(18, "郑州二店");
		storeMap.put(19, "河南分中心");
		storeMap.put(20, "南宁一店");
		storeMap.put(21, "广州分中心");
		storeMap.put(22, "东莞分中心");

	}

	@SuppressWarnings("unchecked")
	@Test
	public void inputData() {
//		 init();
		packageStoreMap();
		try {

			int count = 0;

			int one = 0;
			int two = 0;
			int three = 0;
			int four = 0;
			int five = 0;
			int six = 0;
			int seven = 0;
			int eight = 0;
			int nine = 0;

			Map<String, Object> map = new HashMap<String, Object>();
			// 测试excel数据格式
			boolean flag = App.isExcelOk(path);
			if (flag == true) {
				// 拿到返回的数据集合
				map = App.getDateList(path);

				customerContractList = (Set<CustomerContract>) map.get("customerContractList");
				contractLenderList = (Set<ContractLender>) map.get("contractLenderList");
				contractParaList = (Set<ContractPara>) map.get("contractParaList");
				cusContractCostList = (Set<CusContractCost>) map.get("cusContractCostList");
				contractStageList = (Set<ContractStage>) map.get("contractStageList");
				contractRepaymentList = (Set<ContractRepayment>) map.get("contractRepaymentList");
				cusContractRepaymentOtherFeeList = (Set<CusContractRepaymentOtherFee>) map
						.get("cusContractRepaymentOtherFeeList");
				contractGpsLateFeeList = (Set<ContractGpsLateFee>) map.get("contractGpsLateFeeList");
				contractStageFeeList = (Set<ContractStageFee>) map.get("contractStageFeeList");

				one = customerContractList.size();
				two = contractLenderList.size();
				three = contractParaList.size();
				four = cusContractCostList.size();
				five = contractStageList.size();
				six = contractRepaymentList.size();
				seven = cusContractRepaymentOtherFeeList.size();
				eight = contractGpsLateFeeList.size();
				nine = contractStageFeeList.size();

				System.out.println(one);
				System.out.println(two);
				System.out.println(three);
				System.out.println(four);
				System.out.println(five);
				System.out.println(six);
				System.out.println(seven);
				System.out.println(eight);
				System.out.println(nine);

				System.out.println();
				count = one + two + three + four + five + six + seven + eight + nine;
				System.out.println("查询总：" + count);
			} else {
				throw new RuntimeException("excel数据格式有错误！！");
			}
			// 删除数据
			List<String> contractNumList = new ArrayList<>();
			for (CustomerContract customerContract : customerContractList) {
				contractNumList.add(customerContract.getContractNum());
			}

//			printDeleteSql(contractNumList);
//			deleteData(contractNumList);

			// 批量插入数据集合
//			if (map.size() > 0) {
//
//				long start = System.currentTimeMillis();
//				int excuteBatchInsertAll = excelBatchInsertDataService.excuteBatchInsertAll(map);
//				long end = System.currentTimeMillis();
//
//				one = customerContractList.size();
//				two = contractLenderList.size();
//				three = contractParaList.size();
//				four = cusContractCostList.size();
//				five = contractStageList.size();
//				six = contractRepaymentList.size();
//				seven = cusContractRepaymentOtherFeeList.size();
//				eight = contractGpsLateFeeList.size();
//				nine = contractStageFeeList.size();
//
//				System.out.println("count1: " + count1);
//				System.out.println("count2: " + count2);
//				System.out.println("count3: " + count3);
//				System.out.println("共删除数据：" + deletecount);
//				System.out.println("客户合同：" + one + "条");
//				System.out.println("出借人：" + two + "条");
//				System.out.println("合同参数：" + three + "条");
//				System.out.println("客户合同费用：" + four + "条");
//				System.out.println("合同分期：" + five + "条");
//				System.out.println("合同还款：" + six + "条");
//				System.out.println("合同还款其他费用：" + seven + "条");
//				System.out.println("合同gps逾期费：" + eight + "条");
//				System.out.println("合同分期费用：" + nine + "条");
//				System.out.println("查询总：" + count);
//				System.out.println("插入总：" + excuteBatchInsertAll);
//				System.out.println("插入总费时：" + (end - start) + "ms");
//
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 打印删除sql
	 * 
	 * @param contractNumList
	 */
	private void printDeleteSql(List<String> contractNumList) {
		try {
			String deletepath = deleteSqlFilePath + storeMap.get(storeId) + "/delete";// /home/aa/Desktop/laoda/sql/delete1.sql";
			File file = new File(deletepath);

			if (!file.exists()) {
				file.mkdirs();
			}

			StringBuilder sb1 = new StringBuilder();

			StringBuilder sb2 = new StringBuilder();
			sb1.append("delete c,cost,gpsfee,para,lender,stage,ment,stagefee\n" + "	FROM cus_contract c \n"
					+ "	left join cus_contract_cost cost \n" + "		on c.id=cost.cus_contract_id \n"
					+ "	left join cus_contract_gps_late_fee gpsfee \n" + "		on c.id=gpsfee.cus_contract_id \n"
					+ "	left join  cus_contract_para para \n" + "		on c.id=para.cus_contract_id \n"
					+ "	left join cus_contract_lender lender \n" + "		on c.id=lender.cus_contract_id \n"
					+ "	left join cus_contract_stage stage \n" + "		on c.id=stage.cus_contract_id\n"
					+ "	left join cus_contract_stage_fee stagefee \n"
					+ "		on stage.id=stagefee.cus_contract_stage_id\n"
					+ "	left join cus_contract_repayment ment \n" + "		on stage.id=ment.cus_contract_stage_id\n"
					+ "	where c.id in(select a.id from (\n" + "			select id from cus_contract where store_id = "
					+ storeId + " and  cus_contract_no in ( ");
			sb2.append("delete otherfee \n" + "	from cus_contract_stage stage \n"
					+ "	left join cus_contract_repayment ment \n" + "		on stage.id=ment.cus_contract_stage_id\n"
					+ "	left join cus_contract_repayment_other_fee otherfee\n"
					+ "		on otherfee.cus_contract_repayment_id = ment.id\n"
					+ "	where stage.stage = 0 and stage.cus_contract_id in(\n"
					+ "			select id from cus_contract where store_id = " + storeId
					+ " and  cus_contract_no in ( ");

			for (int i = 0; i < contractNumList.size(); i++) {
				if (i < contractNumList.size() - 1) {
					sb1.append("'" + contractNumList.get(i) + "', " + "\n");
					sb2.append("'" + contractNumList.get(i) + "', " + "\n");
				} else {
					sb1.append("'" + contractNumList.get(i) + "'");
					sb2.append("'" + contractNumList.get(i) + "'");
				}
				// sb1.append(contractNumList.get(i)+", "+"\n");
				// sb2.append(contractNumList.get(i)+", "+"\n");
			}

			sb1.append(" ))a);");
			sb2.append(" ));");

			BufferedWriter bw1 = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(new File(file, "delete1.sql"))));
			BufferedWriter bw2 = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(new File(file, "delete2.sql"))));

			bw1.write(sb1.toString());
			bw2.write(sb2.toString());

			bw1.flush();
			bw2.flush();

			bw1.close();
			bw2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void deleteData(List<String> contractNumList) {
		// Date date = new Date();
		// count3 = deleteDataService.deleteDateByStoreAndDate2(storeId, date);
		// count1 = 0;//deleteDataService.deleteDateByStoreAndDate(storeId, date);
		// count2 = deleteDataService.deleteDateByStoreAndDate1(storeId, date);

		count3 = deleteDataService.deleteDateByStoreAndDate2(storeId, contractNumList);
		count1 = 0;// deleteDataService.deleteDateByStoreAndDate(storeId, date);
		count2 = deleteDataService.deleteDateByStoreAndDate1(storeId, contractNumList);

		deletecount = count1 + count2 + count3;

		System.out.println("分别删除数据是条数是：");
		System.out.println("count1= " + count1);
		System.out.println("count2= " + count2);
		System.out.println("count3= " + count3);
		System.out.println("共删除：" + deletecount);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("======================================");
		System.out.println();

	}
}
