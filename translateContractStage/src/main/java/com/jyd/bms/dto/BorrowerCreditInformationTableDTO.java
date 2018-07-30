package com.jyd.bms.dto;

import java.util.HashMap;
import java.util.Map;

public class BorrowerCreditInformationTableDTO {

	// 第一行
	private String first_first_money_doublebox;
//	private String first_second_applicationPeriodBegin_datebox;
//	private String first_second_applicationPeriodEnd_datebox;
	private String first_second_repaymentStage_componentslistbox;
	// 第2行
	private Map<String, String> second_first_borrowingPurposes_checkbox_map = new HashMap<>();
	private Map<String, String> second_second_repaymentType_radiogroup_map = new HashMap<>();
	// 第4行
	private String fourth_first_name_textbox;
	private String fourth_second_idcard_textbox;
	private Map<String, String> fourth_third_gender_radiogroup_map = new HashMap<>();
	// 第5行
	private String fifth_first_phone_textbox;
	private Map<String, String> fifth_second_maritalStatus_radiogroup_map = new HashMap<>();
	private Map<String, String> fifth_third_education_radiogroup_map = new HashMap<>();
	// 第6行
	private String sixth_first_address_textbox;
	private String sixth_second_address_datebox;
	// 第7行
	private Map<String, String> seventh_first_houseType_radiogroup_map = new HashMap<>();
	// 第8行
	private String eight_first_email_textbox;
	private String eight_second_telephone_textbox;
	// 第10行
	private String tenth_first_plateNumber_textbox;
	private String tenth_second_carColor_textbox;
	private String tenth_third_carBrand_textbox;
	// 第11行
	private String eleventh_first_carLicenceDate_datebox;
	private String eleventh_second_carPurchaseDate_datebox;
	private String eleventh_third_carPrice_doublebox;
	private String eleventh_fourth_insourceExpireDate_datebox;
	private String eleventh_fifth_annualInspectionDate_datebox;
	// 第12行
	private Map<String, String> twelfth_first_purchaseType_radiogroup_map = new HashMap<>();
	private Map<String, String> twelfth_second_insourceBill_checkbox_map = new HashMap<>();
	// 第14行
	private String fourteenth_first_workUnitName_textbox;
	private Map<String, String> fourteenth_second_unitProperty_radiogroup_map = new HashMap<>();
	// 第15行
	private String fifteenth_first_workUnitAddress_textbox;
	private String fifteenth_second_unitPhone_textbox;
	// 第16行
	private Map<String, String> sixteenth_first_industry_radiogroup_map = new HashMap<>();
	// 第17行
	private Map<String, String> seventeenth_first_jobLevel_radiogroup_map = new HashMap<>();
	private String seventeenth_second_position_textbox;
	// 第18行
	private String eighteenth_first_monthlySalary_doublebox;
	private String eighteenth_second_otherMonthlySalary_doublebox;
	private String eighteenth_third_sumMonthlySalary_doublebox;
	// 第20行
	private Map<String, String> twentieth_first_debtSituation_radiogroup_map = new HashMap<>();
	// 第21行
	private Map<String, String> twentyfirst_first_otherPlatformBorrowSituation_radiogroup_map = new HashMap<>();
	private Map<String, String> twentyfirst_second_creditCardOverdueSituation_radiogroup_map = new HashMap<>();
	// 第22行
	private Map<String, String> twentySecond_first_creditReportOverdueSituation_radiogroup_map = new HashMap<>();
	private String twentySecond_first_overdueCount_intbox;
	private String twentySecond_first_overdueMoney_doublebox;
	private Map<String, String> twentySecond_second_isOperator_radiogroup_map = new HashMap<>();
	// 第23行
	private Map<String, String> twentythird_first_isPunished_radiogroup_map = new HashMap<>();
	private Map<String, String> twentythird_second_isAffectEquityInformation_radiogroup_map = new HashMap<>();
	// 第24行
	private String twentyfourth_first_name_textbox;
	private String twentyfourth_second_phone_textbox;
	private String twentyfourth_third_idcard_textbox;
	// 第25行
	private String twentyfifth_first_address_textbox;
	private Map<String, String> twentyfifth_second_isKnowThisBorrow_radiogroup_map = new HashMap<>();
	// 第26行
	private String twentysixth_first_name_textbox;
	private String twentysixth_second_phone_textbox;
	private String twentysixth_third_relationship_textbox;
	// 第27行
	private String twentyseventh_first_address_textbox;
	private Map<String, String> twentyseventh_second_isKnowThisBorrow_radiogroup_map = new HashMap<>();
	// 第28行
	private String twentyeighth_first_name_textbox;
	private String twentyeighth_second_phone_textbox;
	private String twentyeighth_third_relationship_textbox;
	// 第29行
	private String twentyninth_first_address_textbox;
	private Map<String, String> twentyninth_second_isKnowThisBorrow_radiogroup_map = new HashMap<>();
	// 第30行
	private String thirty_first_name_textbox;
	private String thirty_second_phone_textbox;
	private String thirty_third_relationship_textbox;
	// 第31行
	private String thirtyfirst_first_address_textbox;
	private Map<String, String> thirtyfirst_second_isKnowThisBorrow_radiogroup_map = new HashMap<>();
	// 第33行
	private String thirtythird_first_name_textbox;
	private String thirtythird_second_phone_textbox;
	private String thirtythird_third_idcard_textbox;
	// 第34行
	private String thirtyfourth_first_telephoneBegin_textbox;
	private String thirtyfourth_second_address_textbox;
	// 第35行
	private String thirtyfifth_first_workUnitName_textbox;
	private Map<String, String> thirtyfifth_second_unitProperty_radiogroup_map = new HashMap<>();
	// 第36行
	private String thirtysixth_first_address_textbox;
	private String thirtysixth_second_phone_textbox;
	private String thirtysixth_third_incomeCondition_doublebox;
	// 第37行
	private Map<String, String> thirtyseventh_first_one_radiogroup_map = new HashMap<>();
	private Map<String, String> thirtyseventh_first_two_radiogroup_map = new HashMap<>();
	private Map<String, String> thirtyseventh_first_three_radiogroup_map = new HashMap<>();

