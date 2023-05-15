package com.facundogaitansegura.Portfolio.Repository;

import com.facundogaitansegura.Portfolio.Entity.Banner;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RBanner extends JpaRepository<Banner, Integer>{
    public Optional<Banner> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}

