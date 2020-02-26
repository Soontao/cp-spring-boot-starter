package corp.sap.hana.spring.demo.configuration;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty("auth.token")
public class StaticTokenFilter implements Filter {

	@Value("${auth.token}")
	private String token;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String t = request.getParameter("token");
		if (!this.token.equals(t)) {
			throw new ServletException("token auth failed");
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
