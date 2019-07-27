package poly.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.com.entitis.Collateral;

@Repository
public interface CollateralRepository extends JpaRepository<Collateral, String> {

}
