package com.andreipetrooshin.repository.jpa;

import com.andreipetrooshin.model.Cafe;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.andreipetrooshin.service.CafeService;
import org.springframework.test.annotation.Commit;

import java.util.Arrays;

import static com.andreipetrooshin.TestData.*;

/**
 * Created by draqo on 28.08.2017.
 */
public class JpaCafeDaoImplTest extends AbstractJpaTest {
    @Autowired
    private CafeService service;

    @Commit
    @Test
    public void add() throws Exception {
        service.add(new Cafe("Zhodino", "azaza", director1, 4.2));
    }

    @Commit
    @Test
    public void remove() throws Exception {
        service.remove(2);
    }


    @Test
    public void get() throws Exception {
        Assert.assertEquals(cafe1,service.get(1));
    }

    @Test
    public void getAll() throws Exception {
        Assert.assertEquals(Arrays.asList(cafe1, cafe2,cafe3,cafe4), service.getAll());
    }

}

