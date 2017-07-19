package com.shop.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;

import com.shop.model.User;
import com.shop.utils.HibernateUtil;

//�û�����ҵ���߼�
public class UserService {
//	private static Random random = new Random();
	//�����û����֤
	//�����û�email
			public static User updateUserIdCard(String user_email,String idCard,String user_name) throws RuntimeException {
				try {
					Session session = HibernateUtil.openSession();
					session.beginTransaction();
					Query query = session
							.createQuery("select t FROM User t where t.user_email=?");
					query.setParameter(0, user_email);
					User user = (User) query.list().get(0);
					int id = user.getUser_id();
					User u = (User) session.get(User.class, id);
					u.setIdCard(idCard);
					u.setUser_name(user_name);
					session.update(u);
					session.getTransaction().commit();
					session.close();
					return u;
				} catch (Exception e) {
					throw new RuntimeException("�����ֻ�����ʧ��");
				}

			}
		
	
	
	//�����û�email
		public static User updateUserEmail(String user_email,String user_new_email) throws RuntimeException {
			try {
				Session session = HibernateUtil.openSession();
				session.beginTransaction();
				Query query = session
						.createQuery("select t FROM User t where t.user_email=?");
				query.setParameter(0, user_email);
				User user = (User) query.list().get(0);
				int id = user.getUser_id();
				User u = (User) session.get(User.class, id);
				u.setUser_email(user_new_email);
				session.update(u);
				session.getTransaction().commit();
				session.close();
				return u;
			} catch (Exception e) {
				throw new RuntimeException("�����ֻ�����ʧ��");
			}

		}
	
	
	
	//����email�����û��ֻ���Ϣ
		public static User updateUserPhone(String user_email,String newPhone) throws RuntimeException {
			try {
				Session session = HibernateUtil.openSession();
				session.beginTransaction();
				Query query = session
						.createQuery("select t FROM User t where t.user_email=?");
				query.setParameter(0, user_email);
				User user = (User) query.list().get(0);
				int id = user.getUser_id();
				User u = (User) session.get(User.class, id);
				u.setUser_telephone(newPhone);
				session.update(u);
				session.getTransaction().commit();
				session.close();
				return u;
			} catch (Exception e) {
				throw new RuntimeException("�����ֻ�����ʧ��");
			}

		}
	
	
	// �����û����� ���¸�����Ϣ
	public static User update(String user_email, String user_petName,
			String user_name, String user_sex, String user_telephone,
			String user_new_email, Date user_birthday) throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			
			Query query = session
					.createQuery("select t FROM User t where t.user_email=?");
			query.setParameter(0, user_email);
			User user = (User) query.list().get(0);
			int id = user.getUser_id();
			User u = (User) session.get(User.class, id);
			if (!("".equals(user_new_email)) || !(null == user_email)) {
				u.setUser_email(user_new_email);
			}
			if (!("".equals(user_petName)) || !(null == user_petName)) {
				u.setUser_petName(user_petName);
			}

