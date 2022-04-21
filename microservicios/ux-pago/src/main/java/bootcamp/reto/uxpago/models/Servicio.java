package bootcamp.reto.uxpago.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Servicio {
    private String idServicio;
    private String codServicio;
    private String descServicio;
    private String canalPermitido;
}
