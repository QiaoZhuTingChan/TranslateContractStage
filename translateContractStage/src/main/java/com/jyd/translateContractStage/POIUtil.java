package com.jyd.translateContractStage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIUtil {
	private XSSFWorkbook workbook2007 = null; // WorkBook对象
	private XSSFSheet sheet2007 = null; // Sheet对象

	private HSSFWorkbook workbook2003 = null;
	private HSSFSheet sheet2003 = null;

	public boolean type = false;

	private String filePath = null;
	
	private static FormulaEvaluator evaluator;
	private static String RR_DATE_FORMAT = "yyyy-MM-dd";

	/**
	 * 创建工作薄
	 * 
	 * @param filePath
	 *            文件路径
	 */
	public void createWorkbook(String filePath) {
		if (isExcel2007(filePath))
			type = true;
		this.filePath = filePath;
		if (type) {
			workbook2007 = new XSSFWorkbook();
			sheet2007 = workbook2007.createSheet();
			
		} else {
			workbook2003 = new HSSFWorkbook();
			sheet2003 = workbook2003.createSheet();
		}
	}

	/**
	 * 保存数据
	 * 
	 * @param filePath
	 *            路径
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void save() throws FileNotFoundException, IOException {
		if (type)
			workbook2007.write(new FileOutputStream(filePath));
		else
			workbook2003.write(new FileOutputStream(filePath));
	}

	public int getTotalSheet() {
		return type ? workbook2007.getNumberOfSheets() : workbook2003.getNumberOfSheets();
	}

	public XSSFWorkbook getWorkbook() {
		return workbook2007;
	}

	public void setWorkbook(XSSFWorkbook workbook) {
		this.workbook2007 = workbook;
	}

	public XSSFSheet getSheet2007() {
		return sheet2007;
	}

	public void setSheet2007(XSSFSheet sheet) {
		this.sheet2007 = sheet;
	}

	public HSSFSheet getSheet2003() {
		return sheet2003;
	}

	public void setSheet2003(HSSFSheet sheet) {
		this.sheet2003 = sheet;
	}

	/**
	 * 打开文件
	 * 
	 * @param Excel文件路径
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public void openFile(String filePath) throws InvalidFormatException, IOException {
		if (isExcel2007(filePath)) {
			workbook2007 = new XSSFWorkbook(OPCPackage.open(filePath));
			sheet2007 = workbook2007.getSheetAt(0);
			evaluator = workbook2007.getCreationHelper().createFormulaEvaluator();
			type = true;
		} else if (isExcel2003(filePath)) {
			workbook2003 = new HSSFWorkbook(new FileInputStream(filePath));
			sheet2003 = workbook2003.getSheetAt(0);
			evaluator = workbook2003.getCreationHelper().createFormulaEvaluator();
		}
	}

	/**
	 * 
	 * @描述：是否是2003的excel，返回true是2003
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
	 * @返回值：boolean
	 */

	public static boolean isExcel2007(String filePath) {
		return filePath.matches("^.+\\.(?i)(xlsx)$");
	}

	/**
	 * 按序号选择表格
	 * 
	 * @param index
	 */
	public void setSheet(int index) {
		if (type)
			sheet2007 = workbook2007.getSheetAt(index);
		else
			sheet2003 = workbook2003.getSheetAt(index);
	}

	/**
	 * 按名称选择表格
	 * 
	 * @param name
	 */
	public void setSheet(String name) {
		if (type)
			sheet2007 = workbook2007.getSheet(name);
		else
			sheet2003 = workbook2003.getSheet(name);
	}

	/**
	 * 获取表格名称
	 * 
	 * @return
	 */
	public String getSheetName() {
		if (type) {
			if (sheet2007 != null)
				return sheet2007.getSheetName();
			else
				return "";
		} else {
			if (sheet2003 != null)
				return sheet2003.getSheetName();
			else
				return "";
		}
	}

	public Row getRow(int rowIndex) {
		Row row = type == true ? sheet2007.getRow(rowIndex) : sheet2003.getRow(rowIndex);
		return row;
	}

	public Row createRow(int rowIndex) {
		Row row = null;
		if (type)
			row = sheet2007.createRow(rowIndex);
		else
			row = sheet2003.createRow(rowIndex);
		return row;
	}

	/**
	 * 获取Boolean数据
	 * 
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 */
	public Boolean getBooleanValue(int rowIndex, int columnIndex) {
		Row row = type == true ? sheet2007.getRow(rowIndex) : sheet2003.getRow(rowIndex);
		if (row == null)
			return null;
		Cell cell = row.getCell(columnIndex);
		if (cell == null)
			return null;

		return cell.getBooleanCellValue();
	}

	/**
	 * 获取时间数据
	 * 
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 */
	public Date getDateValue(int rowIndex, int columnIndex) {
		Row row = type == true ? sheet2007.getRow(rowIndex) : sheet2003.getRow(rowIndex);
		if (row == null)
			return null;
		Cell cell = row.getCell(columnIndex);
		if (cell == null)
			return null;

		return cell.getDateCellValue();
	}

	/**
	 * 获取文本数据
	 * 
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 */
	public String getStringValue(int rowIndex, int columnIndex) {
		Row row = type == true ? sheet2007.getRow(rowIndex) : sheet2003.getRow(rowIndex);
		if (row == null)
			return null;
		Cell cell = row.getCell(columnIndex);
		if (cell == null)
			return null;

		return cell.getStringCellValue();
	}

	/**
	 * 获取数字类型数据
	 * 
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 */
	public Double getDoubleValue(int rowIndex, int columnIndex) {
		Row row = type == true ? sheet2007.getRow(rowIndex) : sheet2003.getRow(rowIndex);
		if (row == null)
			return null;
		Cell cell = row.getCell(columnIndex);
		if (cell == null)
			return null;

		return cell.getNumericCellValue();
	}
	
	@SuppressWarnings("deprecation")
	public void setStringValue(int rowIndex, int columnIndex, String value) {
		Row row = type == true ? sheet2007.getRow(rowIndex) : sheet2003.getRow(rowIndex);
		if (row == null)
			return;
		Cell cell = row.getCell(columnIndex);
		if(cell == null) {
			cell = row.createCell(15, Cell.CELL_TYPE_STRING);
		}
		cell.setCellValue(value);
	}
	
	
	
	/**
	 * 已转换所有cell类型的值为字符串
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 */
	public String getValue(int rowIndex, int columnIndex) {
		Row row = type == true ? sheet2007.getRow(rowIndex) : sheet2003.getRow(rowIndex);
		if (row == null)
			return null;
		Cell cell = row.getCell(columnIndex);
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
//					NumberFormat format = NumberFormat.getNumberInstance();
//					format.setMaximumIntegerDigits(99);
//					format.setGroupingUsed(false);
//
//					cellValue = format.format(value);
//					cellValue = String.valueOf(value);
					
					NumberFormat format = new DecimalFormat("0.000000");
					cellValue = format.format(value);
					
				}
				break;

			case HSSFCell.CELL_TYPE_STRING: // 字符串
				cellValue = cell.getStringCellValue().replaceAll(" +", "");
				
				if(cellValue.matches("(\\d{4})/(\\d{1,2})/(\\d{1,2})")) {
					StringBuilder sb = new StringBuilder();
					String[] split = cellValue.split("/");
					
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
					cellValue = sb.toString();
				}else if(cellValue.matches("(\\d{4})\\.(\\d{1,2})\\.(\\d{1,2})")) {
					StringBuilder sb = new StringBuilder();
					String[] split = cellValue.split("\\.");
					
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
					cellValue = sb.toString();
				}
				
				
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

		return cellValue;
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
	 * 获取富文本类型数据
	 * 
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 */
	public RichTextString getRichTextStringValue(int rowIndex, int columnIndex) {
		Row row = type == true ? sheet2007.getRow(rowIndex) : sheet2003.getRow(rowIndex);
		if (row == null)
			return null;
		Cell cell = row.getCell(columnIndex);
		if (cell == null)
			return null;

		return cell.getRichStringCellValue();
	}

	/**
	 * 关闭Excel
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException {
		if (type)
			workbook2007.close();
		else
			workbook2003.close();
	}
}
