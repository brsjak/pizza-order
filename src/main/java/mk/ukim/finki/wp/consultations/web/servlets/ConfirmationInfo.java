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

@WebServlet(urlPatterns = "/ConfirmationInfo.do")
public class ConfirmationInfo extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfo(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String selectedPizza = (String) session.getAttribute("selectedPizza");
        String selectedSize = (String) session.getAttribute("selectedSize");
        String clientName = (String) session.getAttribute("clientName");
        String clientAddress = (String) session.getAttribute("clientAddress");
        WebContext webContext = new WebContext(req,resp,req.getServletContext());

        webContext.setVariable("clientName",clientName);
        webContext.setVariable("selectedSize",selectedSize);
        webContext.setVariable("selectedPizza",selectedPizza);
        webContext.setVariable("clientAddress",clientAddress);
        webContext.setVariable("clientIPAddress",req.getRemoteAddr());
        webContext.setVariable("clientBrowser",req.getHeader("User-Agent"));

        this.springTemplateEngine.process("confirmationInfo.html",webContext,resp.getWriter());
    }

}
