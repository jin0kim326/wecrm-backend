package com.douzone.wecrm;

import com.douzone.wecrm.domain.Customer;
import com.douzone.wecrm.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
class WecrmApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	@Transactional
	@Rollback(false)
	public void testMember() {
		Customer customer = Customer.builder().customerName("jinyoung").build();

		Long saveId = customerRepository.save(customer);
		Customer findCustomer = customerRepository.find(saveId);

		Assertions.assertThat(findCustomer.getId()).isEqualTo(customer.getId());
		System.out.println("findCustomer.getId() = " + findCustomer.getId());
	}


}
