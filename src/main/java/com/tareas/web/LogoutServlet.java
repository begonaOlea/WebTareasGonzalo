/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.web;

import com.tareas.excepciones.LoginException;
import com.tareas.services.LoginService;
import com.tareas.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usuario;

        //SI TODO OK
        HttpSession session = request.getSession();
        LoginService service = new LoginService();

        service.logout(session);

        String jspAMostrar = "";
        jspAMostrar = "index.jsp";

        RequestDispatcher rd = request.getRequestDispatcher(jspAMostrar);
        rd.forward(request, response);

    }

}
