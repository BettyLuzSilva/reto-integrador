package bootcamp.reto.pagoservicios.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document (value = "transacciones")
public class Transaccion {
    @Id
    private String idTransaccion;
    private String codServicio;
    private String nroSuministro;
    private Date fechaTran;
    private BigDecimal montoPagado;
    private String canalPago;

}
