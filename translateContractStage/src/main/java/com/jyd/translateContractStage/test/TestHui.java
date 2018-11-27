package com.jyd.translateContractStage.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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

	// public static void main(String[] args) {
	// String str = "12.0";
	//
	// int stage = (int) Double.parseDouble(str);
	//
	// System.out.println(stage);
	//
	//
	// }
	@Test
	public void testContractNo() {
		
		
	}
	
	
	
	
	
	@Test
	public void TestHKId() {
		String regex = "^[A-Z]?[A-Z]{1}\\d{6}\\([0-9A]{1}\\)$";
		String value = "H1006283900";
		
		if(value.matches(regex)) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
		
	}
	
	
	@Test
	public void findChongfu() {
		List<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(11);
		list.add(11);
		list.add(12);
		list.add(12);
		list.add(32);
		list.add(54);
		list.add(54);
		list.add(54);
		list.add(85);

		System.out.println(list);
		Map<Integer, Integer> countMap = new HashMap<>();
		if (!list.isEmpty()) {
			for (Integer value : list) {
				if (countMap.get(value) != null) {
					countMap.put(value, countMap.get(value) + 1);
				} else {
					countMap.put(value, 1);
				}
			}
		}

		for (Integer key : countMap.keySet()) {
			System.out.println(key + "  ---> " + countMap.get(key));

		}
	}

	@Test
	public void test1() {
		String str = "0420180118005\n" + "0420180421002\n" + "0420180127006\n" + "0371ZZ120170710-3\n"
				+ "JYD20161110-A006\n" + "0420180301001\n" + "0371ZZ120170727-1\n" + "0420180123004\n"
				+ "0371ZZ120170802-3\n" + "0371ZZ120170804-3\n" + "0371ZZ120170904-4\n" + "0371ZZ120170616-1\n"
				+ "0420180131002\n" + "0420180302001\n" + "042018018004\n" + "0371ZZ120170725-4\n" + "0420180301002\n"
				+ "0420180126003\n" + "0420180123006\n" + "0371ZZ20170323-9\n" + "0420180209002\n" + "0420180126002\n"
				+ "0420180112007\n" + "0371ZZ120170905-2\n" + "0420180208005\n" + "0420180419003\n"
				+ "0371ZZ20170413-2\n" + "0371ZZ120170825-1\n" + "0371ZZ120170804-1\n" + "0420180205001\n"
				+ "0371ZZ120170815-3\n" + "0371ZZ120170907-3\n" + "0371ZZ120170815\n" + "0420180131003\n"
				+ "0371ZZ120170904-9\n" + "0420180425001\n" + "0371ZZ120170802-1\n" + "0371ZZ120170812-2\n"
				+ "0371ZZ120170710-2\n" + "0371ZZ120170710-6\n" + "0420180424001\n" + "0371ZZ20170411-1\n"
				+ "0420180122002\n" + "0371ZZ120170824-1\n" + "0420180301004\n" + "0420180224001\n" + "0420180205002\n"
				+ "0371ZZ120170911-1\n" + "0420180112004\n" + "0371ZZ120171220-7\n" + "0371ZZ120170822-6\n"
				+ "0420180113001\n" + "0371ZZ20170327-11\n" + "0371ZZ120170427-8\n" + "0371ZZ120170809-4\n"
				+ "0371ZZ20170322-12\n" + "0371ZZ120170810-1\n" + "0371ZZ20170323-4\n" + "0371ZZ20170329-1\n"
				+ "0420180227002\n" + "0371zz120170818-3\n" + "0371ZZ20170327-2\n" + "0420180113002\n"
				+ "0420180428001\n" + "0371ZZ120170822-2\n" + "0371ZZ120180103-4\n" + "0371ZZ120170712-1\n"
				+ "0371ZZ120170830-9\n" + "0420180123007\n" + "0420180207002\n" + "0371ZZ120170712-10\n"
				+ "0371ZZ20170331-1\n" + "0420180125002\n" + "0371ZZ120170810-4\n" + "0420180123001\n"
				+ "420180116007.000000\n" + "0371ZZ20170410-3\n" + "0371ZZ120180108-1\n" + "0420180420002\n"
				+ "0420180427001\n" + "0371ZZ120170725-1\n" + "0371ZZ120180105-5\n" + "042018012610\n"
				+ "0420180206001\n" + "0420180130005\n" + "0371ZZ120170720-5\n" + "0420180420005\n"
				+ "0371ZZ120170831-1\n" + "0420180122004\n" + "0420180130004\n" + "0371ZZ120170902-2\n"
				+ "0420180120002\n" + "0371ZZ120180104-4\n" + "0371ZZ120170710-1\n" + "0420180208009\n"
				+ "0371ZZ120170830-2\n" + "0371ZZ120170911-13\n" + "0371ZZ120170331-13\n" + "0420180502001\n"
				+ "0420180301003\n" + "0371ZZ120170815-1\n" + "0420180127006\n" + "0371ZZ120170823-4\n"
				+ "0371ZZ120170904-12\n" + "0371zz120170912-1\n" + "0371ZZ120171205-1\n" + "0420180125008\n"
				+ "0371ZZ120170911-5\n" + "0371ZZ120180105-4\n" + "0371ZZ120170706-7\n" + "0371ZZ120170810-2\n"
				+ "0371ZZ120170715-2\n" + "0371ZZ120170922-6\n" + "0371ZZ120170712-11\n" + "0420180113006\n"
				+ "0371ZZ120170712-12\n" + "0420180118003\n" + "0371ZZ120171010-3\n" + "0371ZZ120170829-1\n"
				+ "0371ZZ120170706-4\n" + "0420180201002\n" + "0420180125007\n" + "0371ZZ120170718-1\n"
				+ "0371ZZ20170410-2\n" + "0371ZZ120170829-8\n" + "0371ZZ120170822-5\n" + "JYD20180119-B003\n"
				+ "0371ZZ12080102-3\n" + "0420180426004\n" + "0371ZZ120180104-1\n" + "0420180419002\n"
				+ "0371ZZ120170524-9\n" + "0371ZZ20170413-6\n" + "0371ZZ120170828-3\n" + "420180115007\n"
				+ "0371ZZ120170710-5\n" + "0420180228001\n" + "0420180124004\n" + "0420180307002\n"
				+ "0371ZZ120170715-1\n" + "0371ZZ120171221-4\n" + "0420180209003\n" + "0371ZZ120171009-3\n"
				+ "0420180115001\n" + "0420180208004\n" + "0420180502002\n" + "0420180126008\n" + "0420180120001\n"
				+ "420180116005\n" + "0371ZZ120170801-1\n" + "0420180130002\n" + "0420180115005\n"
				+ "0371ZZ120170901-12\n" + "0371ZZ120170727-3\n" + "0420180127005\n" + "0420180207001\n"
				+ "0420180423003\n" + "0420180423002\n" + "420180116001\n" + "0420180124003\n" + "0420180206002\n"
				+ "0420180131004\n" + "0420180123008\n" + "0420180124002\n" + "0420180302003\n" + "0371ZZ120170710-4\n"
				+ "0371ZZ20170329-3\n" + "0371ZZ120180103-3\n" + "0371ZZ120171213-1\n" + "0371ZZ120180105-1\n"
				+ "0420180131005\n" + "0420180502003\n" + "0371ZZ120170814-4\n" + "0371ZZ120170913-1\n"
				+ "0371ZZ20170408-4\n" + "0371ZZ120170612-4\n" + "0420180421003\n" + "0371ZZ120170831-12\n"
				+ "0420180308003\n" + "0420180427002\n" + "0420180115003\n" + "JYD20170104-A002\n" + "0420180118001\n"
				+ "0420180426001\n" + "0371ZZ120170911-4\n" + "0371ZZ120170908-1\n" + "0371ZZ120170914-2";

		String[] arr = str.split("\n");
		List<String> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 1) {
				list.add("'" + arr[i] + "', ");
			} else {
				list.add("'" + arr[i] + "'");
			}

		}
		for (String value : list) {
			System.out.println(value);
		}
	}

	@Test
	public void test2() {
		// String value = "37759.990000000005";
		String value = "64936.70999999999";
		BigDecimal b = new BigDecimal(value);
		double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(doubleValue);
	}

	@Test
	public void test3() {
		String str = "2018/23/23";
		String value = "";

		if (str.matches("(\\d{4})/(\\d{1,2})/(\\d{1,2})")) {
			StringBuilder sb = new StringBuilder();
			String[] split = str.split("/");

			sb.append(split[0]);// 年
			sb.append("-");
			if (!split[1].matches("\\d{2}")) {// 月
				sb.append("0" + split[1]);
			} else {
				sb.append(split[1]);
			}
			sb.append("-");
			if (!split[2].matches("\\d{2}")) {// 日
				sb.append("0" + split[2]);
			} else {
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

		System.out.println("lista:" + lista.size());
		System.out.println("listb:" + listb.size());

		listAll.addAll(lista);
		System.out.println("listAll:" + listAll.size());

		listAll.addAll(listb);
		System.out.println("listAll:" + listAll.size());
		for (String value : listAll) {
			System.out.println(value);

		}

	}

	@Test
	public void test5() {
		// List<User> users = new ArrayList<>();
		//
		// users.add(new User("zhangsan", 10));
		// users.add(new User("lisi", 20));
		// users.add(new User("wangwu", 50));
		// users.add(new User("weiliu", 10));
		//
		// User u = null;
		// for (User user : users) {
		// if (user.getName().equals("lisi")) {
		// u = user;
		// }
		// }
		//
		// if (u != null) {
		// u.setName("li");
		// }
		//
		// for (User user : users) {
		// System.out.println(user);
		//
		// }

	}

	@Test
	public void test6() {

		String str = "2018-08-20";
		String value = "";

		if (!str.matches("[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])")) {
			System.out.println(value);
		}

	}

	@Test
	public void test7() {

		String str = "6fdf43704.000000";
		String value = "";

		if (str.matches("\\w+\\.\\d+")) {
			str = str.replaceAll("(\\w+)\\.\\d+", "$1");
			System.out.println(str);
		}

	}

	@Test
	public void test8() {
		// List<User> users = new ArrayList<>();
		//
		// users.add(new User("zhangsan", 10));
		// users.add(new User("lisi", 20));
		// users.add(new User("wangwu", 50));
		// users.add(new User("weiliu", 10));
		//
		// System.out.println(users.size());
		//
		// users.clear();
		//
		// System.out.println(users.size());

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
			System.out.println("storeMap.put(" + storeMap.get(key) + ", \"" + key + "\");");
		}

	}

	@Test
	public void testSerializable() throws FileNotFoundException, IOException, ClassNotFoundException {
		String path = "/home/aa/Desktop/serializeable.txt";

		User user = new User();
		user.setAge(10);
		user.setName("李阳");
		user.setSex("男");
		System.out.println(user);
		writeObjectTest(path, user);

		User user2 = readObjectTest(path);
		System.out.println(user2);

	}

	@Test
	public void test10() {
		String value = "李四";

		switch (value) {
		case "张三":
			System.out.println("true");
			break;
		case "李四":
			System.out.println("false");
			break;
		case "王五":
			System.out.println("false");
			break;
		case "xiaoliu":
			System.out.println("false");
			break;
		default:
			System.out.println("false");
			break;
		}

	}

	private User readObjectTest(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)));
		User user = (User) ois.readObject();
		ois.close();
		System.out.println("反序列化对象成功！！");
		return user;
	}

	private void writeObjectTest(String path, User user) throws IOException, FileNotFoundException {
		ObjectOutputStream oops = new ObjectOutputStream(new FileOutputStream(new File(path)));
		oops.writeObject(user);
		oops.flush();
		oops.close();
		System.out.println("序列化对象成功！！");
	}

}

class User implements Serializable {
	private static final long serialVersionUID = -68500489356533615L;
	private String name;
	private int age;
	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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
		return "User [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
}
