package br.com.lan.persistencia;

import java.util.List;

import javax.persistence.EntityManager;

public interface PersistenciaDao<E> {

	public E salvar(E entity) throws Exception;
	
	public List<E> listar();
	
	public E buscarPorId(int id);
	
	public void excluir(E entity) throws Exception;
	
	public EntityManager getEntityManager();
}	
	
