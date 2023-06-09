package kz.pavel.crm.repository;

import kz.pavel.crm.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findById(Long id);

//    List<Customer> findByName(String name);
//    List<Customer> findByAge(int age);
}
