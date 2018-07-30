package com.jyd.translateContractStage.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestHui {

//	public static void main(String[] args) {
//		String str = "12.0";
//		
//		int stage = (int) Double.parseDouble(str);
//		
//		System.out.println(stage);
//				
//		
//	}
	
	
	@Test
	public void test2() {
//		 String value = "37759.990000000005";
		 String value = "64936.70999999999";
		 BigDecimal b = new BigDecimal(value);
		 double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();      
		 System.out.println(doubleValue);
	}
	
	@Test
	public void test3() {
		String str = "2018/23/23";
		String value = "";
		
		if(str.matches("(\\d{4})/(\\d{1,2})/(\\d{1,2})")) {
			StringBuilder sb = new StringBuilder();
			String[] split = str.split("/");
			
			sb.append(split[0]);//年
			sb.append("-");
			if(!split[1].matches("\\d{2}")) {//月
				sb.append("0"+split[1]);
			}else {
				sb.append(split[1]);
			}
			sb.append("-");
			if(!split[2].matches("\\d{2}")) {//日
				sb.append("0"+split[2]);
			}else {
				sb.append(split[2]);
			}
			value = sb.toString();
		}
		System.out.println(value);
		
	}
	
	@Test
	public void test4() {
		Set<String> lista = new HashSet<>();
		Set<String> listb = new HashSet<>();
		Set<String> listAll = new HashSet<>();
		
		
		lista.add("1");
		lista.add("2");
		lista.add("3");
		lista.add("4");
		
		listb.add("11");
		listb.add("2");
		listb.add("3");
		listb.add("4");
		
		System.out.println("lista:"+lista.size());
		System.out.println("listb:"+listb.size());
		
		listAll.addAll(lista);
		System.out.println("listAll:"+listAll.size());

		listAll.addAll(listb);
		System.out.println("listAll:"+listAll.size());
		for (String value : listAll) {
			System.out.println(value);
			
		}
		
	}
	
	@Test
	public void test5() {
		List<User> users = new ArrayList<>(); 
		
		users.add(new User("zhangsan", 10));
		users.add(new User("lisi", 20));
		users.add(new User("wangwu", 50));
		users.add(new User("weiliu", 10));
		
		
		User u = null;
		for (User user : users) {
			if(user.getName().equals("lisi")) {
				u = user;
			}
		}
		
		if(u != null) {
			u.setName("li");
		}
		
		for (User user : users) {
			System.out.println(user);
			
		}
		
	}
	
	@Test
	public void test6() {

		String str = "2018-08-20";
		String value = "";
		
		if(!str.matches("[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])")) {
			System.out.println(value);
		}
		
	
	}
	@Test
	public void test7() {
		
		String str = "6fdf43704.000000";
		String value = "";
		
		if(str.matches("\\w+\\.\\d+")) {
			str = str.replaceAll("(\\w+)\\.\\d+", "$1");
			System.out.println(str);
		}
		
		
	}
	
	@Test
	public void test8() {
		List<User> users = new ArrayList<>(); 
		
		users.add(new User("zhangsan", 10));
		users.add(new User("lisi", 20));
		users.add(new User("wangwu", 50));
		users.add(new User("weiliu", 10));
		
		
		System.out.println(users.size());
		
		users.clear();
		
		System.out.println(users.size());
		
	}
	
	
	
	@Test
	public void test9() {
		Map<String, Integer> storeMap = new LinkedHashMap<>();
		
		
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
		
		
		for (String key : storeMap.keySet()) {
			System.out.println("storeMap.put("+storeMap.get(key)+", \""+key+"\");");
		}
		
		
	}
	
	
	
	class User{
		private String name;
		private int age;
		
		public User() {
		}
		public User(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		@Override
		public String toString() {
			return "User [name=" + name + ", age=" + age + "]";
		}
		
		
	}
	
}
