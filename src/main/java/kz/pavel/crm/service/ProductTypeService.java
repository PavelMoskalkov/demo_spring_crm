package kz.pavel.crm.service;

import kz.pavel.crm.entity.ProductType;
import kz.pavel.crm.repository.ProductTypeRepository;
import kz.pavel.crm.util.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ProductTypeService {

    private final ProductTypeRepository productTypeRepository;

    @Autowired
    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    public ProductType getProductType(Long id) {
        Optional<ProductType> productType = productTypeRepository.findById(id);
        return productType.orElseThrow(EntityNotFoundException::new);
    }

    public void saveProductType(ProductType productType) {
        productTypeRepository.save(productType);
    }

    public void deleteProductType(Long id) {
        productTypeRepository.deleteById(id);
    }
}
