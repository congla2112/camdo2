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

import poly.com.entitis.Contract;
import poly.com.exception.ResourceNotFoundException;
import poly.com.repository.ContractRepository;

@RestController
@RequestMapping(value="/api")
public class ContractController {
	
	@Autowired
	ContractRepository  contractRepository;
	
	@GetMapping("/contract")
	public List<Contract> getAllContract() {
		return contractRepository.findAll();
	}

	@PostMapping("/contract")
	public Contract createContract(@Valid @RequestBody Contract contract) {
		return contractRepository.save(contract);
	}

	@GetMapping("/contract/{id}")
	public Contract getContractId(@PathVariable(value = "id") String ContrId) {
		return contractRepository.findById(ContrId).orElseThrow(() -> new ResourceNotFoundException("Contract", "id", ContrId));
	}
	
	@PutMapping("/contract/{id}")
	public Contract updateContract(@PathVariable(value="id")String ContrId, @Valid @RequestBody Contract contractDetails) {
		Contract contract = contractRepository.findById(ContrId).orElseThrow(()->new ResourceNotFoundException("Contract", "id", ContrId));
		
		contract.setId(contractDetails.getId());
		contract.setCustomerName(contractDetails.getCustomerName());
		contract.setCollateralName(contractDetails.getCollateralName());
		contract.setMoney(contractDetails.getMoney());
		contract.setLoanDay(contractDetails.getLoanDay());
		contract.setInterestRate(contractDetails.getInterestRate());
		contract.setMonthlyInterest(contractDetails.getMonthlyInterest());
		contract.setEmployyeName(contractDetails.getEmployyeName());
		contract.setStutas(contractDetails.getStutas());
		contract.setMessage(contractDetails.getMessage());
		
		Contract upContract = contractRepository.save(contract);
		return upContract;
	}
	
	@DeleteMapping("/contract/{id}")
	public ResponseEntity<?> deleteContract(@PathVariable(value ="id")String ContrId){
		Contract conntract = contractRepository.findById(ContrId).orElseThrow(()-> new ResourceNotFoundException("Contract", "id", ContrId));
		contractRepository.delete(conntract);
		return  ResponseEntity.ok().build();
	}

}
