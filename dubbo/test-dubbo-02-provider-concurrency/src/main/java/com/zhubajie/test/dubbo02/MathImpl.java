package com.zhubajie.test.dubbo02;

import com.alibaba.dubbo.config.annotation.Service;

/*import org.springframework.stereotype.Service;*/



@Service
public class MathImpl implements Math{

	public int add(int a, int b) {
		System.out.println("into MathImpl.add()" + a + " + " + b);
		return a + b ;
	}

	public int minus(int a, int b) {
		System.out.println("into MathImpl.minus()" + a + " - " + b);
		return a - b ;
	}

}
