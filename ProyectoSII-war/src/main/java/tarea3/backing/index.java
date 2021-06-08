package tarea3.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import tarea1.jpa.Grupo;
import tarea1.jpa.Titulacion;
import tarea2.ejb.GestionGrupo;
import tarea2.ejb.GestionTitulacion;
import tarea2.exception.ProyectoException;
import tarea3.backing.grupos.Modo;

@Named(value = "Index")
@RequestScoped
public class index {
	@Inject
	private GestionGrupo grupoEJB;

	@Inject
	private GestionTitulacion titulacionEJB;

	public static enum Modo {
		BBDD, NOACCION;
	};

	public index() {
		modo = Modo.NOACCION;
	}

	private Modo modo;

	public Modo getModo() {
		return modo;
	}

	public void setModo(Modo modo) {
		this.modo = modo;
	}

	public String getAccion() {
		switch (modo) {
		case BBDD:
			return "bbdd";
		}
		return null;
	}

	public String actualizar() {
		setModo(Modo.BBDD);

		try {
			Grupo grupo1A = new Grupo((long) 1, "Primero", "A", "Mañana", false, true, true, (long) 42);
			Grupo grupo2A = new Grupo((long) 2, "Segundo", "A", "Mañana", false, true, true, (long) 42);
			Grupo grupo3C = new Grupo((long) 3, "Tercero", "C", "Tarde", false, true, true, (long) 24);
			Titulacion informatica = new Titulacion((long) 1, "Ingenieria Informática", 240);
			Titulacion computadores = new Titulacion((long) 2, "Ingenieria de Computadores", 240);
			titulacionEJB.insertarTitulacion(informatica);
			titulacionEJB.insertarTitulacion(computadores);
			grupoEJB.insertarGrupo(grupo1A, (long) 1);
			grupoEJB.insertarGrupo(grupo2A, (long) 1);
			grupoEJB.insertarGrupo(grupo3C, (long) 2);
			return "grupos.xhtml";
			/*
			switch (modo) {
			case BBDD:
				
				Grupo grupo1A = new Grupo((long) 1, "Primero", "A", "Mañana", false, true, true, (long) 42);
				Grupo grupo2A = new Grupo((long) 2, "Segundo", "A", "Mañana", false, true, true, (long) 42);
				Grupo grupo3C = new Grupo((long) 2, "Tercero", "C", "Tarde", false, true, true, (long) 24);
				Titulacion informatica = new Titulacion((long) 1, "Ingenieria Informática", 240);
				Titulacion computadores = new Titulacion((long) 2, "Ingenieria de Computadores", 240);
				titulacionEJB.insertarTitulacion(informatica);
				titulacionEJB.insertarTitulacion(computadores);
				grupoEJB.insertarGrupo(grupo1A, (long) 1);
				grupoEJB.insertarGrupo(grupo2A, (long) 1);
				grupoEJB.insertarGrupo(grupo3C, (long) 2);
				
				break;
				}
				*/
			
		} catch (ProyectoException e) {
			return "index.xhtml";
		}
	}
}
