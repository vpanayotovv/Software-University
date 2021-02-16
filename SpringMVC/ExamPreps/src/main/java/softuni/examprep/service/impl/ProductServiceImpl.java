package softuni.examprep.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.examprep.model.dto.ProductAddBindingModel;
import softuni.examprep.model.entity.Product;
import softuni.examprep.repository.ProductRepository;
import softuni.examprep.service.CategoryService;
import softuni.examprep.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductServiceImpl(ModelMapper modelMapper, ProductRepository productRepository, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public void addProduct(ProductAddBindingModel productAddBindingModel) {
        Product product = modelMapper.map(productAddBindingModel, Product.class);
        product.setCategory(categoryService.getByName(productAddBindingModel.getCategory()));
        productRepository.saveAndFlush(product);
    }
}
