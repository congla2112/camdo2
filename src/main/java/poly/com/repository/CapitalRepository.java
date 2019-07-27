package poly.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.com.entitis.Capital;

@Repository
public interface CapitalRepository extends JpaRepository<Capital, String> {

}
