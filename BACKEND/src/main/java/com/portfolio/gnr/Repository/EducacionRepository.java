package com.portfolio.gnr.Repository;

import com.portfolio.gnr.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Integer> {

    public Optional<Educacion> findByNombreEdu(String nombreEdu);

    public boolean existsByNombreEdu(String nombreEdu);
}
