package ec.edu.espe.conjunto.repository;

import ec.edu.espe.conjunto.entity.Anexo;
import ec.edu.espe.conjunto.enums.TipoAnexo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnexoRepository extends JpaRepository<Anexo, UUID> {

    Optional<Anexo> findByIdAndDeletedAtIsNull(UUID id);
    Page<Anexo> findByConjunto_IdAndDeletedAtIsNull(UUID conjuntoId, Pageable pageable);
    Page<Anexo> findByConjunto_IdAndTipoAnexoAndDeletedAtIsNull(UUID conjuntoId, TipoAnexo tipoAnexo, Pageable pageable);
    boolean existsByConjunto_IdAndCodigoIgnoreCaseAndDeletedAtIsNull(UUID conjuntoId, String codigo);
}
