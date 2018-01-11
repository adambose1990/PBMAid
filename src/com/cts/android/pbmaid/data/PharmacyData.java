/**
 * 
 */
package com.cts.android.pbmaid.data;

import java.io.Serializable;

/**
 * @author Arindam
 *
 */
public class PharmacyData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2094262154488502827L;
	private String strOID;
	private String strName;
	private String strAddressLine1;
	private String strAddressLine2;
	private String strState;
	private String strZIPCode;
	private String strContactNo;
	private int intRating;
	private String strOpeningTime;
	private String strClosingTime;
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
	 * @return the strName
	 */
	public String getStrName() {
		return strName;
	}
	/**
	 * @param strName the strName to set
	 */
	public void setStrName(String strName) {
		this.strName = strName;
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
	 * @return the strState
	 */
	public String getStrState() {
		return strState;
	}
	/**
	 * @param strState the strState to set
	 */
	public void setStrState(String strState) {
		this.strState = strState;
	}
	/**
	 * @return the strZIPCode
	 */
	public String getStrZIPCode() {
		return strZIPCode;
	}
	/**
	 * @param strZIPCode the strZIPCode to set
	 */
	public void setStrZIPCode(String strZIPCode) {
		this.strZIPCode = strZIPCode;
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
	 * @return the noStar
	 */
	public int getIntRating() {
		return intRating;
	}
	/**
	 * @param intRating the intRating to set
	 */
	public void setIntRating(int intRating) {
		this.intRating = intRating;
	}
	/**
	 * @return the strOpeningTime
	 */
	public String getStrOpeningTime() {
		return strOpeningTime;
	}
	/**
	 * @param strOpeningTime the strOpeningTime to set
	 */
	public void setStrOpeningTime(String strOpeningTime) {
		this.strOpeningTime = strOpeningTime;
	}
	/**
	 * @return the strClosingTime
	 */
	public String getStrClosingTime() {
		return strClosingTime;
	}
	/**
	 * @param strClosingTime the strClosingTime to set
	 */
	public void setStrClosingTime(String strClosingTime) {
		this.strClosingTime = strClosingTime;
	}
	
	

}
