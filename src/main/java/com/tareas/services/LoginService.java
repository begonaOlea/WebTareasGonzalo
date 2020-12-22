/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.services;

import com.tareas.excepciones.LoginException;
import com.tareas.model.DB;
import com.tareas.model.Usuario;
import java.util.Collection;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class LoginService {

    public void login(String email, String pass, HttpSession session) throws LoginException {

        //Ver si existe email y clave en DB
        Collection<Usuario> usuarios = DB.getUsuarios();
        Usuario usuarioRegistrado = null;
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                usuarioRegistrado = u;
                break;
            }
        }

        if (usuarioRegistrado == null) {
            throw new LoginException("El usuario no existe. Debe registrarse");
        } else {
            //Comprobar clave
            if (usuarioRegistrado.getPass().equals(pass)) {
                session.setAttribute("usuario", usuarioRegistrado);

            } else {
                throw new LoginException("Clave no valida. Vuelva a intentarlo");
            }
        }

        //Si existe añadir a sesion
        //Si no existe lanzar una excepción
    }

    public void logout(HttpSession session) {

        session.invalidate();

    }
}
