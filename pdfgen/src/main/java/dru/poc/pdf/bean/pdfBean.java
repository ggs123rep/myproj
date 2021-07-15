package dru.poc.pdf.bean;

import org.springframework.context.annotation.Configuration;


public class pdfBean {

	private String orgid;
	private String orgName;
	private String city;
	private String ventilators;
	public pdfBean() {
		super();
	}
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getVentilators() {
		return ventilators;
	}
	public void setVentilators(String ventilators) {
		this.ventilators = ventilators;
	}
	
}
