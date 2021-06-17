package com.salesianos.dam.manspitub.porra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianos.dam.manspitub.porra.model.ApuestaUsuario;

@Repository
/**
 * Interfaz de repositorio que almacena los datos de una apuesta de usuario
 * @author MANSPITUB
 *
 */
public interface ApuestaUsuarioRepository extends JpaRepository<ApuestaUsuario, Long>{

}
