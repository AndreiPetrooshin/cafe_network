package services;

import model.Cafe;
import model.Drink;
import repository.CafeDAO;
import repository.DrinkDAO;
import repository.impl.CafeDAOImpl;
import repository.impl.DrinkDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by draqo on 10.08.2017.
 */

@WebServlet("/servlet")
public class ServletCafe extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        CafeDAO cafeDAO = new CafeDAOImpl();
        List<Cafe> cafes = cafeDAO.getAll();
        req.setAttribute("cafes", cafes);
        req.getRequestDispatcher("/cafes.jsp").forward(req,resp);

    }
}
