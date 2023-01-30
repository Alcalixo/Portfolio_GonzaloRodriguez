
package com.portfolio.gnr.Repository;

import com.portfolio.gnr.Entity.HardSoftSkill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HardSoftSkillRepository extends JpaRepository<HardSoftSkill, Integer>{
    Optional<HardSoftSkill> findByNombreS (String nombreS);
    public boolean existsByNombreS (String nombreS);
    
}
