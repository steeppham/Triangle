package hibernate;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


//import javax.security.auth.login.Configuration;

public class HibernateTest {
	public static void main(String[] args){
		User user = new User();
		user.setAddress("27 ramsgate rd kogarah bay");
		user.setCreditCard(1234567890);
		user.setDOB("01/04/1991");
		user.setFirstname("Matthew");
		user.setLastname("Williams");
		user.setUserID(3337541);
		//having a problem here 
	
		AnnotationConfiguration config = new AnnotationConfiguration();
		// add your annotated classes
		config.addAnnotatedClass(User.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
	
	}
}
