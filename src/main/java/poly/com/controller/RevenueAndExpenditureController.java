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

import poly.com.entitis.RevenueAndExpenditure;
import poly.com.exception.ResourceNotFoundException;
import poly.com.repository.RevenueAndExpenditureRepository;

@RestController
@RequestMapping(value = "/api")
public class RevenueAndExpenditureController {
	
	@Autowired
	RevenueAndExpenditureRepository revenueAndExpenditureRepository;
	
	@GetMapping("/revenueAndExpenditure")
	public List<RevenueAndExpenditure> getAllRevenExpen() {
		return revenueAndExpenditureRepository.findAll();
	}

	@PostMapping("/revenueAndExpenditure")
	public RevenueAndExpenditure createRevenExpen(@Valid @RequestBody RevenueAndExpenditure revenueAndExpenditure) {
		return revenueAndExpenditureRepository.save(revenueAndExpenditure);
	}

	@GetMapping("/revenueAndExpenditure/{id}")
	public RevenueAndExpenditure getRevenExpenId(@PathVariable(value = "id") String revenExpenId) {
		return revenueAndExpenditureRepository.findById(revenExpenId).orElseThrow(() -> new ResourceNotFoundException("RevenueAndExpenditure", "id", revenExpenId));
	}
	
	@PutMapping("/revenueAndExpenditure/{id}")
	public RevenueAndExpenditure updateRevenExpen(@PathVariable(value="id")String revenExpenId, @Valid @RequestBody RevenueAndExpenditure revenExpenDetails) {
		RevenueAndExpenditure revenueAndExpenditure = revenueAndExpenditureRepository.findById(revenExpenId).orElseThrow(()->new ResourceNotFoundException("RevenueAndExpenditure","id",revenExpenId));
		
		revenueAndExpenditure.setId(revenExpenDetails.getId());
		revenueAndExpenditure.setEmployee(revenExpenDetails.getEmployee());
		revenueAndExpenditure.setCustomer(revenExpenDetails.getCustomer());
		revenueAndExpenditure.setDayTrading(revenExpenDetails.getDayTrading());
		revenueAndExpenditure.setRevenue(revenExpenDetails.getRevenue());
		revenueAndExpenditure.setExpenditure(revenExpenDetails.getExpenditure());
		
		
		RevenueAndExpenditure upRevenExpen = revenueAndExpenditureRepository.save(revenueAndExpenditure);
		return upRevenExpen;
	}
	
	@DeleteMapping("/RevenueAndExpenditure/{id}")
	public ResponseEntity<?> deleteRevenExpen(@PathVariable(value ="id")String revenExpenId){
		RevenueAndExpenditure RevenueAndExpenditure = revenueAndExpenditureRepository.findById(revenExpenId).orElseThrow(()-> new ResourceNotFoundException("RevenueAndExpenditure", "id", revenExpenId));
		revenueAndExpenditureRepository.delete(RevenueAndExpenditure);
		return  ResponseEntity.ok().build();
	}

}
