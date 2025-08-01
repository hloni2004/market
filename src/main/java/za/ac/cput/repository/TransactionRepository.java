package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
