package com.example.servicedemo;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends ActionBarActivity {

	private final String tag = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	ServiceConnection conn = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.d(tag, "onServiceDisconnected.......");
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.d(tag, "onServiceConnected.......");
		}
	};

	public void onClick(View view) {

		Intent intent = new Intent();
		intent.setAction("com.example.servicedemo.TestService");
		Intent intent2 = new Intent();
		
		Bundle b = new Bundle();  
        b.putString("param", "a");  
		intent2.putExtras(b);
		intent2.setAction("com.example.servicedemo.TestService2");

		switch (view.getId()) {
		case R.id.bt_start:
			// 启动service
			startService(intent);

			break;
		case R.id.bt_stop:
			// 关闭service
			stopService(intent);

			break;

		case R.id.bt_start_bind:
			// 绑定service
			bindService(intent, conn, Service.BIND_AUTO_CREATE);
			
			break;
		case R.id.bt_stop_bind:

			// 解除service绑定
			unbindService(conn);
			break;
		case R.id.bt_status_bind:
			break;
		case R.id.bt_start_intent:
			startService(intent2);
			break;
		default:
			break;
		}
	}
}
