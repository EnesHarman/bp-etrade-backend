package com.etrade.analytic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "product-link-click-event")
public class ProductLinkClickEvent {
    @Id
    private String id;
    private String userEmail;
    private LocalDateTime clickDate;
    private String productId;
    private String linkType;
}