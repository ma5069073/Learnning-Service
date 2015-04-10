/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: E:\\WorkSpance\\Android_Learnning\\AIDLServer\\src\\com\\makk\\aidlserver\\ISalary.aidl
 */
package com.makk.aidlserver;
public interface ISalary extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.makk.aidlserver.ISalary
{
private static final java.lang.String DESCRIPTOR = "com.makk.aidlserver.ISalary";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.makk.aidlserver.ISalary interface,
 * generating a proxy if needed.
 */
public static com.makk.aidlserver.ISalary asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.makk.aidlserver.ISalary))) {
return ((com.makk.aidlserver.ISalary)iin);
}
return new com.makk.aidlserver.ISalary.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getMsg:
{
data.enforceInterface(DESCRIPTOR);
Worker _arg0;
if ((0!=data.readInt())) {
_arg0 = Worker.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
Salary _result = this.getMsg(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.makk.aidlserver.ISalary
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
//定义一个Person对象作为传入参数  
//接口中定义方法时,需要制定新参的传递模式,这里是传入,所以前面有一个in  

@Override public Salary getMsg(Worker owner) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
Salary _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((owner!=null)) {
_data.writeInt(1);
owner.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getMsg, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = Salary.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getMsg = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
//定义一个Person对象作为传入参数  
//接口中定义方法时,需要制定新参的传递模式,这里是传入,所以前面有一个in  

public Salary getMsg(Worker owner) throws android.os.RemoteException;
}
