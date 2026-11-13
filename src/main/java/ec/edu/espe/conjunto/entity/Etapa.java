package ec.edu.espe.conjunto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "etapas", uniqueConstraints = {
    @UniqueConstraint(name = "uq_etapa_conjunto_codigo", columnNames = {"conjunto_id","codigo"})
})
public class Etapa extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "conjunto_id", nullable = false)
    private ConjuntoHabitacional conjunto;

    @Column(name = "codigo", nullable = false, length = 40)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "descripcion", length = 700)
    private String descripcion;

    @OneToMany(mappedBy = "etapa", fetch = FetchType.LAZY)
    private List<Manzana> manzanas = new ArrayList<>();

    @OneToMany(mappedBy = "etapa", fetch = FetchType.LAZY)
    private List<Bloque> bloquesDirectos = new ArrayList<>();

    @OneToMany(mappedBy = "etapa", fetch = FetchType.LAZY)
    private List<UnidadInmobiliaria> unidadesDirectas = new ArrayList<>();
}
