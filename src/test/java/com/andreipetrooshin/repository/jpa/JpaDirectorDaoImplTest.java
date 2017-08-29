package com.andreipetrooshin.repository.jpa;

import com.andreipetrooshin.model.Director;
import com.andreipetrooshin.service.DirectorService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Commit;

import java.util.Arrays;

import static org.junit.Assert.*;
import static com.andreipetrooshin.TestData.*;
import static org.springframework.test.jdbc.JdbcTestUtils.*;
/**
 * Created by draqo on 29.08.2017.
 */
public class JpaDirectorDaoImplTest extends AbstractJpaTest {

    @Autowired
    private DirectorService service;

    @Commit
    @Test
    public void add(){
        service.add(new Director("Andrei", "Petrooshin",
                        "andrei@mail.ru", "+375295559297"));
    }

    @Test
    public void get(){
        assertEquals(director2,service.get(2));
    }

    @Test
    public void getAll(){
        assertEquals(Arrays.asList(director1,director2,director3),service.getAll());
    }

    @Commit
    @Test
    public void remove(){
        service.remove(3);
    }

}
