package com.douzone.wecrm.controller.api;

import com.douzone.wecrm.controller.api.dto.*;
import com.douzone.wecrm.domain.Customer;
import com.douzone.wecrm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/customer")
@CrossOrigin("*")
public class CustomerController {
    private final CustomerService customerService;


    /**
     * 거래처 화면 조회 (거래처 목록)
     */
    @GetMapping
    public CustomerCardResponse listCustomers(
    ) {
        List<Customer> customers = customerService.listCustomers();
        return new CustomerCardResponse(customers);
    }

    /**
     * 거래처 등록하기
     */
    @PostMapping
    public Long registryCustomer(
            @RequestBody registryCustomerRequest request
    ) {
        Customer customer = Customer.builder()
                .customerName(request.getCustomerName())
                .customerDivision(request.getCustomerDivision())
                .companyNumber(request.getCompanyNumber())
                .representativeName(request.getRepresentativeName())
                .representativeNumber(request.getRepresentativeNumber())
                .representativeAddress(request.getRepresentativeAddress())
                .tel(request.getTel())
                .build();
        return customerService.registry(customer);
    }

    /**
     * 거래처 1개 조회 (거래처 클릭시 호출)
     */
    @GetMapping("/{customerId}")
    public Customer viewCustomerInfo (
            @PathVariable Long customerId
    ) {
        Customer customer = customerService.findCustomer(customerId);
        return customer;
    }
    /**
     * 검색하기
     * 1. 거래처명
     */
    @PostMapping("/search")
    public CustomerCardResponse searchCustomers (
            @RequestBody searchVo search
    ) {
        String searchParam = search.getSearchParam();
        List<Customer> searchedCustomers = customerService.searchCustomers(searchParam);

        System.out.println("searchParam = " + searchParam);
        return new CustomerCardResponse(searchedCustomers);
    }

    /**
     * Customer Update(수정)
     */
    @PatchMapping
    public Long updateCustomer(
        @RequestBody UpdateCustomerRequest request
    ) {
        Long customerId = request.getId();

        UpdateCustomerDto customer = UpdateCustomerDto.builder()
                .customerName(request.getCustomerName())
                .customerDivision(request.getCustomerDivision())
                .companyNumber(request.getCompanyNumber())
                .representativeName(request.getRepresentativeName())
                .representativeNumber(request.getRepresentativeNumber())
                .representativeAddress(request.getRepresentativeAddress())
                .tel(request.getTel())
                .build();

        return customerService.update(customerId,customer);

    }
}






















