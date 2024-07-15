package model.service.Interface;

import model.models.LoginDTO;
import model.models.UsuarioAutenticadoDTO;

public interface ILogin {
    public UsuarioAutenticadoDTO ValidaUsuario(LoginDTO loginDTO);
}
