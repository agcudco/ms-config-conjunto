package ec.edu.espe.conjunto.repository;

import ec.edu.espe.conjunto.entity.UnidadInmobiliaria;
import ec.edu.espe.conjunto.enums.TipoUnidad;
import ec.edu.espe.conjunto.enums.EstadoOcupacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UnidadInmobiliariaRepository extends JpaRepository<UnidadInmobiliaria, UUID> {

    Optional<UnidadInmobiliaria> findByIdAndDeletedAtIsNull(UUID id);
    Page<UnidadInmobiliaria> findByConjunto_IdAndDeletedAtIsNull(UUID conjuntoId, Pageable pageable);
    Page<UnidadInmobiliaria> findByManzana_IdAndTipoUnidadAndDeletedAtIsNull(UUID manzanaId, TipoUnidad tipoUnidad, Pageable pageable);
    Page<UnidadInmobiliaria> findByPiso_IdAndTipoUnidadAndDeletedAtIsNull(UUID pisoId, TipoUnidad tipoUnidad, Pageable pageable);
    Page<UnidadInmobiliaria> findByBloque_IdAndDeletedAtIsNull(UUID bloqueId, Pageable pageable);
    Page<UnidadInmobiliaria> findByEtapa_IdAndDeletedAtIsNull(UUID etapaId, Pageable pageable);
    Page<UnidadInmobiliaria> findByConjunto_IdAndEstadoOcupacionAndDeletedAtIsNull(UUID conjuntoId, EstadoOcupacion estadoOcupacion, Pageable pageable);
    boolean existsByConjunto_IdAndCodigoIgnoreCaseAndDeletedAtIsNull(UUID conjuntoId, String codigo);
}
