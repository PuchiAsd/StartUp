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

public class LoginDTO {
    private String correo;
    private String clave;
}