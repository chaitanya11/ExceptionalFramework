package com.bringmyweb.exceptionalframwork.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.bringmyweb.exceptionalframwork.annotations.Catch;
import com.bringmyweb.exceptionalframwork.annotations.CatchGroup;

public class MethodCaller{
	  /*
	   * @param isntance: instance which implemented the Caller interface
	   */
	  public static void callMethod(Caller instance)
	      throws Exception {
	    Method m = instance.getClass().getMethod("callMethod");
	    Annotation as[] = m.getAnnotations();
	    Catch[] li = null;
	    for (Annotation a : as) {
	      if (a.annotationType().equals(CatchGroup.class)) {
	        li = ((CatchGroup) a).catchers();
	      }
	      // for(Catch cx:li){cx.targetException().getName();}
	    }
	    try {
	      instance.callMethod();
	    } catch (Throwable e) {
	      Class<?> ec = e.getClass();
	      if (li == null) {
	        return;
	      }
	      for (Catch cx : li) {
	        if (cx.targetException().equals(ec)) {
	          ExceptionHandler h = cx.targetCatchHandler().newInstance();
	          h.handleException(e);
	          break;
	        }
	      }
	    }
	  }
	}