			u.setUser_pirthday(user_birthday);
			if (!("".equals(user_name)) || !(null == user_name)) {
				u.setUser_name(user_name);
			}
			if (!("".equals(user_sex)) || !(null == user_sex)) {
				u.setUser_sex(user_sex);
			}
			if (!("".equals(user_telephone)) || !(null == user_telephone)) {
				u.setUser_telephone(user_telephone);
			}
			session.update(u);
			session.getTransaction().commit();
			session.close();
			return u;
		} catch (Exception e) {
			throw new RuntimeException("�����û���ʧ��");
		}

	}
	//��ӻ����֧������
	// �����û����� ���¸�����Ϣ
	public static User updatePayPassword(String user_email,String payPassword) throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			Query query = session
					.createQuery("select t FROM User t where t.user_email=?");
			query.setParameter(0, user_email);
			User user = (User) query.list().get(0);
			int id = user.getUser_id();
			User u = (User) session.get(User.class, id);
			u.setPayPassword(payPassword);
			session.update(u);
			session.getTransaction().commit();
			session.close();
			return u;
		} catch (Exception e) {
			throw new RuntimeException("�����û���ʧ��");
		}

	}
	
	
	//�����û�email�õ��û�ȫ����Ϣ
	public static User getUserInfo(String user_email) throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			Query query = session
					.createQuery("select t FROM User t where t.user_email=?");
			query.setParameter(0, user_email);
			User user = (User) query.list().get(0);
			int id = user.getUser_id();
			User u = (User) session.get(User.class, id);
			session.getTransaction().commit();
			session.close();
			return u;
		} catch (Exception e) {
			throw new RuntimeException("�����û���ʧ��");
		}

	}

	//�޸��û�����
	public static User updatePassword(String user_email,String user_old_password,String user_new_password) throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			Query query = session
					.createQuery("select t FROM User t where t.user_email=?");
			query.setParameter(0, user_email);
			User user = (User) query.list().get(0);
			int id = user.getUser_id();
			User u = (User) session.get(User.class, id);
			if(!u.getUser_password().equals(user_old_password))
			{
				System.out.println("ԭ�������");
				throw new RuntimeException("ԭ�������");
			}
			
			u.setUser_password(user_new_password);
			
			session.update(u);
			session.getTransaction().commit();
			session.close();
			return u;
		} catch (Exception e) {
			throw new RuntimeException("�����û���ʧ��");
		}

	}
	// ��õ�¼Ա������ʧ�������쳣
	public static User login(String name, String password)
			throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			System.out.println(name + "," + password);
			Query query = session
					.createQuery("select t FROM User t where t.user_email=? and t.user_password=?");
			query.setParameter(0, name);
			query.setParameter(1, password);
			List<User> userList = query.list();
			System.out.println(userList);
			if (userList.isEmpty()) {
				System.out.println("û���ҵ�");
				throw new RuntimeException(); // δ�ҵ���Ա��
			}
			User user = userList.get(0);

			return user;
		} catch (Exception e) {
			throw new RuntimeException("�û������������!!!��");
		}

	}

	// �û�ע��
	public static User register(String email, String password)
			throws RuntimeException {
		try {

			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			Query query = session
					.createQuery("select t FROM User t where t.user_email=?");
			query.setParameter(0, email);

			List<User> userList = query.list();
			if (!userList.isEmpty()) {
				throw new RuntimeException("��email�Ѿ�ע�ᣡ"); // δ�ҵ���Ա��
			}

			User user = new User();

			user.setUser_email(email);
			user.setUser_password(password);

			session.save(user);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return user;
		} catch (Exception e) {
			throw new RuntimeException("ע����Ա��ʧ�ܣ�" + e.getMessage());
		}
	}

	// // ��ø����ִ���˾�е�ȫ��Ա���б�����ְʱ������
	// public static List<Employee> getEmployeeListInWarehouseCompany(int
	// warehouseCompanyId) throws RuntimeException
	// {
	// try
	// {
	// Session session = HibernateUtil.getSession();
	// Query query =
	// session.createQuery("select t from Employee as t join t.warehouseCompany as x  where x.id=? order by t.registerTime asc ");
	// query.setParameter(0, warehouseCompanyId);
	// List<Employee> employeeList = query.list();
	// return employeeList;
	// } catch (Exception e)
	// {
	// throw new RuntimeException("��ȡԱ���б�ʧ�ܣ�" + e.getMessage());
	// }
	// }
	//
	//
	// // ģ����ѯ�����ִ���˾�е�ȫ��Ա���б�����ְʱ������
	// public static List<Employee> queryEmployeeListInWarehouseCompany(int
	// warehouseCompanyId,String name,String gender,String role,String status)
	// throws RuntimeException
	// {
	// try
	// {
	// Session session = HibernateUtil.getSession();
	// Query query =
	// session.createQuery("select t from Employee as t join t.warehouseCompany as x  where x.id=? and t.name like ? and t.gender like ? and t.role like ? and t.status like ? order by t.registerTime asc ");
	// query.setParameter(0, warehouseCompanyId);
	// query.setParameter(1, ServiceUtil.toQueryString(name));
	// query.setParameter(2, ServiceUtil.toQueryString(gender));
	// query.setParameter(3, ServiceUtil.toQueryString(role));
	// query.setParameter(4, ServiceUtil.toQueryString(status));
	// List<Employee> employeeList = query.list();
	// return employeeList;
	// } catch (Exception e)
	// {
	// throw new RuntimeException("ģ����ѯԱ���б�ʧ�ܣ�" + e.getMessage());
	// }
	// }

	// // ���¸���id��Ա����Ϣ
	// public static Employee update(int employeeId, String name, String
	// password, String gender, String role, String status, Date registerTime)
	// throws RuntimeException
	// {
	// try
	// {
	// Session session = HibernateUtil.getSession();
	// Employee employee = (Employee) session.get(Employee.class, employeeId);
	// employee.setGender(gender);
	// employee.setName(name);
	// employee.setPassword(password);
	// employee.setRegisterTime(registerTime);
	// employee.setRole(role);
	// employee.setStatus(status);
	// session.update(employee);
	// session.flush();
	// return employee;
	// } catch (Exception e)
	// {
	// throw new RuntimeException("����Ա��ʧ�ܣ�" + e.getMessage());
	// }
	// }
	//
	// // ɾ������id��Ա����Ϣ����Ա�������ҵ�����ݻ�ȫ��ɾ����
	// public static void remove(int employeeId) throws RuntimeException
	// {
	// try
	// {
	// Session session = HibernateUtil.getSession();
	// Employee employee = (Employee) session.get(Employee.class, employeeId);
	// session.delete(employee);
	// session.flush();
	// } catch (Exception e)
	// {
	// throw new RuntimeException("ɾ��Ա��ʧ�ܣ�" + e.getMessage());
	// }
	// }

}
