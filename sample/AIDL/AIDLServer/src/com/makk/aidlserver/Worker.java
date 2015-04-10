package com.makk.aidlserver;


import android.os.Parcel;
import android.os.Parcelable;

public class Worker implements Parcelable {
	private int id;
	private String name;

	public Worker() {
	}

	public Worker(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 实现Parcelable必须实现的方法,不知道拿来干嘛的,直接返回0就行了
	@Override
	public int describeContents() {
		return 0;
	}

	// 写入数据到Parcel中的方法
	@Override
	public void writeToParcel(Parcel dest, int flags) {

		dest.writeInt(id);
		dest.writeString(name);
	}

	// 必须提供一个名为CREATOR的static final属性 该属性需要实现
	// android.os.Parcelable.Creator<T>接口
	public static final Parcelable.Creator<Worker> CREATOR = new Creator<Worker>() {

		@Override
		public Worker[] newArray(int size) {
			return new Worker[size];
		}

		@Override
		public Worker createFromParcel(Parcel source) {
			return new Worker(source.readInt(), source.readString());
		}
	};

	// 因为我们集合取出元素的时候是根据Person对象来取得,所以比较麻烦,
	// 需要我们重写hashCode()和equals()方法
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
