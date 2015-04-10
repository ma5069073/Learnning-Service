package com.makk.aidlserver;

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

	IPerson iPerson;
	ISalary iSalary;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Intent intent = new Intent(this, SalaryService.class);
		bindService(intent, connSalary, Service.BIND_AUTO_CREATE);
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.button1:
			Intent i = new Intent(this, MyService.class);
			bindService(i, conn, Service.BIND_AUTO_CREATE);

			break;
		case R.id.button2:
			unbindService(conn);
			break;

		default:
			break;
		}
	}

	ServiceConnection connSalary = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
		}
	};

	ServiceConnection conn = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			iPerson = IPerson.Stub.asInterface(service);
			if (iPerson != null) {
				try {
					iPerson.setValue("makk is exist");
					Toast.makeText(MainActivity.this, "赋值成功",
							Toast.LENGTH_SHORT).show();
				} catch (RemoteException e) {
					e.printStackTrace();
					Toast.makeText(MainActivity.this, "赋值失败",
							Toast.LENGTH_SHORT).show();
				}
			}
		}
	};
}
