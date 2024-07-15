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

public class Auto {
    private int id;
    private String nombre;
    private String url;
    private int id_proveedores;
}
