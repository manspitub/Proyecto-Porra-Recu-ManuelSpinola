package com.salesianos.dam.manspitub.porra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianos.dam.manspitub.porra.model.ApuestaUsuario;

@Repository
public interface ApuestaUsuarioRepository extends JpaRepository<ApuestaUsuario, Long>{

}
