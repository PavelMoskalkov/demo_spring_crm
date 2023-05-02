package kz.pavel.crm.controller;

import kz.pavel.crm.dto.CustomerDTO;
import kz.pavel.crm.dto.CustomerRequestDTO;
import kz.pavel.crm.entity.Customer;
import kz.pavel.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static kz.pavel.crm.builder.CustomerConverter.toCustomerDto;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void saveCustomer(@RequestBody CustomerRequestDTO request) {
        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setBirthDate(request.getBirthDate());
        customer.setPhoneNumber(request.getPhoneNumber());
        customer.setEmail(request.getEmail());

        customerService.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable("id") Long id) {
        return toCustomerDto(customerService.getCustomer(id));
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping
    public void updateCustomer(@RequestBody CustomerRequestDTO customerRequestDto) {

        Customer existingCustomer = customerService.getCustomer(customerRequestDto.getId());

        existingCustomer.setFirstName(customerRequestDto.getFirstName());
        existingCustomer.setLastName(customerRequestDto.getLastName());
        existingCustomer.setBirthDate(customerRequestDto.getBirthDate());
        existingCustomer.setPhoneNumber(customerRequestDto.getPhoneNumber());
        existingCustomer.setEmail(customerRequestDto.getEmail());
        customerService.saveCustomer(existingCustomer);
    }






//
//    @GetMapping("/persons")
//    public List<CustomerDto> getPersons() {
//        return customerService.getPersons();
//    }
//
//    @GetMapping("/person")
//    public CustomerDto getPerson(@RequestParam("id") Long id) {
//        return customerService.getPersonById(id);
//    }
//
//    @GetMapping("/personByName")
//    public List<CustomerDto> getPersonByName(@RequestParam("name") String name) {
//        return customerService.getPersonByName(name);
//    }
//
//    @GetMapping("/personByAge")
//    public List<CustomerDto> getPersonByAge(@RequestParam("age") int age) {
//        return customerService.getPersonByAge(age);
//    }



}