	public String getFirst_first_money_doublebox() {
		return first_first_money_doublebox;
	}

	public void setFirst_first_money_doublebox(String first_first_money_doublebox) {
		this.first_first_money_doublebox = first_first_money_doublebox;
	}

//	public String getFirst_second_applicationPeriodBegin_datebox() {
//		return first_second_applicationPeriodBegin_datebox;
//	}
//
//	public void setFirst_second_applicationPeriodBegin_datebox(String first_second_applicationPeriodBegin_datebox) {
//		this.first_second_applicationPeriodBegin_datebox = first_second_applicationPeriodBegin_datebox;
//	}
//
//	public String getFirst_second_applicationPeriodEnd_datebox() {
//		return first_second_applicationPeriodEnd_datebox;
//	}
//
//	public void setFirst_second_applicationPeriodEnd_datebox(String first_second_applicationPeriodEnd_datebox) {
//		this.first_second_applicationPeriodEnd_datebox = first_second_applicationPeriodEnd_datebox;
//	}

	public String getFirst_second_repaymentStage_componentslistbox() {
		return first_second_repaymentStage_componentslistbox;
	}

	public void setFirst_second_repaymentStage_componentslistbox(String first_second_repaymentStage_componentslistbox) {
		this.first_second_repaymentStage_componentslistbox = first_second_repaymentStage_componentslistbox;
	}

	public Map<String, String> getSecond_first_borrowingPurposes_checkbox_map() {
		return second_first_borrowingPurposes_checkbox_map;
	}

	public void setSecond_first_borrowingPurposes_checkbox_map(
			Map<String, String> second_first_borrowingPurposes_checkbox_map) {
		this.second_first_borrowingPurposes_checkbox_map = second_first_borrowingPurposes_checkbox_map;
	}

	public Map<String, String> getSecond_second_repaymentType_radiogroup_map() {
		return second_second_repaymentType_radiogroup_map;
	}

	public void setSecond_second_repaymentType_radiogroup_map(
			Map<String, String> second_second_repaymentType_radiogroup_map) {
		this.second_second_repaymentType_radiogroup_map = second_second_repaymentType_radiogroup_map;
	}

	public String getFourth_first_name_textbox() {
		return fourth_first_name_textbox;
	}

	public void setFourth_first_name_textbox(String fourth_first_name_textbox) {
		this.fourth_first_name_textbox = fourth_first_name_textbox;
	}

