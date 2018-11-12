package corp.sap.hana.spring.demo.aspects;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import io.sentry.Sentry;
import io.sentry.event.Breadcrumb.Level;
import io.sentry.event.BreadcrumbBuilder;

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
		dataMap.put("args", JSON.toJSONString(jp.getArgs()));
		// capture
		Sentry.getContext().recordBreadcrumb(b.setMessage(jp.toShortString()).build());
	}

}
