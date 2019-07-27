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

import poly.com.entitis.Capital;
import poly.com.exception.ResourceNotFoundException;
import poly.com.repository.CapitalRepository;

@RestController
@RequestMapping(value = "/api")
public class CapitalController {

	@Autowired
	CapitalRepository capitalRepository;
	
	@GetMapping("/capital")
	public List<Capital> getAllCapital() {
		return capitalRepository.findAll();
	}

	@PostMapping("/capital")
	public Capital createCapital(@Valid @RequestBody Capital capital) {
		return capitalRepository.save(capital);
	}

	@GetMapping("/capital/{id}")
	public Capital getCapitalId(@PathVariable(value = "id") String capitalId) {
		return capitalRepository.findById(capitalId).orElseThrow(() -> new ResourceNotFoundException("Capital", "id", capitalId));
	}
	
	@PutMapping("/capital/{id}")
	public Capital updateCapital(@PathVariable(value="id")String capitalId, @Valid @RequestBody Capital CapitalDetails) {
		Capital capital = capitalRepository.findById(capitalId).orElseThrow(()->new ResourceNotFoundException("Capital","id",capitalId));
		
		capital.setId(CapitalDetails.getId());
		capital.setShareholder(CapitalDetails.getShareholder());
		capital.setStock(CapitalDetails.getStock());
		
		Capital upCapital = capitalRepository.save(capital);
		return upCapital;
	}
	
	@DeleteMapping("/capital/{id}")
	public ResponseEntity<?> deleteCapital(@PathVariable(value ="id")String capitalId){
		Capital capital = capitalRepository.findById(capitalId).orElseThrow(()-> new ResourceNotFoundException("Capital", "id", capitalId));
		capitalRepository.delete(capital);
		return  ResponseEntity.ok().build();
	}

}
