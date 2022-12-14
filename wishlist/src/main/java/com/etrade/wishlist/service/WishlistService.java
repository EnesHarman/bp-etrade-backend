package com.etrade.wishlist.service;

import com.etrade.wishlist.core.config.kafka.events.ProductEvent;
import com.etrade.core.result.*;
import com.etrade.wishlist.dto.AddWishlistRequest;
import com.etrade.wishlist.dto.ListWishlistResponse;
import com.etrade.core.model.WishlistMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface WishlistService {
    Result addWishList(HttpServletRequest request, AddWishlistRequest addWishlistRequest);

    DataResult<List<ListWishlistResponse>> listWishlist(HttpServletRequest request, int page);

    Result deleteWishlist(String id);

    void addDiscountWishlistMessage(ProductEvent message);

    void addStockWishlistMessage(ProductEvent message);

    DataResult<List<WishlistMessage>> listMessages(HttpServletRequest request, int page);

    void clearOldWishlistMessages();
}
