package ClassProject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ClassProject.JPAUtil;
import ClassProject.BeanClass;

@Path("/")
public class WorkClass {
	
	
	@Path("/create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String createTest(BeanClass beanie) {

		SessionFactory sf = JPAUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		BeanClass b = new BeanClass();
		b.first_name(beanie.first_name);
		b.puppy_id(beanie.puppy_id);
		
		s.save(beanie);
		

		s.getTransaction().commit();
		
		s.close();
		
		return "COMPLETED";
	}
	
	@Path("/read")
	@GET
	@Produces("text/plain")
	public String methond() {

		SessionFactory sessionFactory = JPAUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<BeanClass> beanClass = session.createQuery("from BeanClass").list();
		
		session.close();
		
		//for(BeanClass bean : beanClass) {
		//	System.out.println(bean.toString());
		
	return "RESULTS";
	}
}
