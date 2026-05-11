package com.inventory.inventory.utlity;

import com.inventory.inventory.dto.ProductDTO;
import com.inventory.inventory.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductDTO dto);

    ProductDTO toDTO(Product product);

    List<ProductDTO> toDTOList(List<Product> products);

    void updateProductFromDto(ProductDTO dto,
                              @MappingTarget Product product);
}
