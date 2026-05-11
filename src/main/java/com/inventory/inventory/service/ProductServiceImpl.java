package com.inventory.inventory.service;

import com.inventory.inventory.dto.ProductDTO;
import com.inventory.inventory.entity.Product;
import com.inventory.inventory.repository.ProductRepository;
import com.inventory.inventory.utlity.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public ProductDTO addProduct(ProductDTO productDto) {
        Product product = mapper.toEntity(productDto);
        Product result = productRepository.save(product);
        return mapper.toDTO(result);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return mapper.toDTOList(products);
    }

    @Override
    public ProductDTO getProductById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return mapper.toDTO(product);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO updatedProduct) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        mapper.updateProductFromDto(updatedProduct, existingProduct);

        Product product = productRepository.save(existingProduct);
        return mapper.toDTO(product);
    }

    @Override
    public void deleteProduct(Long id) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        productRepository.delete(existingProduct);
    }
}
