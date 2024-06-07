package com.ruby.funcimpl;

import com.ruby.func.MyProvider;
import com.ruby.func.MySubFunc;

public class MultiplyProvider implements MyProvider {

  public MySubFunc get() {
    return new MultiplyFunc();
  }
}
