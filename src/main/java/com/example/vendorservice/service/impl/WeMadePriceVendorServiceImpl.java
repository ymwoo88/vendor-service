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
public class WeMadePriceVendorServiceImpl implements VendorService {
    @Override
    public VendorType getVendorType() {
        return VendorType.WE_MADE_PRICE;
    }

    @Override
    public List<String> getProductList() {
        return Streams.ofNullable(List.of("#1 weMadePrice_product", "#2 weMadePrice_product", "#3 weMadePrice_product"))
                .peek(productList -> log.info("[getProductList] >>> {}", productList))
                .collect(Collectors.toList());
    }

    @Override
    public String getProductDetail() {
        String result = "weMadePrice_product_detail";
        log.info("[getProductDetail] >>> {}", result);
        return result;
    }

    @Override
    public List<String> getOptionList() {
        return Streams.ofNullable(List.of("#1 weMadePrice_option", "#2 weMadePrice_option", "#3 weMadePrice_option"))
                .peek(optionList -> log.info("[getOptionList] >>> {}", optionList))
                .collect(Collectors.toList());
    }

    @Override
    public String getOptionDetail() {
        String result = "weMadePrice_option_detail";
        log.info("[getOptionDetail] >>> {}", result);
        return result;
    }

    @Override
    public void requestOrder() {
        log.info("[requestOrder] >>> weMadePrice_");
    }

    @Override
    public void completeOrder() {
        log.info("[completeOrder] >>> weMadePrice_");
    }
}
