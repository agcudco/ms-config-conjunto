package ec.edu.espe.conjunto.repository;

import ec.edu.espe.conjunto.entity.AsignacionAnexo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AsignacionAnexoRepository extends JpaRepository<AsignacionAnexo, UUID> {

    Optional<AsignacionAnexo> findByIdAndDeletedAtIsNull(UUID id);
    Page<AsignacionAnexo> findByUnidad_IdAndDeletedAtIsNull(UUID unidadId, Pageable pageable);
    Page<AsignacionAnexo> findByAnexo_IdAndDeletedAtIsNull(UUID anexoId, Pageable pageable);
    Page<AsignacionAnexo> findByAnexo_IdAndFechaFinIsNullAndDeletedAtIsNull(UUID anexoId, Pageable pageable);
}
