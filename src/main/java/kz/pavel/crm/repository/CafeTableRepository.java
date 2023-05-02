package kz.pavel.crm.repository;

import kz.pavel.crm.entity.CafeTable;
import kz.pavel.crm.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CafeTableRepository extends JpaRepository<CafeTable, Long> {
    Optional<CafeTable> findById(Long id);
}
