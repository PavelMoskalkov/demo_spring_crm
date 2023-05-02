package kz.pavel.crm.controller;

import kz.pavel.crm.dto.CheckDTO;
import kz.pavel.crm.dto.CheckOrderRequestDTO;
import kz.pavel.crm.dto.CheckRequestDTO;
import kz.pavel.crm.entity.Check;
import kz.pavel.crm.entity.Customer;
import kz.pavel.crm.entity.Order;
import kz.pavel.crm.entity.Product;
import kz.pavel.crm.enums.OrderStatusEnum;
import kz.pavel.crm.service.CafeTableService;
import kz.pavel.crm.service.CheckService;
import kz.pavel.crm.service.CustomerService;
import kz.pavel.crm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;



import static kz.pavel.crm.builder.CheckConverter.toCheckDTO;
@RestController
@RequestMapping("/check")
public class CheckController {
    private final CheckService checkService;
    private final CafeTableService cafeTableService;
    private final CustomerService customerService;
    private final OrderService orderService;


    @Autowired
    public CheckController(CheckService checkService, CafeTableService cafeTableService, CustomerService customerService, OrderService orderService) {
        this.checkService = checkService;
        this.cafeTableService = cafeTableService;
        this.customerService = customerService;
        this.orderService = orderService;
    }


    @PostMapping
    @Transactional
    public void saveCheck(@RequestBody CheckOrderRequestDTO request) {
        Check check = new Check();

        check.setCustomer(customerService.getCustomer(request.getCustomerId()));
        check.setCafeTable(cafeTableService.getCafeTable(request.getCafeTableId()));

        Order order = orderService.getOrder(request.getOrderId());

        BigDecimal sum = BigDecimal.ZERO;
        for (Product product : order.getProducts()) {
            sum = sum.add(product.getSalePrice());
        }
        check.setSum(sum);

        check.setCreatedAt(LocalDateTime.now());
        Check newCheck = checkService.saveCheck(check);

        Customer customer = customerService.getCustomer(request.getCustomerId());
        customer.setCafeTable(null);

        order.setStatus(OrderStatusEnum.PAID.name());
        order.setCheck(checkService.getCheck(newCheck.getId()));

        customerService.saveCustomer(customer);
        orderService.saveOrder(order);
    }

    @GetMapping("/{id}")
    public CheckDTO getCheck(@PathVariable("id") Long id) {
        return toCheckDTO(checkService.getCheck(id));
    }

    @DeleteMapping("/{id}")
    public void deleteCheck(@PathVariable("id") Long id) {
        checkService.deleteCheck(id);
    }

    @PutMapping
    public void updateCheck(@RequestBody CheckRequestDTO checkRequestDTO) {
        Check existingCheck = checkService.getCheck(checkRequestDTO.getId());

        existingCheck.setCustomer(customerService.getCustomer(checkRequestDTO.getCustomerId()));
        existingCheck.setCafeTable(cafeTableService.getCafeTable(checkRequestDTO.getCafeTableId()));

        checkService.saveCheck(existingCheck);
    }
}
