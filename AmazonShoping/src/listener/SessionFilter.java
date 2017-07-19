package listener;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.shop.utils.HibernateUtil;


//ְ��Hibernate Sessionÿ������һ��Session
public class SessionFilter implements Filter
{

	public void destroy()
	{
		System.out.println("SessionFilter destroyed.");

	}

	public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain) throws IOException, ServletException
	{
		HttpServletResponse response = (HttpServletResponse) res;
		Session session = null;
		try
		{
			session = HibernateUtil.openSession();
			System.out.println("open new session..." + session.getStatistics());
			chain.doFilter(request, response);

		} catch (Exception e)
		{
			System.out.println("filter chain throw exception:" + e.getMessage());
		} finally
		{
			session = HibernateUtil.openSession();
			System.out.println("close old session..." + session.getStatistics());
			HibernateUtil.closeSession();
			
			
			
			
		}

	}

	public void init(FilterConfig arg0) throws ServletException
	{
		System.out.println("SessionFilter inited.");

	}

}
