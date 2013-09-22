package hibernate;

import javax.security.auth.login.Configuration;

//import javax.security.auth.login.Configuration;

public class HibernateTest {
	public static void main(String[] args){
		User user = new User();
		user.setAddress("27 ramsgate rd kogarah bay");
		user.setCreditCard("1234567890");
		user.setDOB("01/04/1991");
		user.setFirstname("Matthew");
		user.setLastname("Williams");
		user.setUserID("z3337541");
		//SessionFactory session = new Configuration().;
	}
}
