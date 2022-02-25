package com.douzone.wecrm.controller.api.dto;

import com.douzone.wecrm.domain.CustomerDivision;
import lombok.Data;

@Data
public class UpdateCustomerRequest {
    private Long id;

    // 거래처이름
    private String customerName;

    //구분
    private CustomerDivision customerDivision;

    //사업자등록번호
    private String companyNumber;

    //대표자 이름
    private String representativeName;

    //대표자 전화번호
    private String representativeNumber;

    //대표 주소
    private String representativeAddress;

    //전화번호
    private String tel;
}
