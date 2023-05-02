package kz.pavel.crm.repository;

import kz.pavel.crm.entity.Check;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CheckRepository extends JpaRepository<Check, Long> {
    Optional<Check> findById(Long id);
}
