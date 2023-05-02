package kz.pavel.crm.controller;

import kz.pavel.crm.dto.ProductDTO;
import kz.pavel.crm.dto.ProductRequestDTO;
import kz.pavel.crm.entity.Product;
import kz.pavel.crm.service.ProductService;
import kz.pavel.crm.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static kz.pavel.crm.builder.ProductConverter.toProductDTO;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ProductTypeService productTypeService;
    @Autowired
    public ProductController(ProductService productService, ProductTypeService productTypeService) {
        this.productService = productService;
        this.productTypeService = productTypeService;
    }

    @PostMapping
    public void saveProduct(@RequestBody ProductRequestDTO request) {
        Product product = new Product();

        product.setName(request.getName());
        product.setProductType(productTypeService.getProductType(request.getProductTypeId()));
        product.setPurchasePrice(request.getPurchasePrice());
        product.setSalePrice(request.getSalePrice());
        product.setStockBalance(request.getStockBalance());

        productService.saveProduct(product);
    }

    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable("id") Long id) {
        return toProductDTO(productService.getProduct(id));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        Product existingProduct = productService.getProduct(productRequestDTO.getId());
        existingProduct.setName(productRequestDTO.getName());
        existingProduct.setProductType(productTypeService.getProductType(productRequestDTO.getProductTypeId()));
        existingProduct.setPurchasePrice(productRequestDTO.getPurchasePrice());
        existingProduct.setSalePrice(productRequestDTO.getSalePrice());
        existingProduct.setStockBalance(productRequestDTO.getStockBalance());

        productService.saveProduct(existingProduct);
    }
}
