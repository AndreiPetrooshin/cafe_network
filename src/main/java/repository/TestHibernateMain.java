package repository;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by draqo on 30.07.2017.
 */
public class TestHibernateMain {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-config.xml",
                "classpath:spring/spring-db.xml");
       CafeDAO cafeDAO= context.getBean("cafeDAOImpl", CafeDAO.class);
        System.out.println(cafeDAO.getAll());


    }
}
