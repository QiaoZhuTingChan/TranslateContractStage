package com.jyd.bms.dto;

public class ContractFileDTO {
	private String templateName;
	private String htmlName;
	private String pdfName;

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getHtmlName() {
		return htmlName;
	}

	public void setHtmlName(String htmlName) {
		this.htmlName = htmlName;
	}

	public String getPdfName() {
		return pdfName;
	}

	public void setPdfName(String pdfName) {
		this.pdfName = pdfName;
	}

	public ContractFileDTO(String templateName, String htmlName, String pdfName) {
		this.templateName = templateName;
		this.htmlName = htmlName;
		this.pdfName = pdfName;
	}
}
