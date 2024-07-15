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

public class Usuario {
    private int id;
    private String correo;
    private String clave;
    private String nombre;
    private String apodo;
    private int peso;
    private Date fecha_creacion;
    private Date fecha_modificacion;
    private int id_auto;
}