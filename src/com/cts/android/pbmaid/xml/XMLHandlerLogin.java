/**
 * 
 */
package com.cts.android.pbmaid.xml;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.cts.android.pbmaid.data.InsurancePlanData;
import com.cts.android.pbmaid.data.PatientData;

/**
 * @author Arindam
 *
 */
public class XMLHandlerLogin extends DefaultHandler {
	
	private PatientData patientData = null;
	private InsurancePlanData planData = null;
	private ArrayList<InsurancePlanData> listPlanData = null;
	private String tempString;

	public PatientData getUserData() {
		return patientData;
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		tempString = new String(ch, start, length);
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		tempString = "";
		if(qName.equalsIgnoreCase("PatientData")) {
			patientData = new PatientData();
			patientData.setStrOID(attributes.getValue("oid"));
		} else if (qName.equalsIgnoreCase("InsurancePlans")) {
			listPlanData = new ArrayList<InsurancePlanData>();
		} else if (qName.equalsIgnoreCase("InsurancePlanData")) {
			planData = new InsurancePlanData();
			planData.setStrOID(attributes.getValue("oid"));
		}
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(qName.equalsIgnoreCase("UserName")) {
			patientData.setStrUserName(tempString);
		} else if (qName.equalsIgnoreCase("Password")) {
			patientData.setStrPassword(tempString);
		} else if (qName.equalsIgnoreCase("FirstName")) {
			patientData.setStrFirstName(tempString);
		} else if (qName.equalsIgnoreCase("LastName")) {
			patientData.setStrLastName(tempString);
		} else if (qName.equalsIgnoreCase("ContactNo")) {
			patientData.setStrContactNo(tempString);
		} else if (qName.equalsIgnoreCase("Email")) {
			patientData.setStrEmail(tempString);
		} else if (qName.equalsIgnoreCase("AddressLine1")) {
			patientData.setStrAddressLine1(tempString);
		} else if (qName.equalsIgnoreCase("AddressLine2")) {
			patientData.setStrAddressLine2(tempString);
		} else if (qName.equalsIgnoreCase("InsurancePlanData")) {
			listPlanData.add(planData);
		} else if (qName.equalsIgnoreCase("Type")) {
			planData.setStrPlanType(tempString);
		} else if (qName.equalsIgnoreCase("PlanName")) {
			planData.setStrPlanName(tempString);
		} else if (qName.equalsIgnoreCase("PlanDesc")) {
			planData.setStrPlanDesc(tempString);
		} else if (qName.equalsIgnoreCase("InsurancePlans")) {
			patientData.setListPlanData(listPlanData);
		}
	}
	
	

}
