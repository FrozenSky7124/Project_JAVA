package com.demo.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);
		Intent receiveIntent = getIntent();
		String data = receiveIntent.getStringExtra("extra_data");
		Toast.makeText(this, data, Toast.LENGTH_SHORT).show();

		Button button2 = (Button) findViewById(R.id.button_2);
		button2.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:10086"));
				startActivity(intent);
			}
		});
	}
}
