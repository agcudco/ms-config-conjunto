package ec.edu.espe.conjunto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import ec.edu.espe.habitacional.enums.TipoUnidad;
import ec.edu.espe.habitacional.enums.EstadoOcupacion;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "unidades_inmobiliarias", uniqueConstraints = {
    @UniqueConstraint(name = "uq_unidad_conjunto_codigo", columnNames = {"conjunto_id","codigo"})
})
public class UnidadInmobiliaria extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "conjunto_id", nullable = false)
    private ConjuntoHabitacional conjunto;

    // Solo una ubicación directa: etapa, manzana, bloque o piso; o ninguna
    // para ubicación directa en el conjunto. No duplicar rutas de ancestros.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etapa_id")
    private Etapa etapa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manzana_id")
    private Manzana manzana;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bloque_id")
    private Bloque bloque;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "piso_id")
    private Piso piso;

    @Column(name = "codigo", nullable = false, length = 40)
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_unidad", nullable = false, length = 25)
    private TipoUnidad tipoUnidad;

    @Column(name = "area_m2", precision = 12, scale = 2)
    private BigDecimal areaM2;

    @Column(name = "alicuota_pct", precision = 8, scale = 4)
    private BigDecimal alicuotaPct;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_ocupacion", nullable = false, length = 25)
    private EstadoOcupacion estadoOcupacion = EstadoOcupacion.DISPONIBLE;

    @Column(name = "descripcion", length = 700)
    private String descripcion;

    @OneToMany(mappedBy = "unidad", fetch = FetchType.LAZY)
    private List<Titularidad> titularidades = new ArrayList<>();

    @OneToMany(mappedBy = "unidad", fetch = FetchType.LAZY)
    private List<Ocupacion> ocupaciones = new ArrayList<>();

    @OneToMany(mappedBy = "unidad", fetch = FetchType.LAZY)
    private List<AsignacionAnexo> asignacionesAnexos = new ArrayList<>();
}
