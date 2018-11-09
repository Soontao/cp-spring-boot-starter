package corp.sap.hana.spring.demo.aspects;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import io.sentry.Sentry;
import io.sentry.SentryClient;
import io.sentry.event.Breadcrumb;
import io.sentry.event.BreadcrumbBuilder;
import io.sentry.event.Event;
import io.sentry.event.Breadcrumb.Level;

@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Component
@Profile({ "sentry" })
public class SentryAspect {

	BreadcrumbBuilder b;

	Map<String, String> dataMap;

	{
		dataMap = new HashMap<String, String>();
		b = new BreadcrumbBuilder();
		b.setCategory("method:trace");
		b.setLevel(Level.INFO);
		b.setData(dataMap);
	}

	// record all method call before exception occurred
	@Before("execution(* corp.sap.hana.spring.demo.*.*.*(..))")
	public void afterCall(JoinPoint jp) throws Throwable {
		// set args
		dataMap.put("args", jp.getArgs().toString());
		// capture
		Sentry.getContext().recordBreadcrumb(b.setMessage(jp.toShortString()).build());
	}

}
