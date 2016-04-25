package br.si.es.sga.dao;

import java.util.List;

import br.si.es.sga.exeception.PersistenciaException;


public interface GenericDAO<T> {
void inserir(T obj) throws PersistenciaException;
	
	void atualizar(T obj)throws PersistenciaException;
	
	void deletar(Integer id)throws PersistenciaException;
	
	List<T> listarTodos()throws PersistenciaException;
	
	T buscarPorId(Integer id)throws PersistenciaException;
}
