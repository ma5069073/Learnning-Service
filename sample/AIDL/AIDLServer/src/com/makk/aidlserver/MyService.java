package com.makk.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

	private IPerson.Stub person = new Person();
	
	@Override
	public IBinder onBind(Intent intent) {
		
		return person;
	}

}
