package ec.edu.espe.conjunto.entity;

import ec.edu.espe.conjunto.enums.TipoBloque;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import ec.edu.espe.conjunto.enums.TipoBloque;

@Getter
@Setter
@Entity
@Table(name = "bloques", uniqueConstraints = {
    @UniqueConstraint(name = "uq_bloque_conjunto_codigo", columnNames = {"conjunto_id","codigo"})
})
public class Bloque extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "conjunto_id", nullable = false)
    private ConjuntoHabitacional conjunto;

    // Elegir etapa o manzana como padre inmediato, o ninguno para bloque directo.
    // La validación de esta exclusividad se realiza en la capa service.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etapa_id")
    private Etapa etapa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manzana_id")
    private Manzana manzana;

    @Column(name = "codigo", nullable = false, length = 40)
    private String codigo;

    @Column(name = "nombre", length = 150)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_bloque", nullable = false, length = 20)
    private TipoBloque tipoBloque;

    @Column(name = "descripcion", length = 700)
    private String descripcion;

    @OneToMany(mappedBy = "bloque", fetch = FetchType.LAZY)
    private List<Piso> pisos = new ArrayList<>();

    @OneToMany(mappedBy = "bloque", fetch = FetchType.LAZY)
    private List<UnidadInmobiliaria> unidadesDirectas = new ArrayList<>();
}
