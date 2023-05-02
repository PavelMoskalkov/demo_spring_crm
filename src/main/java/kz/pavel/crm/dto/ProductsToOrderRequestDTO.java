package kz.pavel.crm.dto;

import java.util.List;

public class ProductsToOrderRequestDTO {
    private List<Long> products;
    private Long id;

    public List<Long> getProducts() {
        return products;
    }

    public void setProducts(List<Long> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
