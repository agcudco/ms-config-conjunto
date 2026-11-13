package ec.edu.espe.conjunto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import ec.edu.espe.conjunto.enums.TipoAnexo;

@Getter
@Setter
@Entity
@Table(name = "anexos", uniqueConstraints = {
    @UniqueConstraint(name = "uq_anexo_conjunto_codigo", columnNames = {"conjunto_id","codigo"})
})
public class Anexo extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "conjunto_id", nullable = false)
    private ConjuntoHabitacional conjunto;

    @Column(name = "codigo", nullable = false, length = 40)
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_anexo", nullable = false, length = 25)
    private TipoAnexo tipoAnexo;

    @Column(name = "descripcion", length = 700)
    private String descripcion;

    @OneToMany(mappedBy = "anexo", fetch = FetchType.LAZY)
    private List<AsignacionAnexo> asignaciones = new ArrayList<>();
}
