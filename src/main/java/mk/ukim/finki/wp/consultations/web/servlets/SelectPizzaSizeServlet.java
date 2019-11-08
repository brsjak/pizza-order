package mk.ukim.finki.wp.consultations.web.servlets;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/select-pizza-size")
public class SelectPizzaSizeServlet extends HttpServlet{
    private final SpringTemplateEngine springTemplateEngine;

    public SelectPizzaSizeServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req,resp,req.getServletContext());
        HttpSession session = req.getSession();
        String selectedPizza = (String) session.getAttribute("selectedPizza");
        webContext.setVariable("selectedPizza",selectedPizza);
        this.springTemplateEngine.process("selectPizzaSize.html",webContext,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String selectedSize = req.getParameter("pizza_size");
        String selectedPizza = (String) session.getAttribute("selectedPizza");
        session.setAttribute("selectedSize",selectedSize);
        session.setAttribute("selectedPizza",selectedPizza);
        resp.sendRedirect("/PizzaOrder.do");
    }
}