	public String getFourth_second_idcard_textbox() {
		return fourth_second_idcard_textbox;
	}

	public void setFourth_second_idcard_textbox(String fourth_second_idcard_textbox) {
		this.fourth_second_idcard_textbox = fourth_second_idcard_textbox;
	}

	public Map<String, String> getFourth_third_gender_radiogroup_map() {
		return fourth_third_gender_radiogroup_map;
	}

	public void setFourth_third_gender_radiogroup_map(Map<String, String> fourth_third_gender_radiogroup_map) {
		this.fourth_third_gender_radiogroup_map = fourth_third_gender_radiogroup_map;
	}

	public String getFifth_first_phone_textbox() {
		return fifth_first_phone_textbox;
	}

	public void setFifth_first_phone_textbox(String fifth_first_phone_textbox) {
		this.fifth_first_phone_textbox = fifth_first_phone_textbox;
	}

	public Map<String, String> getFifth_second_maritalStatus_radiogroup_map() {
		return fifth_second_maritalStatus_radiogroup_map;
	}

	public void setFifth_second_maritalStatus_radiogroup_map(
			Map<String, String> fifth_second_maritalStatus_radiogroup_map) {
		this.fifth_second_maritalStatus_radiogroup_map = fifth_second_maritalStatus_radiogroup_map;
	}

	public Map<String, String> getFifth_third_education_radiogroup_map() {
		return fifth_third_education_radiogroup_map;
	}

	public void setFifth_third_education_radiogroup_map(Map<String, String> fifth_third_education_radiogroup_map) {
		this.fifth_third_education_radiogroup_map = fifth_third_education_radiogroup_map;
	}

	public String getSixth_first_address_textbox() {
		return sixth_first_address_textbox;
	}

	public void setSixth_first_address_textbox(String sixth_first_address_textbox) {
		this.sixth_first_address_textbox = sixth_first_address_textbox;
	}

	public String getSixth_second_address_datebox() {
		return sixth_second_address_datebox;
	}

	public void setSixth_second_address_datebox(String sixth_second_address_datebox) {
		this.sixth_second_address_datebox = sixth_second_address_datebox;
	}

	public Map<String, String> getSeventh_first_houseType_radiogroup_map() {
		return seventh_first_houseType_radiogroup_map;
	}

	public void setSeventh_first_houseType_radiogroup_map(Map<String, String> seventh_first_houseType_radiogroup_map) {
		this.seventh_first_houseType_radiogroup_map = seventh_first_houseType_radiogroup_map;
	}

	public String getEight_first_email_textbox() {
		return eight_first_email_textbox;
	}

	public void setEight_first_email_textbox(String eight_first_email_textbox) {
		this.eight_first_email_textbox = eight_first_email_textbox;
	}

	public String getEight_second_telephone_textbox() {
		return eight_second_telephone_textbox;
	}

	public void setEight_second_telephone_textbox(String eight_second_telephone_textbox) {
		this.eight_second_telephone_textbox = eight_second_telephone_textbox;
	}

	public String getTenth_first_plateNumber_textbox() {
		return tenth_first_plateNumber_textbox;
	}

	public void setTenth_first_plateNumber_textbox(String tenth_first_plateNumber_textbox) {
		this.tenth_first_plateNumber_textbox = tenth_first_plateNumber_textbox;
	}

	public String getTenth_second_carColor_textbox() {
		return tenth_second_carColor_textbox;
	}

	public void setTenth_second_carColor_textbox(String tenth_second_carColor_textbox) {
		this.tenth_second_carColor_textbox = tenth_second_carColor_textbox;
	}

	public String getTenth_third_carBrand_textbox() {
		return tenth_third_carBrand_textbox;
	}

	public void setTenth_third_carBrand_textbox(String tenth_third_carBrand_textbox) {
		this.tenth_third_carBrand_textbox = tenth_third_carBrand_textbox;
	}

	public String getEleventh_first_carLicenceDate_datebox() {
		return eleventh_first_carLicenceDate_datebox;
	}

	public void setEleventh_first_carLicenceDate_datebox(String eleventh_first_carLicenceDate_datebox) {
		this.eleventh_first_carLicenceDate_datebox = eleventh_first_carLicenceDate_datebox;
	}

	public String getEleventh_second_carPurchaseDate_datebox() {
		return eleventh_second_carPurchaseDate_datebox;
	}

