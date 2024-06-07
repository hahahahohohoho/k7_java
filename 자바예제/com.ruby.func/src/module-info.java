module com.ruby.func {
	exports com.ruby.func;
	exports com.ruby.funcimpl;
	requires transitive com.ruby.util;
	provides com.ruby.func.MyProvider with com.ruby.funcimpl.AddProvider, 
	                                       com.ruby.funcimpl.MultiplyProvider;

}