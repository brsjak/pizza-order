package mk.ukim.finki.wp.consultations.web.servlets;


import mk.ukim.finki.wp.consultations.model.Pizza;
import mk.ukim.finki.wp.consultations.service.PizzaService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "")
public class ShowPizzaServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final PizzaService pizzaService;

    public ShowPizzaServlet(SpringTemplateEngine springTemplateEngine, PizzaService pizzaService) {
        this.springTemplateEngine = springTemplateEngine;
        this.pizzaService = pizzaService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req,resp,req.getServletContext());
        List<Pizza> pizzas = pizzaService.getAllPizzas();
        webContext.setVariable("pizzas",pizzas);
        resp.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("listPizzas.html",webContext,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String selectedPizza = req.getParameter("pizza");
        session.setAttribute("selectedPizza",selectedPizza);
        resp.sendRedirect("/select-pizza-size");
    }
}
