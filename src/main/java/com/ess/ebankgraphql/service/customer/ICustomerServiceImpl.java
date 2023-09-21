package com.ess.ebankgraphql.service.customer;

import com.ess.ebankgraphql.dto.CustomerDTO;
import com.ess.ebankgraphql.entity.Customer;
import com.ess.ebankgraphql.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ICustomerServiceImpl implements ICustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer create(CustomerDTO item) {
        Customer customer = Customer.toCustomer(item);
        customer.setCreatedAt(new Date());

        return customerRepository.save(customer);
    }

    @Override
    public Customer update(CustomerDTO item, Long id) {
        Customer customerToUpdate = Customer.toCustomer(item);
        customerToUpdate.setId(id);
        customerToUpdate.setUpdatedAt(new Date());

        return customerRepository.save(customerToUpdate);
    }

    @Override
    public Customer remove(CustomerDTO item) {
        Customer customerToDelete = Customer.toCustomer(item);
        customerRepository.delete(customerToDelete);

        return customerToDelete;
    }

    @Override
    public void removeMany(List<CustomerDTO> items) {
        // find ids for customers to be deleted
        List<Long> ids = items.stream()
                .map(CustomerDTO::getId)
                .collect(Collectors.toList());

        // delete customers
        customerRepository.deleteAllById(ids);
    }

    @Override
    public List<CustomerDTO> findAll() {
        // find all customers
        return customerRepository.findAll()
                // for each customer map to DTO
                .stream().map(Customer::toCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findByID(Long id) {
        // find customer by id
        Optional<Customer> customer = customerRepository.findById(id);
        CustomerDTO customerDTO = new CustomerDTO();

        // if customer exist map to DTO
        if (customer.isPresent())
            customerDTO = Customer.toCustomerDTO(customer.get());

        return customerDTO;
    }

    @Override
    public CustomerDTO findByIdentityNumber(String identityNumber) {
        Customer customer = customerRepository.findByIdentityCardNumber(identityNumber);
        CustomerDTO customerDTO = new CustomerDTO();

        if (customer != null) {
            customerDTO = Customer.toCustomerDTO(customer);
        }
        return customerDTO;
    }
}
