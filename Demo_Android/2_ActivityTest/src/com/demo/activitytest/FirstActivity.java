package com.demo.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.content.*;
import android.net.Uri;

public class FirstActivity extends Activity {

	@Override
	//��дonCreate����
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//ȡ���������
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//���û����
		setContentView(R.layout.first_layout);
		
		//Button1����¼�
		Button button1 = (Button) findViewById(R.id.button_1);
		button1.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(FirstActivity.this, "You clicked Button 1", Toast.LENGTH_SHORT).show();
				
				// finish(); // �����
				
				// ������ʽ Intent ����ͼ
				// Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				// startActivity(intent);
				
				// ������ʽ Intent ����Ӧ��ͼ
				Intent intent = new Intent("com.demo.activitytest.ACTION_START");
				intent.addCategory("com.demo.activitytest.MY_CATEGORY");
				String data = "Hello SecondActivity!";
				intent.putExtra("extra_data", data);
				startActivity(intent);
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
	
	// ��дonCreateOptionsMenu���� �����˵�
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	// ��дonOptionsItemSelected���� ��������¼�
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
}