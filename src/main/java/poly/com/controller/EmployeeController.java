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

import poly.com.entitis.Employee;
import poly.com.exception.ResourceNotFoundException;
import poly.com.repository.EmployeeRepository;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/employee")
	public List<Employee> getAllEmp() {
		return employeeRepository.findAll();
	}

	@PostMapping("/employee")
	public Employee createEmp(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@GetMapping("/employee/{id}")
	public Employee getEmpId(@PathVariable(value = "id") String empId) {
		return employeeRepository.findById(empId).orElseThrow(() -> new poly.com.exception.ResourceNotFoundException("Employee", "id", empId));
	}
	
	@PutMapping("employee/{id}")
	public Employee updateEmp(@PathVariable(value="id")String empId, @Valid @RequestBody Employee empDetails) {
		Employee employee = employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee","id",empId));
		
		employee.setId(empDetails.getId());
		employee.setUsername(empDetails.getUsername());
		employee.setPassword(empDetails.getPassword());
		employee.setFullname(empDetails.getFullname());
		employee.setGender(empDetails.getGender());
		employee.setBirth(empDetails.getBirth());
		employee.setPhone(empDetails.getPhone());
		employee.setPeopleID(empDetails.getPeopleID());
		employee.setIssuedDate(empDetails.getIssuedDate());
		employee.setReleaseLocation(empDetails.getReleaseLocation());
		employee.setTemporaryResidenceAddress(empDetails.getTemporaryResidenceAddress());
		employee.setEmail(empDetails.getEmail());
		employee.setImage(empDetails.getImage());
		
		Employee upEmployee = employeeRepository.save(employee);
		return upEmployee;
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> deleteEmp(@PathVariable(value ="id")String empId){
		Employee employee = employeeRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee", "id", empId));
		employeeRepository.delete(employee);
		return  ResponseEntity.ok().build();
	}

}
