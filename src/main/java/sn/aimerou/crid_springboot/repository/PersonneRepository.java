package sn.aimerou.crid_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.aimerou.crid_springboot.entity.Personne;

public interface PersonneRepository extends JpaRepository <Personne, Long>{

    
} 