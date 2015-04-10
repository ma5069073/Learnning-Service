package com.makk.aidlserver;

import android.os.RemoteException;

public class Person extends IPerson.Stub{
	String name;

	@Override
	public void setValue(String name) throws RemoteException {
		this.name = name;
	}

	@Override
	public String getValue() throws RemoteException {
		return name;
	}

}
