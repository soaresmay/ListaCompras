package br.edu.ifal.compras;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepositorio extends JpaRepository<Item, Long>{
    
}