	public void setEleventh_second_carPurchaseDate_datebox(String eleventh_second_carPurchaseDate_datebox) {
		this.eleventh_second_carPurchaseDate_datebox = eleventh_second_carPurchaseDate_datebox;
	}

	public String getEleventh_third_carPrice_doublebox() {
		return eleventh_third_carPrice_doublebox;
	}

	public void setEleventh_third_carPrice_doublebox(String eleventh_third_carPrice_doublebox) {
		this.eleventh_third_carPrice_doublebox = eleventh_third_carPrice_doublebox;
	}

	public String getEleventh_fourth_insourceExpireDate_datebox() {
		return eleventh_fourth_insourceExpireDate_datebox;
	}

	public void setEleventh_fourth_insourceExpireDate_datebox(String eleventh_fourth_insourceExpireDate_datebox) {
		this.eleventh_fourth_insourceExpireDate_datebox = eleventh_fourth_insourceExpireDate_datebox;
	}

	public String getEleventh_fifth_annualInspectionDate_datebox() {
		return eleventh_fifth_annualInspectionDate_datebox;
	}

	public void setEleventh_fifth_annualInspectionDate_datebox(String eleventh_fifth_annualInspectionDate_datebox) {
		this.eleventh_fifth_annualInspectionDate_datebox = eleventh_fifth_annualInspectionDate_datebox;
	}

	public Map<String, String> getTwelfth_first_purchaseType_radiogroup_map() {
		return twelfth_first_purchaseType_radiogroup_map;
	}

	public void setTwelfth_first_purchaseType_radiogroup_map(
			Map<String, String> twelfth_first_purchaseType_radiogroup_map) {
		this.twelfth_first_purchaseType_radiogroup_map = twelfth_first_purchaseType_radiogroup_map;
	}

	public Map<String, String> getTwelfth_second_insourceBill_checkbox_map() {
		return twelfth_second_insourceBill_checkbox_map;
	}

	public void setTwelfth_second_insourceBill_checkbox_map(
			Map<String, String> twelfth_second_insourceBill_checkbox_map) {
		this.twelfth_second_insourceBill_checkbox_map = twelfth_second_insourceBill_checkbox_map;
	}

	public String getFourteenth_first_workUnitName_textbox() {
		return fourteenth_first_workUnitName_textbox;
	}

	public void setFourteenth_first_workUnitName_textbox(String fourteenth_first_workUnitName_textbox) {
		this.fourteenth_first_workUnitName_textbox = fourteenth_first_workUnitName_textbox;
	}

	public Map<String, String> getFourteenth_second_unitProperty_radiogroup_map() {
		return fourteenth_second_unitProperty_radiogroup_map;
	}

	public void setFourteenth_second_unitProperty_radiogroup_map(
			Map<String, String> fourteenth_second_unitProperty_radiogroup_map) {
		this.fourteenth_second_unitProperty_radiogroup_map = fourteenth_second_unitProperty_radiogroup_map;
	}

	public String getFifteenth_first_workUnitAddress_textbox() {
		return fifteenth_first_workUnitAddress_textbox;
	}

	public void setFifteenth_first_workUnitAddress_textbox(String fifteenth_first_workUnitAddress_textbox) {
		this.fifteenth_first_workUnitAddress_textbox = fifteenth_first_workUnitAddress_textbox;
	}

	public String getFifteenth_second_unitPhone_textbox() {
		return fifteenth_second_unitPhone_textbox;
	}

	public void setFifteenth_second_unitPhone_textbox(String fifteenth_second_unitPhone_textbox) {
		this.fifteenth_second_unitPhone_textbox = fifteenth_second_unitPhone_textbox;
	}

	public Map<String, String> getSixteenth_first_industry_radiogroup_map() {
		return sixteenth_first_industry_radiogroup_map;
	}

	public void setSixteenth_first_industry_radiogroup_map(
			Map<String, String> sixteenth_first_industry_radiogroup_map) {
		this.sixteenth_first_industry_radiogroup_map = sixteenth_first_industry_radiogroup_map;
	}

	public Map<String, String> getSeventeenth_first_jobLevel_radiogroup_map() {
		return seventeenth_first_jobLevel_radiogroup_map;
	}

