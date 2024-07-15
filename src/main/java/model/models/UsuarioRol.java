package model.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UsuarioRol {
    private int id;
    private int id_usuario;
    private int id_role;
}
