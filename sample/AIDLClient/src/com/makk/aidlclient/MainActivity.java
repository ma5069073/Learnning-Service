package com.makk.aidlclient;

import com.makk.aidlserver.IPerson;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	IPerson person;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onClick(View view) {
		Intent intent = new Intent();
		intent.setAction("com.makk.aidlserver.MyService");
		bindService(intent, conn, Service.BIND_AUTO_CREATE);
	}

	ServiceConnection conn = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			person = IPerson.Stub.asInterface(service);
			if (person != null) {
				try {
					String value = person.getValue();
					Toast.makeText(MainActivity.this, "获取成功：" + value,
							Toast.LENGTH_SHORT).show();
				} catch (RemoteException e) {
					e.printStackTrace();
					Toast.makeText(MainActivity.this, "获取失败！！！",
							Toast.LENGTH_SHORT).show();
				}
			}
		}
	};
}
