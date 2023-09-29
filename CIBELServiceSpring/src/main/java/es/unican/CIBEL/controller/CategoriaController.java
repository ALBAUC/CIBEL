package es.unican.CIBEL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.unican.CIBEL.domain.Categoria;
import es.unican.CIBEL.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> getCategorias() {
		return categoriaService.categorias();
	}
	
	@GetMapping("/apps")
	public List<Categoria> getCategoriasDeApps() {
		return categoriaService.categoriasDeApps();
	}
	
	@GetMapping("/dispositivos")
	public List<Categoria> getCategoriasDeDispositivos() {
		return categoriaService.categoriasDeDispositivos();
	}
}
