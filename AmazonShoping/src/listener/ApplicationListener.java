package listener;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ApplicationListener implements ServletContextListener
{
	public void contextDestroyed(ServletContextEvent arg0)
	{
		System.out.println("�̳Ƿ���ϵͳֹͣ��...");
	}

	public void contextInitialized(ServletContextEvent event)
	{
		System.out.println("�̳Ƿ���ϵͳ������������...");
		// ��ȡ������ȫ�ֲ���
		ServletContext context = event.getServletContext();
		String webroot = context.getRealPath("/");
		System.out.println("��������·��-------" + webroot);
	}

}
