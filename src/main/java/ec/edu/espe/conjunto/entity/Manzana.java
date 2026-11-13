package ec.edu.espe.habitacional.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "manzanas", uniqueConstraints = {
    @UniqueConstraint(name = "uq_manzana_conjunto_codigo", columnNames = {"conjunto_id","codigo"})
})
public class Manzana extends BaseEntity {

    // El conjunto es obligatorio incluso cuando no hay etapa.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "conjunto_id", nullable = false)
    private ConjuntoHabitacional conjunto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etapa_id")
    private Etapa etapa;

    @Column(name = "codigo", nullable = false, length = 40)
    private String codigo;

    @Column(name = "nombre", length = 150)
    private String nombre;

    @Column(name = "descripcion", length = 700)
    private String descripcion;

    @OneToMany(mappedBy = "manzana", fetch = FetchType.LAZY)
    private List<Bloque> bloques = new ArrayList<>();

    @OneToMany(mappedBy = "manzana", fetch = FetchType.LAZY)
    private List<UnidadInmobiliaria> viviendas = new ArrayList<>();
}
