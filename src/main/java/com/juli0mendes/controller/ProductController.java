package com.juli0mendes.controller;

import com.juli0mendes.domain.Product;
import com.juli0mendes.dto.ProductDto;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/poc/v1/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    @GET
    public List<Product> findAll() {
        return Product.listAll();
    }

    @POST
    @Transactional
    public void create(ProductDto productDto) {

        Product product = new Product();
        product.setName(productDto.getName());
        product.setValue(productDto.getValue());

        product.persist();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void update(@PathParam("id") Long id, ProductDto productDto) {

        Optional<Product> productExists = Product.findByIdOptional(id);

        if (productExists.isPresent()) {
            Product product = productExists.get();
            product.setName(productDto.getName());
            product.setValue(productDto.getValue());

            product.persist();
        } else {
            throw new NotFoundException();
        }
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void update(@PathParam("id") Long id) {

        Optional<Product> productExists = Product.findByIdOptional(id);

        productExists.ifPresentOrElse(Product::delete, () -> {
            throw new NotFoundException();
        });
    }
}
