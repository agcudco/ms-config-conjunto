package ec.edu.espe.conjunto.repository;

import ec.edu.espe.conjunto.entity.ConjuntoHabitacional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ConjuntoHabitacionalRepository extends JpaRepository<ConjuntoHabitacional, UUID> {

    Optional<ConjuntoHabitacional> findByIdAndDeletedAtIsNull(UUID id);
    Optional<ConjuntoHabitacional> findByCodigoIgnoreCaseAndDeletedAtIsNull(String codigo);
    Page<ConjuntoHabitacional> findAllByDeletedAtIsNull(Pageable pageable);
    boolean existsByCodigoIgnoreCaseAndDeletedAtIsNull(String codigo);
}
