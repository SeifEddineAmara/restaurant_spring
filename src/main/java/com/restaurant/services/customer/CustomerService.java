package com.restaurant.services.customer;

import com.restaurant.dtos.CategoryDto;
import com.restaurant.dtos.ProductDto;
import com.restaurant.dtos.ReservationDto;

import java.util.List;

public interface CustomerService {
    List<CategoryDto> getAllCategories();

    List<CategoryDto> getAllCategoriesByName(String title);

    List<ProductDto> getProductsByCategory(Long categoryId);

    List<ProductDto> getAllProductsByCategoryAndTitle(Long categoryId, String title);

    ReservationDto postReservation(ReservationDto reservationDto);

    List<ReservationDto> getReservationByUser(Long customerId);
}
