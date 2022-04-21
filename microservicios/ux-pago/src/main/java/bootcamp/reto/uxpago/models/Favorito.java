package bootcamp.reto.uxpago.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Favorito {
     private Integer idFavorito;
     private String tipoFavorito;
    private String nombreFavorito;
    private String codServicio;
    private String idCliente;
}
