package com.example.servicedemo;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class TestService2 extends IntentService {

	public TestService2() {
		super("TestService2");
	}

	private String tag = "TestService2";

	@Override
	protected void onHandleIntent(Intent intent) {
		String param = intent.getExtras().getString("param");
		if ("a".equals(param)) {
			Log.d(tag, "onHandleIntent");
		}
	}

	@Override
	public void onCreate() {
		Log.d(tag, "onCreate");
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		Log.d(tag, "onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		Log.d(tag, "onDestroy");
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.d(tag, "onBind.......");
		return null;
	}

}
