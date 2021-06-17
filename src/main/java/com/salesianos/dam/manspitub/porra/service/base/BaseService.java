package com.salesianos.dam.manspitub.porra.service.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Clase con métodos básicos para la gestión de las entidades
 * @author MANSPITUB
 *
 * @param <T>
 * @param <ID>
 * @param <R>
 */

public abstract class BaseService<T, ID, R extends JpaRepository<T, ID>> {
	
	@Autowired
	protected R repository;
	
	/**
	 * Guarda una entidad
	 * @param t
	 * @return
	 */
	public T save(T t) {
		return repository.save(t);
		}
	/**
	 * Edita una entidad
	 * @param t
	 * @return
	 */
	public T edit(T t) {
		return save(t);
	}
	/**
	 * Borra una entidad
	 * @param t
	 */
	public void delete(T t) {
		repository.delete(t);
	}
	/**
	 * Borra una entidad por el parámetro id
	 * @param id
	 */
	public void deleteById(ID id) {
		repository.deleteById(id);
	}
	/**
	 * Busca todos los elementos de la lista
	 * @return
	 */
	public List<T> findAll(){
		return repository.findAll();
	}
	
	/**
	 * Busca una entidad por parámetro id
	 * @param id
	 * @return
	 */
	public Optional<T> findById(ID id){
		return repository.findById(id);
	}
	
	
}
