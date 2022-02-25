package com.douzone.wecrm.controller.api.dto;

import com.douzone.wecrm.domain.Customer;
import lombok.Data;

@Data
public class CustomerDto {
    private Long id;
    private String customerName;
    private String tel;

    public CustomerDto(Customer customer) {
        this.id = customer.getId();
        this.customerName = customer.getCustomerName();
        this.tel = customer.getTel();
    }
}
