import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by draqo on 27.08.2017.
 */
public class Main    {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-config.xml",
                "classpath:spring/spring-db.xml");
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
    }
}
