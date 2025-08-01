package za.ac.cput.service;

import za.ac.cput.domain.Product;

import java.util.List;

public interface IProductService extends IService<Product, Long> {
    boolean delete(Long id);
    List<Product> getAll();

}
