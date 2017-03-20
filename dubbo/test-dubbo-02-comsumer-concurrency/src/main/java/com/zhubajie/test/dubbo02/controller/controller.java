package com.zhubajie.test.dubbo02.controller;

import java.util.List;
import java.util.Map;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhubajie.test.dubbo02.Math;
import com.zhubajie.test.dubbo02.IBusinessOrder;
import com.zhubajie.test.dubbo02.model.OrderInfo;
import com.zhubajie.test.dubbo02.service.Common;
import com.zhubajie.test.dubbo02.thread.ThreadPoolDemo.MyTask;
import com.zhubajie.test.dubbo02.thread.myTask;

@Controller
public class controller {
	
/*	 @Autowired
	 private Math mathService;*/
	 
	 @Autowired
	 private IBusinessOrder orderBusiness;
	 
	 @RequestMapping("/index")
	 public void index() {
/*		    int hello = mathService.add(1,2); 
		 */
		    myTask myTask = new myTask(orderBusiness);
			ExecutorService es = Executors.newFixedThreadPool(100);
			for (int i = 0; i < 10; i++) {
				es.submit(myTask);
			} 
		
	 }

}
