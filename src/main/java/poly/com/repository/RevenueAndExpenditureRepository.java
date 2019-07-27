package poly.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.com.entitis.RevenueAndExpenditure;

@Repository
public interface RevenueAndExpenditureRepository extends JpaRepository<RevenueAndExpenditure, String> {

}
