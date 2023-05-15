
package com.facundogaitansegura.Portfolio.Repository;

import com.facundogaitansegura.Portfolio.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
