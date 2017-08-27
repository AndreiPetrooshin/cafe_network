package service.servlets;


import model.Cafe;
import model.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.CafeDAO;
import repository.impl.DrinkDAOImpl;
import service.CafeService;
import service.DirectorService;
import service.DrinkService;
import service.impl.CafeServiceImpl;
import service.impl.DirectorServiceImpl;
import service.impl.DrinkServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;


/**
 * Created by draqo on 10.08.2017.
 */

@WebServlet("/servlet")
public class ServletCafe extends HttpServlet {

    private DrinkService drinkService;
    private DirectorService directorService;
    private CafeService cafeService;
    private ClassPathXmlApplicationContext context;


    @Override
    public void init() throws ServletException {
        context = new ClassPathXmlApplicationContext
                ("classpath:spring/spring-config.xml",
                "classpath:spring/spring-db.xml");
        drinkService = context.getBean(DrinkServiceImpl.class);
        directorService = context.getBean(DirectorServiceImpl.class);
        cafeService = context.getBean(CafeServiceImpl.class);
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        System.out.println(drinkService);
        chooseComponent(req, resp);
    }

    private void chooseComponent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("value");
        switch (value) {
            case "cafeList":
                doTheCafeList(req, resp);
                break;
            case "drinkList":
                doTheDrinkList(req, resp);
                break;
            case "drinkSortByPriceUp":
                sortByPrice(req, resp, true);
                break;
            case "drinkSortByPriceDown":
                sortByPrice(req, resp, false);
                break;
            case "drinkSortByAlphabetUp":
                sortByAlphabet(req,resp,true);
                break;
            case "drinkSortByAlphabetDown":
                sortByAlphabet(req,resp,false);
                break;
            default:
                break;
        }
    }

    private void sortByAlphabet(HttpServletRequest req, HttpServletResponse resp, boolean flag) throws ServletException, IOException {
        List<Drink> drinks = drinkService.sortByAlphabet();
        if(!flag) Collections.reverse(drinks);
        req.setAttribute("drinks", drinks);
        req.getRequestDispatcher("coffees.jsp").forward(req,resp);

    }

    private void sortByPrice(HttpServletRequest req, HttpServletResponse resp, boolean flag) throws ServletException, IOException {
        List<Drink> drinks = drinkService.sortByPrice();
        if (!flag) Collections.reverse(drinks);
        req.setAttribute("drinks", drinks);
        req.getRequestDispatcher("coffees.jsp").forward(req, resp);
    }

    private void doTheDrinkList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Drink> drinks = drinkService.getAll();
        req.setAttribute("drinks", drinks);
        req.getRequestDispatcher("coffees.jsp").forward(req, resp);

    }

    private void doTheCafeList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cafe> cafeList = cafeService.getAll();
        req.setAttribute("cafeList", cafeList);
        req.getRequestDispatcher("cafes.jsp").forward(req, resp);
    }
}
