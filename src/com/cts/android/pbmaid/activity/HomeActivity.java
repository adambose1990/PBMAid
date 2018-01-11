package com.cts.android.pbmaid.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.cts.android.pbmaid.R;
import com.cts.android.pbmaid.data.InsurancePlanData;
import com.cts.android.pbmaid.data.PatientData;

public class HomeActivity extends Activity {
	
	private EditText etHomeZipCode;
	private TextView tvHomeWelcomeNote;
	private Spinner spHomePlanName, spHomeSearch;
	private Button btHomeSearch, btHomeReset;
	private PatientData patientData = null;
	private String[] PLANS;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_home);
		initializeItems();
		setItems();
	}
	
	private void initializeItems() {
		patientData = (PatientData) getIntent().getSerializableExtra("PATIENTINFO");
		etHomeZipCode = (EditText) findViewById(R.id.etHomeZipCode);
		tvHomeWelcomeNote = (TextView) findViewById(R.id.tvHomeWelcomeNote);
		spHomePlanName = (Spinner) findViewById(R.id.spHomePlanName);
		spHomeSearch = (Spinner) findViewById(R.id.spHomeSearch);
		btHomeSearch = (Button) findViewById(R.id.btHomeSearch);
		btHomeReset = (Button) findViewById(R.id.btHomeReset);
	}
	
	private void setItems() {
		ArrayAdapter<String> adapterTopic = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.array_SearchTopic));
		adapterTopic.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		spHomeSearch.setAdapter(adapterTopic);
		if (patientData != null) {
			tvHomeWelcomeNote.setText("Hi " + patientData.getStrFirstName() + ",");
			ArrayList<String> listPlanNames = new ArrayList<String>();
			listPlanNames.add("Select a Plan");
			if (patientData.getListPlanData() != null) {
				for (InsurancePlanData planData : patientData.getListPlanData()) {
					listPlanNames.add(planData.getStrPlanName());
				}
				PLANS = listPlanNames.toArray(new String[listPlanNames.size()]);
				ArrayAdapter<String> adapterPlan = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, PLANS);
				spHomePlanName.setAdapter(adapterPlan);
			}
		}
	}
	
	public void onClickHandlerHome(View view) {
		switch (view.getId()) {
		case R.id.btHomeReset: // Reset
			etHomeZipCode.setText("");
			spHomePlanName.setSelection(0);
			spHomeSearch.setSelection(0);
			break;
			
		case R.id.btHomeSearch: // Login
			String strZipCode = etHomeZipCode.getText().toString();
			String strPlanName = spHomePlanName.getSelectedItem().toString();
			String strSearchTopic = spHomeSearch.getSelectedItem().toString();
			String strPlanID = null;
			for (InsurancePlanData planData : patientData.getListPlanData()) {
				if (strPlanName.equalsIgnoreCase(planData.getStrPlanName())) {
					strPlanID = planData.getStrOID();
				}
			}
			Intent intent = new Intent(HomeActivity.this, PharmacyActivity.class);
			intent.putExtra("PATIENTOID", patientData.getStrOID());
			intent.putExtra("ZIPCODE", strZipCode);
			intent.putExtra("PLANID", strPlanID);
			intent.putExtra("TOPIC", strSearchTopic);
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
