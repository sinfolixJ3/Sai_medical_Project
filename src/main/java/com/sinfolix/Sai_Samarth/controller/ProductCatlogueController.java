package com.sinfolix.Sai_Samarth.controller;

import com.sinfolix.Sai_Samarth.DTO.ApiResponse;
import com.sinfolix.Sai_Samarth.DTO.ProductCatlogueDTO;
import com.sinfolix.Sai_Samarth.service.Impl.ProductCatlogueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-catalogue")// Mapping the API endpoint to root URL
@CrossOrigin(origins = "*")  // Allowing all origins to access the API
//@Api(value = "Product Catlogue API", description = "API for managing product catalogue") //This annotation is used for documenting the API, typically with Swagger or similar tools. The value provides a brief title, while the description gives more context about what the API does.
//@Tag(name = "Product Catlogue API")  // Adding a tag to the API documentation
public class ProductCatlogueController {
    @Autowired
    ProductCatlogueServiceImpl productCatlogueService;

    //post -create product catlogue
    @PostMapping("/")
    public ResponseEntity<ProductCatlogueDTO> createProductCatlogue(@RequestBody ProductCatlogueDTO productCatlogueDTO) {
        ProductCatlogueDTO createproductCatlogueDTO = this.productCatlogueService.createProductCatlogue(productCatlogueDTO);
        return new ResponseEntity<>(createproductCatlogueDTO, HttpStatus.CREATED);
    }


//    Put update product catlogue

    @PutMapping("/{id}")
    public ResponseEntity<ProductCatlogueDTO> updateProductCatlogue(@PathVariable int id, @RequestBody ProductCatlogueDTO productCatlogueDTO) {
        ProductCatlogueDTO updatedProductCatlogueDTO = this.productCatlogueService.updateProductCatlogue(productCatlogueDTO, id);
        return new ResponseEntity<>(updatedProductCatlogueDTO, HttpStatus.OK);
//        or return ResponseEntity.ok(updatedProductCatlogueDTO);
    }

    //    DELETE  catlogue
//    NOTE : Never Use this API
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProductCatlogue(@PathVariable int id) {
        this.productCatlogueService.deleteProductCatlogue(id);
        return ResponseEntity.ok(new ApiResponse("User Deleted Successfully", true));
    }

    //    Get - user catlogue all Productes that are available irrespective of Status(enabled/disabled)
    @GetMapping("/")
    public ResponseEntity<List<ProductCatlogueDTO>> getAllUser() {
        return ResponseEntity.ok(this.productCatlogueService.getAllProductCatlogue());
    }

    @GetMapping("/enabled")
    public ResponseEntity<List<ProductCatlogueDTO>> getEnabledAllUser() {
        return ResponseEntity.ok(this.productCatlogueService.getAllEnabledProductCatlogue());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCatlogueDTO> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(this.productCatlogueService.getProductCatlogueById(id));
    }
}
