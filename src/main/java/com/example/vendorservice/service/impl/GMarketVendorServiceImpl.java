package com.example.vendorservice.service.impl;

import com.example.vendorservice.constans.VendorType;
import com.example.vendorservice.service.VendorService;
import com.example.vendorservice.utils.Streams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GMarketVendorServiceImpl implements VendorService {
    @Override
    public VendorType getVendorType() {
        return VendorType.G_MARKET;
    }

    @Override
    public List<String> getProductList() {
        return Streams.ofNullable(List.of("#1 gMarket_product", "#2 gMarket_product", "#3 gMarket_product"))
                .peek(productList -> log.info("[getProductList] >>> {}", productList))
                .collect(Collectors.toList());
    }

    @Override
    public String getProductDetail() {
        String result = "gMarket_product_detail";
        log.info("[getProductDetail] >>> {}", result);
        return result;
    }

    @Override
    public List<String> getOptionList() {
        return Streams.ofNullable(List.of("#1 gMarket_option", "#2 gMarket_option", "#3 gMarket_option"))
                .peek(optionList -> log.info("[getOptionList] >>> {}", optionList))
                .collect(Collectors.toList());
    }

    @Override
    public String getOptionDetail() {
        String result = "gMarket_option_detail";
        log.info("[getOptionDetail] >>> {}", result);
        return result;
    }

    @Override
    public void requestOrder() {
        log.info("[requestOrder] >>> gMarket_");
    }

    @Override
    public void completeOrder() {
        log.info("[completeOrder] >>> gMarket_");
    }
}
