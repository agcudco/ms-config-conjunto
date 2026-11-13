package ec.edu.espe.conjunto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import ec.edu.espe.conjunto.enums.TipoAreaComun;

@Getter
@Setter
@Entity
@Table(name = "areas_comunes", uniqueConstraints = {
    @UniqueConstraint(name = "uq_area_conjunto_codigo", columnNames = {"conjunto_id","codigo"})
})
public class AreaComun extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "conjunto_id", nullable = false)
    private ConjuntoHabitacional conjunto;

    @Column(name = "codigo", nullable = false, length = 40)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_area", nullable = false, length = 30)
    private TipoAreaComun tipoArea;

    @Column(name = "descripcion", length = 700)
    private String descripcion;

    @Column(name = "capacidad_personas")
    private Integer capacidadPersonas;
}
