package com.zhubajie.test.dubbo02.thread;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhubajie.test.dubbo02.IBusinessOrder;
import com.zhubajie.test.dubbo02.model.OrderInfo;
import com.zhubajie.test.dubbo02.service.Common;

public class myTask implements Runnable{
	
	private IBusinessOrder orderBusiness;
	long returnOrder = 0,returnOrderList=0,returnStr1k=0,returnStr100k=0,returnStr1M=0;
	int returnOrderNum = 0,returnOrderListNum=0,returnStr1kNum=0,returnStr100kNum=0,returnStr1MNum=0;
	
	public myTask(IBusinessOrder BusinessOrder){
		this.orderBusiness=BusinessOrder;
		
	}
	
	@Override
	public void run() {
		Common Common = new Common();
		long startMili, endMili;
		int loop = 1;
		
		// 单个pojo
		try {

			OrderInfo order = Common.BuildOrder();
			//orderBusiness.LoadOrder(order); // 防止首次连接的开销
			startMili = System.currentTimeMillis();
			OrderInfo returnOrder = null;
			for (int i = 0; i < loop; i++) {
				returnOrder = orderBusiness.LoadOrder(order);
			}
			
			endMili = System.currentTimeMillis();
			this.returnOrder = this.returnOrder + (endMili - startMili);
			this.returnOrderNum = this.returnOrderNum+1;
			if(this.returnOrderNum >= 10){
				System.out.println("单个pojo 总共传输耗时为："
						+ this.returnOrder + "毫秒 ,返回对象BillNumber:" 
						+ returnOrder.getAddress());
			}
			
		} catch (Exception ex) {
			System.out.println("单个pojo 测试失败!");
			ex.printStackTrace();
		}

		// pojo集合 (100)
		try {
			List<OrderInfo> orderList = Common.BuildOrderList();
			startMili = System.currentTimeMillis();
			List<OrderInfo> returnOrderList = null;
			for (int i = 0; i < loop; i++) {
				returnOrderList = orderBusiness.LoadOrders(orderList);
			}
			endMili = System.currentTimeMillis();
			this.returnOrderList = this.returnOrderList + (endMili - startMili);
			this.returnOrderListNum = this.returnOrderListNum+1;
			if(this.returnOrderListNum >= 10){
				System.out.println("pojo集合 (100) 总共传输耗时为："
						+ this.returnOrderList + "毫秒 ,返回记录数："
						+ returnOrderList.size());
			}
	
		} catch (Exception ex) {
			System.out.println("pojo集合 (100) 测试失败!");
		}

		// 1K String
		try {
			String str1k = Common.Build1KString();
			startMili = System.currentTimeMillis();
			String returnStr1k = null;
			for (int i = 0; i < loop; i++) {
				returnStr1k = orderBusiness.SendStr(str1k);
			}
			endMili = System.currentTimeMillis();
			this.returnStr1k = this.returnStr1k + (endMili - startMili);
			this.returnStr1kNum = this.returnStr1kNum+1;
			if(this.returnStr1kNum >= 10){
				System.out.println("1K String 总共传输耗时为："
						+ this.returnStr1k + "毫秒,返回字符长度："
						+ returnStr1k.length());
			}

		} catch (Exception ex) {
			System.out.println("1K String 测试失败!");
		}

		// 100K String
		try {
			String str100K = Common.Build100KString();
			startMili = System.currentTimeMillis();
			String returnStr100k = null;
			for (int i = 0; i < loop; i++) {
				returnStr100k = orderBusiness.SendStr(str100K);
			}
			endMili = System.currentTimeMillis();
			this.returnStr100k = this.returnStr100k + (endMili - startMili);
			this.returnStr100kNum = this.returnStr100kNum+1;
			if(this.returnStr100kNum >= 10){
				System.out.println("100K String 总共传输耗时为："
						+ this.returnStr100k + "毫秒,返回字符长度："
						+ returnStr100k.length());				
			}

		} catch (Exception ex) {
			System.out.println("100K String 测试失败!");
		}

		// 1M String
		try {
			String str1M = Common.Build1MString();
			startMili = System.currentTimeMillis();
			String returnStr1M = null;
			for (int i = 0; i < loop; i++) {
				returnStr1M = orderBusiness.SendStr(str1M);
			}
			endMili = System.currentTimeMillis();
			this.returnStr1M = this.returnStr1M + (endMili - startMili);
			this.returnStr1MNum = this.returnStr1MNum+1;
			if(this.returnStr1MNum >= 10){
				System.out.println("1M String 总共传输耗时为："
						+ this.returnStr1M + "毫秒,返回字符长度："
						+ returnStr1M.length());
			}
			
		} catch (Exception ex) {
			System.out.println("1M String 测试失败!");
		}

		System.out.println("all test done!");
	}

}
