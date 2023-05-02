package kz.pavel.crm.builder;

import kz.pavel.crm.dto.ProductDTO;
import kz.pavel.crm.entity.Product;
import kz.pavel.crm.entity.ProductType;

import java.math.BigDecimal;

public class ProductConverter {
    public static ProductDTO toProductDTO(Product product) {
      ProductDTO productDTO = new ProductDTO();

      productDTO.setId(product.getId());
      productDTO.setName(product.getName());
      productDTO.setProductType(product.getProductType());
      productDTO.setPurchasePrice(product.getPurchasePrice());
      productDTO.setSalePrice(product.getSalePrice());
      productDTO.setStockBalance(product.getStockBalance());

      return productDTO;
    }
}
