package ec.edu.espe.habitacional.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pisos", uniqueConstraints = {
    @UniqueConstraint(name = "uq_piso_bloque_nivel", columnNames = {"bloque_id","numero_nivel"})
})
public class Piso extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bloque_id", nullable = false)
    private Bloque bloque;

    // -1: subsuelo; 0: planta baja; 1,2,3...: pisos superiores.
    @Column(name = "numero_nivel", nullable = false)
    private Integer numeroNivel;

    @Column(name = "codigo", length = 40)
    private String codigo;

    @Column(name = "descripcion", length = 700)
    private String descripcion;

    @OneToMany(mappedBy = "piso", fetch = FetchType.LAZY)
    private List<UnidadInmobiliaria> unidades = new ArrayList<>();
}
