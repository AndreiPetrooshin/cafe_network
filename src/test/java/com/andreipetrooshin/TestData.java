package com.andreipetrooshin;

import com.andreipetrooshin.model.Cafe;
import com.andreipetrooshin.model.Director;
import com.andreipetrooshin.model.Drink;

/**
 * Created by draqo on 28.08.2017.
 */
public class TestData {

    public final static Director director1 =
            new Director(1,"Andrei", "Petrooshin", "andrei@mail.ru", "+375295559297");
    public final static Director director2 =
            new Director(2,"Valerii", "Cezarev", "cezarev@mail.ru", "+375297815648");
    public final static Director director3 =
            new Director(3,"Evgenii", "Kovalev", "kovalev@mail.ru", "+375297844687");


    public final static Cafe cafe1 = new Cafe( 1,"Zhodino, ul.Lenina 12, d.12", "Coffee_Saund", director2, 5.0);
    public final static Cafe cafe2 = new Cafe(2,"Minsk, pr. Nezavisimosti 11", "Coffee_Like", director1, 4.6);
    public final static Cafe cafe3 = new Cafe( 3,"Borisov, ul. Molodezhnaia 11", "GoodCoffee", director3, 4.7);
    public final static Cafe cafe4 = new Cafe( 4,"Minsk, pr. Nezavisimosti 4", "GetCoffee", director1, 5.0);

    public final static Drink drink1 = new Drink(1, "kapuchino", 2.50, 250, cafe2);
    public final static Drink drink2 = new Drink( 2,"americano", 2.50, 250, cafe2);
    public final static Drink drink3 = new Drink( 3,"latte", 3.50, 350, cafe2);
    public final static Drink drink4 = new Drink( 4,"espresso",  2.50, 250, cafe2);
    public final static Drink drink5 = new Drink(5,"kapuchino", 1.99, 250, cafe1);
    public final static Drink drink6 = new Drink(6,"americano",  1.99, 250, cafe1);
    public final static Drink drink7 = new Drink( 7,"latte", 2.99, 350, cafe1);
    public final static Drink drink8 = new Drink(8,"espresso",  1.99, 250, cafe1);
    public final static Drink drink9 = new Drink(9,"kapuchino", 2.10, 250, cafe3);
    public final static Drink drink10 = new Drink(10,"americano", 2.10, 250, cafe3);
    public final static Drink drink11 = new Drink(11,"latte", 3.0, 350, cafe3);
    public final static Drink drink12= new Drink(12,"espresso", 2.10, 250, cafe3);
    public final static Drink drink13 = new Drink(13,"makachino", 2.10, 300, cafe3);

}