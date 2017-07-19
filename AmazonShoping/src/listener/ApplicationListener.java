package listener;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ApplicationListener implements ServletContextListener
{
	public void contextDestroyed(ServletContextEvent arg0)
	{
		System.out.println("商城服务系统停止了...");
	}

	public void contextInitialized(ServletContextEvent event)
	{
		System.out.println("商城服务系统服务器启动了...");
		// 获取和配置全局参数
		ServletContext context = event.getServletContext();
		String webroot = context.getRealPath("/");
		System.out.println("服务器根路径-------" + webroot);
	}

}
