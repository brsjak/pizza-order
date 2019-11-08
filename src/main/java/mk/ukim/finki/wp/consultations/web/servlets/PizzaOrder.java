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

@WebServlet(urlPatterns = "/PizzaOrder.do")
public class PizzaOrder extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    public PizzaOrder(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String selectedPizza = (String) session.getAttribute("selectedPizza");
        String selectedSize = (String) session.getAttribute("selectedSize");
        WebContext webContext = new WebContext(req,resp,req.getServletContext());
        webContext.setVariable("selectedPizza",selectedPizza);
        webContext.setVariable("selectedSize",selectedSize);
        resp.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("deliveryInfo.html",webContext,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String clientName = req.getParameter("clientName");
        String clientAddress = req.getParameter("clientAddress");
        session.setAttribute("clientName",clientName);
        session.setAttribute("clientAddress",clientAddress);
        String selectedPizza = (String) session.getAttribute("selectedPizza");
        String selectedSize = (String) session.getAttribute("selectedSize");
        session.setAttribute("selectedPizza",selectedPizza);
        session.setAttribute("selectedSize",selectedSize);
        resp.sendRedirect("/ConfirmationInfo.do");
    }
}
