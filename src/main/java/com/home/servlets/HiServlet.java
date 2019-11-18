package com.home.servlets;

import com.home.Utility.ClassDoSometh;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Denis
 */
@WebServlet(urlPatterns = {"/hi", "/"})
public class HiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassDoSometh doSometh = new ClassDoSometh();
        doSometh.getRequestInfo(request, response);
        response.getWriter().println(doSometh.getTime());
    }

}
