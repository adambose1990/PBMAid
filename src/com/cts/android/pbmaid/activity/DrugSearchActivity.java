package com.cts.android.pbmaid.activity;

import com.cts.android.pbmaid.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class DrugSearchActivity extends Activity {

	String strPatientOID = null;
	String strPlanID = null;
	String strPharmacyOID = null;
	String strPharmacyName = null;
	String strDrugName = null;
	private TextView tvDrugSearchPHRName;
	private AutoCompleteTextView actvDrugSearchDrugName;
	private Button btDrugSearchSearch, btDrugSearchReset;
	private static String[] DRUGS;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_drug_search);
		initializeItems();
		setItems();
	}

	private void initializeItems() {
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			strPatientOID = extras.getString("PATIENTOID");
			strPlanID = extras.getString("PLANID");
			strPharmacyOID = extras.getString("PHARMACYOID");
			strPharmacyName = extras.getString("PHARMACYNAME");
		}
		tvDrugSearchPHRName = (TextView) findViewById(R.id.tvDrugSearchPHRName);
		actvDrugSearchDrugName = (AutoCompleteTextView) findViewById(R.id.actvDrugSearchDrugName);
		btDrugSearchSearch = (Button) findViewById(R.id.btDrugSearchSearch);
		btDrugSearchReset = (Button) findViewById(R.id.btDrugSearchReset);
		DRUGS = getResources().getStringArray(R.array.array_drug);
		ArrayAdapter<String> adapterDrug = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, DRUGS);
		actvDrugSearchDrugName.setAdapter(adapterDrug);
	}

	private void setItems() {
		tvDrugSearchPHRName.setText(strPharmacyName);
	}

	public void onClickHandlerDrugSearch(View view) {
		switch (view.getId()) {
		case R.id.btDrugSearchReset: // Reset
			actvDrugSearchDrugName.setText("");
			break;

		case R.id.btDrugSearchSearch: // Login
			strDrugName = actvDrugSearchDrugName.getText().toString();
			Intent intent = new Intent(DrugSearchActivity.this, DrugActivity.class);
			intent.putExtra("PATIENTOID", strPatientOID);
			intent.putExtra("PLANID", strPlanID);
			intent.putExtra("PHARMACYOID", strPharmacyOID);
			intent.putExtra("DRUGNAME", strDrugName);
			intent.putExtra("PHARMACYNAME", strPharmacyName);
			startActivity(intent);
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
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
