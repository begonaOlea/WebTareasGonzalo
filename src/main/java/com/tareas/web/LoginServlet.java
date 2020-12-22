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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean valido = true;
        Usuario usuario;

        //LEER LOS PARÁMETROS
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        //VALIDAR
        String msgErrorEmail = null;
        String msgErrorPass = null;
        String msgErrorLogin = null;

        int id = 0;
        //validar
        if (email == null || email.trim().length() == 0) {
            valido = false;
            msgErrorEmail = "Debe introducir un email";
        }

        if (pass == null || pass.trim().length() == 0) {
            valido = false;
            msgErrorPass = "Debe introducir una contraseña";
        }

        //SI TODO OK
        HttpSession session = request.getSession();
        LoginService service = new LoginService();

        if (valido) {
            try {
                service.login(email, pass, session);
            } catch (LoginException e) {
                msgErrorLogin = e.getMessage(); //Aprovecha el mensaje de error definidop anteriormente
                valido = false;
            }
        }

        String jspAMostrar = "";
        if (valido) {
            jspAMostrar = "index.jsp";
        } else {
            jspAMostrar = "login.jsp";
            request.setAttribute("msgErrorEmail", msgErrorEmail);
            request.setAttribute("msgErrorPass", msgErrorPass);
            request.setAttribute("msgErrorLogin", msgErrorLogin);
        }

        RequestDispatcher rd = request.getRequestDispatcher(jspAMostrar);
        rd.forward(request, response);

    }

}
