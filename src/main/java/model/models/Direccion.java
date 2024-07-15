package model.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class Direccion {
    private int id;
    private String nombre;
    private int numero;
    private int id_usuario;
}