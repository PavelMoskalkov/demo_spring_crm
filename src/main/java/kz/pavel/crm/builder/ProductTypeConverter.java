package kz.pavel.crm.builder;

import kz.pavel.crm.dto.ProductTypeDTO;
import kz.pavel.crm.entity.ProductType;

public class ProductTypeConverter {

    public static ProductTypeDTO toProductTypeDTO(ProductType productType) {
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();

        productTypeDTO.setId(productType.getId());
        productTypeDTO.setName(productType.getName());

        return productTypeDTO;
    }
}
