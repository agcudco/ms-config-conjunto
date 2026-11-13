package ec.edu.espe.conjunto.repository;

import ec.edu.espe.conjunto.entity.AreaComun;
import ec.edu.espe.conjunto.enums.TipoAreaComun;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AreaComunRepository extends JpaRepository<AreaComun, UUID> {

    Optional<AreaComun> findByIdAndDeletedAtIsNull(UUID id);
    Page<AreaComun> findByConjunto_IdAndDeletedAtIsNull(UUID conjuntoId, Pageable pageable);
    Page<AreaComun> findByConjunto_IdAndTipoAreaAndDeletedAtIsNull(UUID conjuntoId, TipoAreaComun tipoArea, Pageable pageable);
    boolean existsByConjunto_IdAndCodigoIgnoreCaseAndDeletedAtIsNull(UUID conjuntoId, String codigo);
}
