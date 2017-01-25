package br.com.lan.persistencia;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PersistenciaDaoJpa<E> implements PersistenciaDao<E> {

	private Class<E> entity;
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public PersistenciaDaoJpa() {
		Type type = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) type;
		entity = (Class<E>) pt.getActualTypeArguments()[0];
	}
	
	public final void setEntity(Class<E> entity) {
		this.entity = entity;
	}

	public E salvar(E entity) throws Exception {
		this.em.persist(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<E> listar() {
		return em.createQuery("SELECT e FROM " + entity.getName() + " e").getResultList();
	}

	public E buscarPorId(int id) {
		return (E) em.find(entity, id);
	}

	public void excluir(E entity) throws Exception {
		entity = em.merge(entity);
		em.remove(entity);
	}
	
	public EntityManager getEntityManager(){
		return em;
	}
	

}
