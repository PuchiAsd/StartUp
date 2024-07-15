package model.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UsuarioAutenticadoDTO {
    private String nombre;
    private String correo;
    private String apodo;
    private String rol;
    private Boolean autenticado;
}