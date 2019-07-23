package poly.com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.com.entitis.Customer;
import poly.com.exception.ResourceNotFoundException;
import poly.com.repository.CustomerRepository;

@RestController
@RequestMapping(value = "/api")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;

	@GetMapping("/customer")
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@PostMapping("/customer")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@GetMapping("/customer/{id}")
	public Customer getCustomerId(@PathVariable(value = "id") String CustomerId) {
		return customerRepository.findById(CustomerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", CustomerId));
	}

	@PutMapping("/customer/{id}")
	public Customer updateCustomer(@PathVariable(value = "id") String CustomerId,
			@Valid @RequestBody Customer customerDetails) {
		Customer customer = customerRepository.findById(CustomerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", CustomerId));

		customer.setId(customerDetails.getId());
		customer.setFullname(customerDetails.getFullname());
		customer.setBirth(customerDetails.getBirth());
		customer.setGender(customerDetails.getGender());
		customer.setPhone(customerDetails.getPhone());
		customer.setPeopleID(customerDetails.getPeopleID());
		customer.setIssuedDate(customerDetails.getIssuedDate());
		customer.setReleaseLocation(customerDetails.getReleaseLocation());
		customer.setTemporaryResidenceAddress(customerDetails.getTemporaryResidenceAddress());
		customer.setPermanentAddress(customerDetails.getPermanentAddress());
		customer.setEmail(customerDetails.getEmail());
		customer.setImage(customerDetails.getImage());
		customer.setJob(customerDetails.getJob());
		customer.setCompanyName(customerDetails.getCompanyName());
		customer.setContact(customerDetails.getContact());
		customer.setContact(customerDetails.getContact());
		customer.setFatherFullName(customerDetails.getFatherFullName());
		customer.setFatherPhoneNumber(customerDetails.getFatherPhoneNumber());
		customer.setMotherFullName(customerDetails.getMotherFullName());
		customer.setMotherPhoneNumber(customerDetails.getMotherPhoneNumber());

		Customer upCustomer = customerRepository.save(customer);
		return upCustomer;
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable(value ="id") String customerId ){
		Customer customer = customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer", "id", customerId));
		customerRepository.delete(customer);
		return ResponseEntity.ok().build();
	}
}
