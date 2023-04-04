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
public class TMonVendorServiceImpl implements VendorService {
    @Override
    public VendorType getVendorType() {
        return VendorType.TMON;
    }

    @Override
    public List<String> getProductList() {
        return Streams.ofNullable(List.of("#1 tMon_product", "#2 tMon_product", "#3 tMon_product"))
                .peek(productList -> log.info("[getProductList] >>> {}", productList))
                .collect(Collectors.toList());
    }

    @Override
    public String getProductDetail() {
        String result = "tMon_product_detail";
        log.info("[getProductDetail] >>> {}", result);
        return result;
    }

    @Override
    public List<String> getOptionList() {
        return Streams.ofNullable(List.of("#1 tMon_option", "#2 tMon_option", "#3 tMon_option"))
                .peek(optionList -> log.info("[getOptionList] >>> {}", optionList))
                .collect(Collectors.toList());
    }

    @Override
    public String getOptionDetail() {
        String result = "tMon_option_detail";
        log.info("[getOptionDetail] >>> {}", result);
        return result;
    }

    @Override
    public void requestOrder() {
        log.info("[requestOrder] >>> tMon_");
    }

    @Override
    public void completeOrder() {
        log.info("[completeOrder] >>> tMon_");
    }
}
