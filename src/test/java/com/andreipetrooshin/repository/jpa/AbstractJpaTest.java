package com.andreipetrooshin.repository.jpa;

/**
 * Created by draqo on 28.08.2017.
 */
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Sql({"/db/initDB.sql", "/db/populate.sql"})
@ContextConfiguration({
        "classpath:WEB-INF/spring/dispatcher-servlet.xml",
        "classpath:WEB-INF/spring/spring-db.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractJpaTest {


}
