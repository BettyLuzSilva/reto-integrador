package bootcamp.reto.uxpago.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaccion {
    private String idTransaccion;
    private String codServicio;
    private String nroSuministro;
    private Date fechaTran;
    private BigDecimal montoPagado;
    private String canalPago;
    private String tipoFavorito;
    private String nombreFavorito;
    private String idCliente;
}
