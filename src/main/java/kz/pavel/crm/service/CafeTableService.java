package kz.pavel.crm.service;

import kz.pavel.crm.entity.CafeTable;
import kz.pavel.crm.entity.Customer;
import kz.pavel.crm.enums.CafeTableStatusEnum;
import kz.pavel.crm.repository.CafeTableRepository;
import kz.pavel.crm.repository.CustomerRepository;
import kz.pavel.crm.util.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@Transactional
public class CafeTableService {

    private final CafeTableRepository cafeTableRepository;

    private final CustomerRepository customerRepository;

    @Autowired
    public CafeTableService(CafeTableRepository cafeTableRepository, CustomerRepository customerRepository) {
        this.cafeTableRepository = cafeTableRepository;
        this.customerRepository = customerRepository;
    }

    public CafeTable getCafeTable(Long id) {
        Optional<CafeTable> cafeTable = cafeTableRepository.findById(id);
        return cafeTable.orElseThrow(EntityNotFoundException::new);
    }

    public void saveCafeTable(CafeTable cafeTable) {
        cafeTableRepository.save(cafeTable);
    }

    public void deleteCafeTable(Long id) {
        cafeTableRepository.deleteById(id);
    }

    public void takeTable(CafeTable cafeTable, Customer customer) {
        customer.setCafeTable(cafeTable);
        cafeTable.setOpeningTime(LocalDateTime.now());
        cafeTable.setStatus(CafeTableStatusEnum.BUSY.name());

        cafeTableRepository.save(cafeTable);
        customerRepository.save(customer);
    }
}
