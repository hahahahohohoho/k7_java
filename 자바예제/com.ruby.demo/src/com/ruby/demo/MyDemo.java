package com.ruby.demo;

import java.util.ServiceLoader;

import com.ruby.func.MyFunc;
import com.ruby.func.MyProvider;
import com.ruby.func.MySubFunc;
import com.ruby.util.MyUtil;

public class MyDemo {
	public static void main(String[] args) {
		MyFunc.get();
		MyUtil.add();

		ServiceLoader<MyProvider> ldr = ServiceLoader.load(MyProvider.class);

		MySubFunc msf = null;
		for (MyProvider mp : ldr) {
			msf = mp.get();
			System.out.println(msf.getName() + ":" + msf.func(10, 2));
		}
	}
}
