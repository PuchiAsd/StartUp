package model.service.Interface;

import model.models.Direccion;
import model.models.Usuario;
import model.models.UsuarioRol;

public interface IUsuarioService {
    public Boolean RegistroUsuario(Usuario usuario, Direccion direccion, UsuarioRol usuarioRol);
}
