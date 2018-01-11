package com.cts.android.pbmaid.activity;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.cts.android.pbmaid.R;
import com.cts.android.pbmaid.adapters.CustomAdapterPharmacy;
import com.cts.android.pbmaid.constants.IMessages;
import com.cts.android.pbmaid.data.PharmacyData;
import com.cts.android.pbmaid.xml.XMLHandlerPharmacy;

public class PharmacyActivity extends Activity {
	
	private ListView lvPharmacylist;
	private String strPatientOID = null;
	private String strZIPCode = null;
	private String strPlanID = null;
	private String strTopic = null;
	private ArrayList<PharmacyData> listPharmacy = null;
	CustomAdapterPharmacy adapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_pharmacy);
		initializeItems();
		setItems();
	}

	private void initializeItems() {
		Bundle extras = getIntent().getExtras();
		if(extras !=null) {
			strPatientOID = extras.getString("PATIENTOID");
			strZIPCode = extras.getString("ZIPCODE");
			strPlanID = extras.getString("PLANID");
			strTopic = extras.getString("TOPIC");
		}
		lvPharmacylist = (ListView) findViewById(R.id.lvPharmacylist);
	}
	
	private void setItems() {
		XMLHandlerPharmacy handler = new XMLHandlerPharmacy();
		try {
			SAXParserFactory spfac = SAXParserFactory.newInstance();
			SAXParser saxParser = spfac.newSAXParser();
			XMLReader xmlReader = saxParser.getXMLReader();
			xmlReader.setContentHandler(handler);
			xmlReader.parse(new InputSource(getAssets().open("XMLPharmacy.xml")));
			listPharmacy = handler.getPharamacyData();
			if (listPharmacy != null) {
				adapter = new CustomAdapterPharmacy(this, listPharmacy);
				lvPharmacylist.setAdapter(adapter);
				// Click event for single list row
				lvPharmacylist.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
						Intent intent = new Intent(PharmacyActivity.this, PharmacyDetailActivity.class);
						intent.putExtra("PHARMACYINFO", listPharmacy.get(position));
						intent.putExtra("PATIENTOID", strPatientOID);
						intent.putExtra("PLANID", strPlanID);
						startActivity(intent);	
					}
				});	
			}
		} catch (Exception e) {
			e.printStackTrace();
			Toast toast = Toast.makeText(this,IMessages.msgForCommonError, Toast.LENGTH_LONG);
			toast.show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.about:
			startActivity(new Intent(this, About.class));
			break;
		case R.id.exit:
			finish();
			break;
		}
		return false;
	}

}