	public void setSeventeenth_first_jobLevel_radiogroup_map(
			Map<String, String> seventeenth_first_jobLevel_radiogroup_map) {
		this.seventeenth_first_jobLevel_radiogroup_map = seventeenth_first_jobLevel_radiogroup_map;
	}

	public String getSeventeenth_second_position_textbox() {
		return seventeenth_second_position_textbox;
	}

	public void setSeventeenth_second_position_textbox(String seventeenth_second_position_textbox) {
		this.seventeenth_second_position_textbox = seventeenth_second_position_textbox;
	}

	public String getEighteenth_first_monthlySalary_doublebox() {
		return eighteenth_first_monthlySalary_doublebox;
	}

	public void setEighteenth_first_monthlySalary_doublebox(String eighteenth_first_monthlySalary_doublebox) {
		this.eighteenth_first_monthlySalary_doublebox = eighteenth_first_monthlySalary_doublebox;
	}

	public String getEighteenth_second_otherMonthlySalary_doublebox() {
		return eighteenth_second_otherMonthlySalary_doublebox;
	}

	public void setEighteenth_second_otherMonthlySalary_doublebox(
			String eighteenth_second_otherMonthlySalary_doublebox) {
		this.eighteenth_second_otherMonthlySalary_doublebox = eighteenth_second_otherMonthlySalary_doublebox;
	}

	public String getEighteenth_third_sumMonthlySalary_doublebox() {
		return eighteenth_third_sumMonthlySalary_doublebox;
	}

	public void setEighteenth_third_sumMonthlySalary_doublebox(String eighteenth_third_sumMonthlySalary_doublebox) {
		this.eighteenth_third_sumMonthlySalary_doublebox = eighteenth_third_sumMonthlySalary_doublebox;
	}

	public Map<String, String> getTwentieth_first_debtSituation_radiogroup_map() {
		return twentieth_first_debtSituation_radiogroup_map;
	}

	public void setTwentieth_first_debtSituation_radiogroup_map(
			Map<String, String> twentieth_first_debtSituation_radiogroup_map) {
		this.twentieth_first_debtSituation_radiogroup_map = twentieth_first_debtSituation_radiogroup_map;
	}

	public Map<String, String> getTwentyfirst_first_otherPlatformBorrowSituation_radiogroup_map() {
		return twentyfirst_first_otherPlatformBorrowSituation_radiogroup_map;
	}

	public void setTwentyfirst_first_otherPlatformBorrowSituation_radiogroup_map(
			Map<String, String> twentyfirst_first_otherPlatformBorrowSituation_radiogroup_map) {
		this.twentyfirst_first_otherPlatformBorrowSituation_radiogroup_map = twentyfirst_first_otherPlatformBorrowSituation_radiogroup_map;
	}

	public Map<String, String> getTwentyfirst_second_creditCardOverdueSituation_radiogroup_map() {
		return twentyfirst_second_creditCardOverdueSituation_radiogroup_map;
	}

	public void setTwentyfirst_second_creditCardOverdueSituation_radiogroup_map(
			Map<String, String> twentyfirst_second_creditCardOverdueSituation_radiogroup_map) {
		this.twentyfirst_second_creditCardOverdueSituation_radiogroup_map = twentyfirst_second_creditCardOverdueSituation_radiogroup_map;
	}

	public Map<String, String> getTwentySecond_first_creditReportOverdueSituation_radiogroup_map() {
		return twentySecond_first_creditReportOverdueSituation_radiogroup_map;
	}

	public void setTwentySecond_first_creditReportOverdueSituation_radiogroup_map(
			Map<String, String> twentySecond_first_creditReportOverdueSituation_radiogroup_map) {
		this.twentySecond_first_creditReportOverdueSituation_radiogroup_map = twentySecond_first_creditReportOverdueSituation_radiogroup_map;
	}

	public String getTwentySecond_first_overdueCount_intbox() {
		return twentySecond_first_overdueCount_intbox;
	}

	public void setTwentySecond_first_overdueCount_intbox(String twentySecond_first_overdueCount_intbox) {
		this.twentySecond_first_overdueCount_intbox = twentySecond_first_overdueCount_intbox;
	}

	public String getTwentySecond_first_overdueMoney_doublebox() {
		return twentySecond_first_overdueMoney_doublebox;
	}

