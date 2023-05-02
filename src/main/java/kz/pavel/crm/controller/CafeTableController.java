package kz.pavel.crm.controller;


import kz.pavel.crm.dto.CafeTableDTO;
import kz.pavel.crm.dto.CafeTableRequestDTO;
import kz.pavel.crm.dto.TakeCafeTableRequestDTO;
import kz.pavel.crm.entity.CafeTable;
import kz.pavel.crm.entity.Customer;
import kz.pavel.crm.enums.CafeTableStatusEnum;
import kz.pavel.crm.service.CafeTableService;
import kz.pavel.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static kz.pavel.crm.builder.CafeTableConverter.toCafeTableDTO;

@RestController
@RequestMapping("/cafe-table")
public class CafeTableController {
    private final CafeTableService cafeTableService;
    private final CustomerService customerService;

    @Autowired
    public CafeTableController(CafeTableService cafeTableService, CustomerService customerService) {
        this.cafeTableService = cafeTableService;
        this.customerService = customerService;
    }

    @PostMapping
    public void saveCafeTable(@RequestBody CafeTableRequestDTO request) {
        CafeTable cafeTable = new CafeTable();
        cafeTable.setNumber(request.getNumber());
        cafeTableService.saveCafeTable(cafeTable);
    }
    @GetMapping("/{id}")
    public CafeTableDTO getCafeTable(@PathVariable("id") Long id) {
        return toCafeTableDTO(cafeTableService.getCafeTable(id));
    }

    @DeleteMapping("/{id}")
    public void deleteCafeTable(@PathVariable("id") Long id) {
        cafeTableService.deleteCafeTable(id);
    }

    @PutMapping
    public void updateCafeTable(@RequestBody CafeTableRequestDTO cafeTableRequestDTO) {
        CafeTable existingCafeTable = cafeTableService.getCafeTable(cafeTableRequestDTO.getId());

        existingCafeTable.setNumber(cafeTableRequestDTO.getNumber());

        cafeTableService.saveCafeTable(existingCafeTable);
    }

    @PutMapping("/take")
    public void takeTable(@RequestBody TakeCafeTableRequestDTO takeCafeTableRequestDTO) {
        CafeTable cafeTable = cafeTableService.getCafeTable(takeCafeTableRequestDTO.getId());
        Customer customer = customerService.getCustomer(takeCafeTableRequestDTO.getCustomerId());
        cafeTableService.takeTable(cafeTable, customer);
    }

    @PutMapping("/clear")
    public void clearTheCafeTable(@RequestBody CafeTableRequestDTO request) {
        CafeTable cafeTable = cafeTableService.getCafeTable(request.getId());
        cafeTable.setStatus(CafeTableStatusEnum.AVAILABLE.name());
        cafeTable.setOpeningTime(null);

        cafeTableService.saveCafeTable(cafeTable);
    }
}
