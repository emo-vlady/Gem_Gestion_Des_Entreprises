package cm.cti.entreprise.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.cti.entreprise.Exception.DAOException;
import cm.cti.entreprise.Exception.FormValidationException;
import cm.cti.entreprise.Repositories.EntrepriseRepository;
import cm.cti.entreprise.Service.EntrepriseIService;
import cm.cti.entreprise.models.Entreprise;
import jakarta.persistence.NoResultException;

@Service 
public class EntrepriseService implements EntrepriseIService{


	@Autowired
	private EntrepriseRepository repository;
	
	@Override
	public List<Entreprise> getAll() throws DAOException {
		try {
			return repository.findAll();
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		} catch (NoResultException e) {
			return new ArrayList<>();
		}
	}

	@Override
	public void add(Entreprise entity) throws DAOException {
		try {
			entity.setId(null);
			repository.save(entity);
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void update(Entreprise entity) throws DAOException {
		try {
			repository.save(entity);
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void delete(Long id) throws DAOException {
		try {
			repository.delete(find(id));
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public Entreprise find(Long id) throws DAOException {
		try {
			return repository.findById(id).get();
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public void saveAll(Iterable<Entreprise> iterable) throws DAOException {
		try {
			repository.saveAll(iterable);
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public Entreprise findId(Long id) throws FormValidationException {
		try {
			return repository.findById(id).get();
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		} catch (NoSuchElementException e) {
			throw new FormValidationException(e.getMessage());
		}
	}

}
