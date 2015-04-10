package com.makk.aidlserver;

import com.makk.aidlserver.Worker;
import com.makk.aidlserver.Salary;

interface ISalary {
	//定义一个Person对象作为传入参数  
    //接口中定义方法时,需要制定新参的传递模式,这里是传入,所以前面有一个in  
    Salary getMsg(in Worker owner);  
}