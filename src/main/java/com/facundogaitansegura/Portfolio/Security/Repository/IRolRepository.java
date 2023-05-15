package com.facundogaitansegura.Portfolio.Security.Repository;

import com.facundogaitansegura.Portfolio.Security.Entity.Rol;
import com.facundogaitansegura.Portfolio.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre (RolNombre rolNombre);
}
