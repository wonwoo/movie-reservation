package me.wonwoo.web;

import me.wonwoo.domain.Customer;
import me.wonwoo.dto.CustomerDto;
import me.wonwoo.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public CustomerDto.Customer getCusomter(@PathVariable Long id){
        Customer customer = customerRepository.findOne(id);
        return modelMapper.map(customer, CustomerDto.Customer.class);
    }
}
