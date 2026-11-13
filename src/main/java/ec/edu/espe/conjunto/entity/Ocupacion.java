package ec.edu.espe.habitacional.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import ec.edu.espe.habitacional.enums.TipoOcupacion;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "ocupaciones")
public class Ocupacion extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unidad_id", nullable = false)
    private UnidadInmobiliaria unidad;

    // UUID externo del microservicio de personas, sin FK local.
    @Column(name = "persona_id", nullable = false)
    private UUID personaId;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_ocupacion", nullable = false, length = 30)
    private TipoOcupacion tipoOcupacion;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;
}
