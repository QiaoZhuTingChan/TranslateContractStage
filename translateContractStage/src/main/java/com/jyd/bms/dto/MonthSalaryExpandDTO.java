package com.jyd.bms.dto;

import java.util.Comparator;

import com.jyd.bms.bean.MonthSalaryExpand;
import com.jyd.bms.bean.SalaryItem;

public class MonthSalaryExpandDTO {
	private SalaryItem salaryItem;
	private MonthSalaryExpand monthSalaryExpand;
	private int sortIndex;

	public SalaryItem getSalaryItem() {
		return salaryItem;
	}

	public void setSalaryItem(SalaryItem salaryItem) {
		this.salaryItem = salaryItem;
	}

	public MonthSalaryExpand getMonthSalaryExpand() {
		return monthSalaryExpand;
	}

	public void setMonthSalaryExpand(MonthSalaryExpand monthSalaryExpand) {
		this.monthSalaryExpand = monthSalaryExpand;
	}

	public int getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}

	public static class ComparatorSalaryItem implements Comparator {
		public int compare(Object o1, Object o2) {
			MonthSalaryExpandDTO value1 = (MonthSalaryExpandDTO) o1;
			MonthSalaryExpandDTO value2 = (MonthSalaryExpandDTO) o2;
			int result = value1.getSortIndex() - value2.getSortIndex();
			return result;
		}
	}
}