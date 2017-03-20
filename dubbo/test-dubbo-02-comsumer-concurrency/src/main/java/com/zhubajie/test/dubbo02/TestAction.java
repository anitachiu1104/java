package com.zhubajie.test.dubbo02;

import java.util.Scanner;

import com.alibaba.dubbo.config.annotation.Reference;

public class TestAction {
	@Reference
	private Math mathService;
	
	
	public void setMath(Math math) {
		this.mathService = math;
	}


	public void start() throws Exception {
		Scanner s = new Scanner(System.in);
		while (true) {
			int result = mathService.add(33, 3);
	    	 System.out.println(" add result:" + result);
			if ("q".equals(s.nextLine())) {
				break;
			}
		}
    	
    }
}
