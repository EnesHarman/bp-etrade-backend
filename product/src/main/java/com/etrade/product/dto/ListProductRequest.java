package com.etrade.product.dto;

import com.etrade.product.model.helpers.Links;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListProductRequest {
    private String id;
    private String isbn;
    private String title;
    private String author;
    private short pageNum;
    private Links links;
    private int price;
    private String publisher;
    private List<String> images;
}