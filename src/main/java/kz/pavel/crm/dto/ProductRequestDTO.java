package kz.pavel.crm.dto;

import java.math.BigDecimal;

public class ProductRequestDTO {
    private Long id;
    private String name;

    private Long productTypeId;

    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private int stockBalance;

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductType(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public int getStockBalance() {
        return stockBalance;
    }

    public void setStockBalance(int stockBalance) {
        this.stockBalance = stockBalance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
