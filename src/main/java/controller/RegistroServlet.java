package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.Implementacion.AutoDaoImp;
import model.dao.Implementacion.RolesDaoImp;
import model.dao.Interface.IAutoDao;
import model.dao.Interface.IRolesDao;
import model.models.Direccion;
import model.models.Usuario;
import model.models.UsuarioRol;
import model.service.Implementacion.UsuarioServiceImp;
import model.service.Interface.IUsuarioService;

import java.io.IOException;
import java.util.Date;

// Definición de la ruta del servlet
@WebServlet("/registroUsuario")
public class RegistroServlet extends HttpServlet {

    // Instanciamos la implementación de IAutoDao
    private IAutoDao autoDaoImp = new AutoDaoImp();

    // Instanciamos la implementación de IRoles
    private IRolesDao rolesDaoImp = new RolesDaoImp();

    // Instanciamos la implementación de IUsuarioService
    private IUsuarioService usuarioService = new UsuarioServiceImp();

    // Método doGet para manejar solicitudes GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Carga la lista de autos y roles y la asigna como atributo en el request
        cargarAutos(request);
        cargarRoles(request);

        // Redirige a la página registro.jsp
        request.getRequestDispatcher("registro.jsp").forward(request, response);
    }

    // Método doPost para manejar solicitudes POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Procesar el registro de usuario, obteniendo los parámetros del request
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");
        String nombre = request.getParameter("nombre");
        String apodo = request.getParameter("apodo");
        int peso = Integer.parseInt(request.getParameter("peso"));

        String direccion = request.getParameter("direccion");
        int direccionNum = Integer.parseInt(request.getParameter("direccionNum"));

        String idRol = request.getParameter("selectRol");
        String idAuto = request.getParameter("selectAuto");

        // Validar el select de roles
        if (idRol == null || idRol.isEmpty() || idRol.equals("Selecciona un Rol")) {
            // Si no se seleccionó un rol, establece un mensaje de error
            request.setAttribute("errorSelectRol", "Por favor, seleccione un Rol.");

            // Carga las listas nuevamente para los select
            cargarRoles(request);
            cargarAutos(request);

            // Redirige a la página registro.jsp con el mensaje de error
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return; // Importante para evitar continuar si hay un error
        }

        // Validar el select de autos
        if (idAuto == null || idAuto.isEmpty() || idAuto.equals("Selecciona un auto")) {
            // Si no se seleccionó un auto, establece un mensaje de error
            request.setAttribute("errorSelectAuto", "Por favor, seleccione un auto.");

            // Carga las listas nuevamente para los select
            cargarAutos(request);
            cargarRoles(request);

            // Redirige a la página registro.jsp con el mensaje de error
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return; // Importante para evitar continuar si hay un error
        }

        // Instancia de objetos de model
        Usuario usuarioModel = new Usuario();
        Direccion direccionModel = new Direccion();
        UsuarioRol usuarioRolModel = new UsuarioRol();

        Boolean respuestaRegistro;


        // Seteo objeto model usuario
        usuarioModel.setCorreo(correo);
        usuarioModel.setClave(clave);
        usuarioModel.setNombre(nombre);
        usuarioModel.setApodo(apodo);
        usuarioModel.setPeso(peso);
        Date now = new Date();
        usuarioModel.setFecha_creacion(now);
        usuarioModel.setFecha_modificacion(now);
        int idAutoParse = Integer.parseInt(idAuto);
        usuarioModel.setId_auto(idAutoParse);

        // Seteo objeto model direccion
        direccionModel.setNombre(direccion);
        direccionModel.setNumero(direccionNum);

        // Seteo objeto model
        int idRolParse = Integer.parseInt(idRol);
        usuarioRolModel.setId_role(idRolParse);

        respuestaRegistro = usuarioService.RegistroUsuario(usuarioModel, direccionModel, usuarioRolModel);

        if (respuestaRegistro){
            // Si todo es correcto, redirige a la pagina index.jsp
            request.setAttribute("mensajeRespuesta", "Usuario creado exitosamente");
            request.setAttribute("flagExito", respuestaRegistro);
        }else{
            request.setAttribute("flagExito", respuestaRegistro);
            request.setAttribute("mensajeRespuesta", "Ocurrio un error al intentar registrar al usuario");
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
        System.out.println(idRol);
        System.out.println(idAuto);

    }

    // Método privado para cargar la lista de autos y asignarla al request
    private void cargarAutos(HttpServletRequest request) {
        request.setAttribute("ListaAuto", autoDaoImp.GetAutos());
    }
    private void cargarRoles(HttpServletRequest request) {
        request.setAttribute("ListaRoles", rolesDaoImp.GetRoles());
    }
}