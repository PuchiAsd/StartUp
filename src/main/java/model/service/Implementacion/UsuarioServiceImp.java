package model.service.Implementacion;

import model.dao.Implementacion.DireccionDaoImp;
import model.dao.Implementacion.UsuarioDaoImp;
import model.dao.Implementacion.UsuarioRolDaoImp;
import model.models.Direccion;
import model.models.Usuario;
import model.models.UsuarioRol;
import model.service.Interface.IUsuarioService;

public class UsuarioServiceImp implements IUsuarioService {
    private UsuarioDaoImp usuarioDaoImp = new UsuarioDaoImp();
    private DireccionDaoImp direccionDaoImp = new DireccionDaoImp();
    private UsuarioRolDaoImp usuarioRolDaoImp = new UsuarioRolDaoImp();
    public Boolean RegistroUsuario(Usuario usuario, Direccion direccion, UsuarioRol usuarioRol){
        Boolean respuesta = false;
        try{
            // Registramos al usuario y obtenemos su id generado para utilizarlo en los siguientes pasos
            usuario = usuarioDaoImp.InsertUsuario(usuario);

            // Agregamos el id del usuario en modelo direccion
            direccion.setId_usuario(usuario.getId());
            // Registramos la direccion asociada al usuario
            direccionDaoImp.InsertDireccion(direccion);

            // Agregamos el id del usuario en modelo usuarioRol
            usuarioRol.setId_usuario(usuario.getId());
            // Registramos el rol del usuario
            usuarioRolDaoImp.InsertUsuarioRol(usuarioRol);


            respuesta = true;
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        return respuesta;
    }
}
