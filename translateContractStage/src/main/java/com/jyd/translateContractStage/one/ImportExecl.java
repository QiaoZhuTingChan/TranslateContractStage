package com.jyd.translateContractStage.one;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @描述：测试excel读取
 * 
 * 				导入的jar包
 * 
 *               poi-3.8-beta3-20110606.jar
 * 
 *               poi-ooxml-3.8-beta3-20110606.jar
 * 
 *               poi-examples-3.8-beta3-20110606.jar
 * 
 *               poi-excelant-3.8-beta3-20110606.jar
 * 
 *               poi-ooxml-schemas-3.8-beta3-20110606.jar
 * 
 *               poi-scratchpad-3.8-beta3-20110606.jar
 * 
 *               xmlbeans-2.3.0.jar
 * 
 *               dom4j-1.6.1.jar
 * 
 *               jar包官网下载地址：http://poi.apache.org/download.html
 * 
 *               下载poi-bin-3.8-beta3-20110606.zipp
 * 
 * @作者：建宁
 * 
 * 		@时间：2012-08-29 下午16:27:15
 */

public class ImportExecl {
	private XSSFWorkbook workbook2007 = null; // WorkBook对象
	// private XSSFSheet sheet2007 = null; // Sheet对象

	private HSSFWorkbook workbook2003 = null;
	// private HSSFSheet sheet2003 = null;

	public boolean type = false;

	private static FormulaEvaluator evaluator;
	private static String RR_DATE_FORMAT = "yyyy-MM-dd";

	/** 总行数 */

	private int totalRows = 0;

	/** 总列数 */

	private int totalCells = 0;

	/** 错误信息 */

	private String errorInfo;

	/** 构造方法 */

	public ImportExecl() {

	}

	/**
	 * 
	 * @描述：得到总行数
	 * 
	 * @作者：建宁
	 * 
	 * 		@时间：2012-08-29 下午16:27:15
	 * 
	 * @参数：@return
	 * 
	 * @返回值：int
	 */

	public int getTotalRows() {

		return totalRows;

	}

	/**
	 * 
	 * @描述：得到总列数
	 * 
	 * @作者：建宁
	 * 
	 * 		@时间：2012-08-29 下午16:27:15
	 * 
	 * @参数：@return
	 * 
	 * @返回值：int
	 */

	public int getTotalCells() {

		return totalCells;

	}

	/**
	 * 
	 * @描述：得到错误信息
	 * 
	 * @作者：建宁
	 * 
	 * 		@时间：2012-08-29 下午16:27:15
	 * 
	 * @参数：@return
	 * 
	 * @返回值：String
	 */

	public String getErrorInfo() {

		return errorInfo;

	}

	/**
	 * 
	 * @描述：验证excel文件
	 * 
	 * @作者：建宁
	 * 
	 * 		@时间：2012-08-29 下午16:27:15
	 * 
	 * @参数：@param filePath 文件完整路径
	 * 
	 * @参数：@return
	 * 
	 * @返回值：boolean
	 */

	public boolean validateExcel(String filePath) {

		/** 检查文件名是否为空或者是否是Excel格式的文件 */

		if (filePath == null || !(WDWUtil.isExcel2003(filePath) || WDWUtil.isExcel2007(filePath))) {

			errorInfo = "文件名不是excel格式";

			return false;

		}

		/** 检查文件是否存在 */

		File file = new File(filePath);

		if (file == null || !file.exists()) {

			errorInfo = "文件不存在";

			return false;

		}

		return true;

	}

	/**
	 * 
	 * @描述：根据文件名读取excel文件
	 * 
	 * @作者：建宁
	 * 
	 * 		@时间：2012-08-29 下午16:27:15
	 * 
	 * @参数：@param filePath 文件完整路径
	 * 
	 * @参数：@return
	 * 
	 * @返回值：List
	 */

	public Map<String, List<List<String>>> read(String filePath) {

		Map<String, List<List<String>>> dataLst = new HashMap<>();

		InputStream is = null;

		try {

			/** 验证文件是否合法 */

			if (!validateExcel(filePath)) {

				System.out.println(errorInfo);

				return null;

			}

			/** 判断文件的类型，是2003还是2007 */

			boolean isExcel2003 = true;

			if (WDWUtil.isExcel2007(filePath)) {

				isExcel2003 = false;

			}

			/** 调用本类提供的根据流读取的方法 */

			File file = new File(filePath);

			is = new FileInputStream(file);

			dataLst = read(is, isExcel2003);

			is.close();

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			if (is != null) {

				try {

					is.close();

				} catch (IOException e) {

					is = null;

					e.printStackTrace();

				}

			}

		}

		/** 返回最后读取的结果 */

		return dataLst;

	}

