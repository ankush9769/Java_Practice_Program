package com.example.ProductMSystemSpringBootapp7.repo;

import com.example.ProductMSystemSpringBootapp7.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    //product above the price
    @Query("select p from Product p where p.price > :price ")
    public List<Product> findAbovePrice(@Param("price")Double price);

    //getting product by using category name
    @Query("select P from Product p where p.category.name = :categoryname")
    public List<Product> getProductsbyCategory(@Param("categoryName")String categoryName);

    //getting list of product whos price is between the range and stock is availabel (greater than 0)
    @Query("select p from Product p where p.price between :min and :max and stoke > 0")
    public List<Product> getRangeStoekProduct(@Param("min")Double min,@Param("max")Double max);

    //sort the product base on price
    @Query("select P from Product p order by p.price desc")
    public List<Product> getSortedProudct();

    //getting product and coategory details based on coming category
    @Query("select p from Product p join from category where p.category = :category")
    public List<Product> getalldetails(@Param("category")String category);

    //same  with native way instead of jpa
    @Query(value = "select p from product p where p.price between :min and :max and stoke > 0",nativeQuery = true)
    public List<Product> getRangeStoekProductBYNative(@Param("min")Double min,@Param("max")Double max);
}
