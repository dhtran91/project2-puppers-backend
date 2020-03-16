import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.OwnerDao;
import com.revature.model.Owner;

public class Driver {

	public static void main(String[] args) {
	ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	OwnerDao ownerDao = (OwnerDao) ac.getBean("ownerDaoImpl");
	
	Owner o = ownerDao.getById(1);
	System.out.println(o);
	


	}

}
