package ec.edu.espe.conjunto.entity;

import ec.edu.espe.conjunto.enums.CategoriaProyecto;
import ec.edu.espe.conjunto.enums.TipoProyecto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "conjuntos_habitacionales")
public class ConjuntoHabitacional extends BaseEntity {

    @Column(name = "codigo", nullable = false, unique = true, length = 40)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 180)
    private String nombre;

    @Column(name = "descripcion", length = 1000)
    private String descripcion;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria_proyecto", nullable = false, length = 25)
    private CategoriaProyecto categoriaProyecto;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_proyecto", nullable = false, length = 20)
    private TipoProyecto tipoProyecto;

    @Column(name = "regimen_propiedad", length = 120)
    private String regimenPropiedad;

    // No contiene fechaInicio ni fechaFin, según el requerimiento.
    @OneToMany(mappedBy = "conjunto", fetch = FetchType.LAZY)
    private List<Etapa> etapas = new ArrayList<>();

    @OneToMany(mappedBy = "conjunto", fetch = FetchType.LAZY)
    private List<Manzana> manzanas = new ArrayList<>();

    @OneToMany(mappedBy = "conjunto", fetch = FetchType.LAZY)
    private List<Bloque> bloques = new ArrayList<>();

    @OneToMany(mappedBy = "conjunto", fetch = FetchType.LAZY)
    private List<UnidadInmobiliaria> unidades = new ArrayList<>();

    @OneToMany(mappedBy = "conjunto", fetch = FetchType.LAZY)
    private List<Anexo> anexos = new ArrayList<>();

    @OneToMany(mappedBy = "conjunto", fetch = FetchType.LAZY)
    private List<AreaComun> areasComunes = new ArrayList<>();
}
