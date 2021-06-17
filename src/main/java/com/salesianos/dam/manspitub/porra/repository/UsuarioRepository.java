package com.salesianos.dam.manspitub.porra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianos.dam.manspitub.porra.model.Usuario;
/**
 * Interfaz de repositorio que guarda datos de usuario
 * @author MANSPITUB
 *
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
