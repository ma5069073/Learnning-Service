package com.makk.aidlserver;

import java.util.HashMap;
import java.util.Map;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class SalaryService extends Service {

	ISalary.Stub salary = new ISalary.Stub() {

		@Override
		public Salary getMsg(Worker owner) throws RemoteException {

			Map<Worker, Salary> ss = new HashMap<Worker, Salary>();
			// 初始化Map集合,这里在静态代码块中进行初始化,当然你可也以在构造方法中完成初始化
			ss.put(new Worker(1, "Jay"), new Salary("码农", 2000));
			ss.put(new Worker(2, "GEM"), new Salary("歌手", 20000));
			ss.put(new Worker(3, "XM"), new Salary("学生", 20));
			ss.put(new Worker(4, "MrWang"), new Salary("老师", 2000));

			return ss.get(owner);
		}
	};

	@Override
	public IBinder onBind(Intent intent) {

		return salary;
	}
	@Override
	public void onCreate() {
		super.onCreate();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}

}
