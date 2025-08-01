package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.ProductRepository;

import java.util.List;
@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Autowired public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    @Override
    public Product create(Product product) {
       return this.productRepository.save(product);
    }

    @Override
    public Product read(Long aLong) {
      return this.productRepository.findById(aLong).orElse(null);
    }

    @Override
    public Product update(Product product) {

       return this.productRepository.save(product);
    }
    @Override
    public boolean delete(Long id) {
         productRepository.deleteById(id);
         return true;
    }

    @Override
    public List<Product> getAll() {
      return this.productRepository.findAll();
    }

}
