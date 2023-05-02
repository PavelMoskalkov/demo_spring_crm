package kz.pavel.crm.builder;

import kz.pavel.crm.dto.CustomerDTO;
import kz.pavel.crm.entity.Customer;

public class CustomerConverter {

    public static CustomerDTO toCustomerDto(Customer customer) {
        CustomerDTO customerDto = new CustomerDTO();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setBirthDate(customer.getBirthDate());
        customerDto.setPhoneNumber(customer.getPhoneNumber());
        customerDto.setEmail(customer.getEmail());
        return customerDto;
    }

//    public static List<CustomerDto> toPersonListDto(List<Customer> personList) {
//        List<CustomerDto> customerDtos = new ArrayList<>();
//        for (Customer person : personList) {
//            customerDtos.add(toPersonDto(person));
//        }
//        return customerDtos;
//    }
}
