package bootcamp.reto.pagoservicios.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document (value = "servicios")
public class Servicio {

    @Id
    private String idServicio;
    private String codServicio;
    private String descServicio;
    private String canalPermitido;

}
