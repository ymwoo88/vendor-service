package com.example.vendorservice.service;

import com.example.vendorservice.constans.VendorType;

import java.util.List;

public interface VendorService {

    VendorType getVendorType();

    List<String> getProductList();

    String getProductDetail();

    List<String> getOptionList();

    String getOptionDetail();

    void requestOrder();

    void completeOrder();
}
