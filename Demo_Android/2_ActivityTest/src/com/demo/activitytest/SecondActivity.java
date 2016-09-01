package com.demo.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("SecondActivity", this.toString());
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);
		// ��ȡ FirstActivity ����� Intent
		Intent receiveIntent = getIntent();
		String data = receiveIntent.getStringExtra("extra_data");
		Toast.makeText(this, data, Toast.LENGTH_SHORT).show();

		Button button2 = (Button) findViewById(R.id.button_2);
		button2.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				/* 2016-08-29
				
				/* Intent ���ò���
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:10086"));
				startActivity(intent);
				
				// �� Intent д������
				Intent intent = new Intent();
				intent.putExtra("data_return", "Hello From SecondActivity.");
				// ���� resultCode = RESULT_OK ������ intent ���ϲ�
				setResult(RESULT_OK, intent);
				finish();
				
				*/
				
				Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
				startActivity(intent);
			}
		});
	}
	
	// ��д onBackPressed ������ʵ���û�������ؼ�ʱִ�еĲ���
	@Override
	public void onBackPressed() {
		Intent intent = new Intent();
		intent.putExtra("data_return", "Hello From SecondActivity.");
		setResult(RESULT_OK, intent);
		finish();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("SecondActivity", "SecondAct onDestroy");
	}
}
