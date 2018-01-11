/**
 * 
 */
package com.cts.android.pbmaid.data;

import java.io.Serializable;

/**
 * @author Arindam
 *
 */
public class InsurancePlanData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 215962194780193879L;
	private String strOID;
	private String strPlanName;
	private String strPlanDesc;
	private String strPlanType;
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
	 * @return the strPlanName
	 */
	public String getStrPlanName() {
		return strPlanName;
	}
	/**
	 * @param strPlanName the strPlanName to set
	 */
	public void setStrPlanName(String strPlanName) {
		this.strPlanName = strPlanName;
	}
	/**
	 * @return the strPlanDesc
	 */
	public String getStrPlanDesc() {
		return strPlanDesc;
	}
	/**
	 * @param strPlanDesc the strPlanDesc to set
	 */
	public void setStrPlanDesc(String strPlanDesc) {
		this.strPlanDesc = strPlanDesc;
	}
	/**
	 * @return the strPlanType
	 */
	public String getStrPlanType() {
		return strPlanType;
	}
	/**
	 * @param strPlanType the strPlanType to set
	 */
	public void setStrPlanType(String strPlanType) {
		this.strPlanType = strPlanType;
	}

}