	public void setTwentySecond_first_overdueMoney_doublebox(String twentySecond_first_overdueMoney_doublebox) {
		this.twentySecond_first_overdueMoney_doublebox = twentySecond_first_overdueMoney_doublebox;
	}

	public Map<String, String> getTwentySecond_second_isOperator_radiogroup_map() {
		return twentySecond_second_isOperator_radiogroup_map;
	}

	public void setTwentySecond_second_isOperator_radiogroup_map(
			Map<String, String> twentySecond_second_isOperator_radiogroup_map) {
		this.twentySecond_second_isOperator_radiogroup_map = twentySecond_second_isOperator_radiogroup_map;
	}

	public Map<String, String> getTwentythird_first_isPunished_radiogroup_map() {
		return twentythird_first_isPunished_radiogroup_map;
	}

	public void setTwentythird_first_isPunished_radiogroup_map(
			Map<String, String> twentythird_first_isPunished_radiogroup_map) {
		this.twentythird_first_isPunished_radiogroup_map = twentythird_first_isPunished_radiogroup_map;
	}

	public Map<String, String> getTwentythird_second_isAffectEquityInformation_radiogroup_map() {
		return twentythird_second_isAffectEquityInformation_radiogroup_map;
	}

	public void setTwentythird_second_isAffectEquityInformation_radiogroup_map(
			Map<String, String> twentythird_second_isAffectEquityInformation_radiogroup_map) {
		this.twentythird_second_isAffectEquityInformation_radiogroup_map = twentythird_second_isAffectEquityInformation_radiogroup_map;
	}

	public String getTwentyfourth_first_name_textbox() {
		return twentyfourth_first_name_textbox;
	}

	public void setTwentyfourth_first_name_textbox(String twentyfourth_first_name_textbox) {
		this.twentyfourth_first_name_textbox = twentyfourth_first_name_textbox;
	}

	public String getTwentyfourth_second_phone_textbox() {
		return twentyfourth_second_phone_textbox;
	}

	public void setTwentyfourth_second_phone_textbox(String twentyfourth_second_phone_textbox) {
		this.twentyfourth_second_phone_textbox = twentyfourth_second_phone_textbox;
	}

	public String getTwentyfourth_third_idcard_textbox() {
		return twentyfourth_third_idcard_textbox;
	}

	public void setTwentyfourth_third_idcard_textbox(String twentyfourth_third_idcard_textbox) {
		this.twentyfourth_third_idcard_textbox = twentyfourth_third_idcard_textbox;
	}

	public String getTwentyfifth_first_address_textbox() {
		return twentyfifth_first_address_textbox;
	}

	public void setTwentyfifth_first_address_textbox(String twentyfifth_first_address_textbox) {
		this.twentyfifth_first_address_textbox = twentyfifth_first_address_textbox;
	}

	public Map<String, String> getTwentyfifth_second_isKnowThisBorrow_radiogroup_map() {
		return twentyfifth_second_isKnowThisBorrow_radiogroup_map;
	}

	public void setTwentyfifth_second_isKnowThisBorrow_radiogroup_map(
			Map<String, String> twentyfifth_second_isKnowThisBorrow_radiogroup_map) {
		this.twentyfifth_second_isKnowThisBorrow_radiogroup_map = twentyfifth_second_isKnowThisBorrow_radiogroup_map;
	}

	public String getTwentysixth_first_name_textbox() {
		return twentysixth_first_name_textbox;
	}

	public void setTwentysixth_first_name_textbox(String twentysixth_first_name_textbox) {
		this.twentysixth_first_name_textbox = twentysixth_first_name_textbox;
	}

	public String getTwentysixth_second_phone_textbox() {
		return twentysixth_second_phone_textbox;
	}

	public void setTwentysixth_second_phone_textbox(String twentysixth_second_phone_textbox) {
		this.twentysixth_second_phone_textbox = twentysixth_second_phone_textbox;
	}

	public String getTwentysixth_third_relationship_textbox() {
		return twentysixth_third_relationship_textbox;
	}

	public void setTwentysixth_third_relationship_textbox(String twentysixth_third_relationship_textbox) {
		this.twentysixth_third_relationship_textbox = twentysixth_third_relationship_textbox;
	}

	public String getTwentyseventh_first_address_textbox() {
		return twentyseventh_first_address_textbox;
	}

