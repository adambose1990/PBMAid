/**
 * 
 */
package com.cts.android.pbmaid.data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Arindam
 *
 */
public class PatientData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1122293759947978642L;
	private String strOID;
	private String strUserName;
	private String strPassword;
	private String strFirstName;
	private String strLastName;
	private String strContactNo;
	private String strEmail;
	private String strAddressLine1;
	private String strAddressLine2;
	private ArrayList<InsurancePlanData> listPlanData;
	
	
	/**
	 * @return the strOID
	 */
	public String getStrOID() {
		return strOID;
	}
	/**
	 * @param strOID the strOID to set
	 */
	public void setStrOID(String strOID) {
		this.strOID = strOID;
	}
	/**
	 * @return the strUserName
	 */
	public String getStrUserName() {
		return strUserName;
	}
	/**
	 * @param strUserName the strUserName to set
	 */
	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}
	/**
	 * @return the strPassword
	 */
	public String getStrPassword() {
		return strPassword;
	}
	/**
	 * @param strPassword the strPassword to set
	 */
	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}
	/**
	 * @return the strFirstName
	 */
	public String getStrFirstName() {
		return strFirstName;
	}
	/**
	 * @param strFirstName the strFirstName to set
	 */
	public void setStrFirstName(String strFirstName) {
		this.strFirstName = strFirstName;
	}
	/**
	 * @return the strLastName
	 */
	public String getStrLastName() {
		return strLastName;
	}
	/**
	 * @param strLastName the strLastName to set
	 */
	public void setStrLastName(String strLastName) {
		this.strLastName = strLastName;
	}
	/**
	 * @return the strContactNo
	 */
	public String getStrContactNo() {
		return strContactNo;
	}
	/**
	 * @param strContactNo the strContactNo to set
	 */
	public void setStrContactNo(String strContactNo) {
		this.strContactNo = strContactNo;
	}
	/**
	 * @return the strEmail
	 */
	public String getStrEmail() {
		return strEmail;
	}
	/**
	 * @param strEmail the strEmail to set
	 */
	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
	}
	/**
	 * @return the strAddressLine1
	 */
	public String getStrAddressLine1() {
		return strAddressLine1;
	}
	/**
	 * @param strAddressLine1 the strAddressLine1 to set
	 */
	public void setStrAddressLine1(String strAddressLine1) {
		this.strAddressLine1 = strAddressLine1;
	}
	/**
	 * @return the strAddressLine2
	 */
	public String getStrAddressLine2() {
		return strAddressLine2;
	}
	/**
	 * @param strAddressLine2 the strAddressLine2 to set
	 */
	public void setStrAddressLine2(String strAddressLine2) {
		this.strAddressLine2 = strAddressLine2;
	}
	/**
	 * @return the listPlanData
	 */
	public ArrayList<InsurancePlanData> getListPlanData() {
		return listPlanData;
	}
	/**
	 * @param listPlanData the listPlanData to set
	 */
	public void setListPlanData(ArrayList<InsurancePlanData> listPlanData) {
		this.listPlanData = listPlanData;
	}
}
