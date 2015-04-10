package com.makk.aidlserver;

import android.os.Parcel;
import android.os.Parcelable;

public class Salary implements Parcelable {

	private String type;
	private int salary;

	public Salary() {
	}

	public Salary(String type, int salary) {
		super();
		this.type = type;
		this.salary = salary;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

		dest.writeString(type);
		dest.writeInt(salary);
	}

	public static final Parcelable.Creator<Salary> CREATOR = new Creator<Salary>() {

		@Override
		public Salary[] newArray(int size) {
			return new Salary[size];
		}

		@Override
		public Salary createFromParcel(Parcel source) {
			return new Salary(source.readString(), source.readInt());
		}
	};

	public String toString() {
		return "工作:" + type + "    薪水" + salary;
	};

}
