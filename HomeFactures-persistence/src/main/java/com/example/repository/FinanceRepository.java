package com.example.repository;




import com.example.model.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceRepository extends JpaRepository<Finance, Integer> {

}
