package listener;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.shop.utils.DateUtil;


//职责：允许Ajax跨域请求资源
public class CrossDomainFilter implements Filter
{

	public void destroy()
	{
		System.out.println("CorssDomainFilter destroyed.");

	}

	public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain) throws IOException, ServletException
	{
		HttpServletResponse response = (HttpServletResponse) res;
		System.out.println(DateUtil.genLogDate() + DateUtil.genLogTime() + "--Server get request from:" + request.getRemoteAddr());
		// 设置跨域请求头
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Allow-Headers", "Accept, Origin, X-Requested-With, Content-Type, Last-Modified");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException
	{
		System.out.println("CorssDomainFilter inited.");

	}

}
