/**
 * 
 */
package com.cts.android.pbmaid.xml;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.cts.android.pbmaid.data.DrugData;

/**
 * @author Arindam
 *
 */
public class XMLHandlerDrug  extends DefaultHandler {
	private DrugData drugData = null;
	private ArrayList<DrugData> listDrugDatas = new ArrayList<DrugData>();
	private String tempString;
	
	public ArrayList<DrugData> getPharamacyData() {
		return listDrugDatas;
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		tempString = "";
		if(qName.equalsIgnoreCase("DrugData")) {
			drugData = new DrugData();
			drugData.setStrOID(attributes.getValue("oid"));
		}
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(qName.equalsIgnoreCase("Name")) {
			drugData.setStrDrugName(tempString);
		} else if(qName.equalsIgnoreCase("Description")) {
			drugData.setStrDrugName(tempString);
		} else if(qName.equalsIgnoreCase("GenOID")) {
			drugData.setStrDrugName(tempString);
		} else if(qName.equalsIgnoreCase("GenName")) {
			drugData.setStrDrugName(tempString);
		} else if(qName.equalsIgnoreCase("CompanyName")) {
			drugData.setStrDrugName(tempString);
		} else if(qName.equalsIgnoreCase("Rating")) {
			drugData.setStrDrugName(tempString);
		} else if(qName.equalsIgnoreCase("OOPE")) {
			drugData.setStrDrugName(tempString);
		} else if(qName.equalsIgnoreCase("DrugData")) {
			drugData.setStrDrugName(tempString);
		}
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		tempString = new String(ch, start, length);
	}
	
	

}
