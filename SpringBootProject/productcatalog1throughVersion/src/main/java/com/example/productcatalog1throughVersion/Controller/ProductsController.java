package com.example.productcatalog1throughVersion.Controller;

import com.example.productcatalog1throughVersion.dto.Requestdto;
import com.example.productcatalog1throughVersion.entity.Product;
import com.example.productcatalog1throughVersion.response.APIresponse;
import com.example.productcatalog1throughVersion.service.IdempotencyService;
import com.example.productcatalog1throughVersion.service.ProductserviceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="https://localhost:3000")       //this is frontend endpoint to listenz
@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    ProductserviceImpl productservice;

    @Autowired
    IdempotencyService idempotencyService;


    @Cacheable(value = "product",key = "#id")
    @GetMapping("/getAll")
    public ResponseEntity<APIresponse<Page<Product>>> getAll(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "5") int size){
        Page<Product> products= productservice.getAll(page,size);
        APIresponse<Page<Product>> apiResponse = APIresponse.<Page<Product>>builder()
                .success(true)
                .message("Data retrieved successfully")
                .data(products).build();
        return ResponseEntity.ok(). body(apiResponse);
    }

    @GetMapping("/getAllBySort")
    public  Page<Product> getBySort(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "5") int size,
                                     @RequestParam(defaultValue = "id" ) String sortBy,
                                     @RequestParam(defaultValue = "ascending") String direction ){
        return productservice.getProductInOrder(page,size,sortBy,direction);
    }

    @GetMapping("/getByCategory/{category}")
    public ResponseEntity<APIresponse<List<Product>>> getBYCategory(@PathVariable String category){
        List<Product> products = productservice.getByCategory(category);
        APIresponse<List<Product>> apiresponse = APIresponse.<List<Product>>builder()
                .success(true)
                .message("Data retrieved successfully by Category")
                .data(products).build();
        return ResponseEntity.ok().body(apiresponse);
    }

    @GetMapping("/findById/{id}")
    public  Product findById(@PathVariable Long id){
        return productservice.findById(id);
    }

    @CacheEvict(value = "product",key = "#id")
    @DeleteMapping("/deleteById/{id}")
    public void deleteProduct(@PathVariable Long id){
        productservice.deleteById(id);
    }


    @CachePut(value = "product",key = "#id")
    //write update controller
    @PutMapping("/update/{id}")
    public ResponseEntity<APIresponse<Product>> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody Requestdto request) {

        Product updatedProduct = productservice.updateProduct(id, request);

        APIresponse<Product> apiResponse = APIresponse.<Product>builder()
                .success(true)
                .message("Product updated successfully")
                .data(updatedProduct)
                .build();

        return ResponseEntity.ok(apiResponse);
    }


    @PostMapping("/create")
    public ResponseEntity<APIresponse<Product>> createProduct(
            @RequestHeader("Idempotency-key")String idempotencyKey,
            @Valid
            @RequestBody Requestdto request
    ) {
        if(idempotencyService.isProcessed(idempotencyKey)){
            Long existingProductId = idempotencyService.getProductId(idempotencyKey);
            Product existingProduct = productservice.findById(existingProductId);

            APIresponse<Product> response = APIresponse.<Product>builder()
                    .success(true)
                    .message("request alreday processed")
                    .data(existingProduct)
                    .build();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        }
        Product product = productservice.createProduct(request);
        idempotencyService.save(
                idempotencyKey,
                product.getId()
        );
        APIresponse<Product> apiResponse = APIresponse.<Product>builder()
                .success(true)
                .message("Product created successfully")
                .data(product)
                .build();

        return ResponseEntity.ok(apiResponse);
    }




}
