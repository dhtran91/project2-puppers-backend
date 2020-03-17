import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.OwnerDao;
import com.revature.model.Owner;

public class Driver {

	public static void main(String[] args) {
	ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	OwnerDao ownerDao = (OwnerDao) ac.getBean("ownerDaoImpl");
	
//	Owner o = new Owner();
//	o.setFirstName("Jay");
//	o.setLastName("Boucher");
//	o.setEmail("jay@gmail.com");
//	o.setPassword("password");
//	o.setAddress("110 abc lane");
//	o.setPostalCode("75019");
	
//	ownerDao.createOwner(o);
//	
//	Owner o1 = ownerDao.getById(1);
//	System.out.println(o1);
	


	}

}
