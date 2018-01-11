/**
 * 
 */
package com.cts.android.pbmaid.adapters;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.cts.android.pbmaid.R;
import com.cts.android.pbmaid.data.PharmacyData;

/**
 * @author Arindam
 * 
 */
public class CustomAdapterPharmacy extends BaseAdapter {

	private Activity activity;
	private ArrayList<PharmacyData> listPharmData;
	private static LayoutInflater inflater = null;
	private TextView tvPharmacyName;
	private RatingBar rbPharmacyStar;
	private ImageView ivPharmacyindicator;
	private final String timeFormat = "HHmm";

	public CustomAdapterPharmacy(Activity activity, ArrayList<PharmacyData> listPharmData) {
		this.activity = activity;
		this.listPharmData = listPharmData;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return listPharmData.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("SimpleDateFormat")
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		Date currTime = new Date();
		int intCurrTime, intOpenTime, intCloseTime;
		if (convertView == null)
			vi = inflater.inflate(R.layout.list_row_pharmacy, null);

		tvPharmacyName = (TextView) vi.findViewById(R.id.tvPharmacyName);
		rbPharmacyStar = (RatingBar) vi.findViewById(R.id.rbPharmacyStar);
		ivPharmacyindicator = (ImageView) vi
				.findViewById(R.id.ivPharmacyindicator);

		PharmacyData pharmData = new PharmacyData();
		pharmData = listPharmData.get(position);

		// Setting all values in listview
		tvPharmacyName.setText(pharmData.getStrName());
		rbPharmacyStar.setRating(pharmData.getIntRating());
		SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
		try {
			intCurrTime = Integer.parseInt(sdf.format(currTime));
			intOpenTime = Integer.parseInt(pharmData.getStrOpeningTime());
			intCloseTime = Integer.parseInt(pharmData.getStrClosingTime());
			if ((intCurrTime >= intOpenTime) && (intCurrTime < intCloseTime)) {
				ivPharmacyindicator.setImageDrawable(vi.getResources()
						.getDrawable(R.drawable.indicatorgreen));
			} else {
				ivPharmacyindicator.setImageDrawable(vi.getResources()
						.getDrawable(R.drawable.indicatorred));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vi;
	}

}
