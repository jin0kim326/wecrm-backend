package com.douzone.wecrm.domain;

import com.douzone.wecrm.controller.api.dto.UpdateCustomerDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Customer {
    @Id @GeneratedValue
    @Column(name = "customer_id")
    private Long id;

    // 거래처이름
    @Column(name = "customer_name")
    private String customerName;

    // 구분 : 법인,개인,금융,카드,기관
    @Enumerated(EnumType.STRING)
    private CustomerDivision customerDivision;

    //사업자등록번호
    @Column(name = "company_number")
    private String companyNumber;

    //대표자 이름
    @Column(name = "representative_name")
    private String representativeName;

    //대표자 전화번호
    @Column(name = "representative_number")
    private String representativeNumber;

    //대표 주소
    @Column(name = "representative_address")
    private String representativeAddress;

    //전화번호
    private String tel;

    @Builder
    public Customer (String customerName, CustomerDivision customerDivision,
                     String companyNumber, String representativeName,
                     String representativeNumber, String representativeAddress, String tel) {
        this.customerName = customerName;
        this.customerDivision = customerDivision;
        this.companyNumber = companyNumber;
        this.representativeName = representativeName;
        this.representativeAddress = representativeAddress;
        this.representativeNumber = representativeNumber;
        this.tel = tel;
    }

    public void updateCustomer(UpdateCustomerDto updateCustomerDto) {
        this.customerName = updateCustomerDto.getCustomerName();
        this.customerDivision = updateCustomerDto.getCustomerDivision();
        this.companyNumber = updateCustomerDto.getCompanyNumber();
        this.representativeName = updateCustomerDto.getRepresentativeName();
        this.representativeAddress = updateCustomerDto.getRepresentativeAddress();
        this.representativeNumber = updateCustomerDto.getRepresentativeNumber();
        this.tel = updateCustomerDto.getTel();
    }
}
