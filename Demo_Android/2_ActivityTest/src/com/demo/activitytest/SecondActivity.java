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
		// 获取 FirstActivity 传入的 Intent
		Intent receiveIntent = getIntent();
		String data = receiveIntent.getStringExtra("extra_data");
		Toast.makeText(this, data, Toast.LENGTH_SHORT).show();

		Button button2 = (Button) findViewById(R.id.button_2);
		button2.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				/* 2016-08-29
				
				/* Intent 调用拨号
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:10086"));
				startActivity(intent);
				
				// 向 Intent 写入数据
				Intent intent = new Intent();
				intent.putExtra("data_return", "Hello From SecondActivity.");
				// 设置 resultCode = RESULT_OK 并返回 intent 给上层活动
				setResult(RESULT_OK, intent);
				finish();
				
				*/
				
				Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
				startActivity(intent);
			}
		});
	}
	
	// 重写 onBackPressed 方法，实现用户点击返回键时执行的操作
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
