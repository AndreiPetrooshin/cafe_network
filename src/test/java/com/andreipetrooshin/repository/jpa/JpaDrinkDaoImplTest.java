package com.andreipetrooshin.repository.jpa;


import com.andreipetrooshin.model.Drink;
import com.andreipetrooshin.service.DrinkService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.andreipetrooshin.TestData.*;
import static org.junit.Assert.*;

/**
 * Created by draqo on 29.08.2017.
 */
public class JpaDrinkDaoImplTest extends AbstractJpaTest {

    @Autowired
   private DrinkService service;

    @Commit
    @Test
    public void add(){
        service.add(new Drink("kapuchino", 1.99, 250, cafe1));
    }

    @Commit
    @Test
    public void remove(){
        service.remove(3);
    }

    @Test
    public void get(){
        assertEquals(drink1.toString(), service.get(1).toString());
    }

    @Test
    public void getAll(){
        List<Drink> drinkList = new ArrayList<>(Arrays.asList(drink1,drink2,drink3,drink4,
                drink5,drink6,drink7,drink8,drink9,drink10,drink11,drink12,drink13));
        assertEquals(drinkList.toString(), service.getAll().toString());
    }

}
