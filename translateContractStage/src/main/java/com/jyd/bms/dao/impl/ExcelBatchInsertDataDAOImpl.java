package com.jyd.bms.dao.impl;

import java.sql.Timestamp;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractGpsLateFee;
import com.jyd.bms.bean.ContractLender;
import com.jyd.bms.bean.ContractPara;
import com.jyd.bms.bean.ContractRepayment;
import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.ContractStageFee;
import com.jyd.bms.bean.CostType;
import com.jyd.bms.bean.CusContractCost;
import com.jyd.bms.bean.CusContractRepaymentOtherFee;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.ExcelBatchInsertDataDAO;

@Repository
public class ExcelBatchInsertDataDAOImpl extends HibernateBaseTemplate<Object> implements ExcelBatchInsertDataDAO {

	private Set<CustomerContract> customerContractList;// 合同
	private Set<ContractLender> contractLenderList;
	private Set<ContractPara> contractParaList;// 参数
	private Set<CusContractCost> cusContractCostList;// 费用
	private Set<ContractStage> contractStageList;// 分期
	private Set<ContractRepayment> contractRepaymentList;// 还款
	private Set<CusContractRepaymentOtherFee> cusContractRepaymentOtherFeeList;
	private Set<ContractGpsLateFee> contractGpsLateFeeList;
	private Set<ContractStageFee> contractStageFeeList;// 合同分期费

	@SuppressWarnings("unchecked")
	@Override
	public int excuteBatchInsertAll(Map<String, Object> map) {
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

		HibernateTemplate template = this.getHibernateTemplate();
		Session session = template.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		int countAll = 0;
		try {
			//客户合同
			if (customerContractList != null && customerContractList.size() > 0) {

				countAll += addCustomerContract(session);
			}
			
			if (contractLenderList != null && contractLenderList.size() > 0) {

				countAll += addContractLender(session);
			}
			if (contractParaList != null && contractParaList.size() > 0) {

				countAll += addContractPara(session);
			}
			//合同分期
			if (contractStageList != null && contractStageList.size() > 0) {

				countAll += addContractStage(session);
			}
			//合同还款
			if (contractRepaymentList != null && contractRepaymentList.size() > 0) {
				
				countAll += addContractRepayment(session);
			}
			//合同还款其他费用
			if (cusContractRepaymentOtherFeeList != null && cusContractRepaymentOtherFeeList.size() > 0) {

				countAll += addCusContractRepaymentOtherFee(session);
			}
			//合同gps逾期费
			if (contractGpsLateFeeList != null && contractGpsLateFeeList.size() > 0) {

				countAll += addContractGpsLateFee(session);
			}
			//合同分期费用
			if (contractStageFeeList != null && contractStageFeeList.size() > 0) {

				countAll += addContractStageFee(session);
			}
			//客户合同费用
			if (cusContractCostList != null && cusContractCostList.size() > 0) {

				countAll += addCusContractCost(session);
			}
			
			

			
			
			transaction.commit();

			return countAll;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return countAll;
	}

	private int addContractStageFee(Session session) {
		int count = 0;
		for (ContractStageFee contractStageFee : contractStageFeeList) {
			count++;
			
			CostType costType = (CostType) session.get(CostType.class,contractStageFee.getCostType().getId());     
			contractStageFee.setCostType(costType);
			session.save(contractStageFee);    
			if(count%100 == 0){             //以每100个数据作为一个处理单元  
//				session.flush();           //保持与数据库数据的同步  
//				session.clear();           //清楚Session级别的一级缓存的全部数据，及时释放占用的内存  
		    }  
		}
		return count;
	}

	private int addContractGpsLateFee(Session session) {
		int count = 0;
		for (ContractGpsLateFee contractGpsLateFee : contractGpsLateFeeList) {
			count++;
			
			session.save(contractGpsLateFee);    
			if(count%100 == 0){             //以每100个数据作为一个处理单元  
//				session.flush();           //保持与数据库数据的同步  
//				session.clear();           //清楚Session级别的一级缓存的全部数据，及时释放占用的内存  
		    }  
		}
		return count;
	}

	private int addCusContractRepaymentOtherFee(Session session) {
		int count = 0;
		for (CusContractRepaymentOtherFee cusContractRepaymentOtherFee : cusContractRepaymentOtherFeeList) {
			count++;
			
			CostType costType = (CostType) session.get(CostType.class,cusContractRepaymentOtherFee.getCostType().getId());
			cusContractRepaymentOtherFee.setCostType(costType);
			session.save(cusContractRepaymentOtherFee);    
			if(count%100 == 0){             //以每100个数据作为一个处理单元  
//				session.flush();           //保持与数据库数据的同步  
//				session.clear();           //清楚Session级别的一级缓存的全部数据，及时释放占用的内存  
		    }  
		}
		return count;
	}

	private int addContractRepayment(Session session) {
		int count = 0;
		for (ContractRepayment contractRepayment : contractRepaymentList) {
			count++;
			
			session.save(contractRepayment);    
			if(count%100 == 0){             //以每100个数据作为一个处理单元  
				session.flush();           //保持与数据库数据的同步  
				session.clear();           //清楚Session级别的一级缓存的全部数据，及时释放占用的内存  
		    }  
		}
		return count;
	}

	private int addContractStage(Session session) {
		int count = 0;
		for (ContractStage contractStage : contractStageList) {
			count++;
			
			session.save(contractStage);    
			if(count%100 == 0){             //以每100个数据作为一个处理单元  
				session.flush();           //保持与数据库数据的同步  
				session.clear();           //清楚Session级别的一级缓存的全部数据，及时释放占用的内存  
		    }  
		}
		return count;
	}

	private int addCusContractCost(Session session) {
		int count = 0;
		for (CusContractCost cusContractCost : cusContractCostList) {
			count++;
			
			CostType costType =  (CostType) session.get(CostType.class,cusContractCost.getCostType().getId());    
			cusContractCost.setCostType(costType);
			session.save(cusContractCost);    
			if(count%100 == 0){             //以每100个数据作为一个处理单元  
//				session.flush();           //保持与数据库数据的同步  
//				session.clear();           //清楚Session级别的一级缓存的全部数据，及时释放占用的内存  
		    }  
		}
		return count;
	}

	private int addContractPara(Session session) {
		int count = 0;
		for (ContractPara contractPara : contractParaList) {
			count++;
			
			session.save(contractPara);    
			if(count%100 == 0){             //以每100个数据作为一个处理单元  
//				session.flush();           //保持与数据库数据的同步  
//				session.clear();           //清楚Session级别的一级缓存的全部数据，及时释放占用的内存  
		    }  
		}
		return count;
	}

	private int addContractLender(Session session) {
		int count = 0;
		for (ContractLender contractLender : contractLenderList) {
			count++;
			
			session.save(contractLender);    
			if(count%100 == 0){             //以每100个数据作为一个处理单元  
//				session.flush();           //保持与数据库数据的同步  
//				session.clear();           //清楚Session级别的一级缓存的全部数据，及时释放占用的内存  
		    }  
		}
		return count;
	}

	private int addCustomerContract(Session session) {
		int count = 0;
		for (CustomerContract customerContract : customerContractList) {
			count++;
			
			session.save(customerContract);    
			if(count%100 == 0){             //以每100个数据作为一个处理单元  
				session.flush();           //保持与数据库数据的同步  
				session.clear();           //清楚Session级别的一级缓存的全部数据，及时释放占用的内存  
		    }  
		}
		return count;
	}


}
