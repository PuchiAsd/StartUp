package model.dao.Interface;

import model.models.UsuarioAutenticadoDTO;

public interface IUsuarioAutenticadoDao {

    public UsuarioAutenticadoDTO ObtieneUsuarioAutenticado(String correo, String clave);
}