	public void setTwentyseventh_first_address_textbox(String twentyseventh_first_address_textbox) {
		this.twentyseventh_first_address_textbox = twentyseventh_first_address_textbox;
	}

	public Map<String, String> getTwentyseventh_second_isKnowThisBorrow_radiogroup_map() {
		return twentyseventh_second_isKnowThisBorrow_radiogroup_map;
	}

	public void setTwentyseventh_second_isKnowThisBorrow_radiogroup_map(
			Map<String, String> twentyseventh_second_isKnowThisBorrow_radiogroup_map) {
		this.twentyseventh_second_isKnowThisBorrow_radiogroup_map = twentyseventh_second_isKnowThisBorrow_radiogroup_map;
	}

	public String getTwentyeighth_first_name_textbox() {
		return twentyeighth_first_name_textbox;
	}

	public void setTwentyeighth_first_name_textbox(String twentyeighth_first_name_textbox) {
		this.twentyeighth_first_name_textbox = twentyeighth_first_name_textbox;
	}

	public String getTwentyeighth_second_phone_textbox() {
		return twentyeighth_second_phone_textbox;
	}

	public void setTwentyeighth_second_phone_textbox(String twentyeighth_second_phone_textbox) {
		this.twentyeighth_second_phone_textbox = twentyeighth_second_phone_textbox;
	}

	public String getTwentyeighth_third_relationship_textbox() {
		return twentyeighth_third_relationship_textbox;
	}

	public void setTwentyeighth_third_relationship_textbox(String twentyeighth_third_relationship_textbox) {
		this.twentyeighth_third_relationship_textbox = twentyeighth_third_relationship_textbox;
	}

	public String getTwentyninth_first_address_textbox() {
		return twentyninth_first_address_textbox;
	}

	public void setTwentyninth_first_address_textbox(String twentyninth_first_address_textbox) {
		this.twentyninth_first_address_textbox = twentyninth_first_address_textbox;
	}

	public Map<String, String> getTwentyninth_second_isKnowThisBorrow_radiogroup_map() {
		return twentyninth_second_isKnowThisBorrow_radiogroup_map;
	}

	public void setTwentyninth_second_isKnowThisBorrow_radiogroup_map(
			Map<String, String> twentyninth_second_isKnowThisBorrow_radiogroup_map) {
		this.twentyninth_second_isKnowThisBorrow_radiogroup_map = twentyninth_second_isKnowThisBorrow_radiogroup_map;
	}

	public String getThirty_first_name_textbox() {
		return thirty_first_name_textbox;
	}

	public void setThirty_first_name_textbox(String thirty_first_name_textbox) {
		this.thirty_first_name_textbox = thirty_first_name_textbox;
	}

	public String getThirty_second_phone_textbox() {
		return thirty_second_phone_textbox;
	}

	public void setThirty_second_phone_textbox(String thirty_second_phone_textbox) {
		this.thirty_second_phone_textbox = thirty_second_phone_textbox;
	}

	public String getThirty_third_relationship_textbox() {
		return thirty_third_relationship_textbox;
	}

	public void setThirty_third_relationship_textbox(String thirty_third_relationship_textbox) {
		this.thirty_third_relationship_textbox = thirty_third_relationship_textbox;
	}

	public String getThirtyfirst_first_address_textbox() {
		return thirtyfirst_first_address_textbox;
	}

	public void setThirtyfirst_first_address_textbox(String thirtyfirst_first_address_textbox) {
		this.thirtyfirst_first_address_textbox = thirtyfirst_first_address_textbox;
	}

	public Map<String, String> getThirtyfirst_second_isKnowThisBorrow_radiogroup_map() {
		return thirtyfirst_second_isKnowThisBorrow_radiogroup_map;
	}

	public void setThirtyfirst_second_isKnowThisBorrow_radiogroup_map(
			Map<String, String> thirtyfirst_second_isKnowThisBorrow_radiogroup_map) {
		this.thirtyfirst_second_isKnowThisBorrow_radiogroup_map = thirtyfirst_second_isKnowThisBorrow_radiogroup_map;
	}

	public String getThirtythird_first_name_textbox() {
		return thirtythird_first_name_textbox;
	}

	public void setThirtythird_first_name_textbox(String thirtythird_first_name_textbox) {
		this.thirtythird_first_name_textbox = thirtythird_first_name_textbox;
	}

