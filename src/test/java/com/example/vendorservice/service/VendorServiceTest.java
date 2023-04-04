package com.example.vendorservice.service;

import com.example.vendorservice.constans.VendorType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class VendorServiceTest {

    private static final List<VendorType> VENDOR_LIST = List.of(
            VendorType.NAVER,
            VendorType.G_MARKET,
            VendorType.TMON,
            VendorType.WE_MADE_PRICE
    );

    @Test
    void vendorServiceTest() {
        VENDOR_LIST.forEach(this::processService);
    }

    private void processService(VendorType vendorType) {
        VendorService service = vendorType.getService();
        log.info(" ==================== [VENDOR][{}] / [CODE][{}] ==================== ", vendorType.getName(), vendorType.getCode());
        service.getProductList();
        service.getProductDetail();
        service.getOptionList();
        service.getOptionDetail();
        service.requestOrder();
        service.completeOrder();
    }
}
