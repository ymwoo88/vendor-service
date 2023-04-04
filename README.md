# 다형성을 적용한 벤더 서비스 구성
## 머리글
이 프로젝트는 개인이구성하여 다형성을 이용한 서비스분기를 하는 방법을 고안하기 위하여 진행한 프로젝트 입니다.  
결과를 바탕으로 실제 업무에 반영 할 기반을 마련할 계획


#### by ymwoo

## 개요 
벤더사의 상품연동 기능을 보다쉽게 유지보수 할 수 있도록 구성

## 기대 결과
- 여러 벤더사의 상품을 조회에서부터 구매
- 각 벤더사별로 요청/응답 형태가 다르지만 통일 된 공통로직에서 처리가 가능하도록 구성
  - 상품조회, 옵션선택, 구매, 구매완료

## 구성
- 벤더를 구별하는 enum type 추가
  - VendorType
    - NAVER("네이버", "NAV00")
    - G_MARKET("지마켓", "GMK00")
    - WE_MADE_PRICE("위메프", "WMP00")
    - TMON("티몬", "TMN00")
- 공통로직에서는 VendorSerivce에서 제공되는 메소드기능만 사용한다.
  - VendorType getVendorType(); 
  - List<String> getProductList(); 
  - String getProductDetail(); 
  - List<String> getOptionList(); 
  - String getOptionDetail(); 
  - void requestOrder(); 
  - void completeOrder();
- VendorService 인터페이스에 공통으로 사용되는 기능을 구성
    - 각 벤더사는 VendorService를 implementes하여 구현체를 생성한다.
        - NaverVendorServiceImpl
        - GMarketVendorServiceImpl
        - TMonVendorServiceImpl
        - WeMadepriceVendorServiceImpl

## 결과 확인
- VendorServiceTest 테스트 파일 실행
  - vendorServiceTest() 메소드 실행 시 아래과 같이 결과를 확인 할 수 있다.
