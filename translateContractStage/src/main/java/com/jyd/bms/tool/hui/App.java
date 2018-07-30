package com.jyd.bms.tool.hui;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;

public class App {
	public static void main(String[] args) {
		App app = new App();
		try {
			String contractFilePath = "/home/aa/Desktop/laoda/contract.xls";
			String outputContractFilePath = "/home/aa/Desktop/laoda/output.xls";
			POIUtil input = app.initContractPOIUtil(contractFilePath);
			POIUtil output = app.initOutputPOIUtil(outputContractFilePath);
			// 处理数据
			app.readContractStage(input, output);
			output.save();
			input.close();
			output.close();
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public POIUtil initContractPOIUtil(String contractFilePath) throws InvalidFormatException, IOException {
		POIUtil poiUtil = new POIUtil();
		poiUtil.openFile(contractFilePath);
		return poiUtil;
	}

	public POIUtil initOutputPOIUtil(String outPutFilePath) {
		POIUtil poiUtil = new POIUtil();
		poiUtil.createWorkbook(outPutFilePath);
		return poiUtil;
	}

	public void readContractStage(POIUtil input, POIUtil output) throws InvalidFormatException, IOException {
		int totalSheet = input.getTotalSheet();
		int rowIndex = 0;
		int nullTotal = 0;
		String nowPosition = "";
		String contractNumber = "";

		int outputRowIndex = 0;

		Map<String, Object> mapStage = new HashMap<String, Object>();

		for (int sheetNumber = 0; sheetNumber < totalSheet; sheetNumber++) {
			input.setSheet(sheetNumber);
			String sheetName = input.getSheetName();

			rowIndex = 0;
			nullTotal = 0;

			for (; rowIndex < 5000 && nullTotal < 20; rowIndex++) {
				Row row = input.getRow(rowIndex);
				if (row == null)
					nullTotal++;
				else {
					nullTotal = 0;

					try {
						String value = input.getStringValue(rowIndex, 0);
						// 找到合同编号位置，代表一个合同的开始
						if (value != null && value.trim().equals("合同编号")) {
							nowPosition = "合同编号";
							outputRowIndex++;
							Row newContractRow = output.createRow(outputRowIndex++);

							contractNumber = input.getStringValue(rowIndex + 1, 0);
							newContractRow.createCell(0).setCellValue("合同编号");
							newContractRow.createCell(1).setCellValue(contractNumber);

							Row stageTitleRow = output.createRow(outputRowIndex++);
							stageTitleRow.createCell(0).setCellValue("期数");
							stageTitleRow.createCell(1).setCellValue("还款日期");
							stageTitleRow.createCell(2).setCellValue("本金");
							stageTitleRow.createCell(3).setCellValue("利息");
							stageTitleRow.createCell(4).setCellValue("GPS费");
							stageTitleRow.createCell(5).setCellValue("停车费");
							stageTitleRow.createCell(6).setCellValue("合同保管费");
							stageTitleRow.createCell(7).setCellValue("逾期费");
							stageTitleRow.createCell(8).setCellValue("多还");
							stageTitleRow.createCell(9).setCellValue("少还");
						}

						if (value != null && value.trim().equals("合同分期")) {
							nowPosition = "合同分期";
						}

						if (value != null && value.trim().equals("还款明细")) {
							nowPosition = "还款明细";
						}
					} catch (Exception e) {
						if (nowPosition.equals("合同分期")) {
							mapStage.put(contractNumber + input.getDoubleValue(rowIndex, 0) + "_stage",
									input.getDoubleValue(rowIndex, 0));
							mapStage.put(contractNumber + input.getDoubleValue(rowIndex, 0) + "_gps",
									input.getDoubleValue(rowIndex, 1));
							mapStage.put(contractNumber + input.getDoubleValue(rowIndex, 0) + "_parking_fee",
									input.getDoubleValue(rowIndex, 2));
							mapStage.put(contractNumber + input.getDoubleValue(rowIndex, 0) + "_interest",
									input.getDoubleValue(rowIndex, 3) + input.getDoubleValue(rowIndex, 4));
							mapStage.put(contractNumber + input.getDoubleValue(rowIndex, 0) + "_principal",
									input.getDoubleValue(rowIndex, 5));
							mapStage.put(contractNumber + input.getDoubleValue(rowIndex, 0) + "_repayment_date",
									input.getDateValue(rowIndex, 9));
						}

						if (nowPosition.equals("还款明细")) {
							Row stageRow = output.createRow(outputRowIndex++);

							double total = input.getDoubleValue(rowIndex, 2);

							double gps = (Double) mapStage
									.get(contractNumber + input.getDoubleValue(rowIndex, 0) + "_gps");
							double parkingFee = (Double) mapStage
									.get(contractNumber + input.getDoubleValue(rowIndex, 0) + "_parking_fee");
							double interest = (Double) mapStage
									.get(contractNumber + input.getDoubleValue(rowIndex, 0) + "_interest");
							double principal = (Double) mapStage
									.get(contractNumber + input.getDoubleValue(rowIndex, 0) + "_principal");

							double realGps = 0, realParkingFee = 0, realInterest = 0, realPrincipal = 0;
							double more = 0, few = 0;

							if (total >= gps) {
								realGps = gps;
								total -= gps;
							}

							if (total >= parkingFee) {
								realParkingFee = parkingFee;
								total -= parkingFee;
							}

							if (total >= interest) {
								realInterest = interest;
								total -= interest;
							}

							if (total >= principal) {
								realPrincipal = principal;
								total -= principal;
							} else {
								realPrincipal = total;
								total = 0;
							}

							if (total > 0)
								more = total;

							stageRow.createCell(0).setCellValue(input.getDoubleValue(rowIndex, 0));
							try
							{
								stageRow.createCell(1).setCellValue(input.getDateValue(rowIndex, 3));
							}
							catch(Exception error)
							{
								stageRow.createCell(10).setCellValue(contractNumber + ",发生错误:"+sheetName+"," + sheetNumber + "," + rowIndex);
							}
							stageRow.createCell(2).setCellValue(realPrincipal);
							stageRow.createCell(3).setCellValue(realInterest);
							stageRow.createCell(4).setCellValue(realGps);
							stageRow.createCell(5).setCellValue(realParkingFee);
							stageRow.createCell(6).setCellValue(0);
							stageRow.createCell(7).setCellValue(input.getDoubleValue(rowIndex, 5));
							stageRow.createCell(8).setCellValue(0);
							stageRow.createCell(9).setCellValue(0);
						}
					}

				}
			}

//			break;
			System.out.println("sheetName: "+sheetName+ "\t"+"sheetNumber: "+sheetNumber);
		}
		System.out.println("跑完！！");
	}
}
