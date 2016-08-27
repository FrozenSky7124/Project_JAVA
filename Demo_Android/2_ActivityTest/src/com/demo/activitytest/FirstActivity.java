package com.demo.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.content.*;
import android.net.Uri;

public class FirstActivity extends Activity {

	@Override
	//重写onCreate方法
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//取消活动标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//设置活动布局
		setContentView(R.layout.first_layout);
		
		//Button1点击事件
		Button button1 = (Button) findViewById(R.id.button_1);
		button1.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(FirstActivity.this, "You clicked Button 1", Toast.LENGTH_SHORT).show();
				
				// finish(); // 结束活动
				
				// 创建显式 Intent 的意图
				// Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				// startActivity(intent);
				
				// 创建隐式 Intent 的响应意图
				Intent intent = new Intent("com.demo.activitytest.ACTION_START");
				intent.addCategory("com.demo.activitytest.MY_CATEGORY");
				String data = "Hello SecondActivity!";
				intent.putExtra("extra_data", data);
				// startActivity(intent);
				startActivityForResult(intent, 1);
			}
		});
		
		Button button2 = (Button) findViewById(R.id.button_2_IE);
		button2.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://www.baidu.com"));
				startActivity(intent);
			}
		});
	}
	
	// 重写onCreateOptionsMenu方法 构建菜单
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	// 重写onOptionsItemSelected方法 创建点击事件
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId())
		{
		case R.id.add_item :
			Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
			break;
		case R.id.remove_item:
			Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
			break;
		default:
		}
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case 1:
			if (resultCode == RESULT_OK) {
				String returnedData = data.getStringExtra("data_return");
				Log.d("FirstActivity", returnedData);
			}
			break;
		default:
		}
	}
}
