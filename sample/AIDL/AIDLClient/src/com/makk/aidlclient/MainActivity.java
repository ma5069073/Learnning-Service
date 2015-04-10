package com.makk.aidlclient;

import com.makk.aidlserver.IPerson;
import com.makk.aidlserver.ISalary;
import com.makk.aidlserver.Salary;
import com.makk.aidlserver.Worker;

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
	ISalary salary;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onClick(View view) {
		Intent intent =  new Intent();;
		switch (view.getId()) {
		case R.id.button1:
			
			intent.setAction("com.makk.aidlserver.MyService");
			bindService(intent, conn, Service.BIND_AUTO_CREATE);
			break;
		case R.id.button2:
			intent.setAction("com.makk.aidlserver.SalaryService");
			bindService(intent, connSalary, Service.BIND_AUTO_CREATE);
			break;

		default:
			break;
		}
	}
	
	ServiceConnection connSalary  = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			salary = ISalary.Stub.asInterface(service);
			if (salary!=null) {
				try {
					Salary s = salary.getMsg(new Worker(1, "Jay"));
					Toast.makeText(MainActivity.this, "获取成功：" + s.getType()+"salary:"+s.getSalary(),
							Toast.LENGTH_SHORT).show();
				} catch (RemoteException e) {
					e.printStackTrace();
					Toast.makeText(MainActivity.this, "获取失败！！！",
							Toast.LENGTH_SHORT).show();
				}
			}
		}
	};

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
