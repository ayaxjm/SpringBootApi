package com.springbootapirest.springbootapirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootapirest.springbootapirest.Entities.Productos;

@Repository
public interface ProductoRepository extends JpaRepository<Productos, Long>{

}