	/**
	 * 
	 * @描述：根据流读取Excel文件
	 * 
	 * @作者：建宁
	 * 
	 * 		@时间：2012-08-29 下午16:40:15
	 * 
	 * @参数：@param inputStream
	 * 
	 * @参数：@param isExcel2003
	 * 
	 * @参数：@return
	 * 
	 * @返回值：List
	 */

	public Map<String, List<List<String>>> read(InputStream inputStream, boolean isExcel2003) {

		Map<String, List<List<String>>> dataLst = null;

		try {

			/** 根据版本选择创建Workbook的方式 */

			Workbook wb = null;

			if (isExcel2003) {
				wb = new HSSFWorkbook(inputStream);
				workbook2003 = (HSSFWorkbook) wb;
				type = false;
			} else {
				wb = new XSSFWorkbook(inputStream);
				workbook2007 = (XSSFWorkbook) wb;
				type = true;
			}
			dataLst = read(wb);

		} catch (IOException e) {

			e.printStackTrace();

		}

		return dataLst;

	}

	public int getTotalSheet() {
		return type ? workbook2007.getNumberOfSheets() : workbook2003.getNumberOfSheets();
	}

	/**
	 * 
	 * @描述：读取数据
	 * 
	 * @作者：建宁
	 * 
	 * 		@时间：2012-08-29 下午16:50:15
	 * 
	 * @参数：@param Workbook
	 * 
	 * @参数：@return
	 * 
	 * @返回值：List<List<String>>
	 */

