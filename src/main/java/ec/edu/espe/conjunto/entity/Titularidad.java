package ec.edu.espe.habitacional.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "titularidades")
public class Titularidad extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unidad_id", nullable = false)
    private UnidadInmobiliaria unidad;

    // UUID externo: NO corresponde a una entidad Persona local.
    @Column(name = "persona_id", nullable = false)
    private UUID personaId;

    @Column(name = "porcentaje", nullable = false, precision = 7, scale = 4)
    private BigDecimal porcentaje;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;
}
