package com.example.vendorservice.constans;

import com.example.vendorservice.service.VendorService;
import com.example.vendorservice.utils.Streams;
import lombok.Getter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Getter
public enum VendorType {

    NAVER("네이버", "NAV00"),
    G_MARKET("지마켓", "GMK00"),
    WE_MADE_PRICE("위메프", "WMP00"),
    TMON("티몬", "TMN00"),
    ;

    private final String name;
    private final String code;

    VendorType(String name, String code) {
        this.name = name;
        this.code = code;
    }

    private VendorService service;

    public VendorService getService() {

        if (Objects.isNull(this.service)) {
            throw new RuntimeException(ErrorCode.SERVER_ERROR);
        }
        return service;
    }

    private void setService(VendorService service) {
        this.service = service;
    }

    public static VendorType of(String vendorCodeString) {
        return Streams.ofNullable(VendorType.values())
                .filter(e -> e.getCode().equals(vendorCodeString))
                .findAny()
                .orElseThrow(() -> new RuntimeException(ErrorCode.SERVER_ERROR));
    }

    @Component
    private static class InjectService implements InitializingBean {

        @Autowired
        private List<VendorService> vendorType;

        @Override
        public void afterPropertiesSet() {
            Streams.ofNullable(vendorType)
                    .forEach(service -> {
                        VendorType type = service.getVendorType();
                        type.setService(service);
                    });
        }
    }
}
