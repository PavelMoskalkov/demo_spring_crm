package kz.pavel.crm.controller;

import kz.pavel.crm.dto.ProductTypeDTO;
import kz.pavel.crm.dto.ProductTypeRequestDTO;
import kz.pavel.crm.entity.ProductType;
import kz.pavel.crm.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static kz.pavel.crm.builder.ProductTypeConverter.toProductTypeDTO;

@RestController
@RequestMapping("/product-type")
public class ProductTypeController {
    private final ProductTypeService productTypeService;

    @Autowired
    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @PostMapping
    public void saveProductType(@RequestBody ProductTypeRequestDTO request) {
        ProductType productType = new ProductType();
        productType.setName(request.getName());

        productTypeService.saveProductType(productType);
    }

    @GetMapping("/{id}")
    public ProductTypeDTO getProductType(@PathVariable("id") Long id) {
        return toProductTypeDTO(productTypeService.getProductType(id));
    }

    @DeleteMapping("/{id}")
    public void deleteProductType(@PathVariable("id") Long id) {
        productTypeService.deleteProductType(id);
    }

    @PutMapping
    public void updateProductType(@RequestBody ProductTypeRequestDTO productTypeRequestDTO) {
        ProductType existingProductType = productTypeService.getProductType(productTypeRequestDTO.getId());
        existingProductType.setName(productTypeRequestDTO.getName());
        productTypeService.saveProductType(existingProductType);
    }
}
