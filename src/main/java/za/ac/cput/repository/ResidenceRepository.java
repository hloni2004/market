package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.cput.domain.Residence;
@Repository
public interface ResidenceRepository extends JpaRepository<Residence, Long> {
}
