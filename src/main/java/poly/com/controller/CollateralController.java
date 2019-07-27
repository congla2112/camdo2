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

import poly.com.entitis.Collateral;
import poly.com.exception.ResourceNotFoundException;
import poly.com.repository.CollateralRepository;

@RestController
@RequestMapping(value ="/api")
public class CollateralController {
	
	@Autowired
	CollateralRepository collateralRepository;
	
	@GetMapping("/collateral")
	public List<Collateral> getAllColl(){
		return collateralRepository.findAll();
	}
	
	@PostMapping("/collateral")
	public Collateral createColl(@Valid @RequestBody Collateral collateral) {
		return collateralRepository.save(collateral);
	}
	
	@GetMapping("/collateral/{id}")
	public Collateral updateColl(@PathVariable(value = "id") String collId) {
		return collateralRepository.findById(collId).orElseThrow(()-> new ResourceNotFoundException("Collateral","id", collId));
	}
	
	@PutMapping("/collateral/{id}")
	public Collateral updateColl(@PathVariable(value ="id") String collId,@Valid @RequestBody Collateral collDetails) {
		Collateral collateral = collateralRepository.findById(collId).orElseThrow(() -> new ResourceNotFoundException("Collaterale", "id", collId));
		
		collateral.setId(collDetails.getId());
		collateral.setCollateralName(collDetails.getCollateralName());
		collateral.setCollateralStyle(collDetails.getCollateralStyle());
		collateral.setStatus(collDetails.getStatus());
		collateral.setNote(collDetails.getNote());
		collateral.setImage(collDetails.getImage());
		
		Collateral upCollateral = collateralRepository.save(collateral);
		return upCollateral;
	}
	
	@DeleteMapping("/collateral/{id}")
	public ResponseEntity<?> deleteColl(@PathVariable(value ="id")String collId){
		Collateral collateral = collateralRepository.findById(collId).orElseThrow(()-> new ResourceNotFoundException("Collateral", "id", collId));
		collateralRepository.delete(collateral);
		return ResponseEntity.ok().build();
	}
	

}
