package com.zhubajie.test.dubbo02.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.zhubajie.test.dubbo02.model.OrderInfo;

public class Common {
	public static OrderInfo orderInfo = null; 
	
	public Common(){
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setAge("12");
		orderInfo.setBillNumber(111);
		orderInfo.setName("anita");
		orderInfo.setDatetime(new Date());
		orderInfo.setAddress("zhongshan road");
		orderInfo.setAmount(8888);
		orderInfo.setEmail("anita@126.com");
		this.orderInfo=orderInfo;
		
	}
	
	public OrderInfo BuildOrder() {
/*		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setAge("12");
		orderInfo.setBillNumber(111);
		orderInfo.setName("anita");
		orderInfo.setDatetime(new Date());
		orderInfo.setAddress("zhongshan road");
		orderInfo.setAmount(8888);
		orderInfo.setEmail("anita@126.com");*/
		return orderInfo;
	}
	
	public List<OrderInfo> BuildOrderList(){
/*		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setAge("12");
		orderInfo.setBillNumber(111);
		orderInfo.setName("anita");
		orderInfo.setDatetime(new Date());
		orderInfo.setAddress("zhongshan road");
		orderInfo.setAmount(8888);
		orderInfo.setEmail("anita@126.com");*/
		ArrayList list = new ArrayList(); 
		for( int i=0;i <100;i++ ) {
			list.add(orderInfo); 
		}
		return list;
	}
	
	public String Build1KString(){
		byte[] b = new byte[1024];
		Arrays.fill(b, (byte)48);
		return new String(b).toString();	
	}
	
	public String Build100KString(){
		byte[] b = new byte[102400];
		Arrays.fill(b, (byte)48);
		return new String(b).toString();	
	}
	
	public String Build1MString(){
		byte[] b = new byte[1024*1024];
		Arrays.fill(b, (byte)48);
		return new String(b).toString();	
	}
	

}
