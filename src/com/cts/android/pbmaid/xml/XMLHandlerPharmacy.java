/**
 * 
 */
package com.cts.android.pbmaid.xml;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.cts.android.pbmaid.data.PharmacyData;

/**
 * @author Arindam
 *
 */
public class XMLHandlerPharmacy extends DefaultHandler {
	
	private PharmacyData pharmacyData = null;
	private ArrayList<PharmacyData> listPharmacyDatas = new ArrayList<PharmacyData>();
	private String tempString;
	
	public ArrayList<PharmacyData> getPharamacyData() {
		return listPharmacyDatas;
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		tempString = new String(ch, start, length);
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement()
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		tempString = "";
		if(qName.equalsIgnoreCase("PharmacyData")) {
			pharmacyData = new PharmacyData();
			pharmacyData.setStrOID(attributes.getValue("oid"));
		}

	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endElement()
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("Name")) {
			pharmacyData.setStrName(tempString);
		} else if(qName.equalsIgnoreCase("AddressLine1")) {
			pharmacyData.setStrAddressLine1(tempString);
		} else if(qName.equalsIgnoreCase("AddressLine2")) {
			pharmacyData.setStrAddressLine2(tempString);
		} else if(qName.equalsIgnoreCase("State")) {
			pharmacyData.setStrState(tempString);
		} else if(qName.equalsIgnoreCase("ZipCode")) {
			pharmacyData.setStrZIPCode(tempString);
		} else if(qName.equalsIgnoreCase("ContactNo")) {
			pharmacyData.setStrContactNo(tempString);
		} else if(qName.equalsIgnoreCase("Star")) {
			pharmacyData.setIntRating(Integer.parseInt(tempString));
		} else if(qName.equalsIgnoreCase("OpeningTime")) {
			pharmacyData.setStrOpeningTime(tempString);
		} else if(qName.equalsIgnoreCase("ClosingTime")) {
			pharmacyData.setStrClosingTime(tempString);
		} else if(qName.equalsIgnoreCase("PharmacyData")) {
			listPharmacyDatas.add(pharmacyData);
		}
	}
	
}
