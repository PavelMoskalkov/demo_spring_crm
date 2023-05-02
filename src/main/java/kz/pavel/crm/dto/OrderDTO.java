package kz.pavel.crm.dto;

import kz.pavel.crm.entity.Product;

import java.util.List;

public class OrderDTO {
    private Long id;
    private Long CheckId;
    private String status;
    private Long customerId;

    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCheckId() {
        return CheckId;
    }

    public void setCheckId(Long checkId) {
        CheckId = checkId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
