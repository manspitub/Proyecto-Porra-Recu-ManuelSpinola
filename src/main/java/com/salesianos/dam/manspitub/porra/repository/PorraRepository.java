package com.salesianos.dam.manspitub.porra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianos.dam.manspitub.porra.model.Porra;
/**
 * Interfaz de repositorio que guarda los datos de una porra
 * @author MANSPITUB
 *
 */
@Repository
public interface PorraRepository extends JpaRepository<Porra, Long>{

}
