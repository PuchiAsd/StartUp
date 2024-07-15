package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.Implementacion.UsuarioRegistroListaDaoImp;
import model.models.*;
import model.service.Implementacion.LoginServiceImp;
import model.service.Interface.ILogin;


import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    // Instanciamos la implementación de IUsuarioService
    //private IUsuarioService usuarioService = new UsuarioServiceImp();
    private ILogin loginService = new LoginServiceImp();
    private UsuarioRegistroListaDaoImp usuarioRegistroListaDaoImp = new UsuarioRegistroListaDaoImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LoginDTO loginDTO = new LoginDTO();
        UsuarioAutenticadoDTO usuarioAutenticadoDTO = new UsuarioAutenticadoDTO();


        // Obtenemos los datos del formulario
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");

        // Seteo objeto model
        loginDTO.setCorreo(correo);
        loginDTO.setClave(clave);


        usuarioAutenticadoDTO = loginService.ValidaUsuario(loginDTO);
        List<UsuarioRegistroDTO> listaUsuarios = usuarioRegistroListaDaoImp.GetUsuarioRegistrado();

        if (usuarioAutenticadoDTO.getAutenticado())
        {
            System.out.println("Usuario Valido");
            request.setAttribute("mensaje", "Usuario logeado");
            request.setAttribute("usuarioAutenticado", true);
            if (usuarioAutenticadoDTO.getRol().equals("ADMINISTRADOR"))
            {
                // Falta logica de carga de datos.
                request.setAttribute("modeloUsuario", usuarioAutenticadoDTO);
                request.setAttribute("listaUsuarios", listaUsuarios);
                request.getRequestDispatcher("home.jsp").forward(request,response);
            }else{
                request.setAttribute("mensajeRol", "No eres Administrador, no tienes acceso");
            }
        }else{
            System.out.println("Usuario Invalido");
            request.setAttribute("mensaje", "Usuario o contraseña incorrecta");
            request.setAttribute("usuarioAutenticado", false);
        }

        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
