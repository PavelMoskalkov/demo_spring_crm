package kz.pavel.crm.entity;


import kz.pavel.crm.enums.CafeTableStatusEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tables")
public class CafeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "cafeTable")
    private List<Customer> customers;

    @OneToMany(mappedBy = "cafeTable")
    private List<Check> checks;


    @Column(name = "number", unique = true)
    @NotNull(message = "Number of tables should not be empty")
    @Min(value = 1, message = "Number of tables should not be less than one")
    private int number;

    @Column(name = "status", columnDefinition = "varchar(50) default 'AVAILABLE'")
    private String status;

    @Column(name = "opening_time", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime openingTime;

    public CafeTable() {
        this.status = CafeTableStatusEnum.AVAILABLE.name();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Check> getChecks() {
        return checks;
    }

    public void setChecks(List<Check> checks) {
        this.checks = checks;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalDateTime openingTime) {
        this.openingTime = openingTime;
    }
}
