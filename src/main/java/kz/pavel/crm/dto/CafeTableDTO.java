package kz.pavel.crm.dto;

import kz.pavel.crm.entity.Customer;
import kz.pavel.crm.enums.CafeTableStatusEnum;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class CafeTableDTO {
    private Long id;
    private int number;
    private LocalDateTime openingTime;
    private String status;
    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDateTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalDateTime openingTime) {
        this.openingTime = openingTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
