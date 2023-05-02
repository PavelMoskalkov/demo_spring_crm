package kz.pavel.crm.service;

import kz.pavel.crm.entity.Customer;
import kz.pavel.crm.repository.CustomerRepository;
import kz.pavel.crm.util.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElseThrow(EntityNotFoundException::new);
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }





//    public List<CustomerDto> getPersons() {
//        List<Customer> personList = customerRepository.findAll();
//        return PersonConverter.toPersonListDto(personList);
//    }
//
//    public CustomerDto getPersonById(Long id) {
//        Customer person = customerRepository.findById(id).orElseThrow();
//        return PersonConverter.toPersonDto(person);
//    }
//
//    public List<CustomerDto> getPersonByName(String name) {
//        List<Customer> personList = customerRepository.findByName(name);
//        return PersonConverter.toPersonListDto(personList);
//    }
//
//    public List<CustomerDto> getPersonByAge(int age) {
//        List<Customer> personList = customerRepository.findByAge(age);
//        return PersonConverter.toPersonListDto(personList);
//    }


}
