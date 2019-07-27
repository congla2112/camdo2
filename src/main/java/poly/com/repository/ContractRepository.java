package poly.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.com.entitis.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, String> {

}