```
2023-04-04 17:23:32.057  INFO 23014 --- [    Test worker] c.e.v.service.VendorServiceTest          :  ==================== [VENDOR][네이버] / [CODE][NAV00] ==================== 
2023-04-04 17:23:32.059  INFO 23014 --- [    Test worker] c.e.v.s.impl.NaverVendorServiceImpl      : [getProductList] >>> #1 naver_product
2023-04-04 17:23:32.059  INFO 23014 --- [    Test worker] c.e.v.s.impl.NaverVendorServiceImpl      : [getProductList] >>> #2 naver_product
2023-04-04 17:23:32.059  INFO 23014 --- [    Test worker] c.e.v.s.impl.NaverVendorServiceImpl      : [getProductList] >>> #3 naver_product
2023-04-04 17:23:32.059  INFO 23014 --- [    Test worker] c.e.v.s.impl.NaverVendorServiceImpl      : [getProductDetail] >>> naver_product_detail
2023-04-04 17:23:32.059  INFO 23014 --- [    Test worker] c.e.v.s.impl.NaverVendorServiceImpl      : [getOptionList] >>> #1 naver_option
2023-04-04 17:23:32.059  INFO 23014 --- [    Test worker] c.e.v.s.impl.NaverVendorServiceImpl      : [getOptionList] >>> #2 naver_option
2023-04-04 17:23:32.059  INFO 23014 --- [    Test worker] c.e.v.s.impl.NaverVendorServiceImpl      : [getOptionList] >>> #3 naver_option
2023-04-04 17:23:32.059  INFO 23014 --- [    Test worker] c.e.v.s.impl.NaverVendorServiceImpl      : [getOptionDetail] >>> naver_option_detail
2023-04-04 17:23:32.059  INFO 23014 --- [    Test worker] c.e.v.s.impl.NaverVendorServiceImpl      : [requestOrder] >>> naver_
2023-04-04 17:23:32.059  INFO 23014 --- [    Test worker] c.e.v.s.impl.NaverVendorServiceImpl      : [completeOrder] >>> naver_
2023-04-04 17:23:32.059  INFO 23014 --- [    Test worker] c.e.v.service.VendorServiceTest          :  ==================== [VENDOR][지마켓] / [CODE][GMK00] ==================== 
2023-04-04 17:23:32.060  INFO 23014 --- [    Test worker] c.e.v.s.impl.GMarketVendorServiceImpl    : [getProductList] >>> #1 gMarket_product
2023-04-04 17:23:32.060  INFO 23014 --- [    Test worker] c.e.v.s.impl.GMarketVendorServiceImpl    : [getProductList] >>> #2 gMarket_product
2023-04-04 17:23:32.060  INFO 23014 --- [    Test worker] c.e.v.s.impl.GMarketVendorServiceImpl    : [getProductList] >>> #3 gMarket_product
2023-04-04 17:23:32.060  INFO 23014 --- [    Test worker] c.e.v.s.impl.GMarketVendorServiceImpl    : [getProductDetail] >>> gMarket_product_detail
2023-04-04 17:23:32.060  INFO 23014 --- [    Test worker] c.e.v.s.impl.GMarketVendorServiceImpl    : [getOptionList] >>> #1 gMarket_option
2023-04-04 17:23:32.060  INFO 23014 --- [    Test worker] c.e.v.s.impl.GMarketVendorServiceImpl    : [getOptionList] >>> #2 gMarket_option
2023-04-04 17:23:32.060  INFO 23014 --- [    Test worker] c.e.v.s.impl.GMarketVendorServiceImpl    : [getOptionList] >>> #3 gMarket_option
2023-04-04 17:23:32.060  INFO 23014 --- [    Test worker] c.e.v.s.impl.GMarketVendorServiceImpl    : [getOptionDetail] >>> gMarket_option_detail
2023-04-04 17:23:32.060  INFO 23014 --- [    Test worker] c.e.v.s.impl.GMarketVendorServiceImpl    : [requestOrder] >>> gMarket_
2023-04-04 17:23:32.060  INFO 23014 --- [    Test worker] c.e.v.s.impl.GMarketVendorServiceImpl    : [completeOrder] >>> gMarket_
2023-04-04 17:23:32.060  INFO 23014 --- [    Test worker] c.e.v.service.VendorServiceTest          :  ==================== [VENDOR][티몬] / [CODE][TMN00] ==================== 
2023-04-04 17:23:32.060  INFO 23014 --- [    Test worker] c.e.v.s.impl.TMonVendorServiceImpl       : [getProductList] >>> #1 tMon_product
2023-04-04 17:23:32.060  INFO 23014 --- [    Test worker] c.e.v.s.impl.TMonVendorServiceImpl       : [getProductList] >>> #2 tMon_product
2023-04-04 17:23:32.061  INFO 23014 --- [    Test worker] c.e.v.s.impl.TMonVendorServiceImpl       : [getProductList] >>> #3 tMon_product
2023-04-04 17:23:32.061  INFO 23014 --- [    Test worker] c.e.v.s.impl.TMonVendorServiceImpl       : [getProductDetail] >>> tMon_product_detail
2023-04-04 17:23:32.061  INFO 23014 --- [    Test worker] c.e.v.s.impl.TMonVendorServiceImpl       : [getOptionList] >>> #1 tMon_option
2023-04-04 17:23:32.061  INFO 23014 --- [    Test worker] c.e.v.s.impl.TMonVendorServiceImpl       : [getOptionList] >>> #2 tMon_option
2023-04-04 17:23:32.061  INFO 23014 --- [    Test worker] c.e.v.s.impl.TMonVendorServiceImpl       : [getOptionList] >>> #3 tMon_option
2023-04-04 17:23:32.061  INFO 23014 --- [    Test worker] c.e.v.s.impl.TMonVendorServiceImpl       : [getOptionDetail] >>> tMon_option_detail
2023-04-04 17:23:32.061  INFO 23014 --- [    Test worker] c.e.v.s.impl.TMonVendorServiceImpl       : [requestOrder] >>> tMon_
2023-04-04 17:23:32.061  INFO 23014 --- [    Test worker] c.e.v.s.impl.TMonVendorServiceImpl       : [completeOrder] >>> tMon_
2023-04-04 17:23:32.061  INFO 23014 --- [    Test worker] c.e.v.service.VendorServiceTest          :  ==================== [VENDOR][위메프] / [CODE][WMP00] ==================== 
2023-04-04 17:23:32.061  INFO 23014 --- [    Test worker] c.e.v.s.i.WeMadePriceVendorServiceImpl   : [getProductList] >>> #1 weMadePrice_product
2023-04-04 17:23:32.062  INFO 23014 --- [    Test worker] c.e.v.s.i.WeMadePriceVendorServiceImpl   : [getProductList] >>> #2 weMadePrice_product
2023-04-04 17:23:32.063  INFO 23014 --- [    Test worker] c.e.v.s.i.WeMadePriceVendorServiceImpl   : [getProductList] >>> #3 weMadePrice_product
2023-04-04 17:23:32.063  INFO 23014 --- [    Test worker] c.e.v.s.i.WeMadePriceVendorServiceImpl   : [getProductDetail] >>> weMadePrice_product_detail
2023-04-04 17:23:32.063  INFO 23014 --- [    Test worker] c.e.v.s.i.WeMadePriceVendorServiceImpl   : [getOptionList] >>> #1 weMadePrice_option
2023-04-04 17:23:32.063  INFO 23014 --- [    Test worker] c.e.v.s.i.WeMadePriceVendorServiceImpl   : [getOptionList] >>> #2 weMadePrice_option
2023-04-04 17:23:32.063  INFO 23014 --- [    Test worker] c.e.v.s.i.WeMadePriceVendorServiceImpl   : [getOptionList] >>> #3 weMadePrice_option
2023-04-04 17:23:32.063  INFO 23014 --- [    Test worker] c.e.v.s.i.WeMadePriceVendorServiceImpl   : [getOptionDetail] >>> weMadePrice_option_detail
2023-04-04 17:23:32.063  INFO 23014 --- [    Test worker] c.e.v.s.i.WeMadePriceVendorServiceImpl   : [requestOrder] >>> weMadePrice_
2023-04-04 17:23:32.063  INFO 23014 --- [    Test worker] c.e.v.s.i.WeMadePriceVendorServiceImpl   : [completeOrder] >>> weMadePrice_

```
