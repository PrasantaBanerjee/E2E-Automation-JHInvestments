package org.jhi.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer{

	//Map the RetryListener class.
	@Override
	public void transform(ITestAnnotation arg0, Class arg1, Constructor arg2, Method arg3) {
		arg0.setRetryAnalyzer(RetryListener.class);
	}

}