	private Map<String, List<List<String>>> read(Workbook wb) {

		evaluator = wb.getCreationHelper().createFormulaEvaluator();

		Map<String, List<List<String>>> sheetMap = new HashMap<>();

		for (int i = 0; i < this.getTotalSheet(); i++) {
			List<List<String>> dataLst = new ArrayList<List<String>>();

			/** 得到第一个shell */

			Sheet sheet = wb.getSheetAt(i);

			/** 得到Excel的行数 */

			// this.totalRows = sheet.getPhysicalNumberOfRows();
			this.totalRows = 2000;
			System.out.println("sheetName" + sheet.getSheetName() + " 总行数：" + totalRows);

			/** 得到Excel的列数 */

			if (this.totalRows >= 1/* && sheet.getRow(2) != null */) {

				// this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
				this.totalCells = 20;

			}

			/** 循环Excel的行 */

			for (int r = 0; r < this.totalRows; r++) {

				Row row = sheet.getRow(r);

				if (row == null) {
					continue;
				}

				List<String> rowLst = new ArrayList<String>();

				/** 循环Excel的列 */

				for (int c = 0; c < this.getTotalCells(); c++) {

					Cell cell = row.getCell(c);

					String cellValue = "";

					if (null != cell) {
						// 以下是判断数据的类型
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_NUMERIC: // 数字
							// cellValue = cell.getNumericCellValue() + "";
							// break;
							if (HSSFDateUtil.isCellDateFormatted(cell)) {
								Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
								DateFormat format = new SimpleDateFormat(RR_DATE_FORMAT);
								cellValue = format.format(date);
							} else {
								double value = cell.getNumericCellValue();
								NumberFormat format = NumberFormat.getNumberInstance();
								format.setMaximumIntegerDigits(99);
								format.setGroupingUsed(false);

								cellValue = format.format(value);
							}
							break;

						case HSSFCell.CELL_TYPE_STRING: // 字符串
							cellValue = cell.getStringCellValue().replaceAll(" +", "");
							break;

						case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
							cellValue = cell.getBooleanCellValue() + "";
							break;

						case HSSFCell.CELL_TYPE_FORMULA: // 公式
							// cellValue = cell.getCellFormula() + "-->" +
							// getCellValue(evaluator.evaluate(cell));
							cellValue = getCellValue(evaluator.evaluate(cell));
							break;

						case HSSFCell.CELL_TYPE_BLANK: // 空值
							cellValue = "";
							break;

						case HSSFCell.CELL_TYPE_ERROR: // 故障
							cellValue = "非法字符";
							break;

						default:
							cellValue = "未知类型";
							break;
						}
					}

					rowLst.add(cellValue);

				}

				/** 保存第r行的第c列 */

				dataLst.add(rowLst);

			}

			sheetMap.put(sheet.getSheetName(), dataLst);
		}
		return sheetMap;
	}

	private static String getCellValue(CellValue cell) {
		String cellValue = null;
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			// System.out.print("String :");
			cellValue = cell.getStringValue();
			break;

		case Cell.CELL_TYPE_NUMERIC:
			// System.out.print("NUMERIC:");
			cellValue = String.valueOf(cell.getNumberValue());
			break;
		case Cell.CELL_TYPE_FORMULA:
			// System.out.print("FORMULA:");
			break;
		default:
			break;
		}

		return cellValue;
	}

	/**
	 * 
	 * @描述：main测试方法
	 * 
	 * @作者：建宁
	 * 
	 * 		@时间：2012-08-29 下午17:12:15
	 * 
	 * @参数：@param args
	 * 
	 * @参数：@throws Exception
	 * 
	 * @返回值：void
	 */

	public static void main(String[] args) throws Exception {

		String path = "/home/aa/Desktop/laoda/output";
		File src = new File(path);
		if (!src.exists()) {
			src.mkdirs();
		}

		ImportExecl poi = new ImportExecl();

		// List<List<String>> list = poi.read("d:/aaa.xls");

		Map<String, List<List<String>>> map = poi.read("/home/aa/Desktop/laoda/zhengzhou2.xls");

		for (String key : map.keySet()) {
			File file = new File(src, key + ".txt");
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

			List<List<String>> list = map.get(key);
			System.out.println(key);
			if (list != null) {

				for (int i = 0; i < list.size(); i++) {

					System.out.print(key + " 第" + (i) + "行");

					List<String> cellList = list.get(i);

					String line = "";
					for (int j = 0; j < cellList.size(); j++) {

						// System.out.print(" 第" + (j + 1) + "列值：");

						System.out.print("\t" + cellList.get(j));
						line += "\t" + cellList.get(j);

					}
					System.out.println();
					bw.write(line);
					bw.newLine();
					bw.flush();
				}
				if (bw != null) {
					bw.close();
					bw = null;
				}

			}
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		}

	}

	public static Map<String, List<List<String>>> getExcelData(String path) throws IOException {

		File src = new File(path);
		if (!src.exists()) {
			src.mkdirs();
		}

		ImportExecl poi = new ImportExecl();

		// List<List<String>> list = poi.read("d:/aaa.xls");

		Map<String, List<List<String>>> map = poi.read("/home/aa/Desktop/laoda/zhengzhou2.xls");

		for (String key : map.keySet()) {
			File file = new File(src, key + ".txt");
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

			List<List<String>> list = map.get(key);
			System.out.println(key);
			if (list != null) {

				for (int i = 0; i < list.size(); i++) {

					System.out.print(key + " 第" + (i) + "行");

					List<String> cellList = list.get(i);

					String line = "";
					for (int j = 0; j < cellList.size(); j++) {

						// System.out.print(" 第" + (j + 1) + "列值：");

						System.out.print("\t" + cellList.get(j));
						line += "\t" + cellList.get(j);

					}
					System.out.println();
					bw.write(line);
					bw.newLine();
					bw.flush();
				}
				if (bw != null) {
					bw.close();
					bw = null;
				}

			}
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		}
		return map;
	}
}

/**
 * 
 * @描述：工具类
 * 
 * @作者：建宁
 * 
 * 		@时间：2012-08-29 下午16:30:40
 */

class WDWUtil {

	/**
	 * 
	 * @描述：是否是2003的excel，返回true是2003
	 * 
	 * @作者：建宁
	 * 
	 * 		@时间：2012-08-29 下午16:29:11
	 * 
	 * @参数：@param filePath 文件完整路径
	 * 
	 * @参数：@return
	 * 
	 * @返回值：boolean
	 */

	public static boolean isExcel2003(String filePath) {

		return filePath.matches("^.+\\.(?i)(xls)$");

	}

	/**
	 * 
	 * @描述：是否是2007的excel，返回true是2007
	 * 
	 * @作者：建宁
	 * 
	 * 		@时间：2012-08-29 下午16:28:20
	 * 
	 * @参数：@param filePath 文件完整路径
	 * 
	 * @参数：@return
	 * 
	 * @返回值：boolean
	 */

	public static boolean isExcel2007(String filePath) {

		return filePath.matches("^.+\\.(?i)(xlsx)$");

	}

}
