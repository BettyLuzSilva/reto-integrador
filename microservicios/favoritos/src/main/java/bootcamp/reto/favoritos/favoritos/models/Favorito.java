package bootcamp.reto.favoritos.favoritos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("favorito")
public class Favorito {
    @Id
    @Column("IdFavorito")
    private Integer idFavorito;
    @Column("TipoFavorito")
    private String tipoFavorito;
    @Column("NombreFavorito")
    private String nombreFavorito;
    @Column("CodServicio")
    private String codServicio;
    @Column("IdCliente")
    private String idCliente;
}
