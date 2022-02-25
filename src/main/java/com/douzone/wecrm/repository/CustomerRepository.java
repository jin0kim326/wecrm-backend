package com.douzone.wecrm.repository;

import com.douzone.wecrm.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerRepository {

    private final EntityManager em;

    public Long save(Customer customer){
        em.persist(customer);
        return customer.getId();
    }

    public Customer find(Long id){
        return em.find(Customer.class, id);
    }

    public List<Customer> findCustomers() {
        List<Customer> customers = em.createQuery("select c from Customer c order by c.id").getResultList();
        return customers;
    }

    public List<Customer> searchCustomers(String searchParam) {
        List<Customer> resultList = em.createQuery(
                "select c from Customer c " +
                        "where c.customerName LIKE :searchParam ", Customer.class
        ).setParameter("searchParam", '%'+searchParam+'%').getResultList();
        return resultList;
    }
}
