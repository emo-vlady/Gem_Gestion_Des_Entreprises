 package cm.cti.entreprise.Service;

import java.util.List;

import cm.cti.entreprise.Exception.DAOException;
import cm.cti.entreprise.Exception.FormValidationException;

public interface ICrudService<T, ID> {
	List<T> getAll() throws DAOException;
	void add(T entity) throws DAOException;
	void update(T entity) throws DAOException;
	void delete(ID id) throws DAOException;
	T find(ID id)throws DAOException;
	void saveAll(Iterable<T> iterable) throws DAOException;
	T findId(Long id) throws FormValidationException;
}
