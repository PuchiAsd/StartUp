package model.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UsuarioRegistroDTO {
    private int id;
    private String nombre;
    private String correo;
    private String apodo;
    private String direccion;
    private String rol;
    private String auto;
    private String url;
    private String proveedor;
}