	public String getThirtythird_second_phone_textbox() {
		return thirtythird_second_phone_textbox;
	}

	public void setThirtythird_second_phone_textbox(String thirtythird_second_phone_textbox) {
		this.thirtythird_second_phone_textbox = thirtythird_second_phone_textbox;
	}

	public String getThirtythird_third_idcard_textbox() {
		return thirtythird_third_idcard_textbox;
	}

	public void setThirtythird_third_idcard_textbox(String thirtythird_third_idcard_textbox) {
		this.thirtythird_third_idcard_textbox = thirtythird_third_idcard_textbox;
	}

	public String getThirtyfourth_first_telephoneBegin_textbox() {
		return thirtyfourth_first_telephoneBegin_textbox;
	}

	public void setThirtyfourth_first_telephoneBegin_textbox(String thirtyfourth_first_telephoneBegin_textbox) {
		this.thirtyfourth_first_telephoneBegin_textbox = thirtyfourth_first_telephoneBegin_textbox;
	}


	public String getThirtyfourth_second_address_textbox() {
		return thirtyfourth_second_address_textbox;
	}

	public void setThirtyfourth_second_address_textbox(String thirtyfourth_second_address_textbox) {
		this.thirtyfourth_second_address_textbox = thirtyfourth_second_address_textbox;
	}

	public String getThirtyfifth_first_workUnitName_textbox() {
		return thirtyfifth_first_workUnitName_textbox;
	}

	public void setThirtyfifth_first_workUnitName_textbox(String thirtyfifth_first_workUnitName_textbox) {
		this.thirtyfifth_first_workUnitName_textbox = thirtyfifth_first_workUnitName_textbox;
	}

	public Map<String, String> getThirtyfifth_second_unitProperty_radiogroup_map() {
		return thirtyfifth_second_unitProperty_radiogroup_map;
	}

	public void setThirtyfifth_second_unitProperty_radiogroup_map(
			Map<String, String> thirtyfifth_second_unitProperty_radiogroup_map) {
		this.thirtyfifth_second_unitProperty_radiogroup_map = thirtyfifth_second_unitProperty_radiogroup_map;
	}

	public String getThirtysixth_first_address_textbox() {
		return thirtysixth_first_address_textbox;
	}

	public void setThirtysixth_first_address_textbox(String thirtysixth_first_address_textbox) {
		this.thirtysixth_first_address_textbox = thirtysixth_first_address_textbox;
	}

	public String getThirtysixth_second_phone_textbox() {
		return thirtysixth_second_phone_textbox;
	}

	public void setThirtysixth_second_phone_textbox(String thirtysixth_second_phone_textbox) {
		this.thirtysixth_second_phone_textbox = thirtysixth_second_phone_textbox;
	}

	public String getThirtysixth_third_incomeCondition_doublebox() {
		return thirtysixth_third_incomeCondition_doublebox;
	}

	public void setThirtysixth_third_incomeCondition_doublebox(String thirtysixth_third_incomeCondition_doublebox) {
		this.thirtysixth_third_incomeCondition_doublebox = thirtysixth_third_incomeCondition_doublebox;
	}

	public Map<String, String> getThirtyseventh_first_one_radiogroup_map() {
		return thirtyseventh_first_one_radiogroup_map;
	}

	public void setThirtyseventh_first_one_radiogroup_map(Map<String, String> thirtyseventh_first_one_radiogroup_map) {
		this.thirtyseventh_first_one_radiogroup_map = thirtyseventh_first_one_radiogroup_map;
	}

	public Map<String, String> getThirtyseventh_first_two_radiogroup_map() {
		return thirtyseventh_first_two_radiogroup_map;
	}

	public void setThirtyseventh_first_two_radiogroup_map(Map<String, String> thirtyseventh_first_two_radiogroup_map) {
		this.thirtyseventh_first_two_radiogroup_map = thirtyseventh_first_two_radiogroup_map;
	}

	public Map<String, String> getThirtyseventh_first_three_radiogroup_map() {
		return thirtyseventh_first_three_radiogroup_map;
	}

	public void setThirtyseventh_first_three_radiogroup_map(
			Map<String, String> thirtyseventh_first_three_radiogroup_map) {
		this.thirtyseventh_first_three_radiogroup_map = thirtyseventh_first_three_radiogroup_map;
	}

}
