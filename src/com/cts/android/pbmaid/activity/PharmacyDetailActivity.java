package com.cts.android.pbmaid.activity;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.cts.android.pbmaid.R;
import com.cts.android.pbmaid.data.InsurancePlanData;
import com.cts.android.pbmaid.data.PharmacyData;

@SuppressLint("SimpleDateFormat")
public class PharmacyDetailActivity extends Activity {

	private PharmacyData pharmacyData = null;
	private String strPatientOID = null;
	private String strPlanID = null;
	private final String timeFormat = "HHmm";
	TextView tvPharmacyDetailName, tvPharmacyDetailContactNo, tvPharmacyDetailAddl1, tvPharmacyDetailAddl2;
	TextView tvPharmacyDetailState, tvPharmacyDetailZIPCode, tvPharmacyDetailOpeningTime;
	RatingBar rbPharmacyDetailStar;
	ImageView ivPharmacyDetailIndicator;
	Button btPharmacyDetailSearch;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_pharmacy_detail);
		initializeItems();
		setItems();
	}

	private void initializeItems() {
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			pharmacyData = (PharmacyData) getIntent().getSerializableExtra("PHARMACYINFO");
			strPatientOID = extras.getString("PATIENTOID");
			strPlanID = extras.getString("PLANID");
		}
		tvPharmacyDetailName = (TextView) findViewById(R.id.tvPharmacyDetailName);
		rbPharmacyDetailStar = (RatingBar) findViewById(R.id.rbPharmacyDetailStar);
		tvPharmacyDetailContactNo = (TextView) findViewById(R.id.tvPharmacyDetailContactNo);
		tvPharmacyDetailAddl1 = (TextView) findViewById(R.id.tvPharmacyDetailAddl1);
		tvPharmacyDetailAddl2 = (TextView) findViewById(R.id.tvPharmacyDetailAddl2);
		tvPharmacyDetailState = (TextView) findViewById(R.id.tvPharmacyDetailState);
		tvPharmacyDetailZIPCode = (TextView) findViewById(R.id.tvPharmacyDetailZIPCode);
		tvPharmacyDetailOpeningTime = (TextView) findViewById(R.id.tvPharmacyDetailOpeningTime);
		ivPharmacyDetailIndicator = (ImageView) findViewById(R.id.ivPharmacyDetailIndicator);
		btPharmacyDetailSearch = (Button) findViewById(R.id.btPharmacyDetailSearch);
	}
	
	private void setItems() {
		Date currTime = new Date();
		int intCurrTime, intOpenTime, intCloseTime;
		SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
		String strOpenTime = pharmacyData.getStrOpeningTime();
		String strCloseTime = pharmacyData.getStrClosingTime();
		tvPharmacyDetailName.setText(pharmacyData.getStrName());
		rbPharmacyDetailStar.setRating(pharmacyData.getIntRating());
		tvPharmacyDetailContactNo.setText(pharmacyData.getStrContactNo());
		tvPharmacyDetailAddl1.setText(pharmacyData.getStrAddressLine1());
		tvPharmacyDetailAddl2.setText(pharmacyData.getStrAddressLine2());
		tvPharmacyDetailState.setText(pharmacyData.getStrState());
		tvPharmacyDetailZIPCode.setText(pharmacyData.getStrZIPCode());
		intCurrTime = Integer.parseInt(sdf.format(currTime));
		intOpenTime = Integer.parseInt(strOpenTime);
		intCloseTime = Integer.parseInt(strCloseTime);
		tvPharmacyDetailOpeningTime.setText(strOpenTime + " Hrs - " + strCloseTime + " Hrs");
		if ((intCurrTime >= intOpenTime) && (intCurrTime < intCloseTime)) {
			ivPharmacyDetailIndicator.setImageDrawable(getResources()
					.getDrawable(R.drawable.indicatorgreen));
		} else {
			ivPharmacyDetailIndicator.setImageDrawable(getResources()
					.getDrawable(R.drawable.indicatorred));
		}
	}
	
	public void onClickPharmacyDetail(View view) {
		switch (view.getId()) {
		case R.id.btPharmacyDetailSearch: // Drug Search
			Intent intent = new Intent(PharmacyDetailActivity.this, DrugSearchActivity.class);
			intent.putExtra("PATIENTOID", strPatientOID);
			intent.putExtra("PLANID", strPlanID);
			intent.putExtra("PHARMACYOID", pharmacyData.getStrOID());
			intent.putExtra("PHARMACYNAME", pharmacyData.getStrName());
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
