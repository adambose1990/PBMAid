package com.cts.android.pbmaid.activity;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.cts.android.pbmaid.R;
import com.cts.android.pbmaid.constants.IMessages;
import com.cts.android.pbmaid.data.PatientData;
import com.cts.android.pbmaid.xml.XMLHandlerLogin;

public class LoginActivity extends Activity {

	private EditText etLoginUserName, etLoginPassWord;
	private CheckBox cbLoginShowPass;
	private Button btLoginLogin, btLoginReset;
	private PatientData patientData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_login);
		initializeItems();
	}

	private void initializeItems() {
		etLoginUserName = (EditText) findViewById(R.id.etLoginUserName);
		etLoginPassWord = (EditText) findViewById(R.id.etLoginPassWord);
		cbLoginShowPass = (CheckBox) findViewById(R.id.cbLoginShowPass);
		btLoginLogin = (Button) findViewById(R.id.btLoginLogin);
		btLoginReset = (Button) findViewById(R.id.btLoginReset);
	}

	public void onClickHandlerLogin(View view) {
		switch (view.getId()) {
		case (R.id.cbLoginShowPass):
			if (cbLoginShowPass.isChecked()) {
				etLoginPassWord.setInputType(InputType.TYPE_CLASS_TEXT);
			} else {
				etLoginPassWord.setInputType(InputType.TYPE_CLASS_TEXT
						| InputType.TYPE_TEXT_VARIATION_PASSWORD);
			}
			break;
		case R.id.btLoginReset: // Reset
			etLoginUserName.setText("");
			etLoginPassWord.setText("");
			break;

		case R.id.btLoginLogin: // Login
			String strUserName = etLoginUserName.getText().toString();
			String strPassWord = etLoginPassWord.getText().toString();
			XMLHandlerLogin handler = new XMLHandlerLogin();
			//StringBuilder finalURL = new StringBuilder(IClientURL.urlForLogin);
			//finalURL.append("?user=" + strUserName);
			try {
				//URL webService = new URL(finalURL.toString());
				SAXParserFactory spfac = SAXParserFactory.newInstance();
				SAXParser saxParser = spfac.newSAXParser();
				XMLReader xmlReader = saxParser.getXMLReader();
				xmlReader.setContentHandler(handler);
				xmlReader.parse(new InputSource(getAssets().open("XMLPatient.xml")));
				patientData = handler.getUserData();
				if (strUserName.equalsIgnoreCase(patientData.getStrUserName()) && 
						strPassWord.equals(patientData.getStrPassword())){
					Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
					intent.putExtra("PATIENTINFO", patientData);
					startActivity(intent);
				} else {
					Toast toast = Toast.makeText(this,IMessages.msgForLoginfailed, Toast.LENGTH_LONG);
					toast.show();
					etLoginUserName.setText("");
					etLoginPassWord.setText("");
				}
			} catch (Exception e) {
				e.printStackTrace();
				Toast toast = Toast.makeText(this,IMessages.msgForCommonError, Toast.LENGTH_LONG);
				toast.show();
				etLoginUserName.setText("");
				etLoginPassWord.setText("");
			}
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
