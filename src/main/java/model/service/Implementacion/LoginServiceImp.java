package model.service.Implementacion;

import model.dao.Implementacion.LoginDaoImp;
import model.dao.Implementacion.UsuarioAutenticadoDaoImp;
import model.models.LoginDTO;
import model.models.UsuarioAutenticadoDTO;
import model.service.Interface.ILogin;

public class LoginServiceImp implements ILogin {
    private LoginDaoImp loginDaoImp = new LoginDaoImp();
    private UsuarioAutenticadoDaoImp usuarioAutenticadoDaoImp = new UsuarioAutenticadoDaoImp();

    public UsuarioAutenticadoDTO ValidaUsuario(LoginDTO loginDTO){
        UsuarioAutenticadoDTO usuario = new UsuarioAutenticadoDTO();

        // Validamos si existe el usuario en la base de datos
        Boolean respuestaLogin = loginDaoImp.Login(loginDTO);
        if (respuestaLogin){
            // Realizamos doble validacion en caso que exista otro usuario con el mismo correo.
            usuario = usuarioAutenticadoDaoImp.ObtieneUsuarioAutenticado(loginDTO.getCorreo(), loginDTO.getClave());
            usuario.setAutenticado(true);
        }else{
            usuario.setNombre("notFound");
            usuario.setCorreo("notFound");
            usuario.setApodo("notFound");
            usuario.setRol("notFound");
            usuario.setAutenticado(false);
        }
        return usuario;
    }
}
