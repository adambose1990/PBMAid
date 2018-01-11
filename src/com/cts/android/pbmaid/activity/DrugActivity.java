package com.cts.android.pbmaid.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.cts.android.pbmaid.R;

public class DrugActivity extends Activity {
	
	private String strPatientOID = null;
	private String strPlanID = null;
	private String strPharmacyOID = null;
	private String strDrugName = null;
	private String strPharmacyName = null;
	private TextView tvDrugPHRName;
	private ListView lvDruglist;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_drug);
		initializeItems();
		setItems();
	}

	private void initializeItems() {
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			strPatientOID = extras.getString("PATIENTOID");
			strPlanID = extras.getString("PLANID");
			strPharmacyOID = extras.getString("PHARMACYOID");
			strDrugName = extras.getString("DRUGNAME");
			strPharmacyName  = extras.getString("PHARMACYNAME");
		}
		tvDrugPHRName = (TextView) findViewById(R.id.tvDrugPHRName);
		lvDruglist = (ListView) findViewById(R.id.lvDruglist);
	}
	
	private void setItems() {
		tvDrugPHRName.setText(strPharmacyName);
		XMLHandlerDrug handler = new XMLHandlerDrug();
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
