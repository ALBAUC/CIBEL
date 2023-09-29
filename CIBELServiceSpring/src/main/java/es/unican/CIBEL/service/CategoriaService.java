package es.unican.CIBEL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.unican.CIBEL.CIBELConstants;
import es.unican.CIBEL.domain.Categoria;
import es.unican.CIBEL.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> categorias() {
		return repository.findAll();
	}
	
	public List<Categoria> categoriasDeApps() {
		return repository.findAllByTipo(CIBELConstants.APP);
	}
	
	public List<Categoria> categoriasDeDispositivos() {
		return repository.findAllByTipo(CIBELConstants.DISPOSITIVO_IOT);
	}
	
	public Categoria buscaCategoria(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public Categoria buscaCategoriaPorNombre(String nombre) {
		return repository.findByNombre(nombre);
	}
}
