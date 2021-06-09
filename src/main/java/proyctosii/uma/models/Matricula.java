package proyctosii.uma.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Matricula {
    @Id
    private long id;
    private String cursoAcademico;
    private Date fechaMatricula;
    private boolean nuevoIngreso;
    private long num_archivo;
    private String turnoPreferente;

    public Matricula() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCursoAcademico() {
        return cursoAcademico;
    }

    public void setCursoAcademico(String cursoAcademico) {
        this.cursoAcademico = cursoAcademico;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public boolean isNuevoIngreso() {
        return nuevoIngreso;
    }

    public void setNuevoIngreso(boolean nuevoIngreso) {
        this.nuevoIngreso = nuevoIngreso;
    }

    public long getNum_archivo() {
        return num_archivo;
    }

    public void setNum_archivo(long num_archivo) {
        this.num_archivo = num_archivo;
    }

    public String getTurnoPreferente() {
        return turnoPreferente;
    }

    public void setTurnoPreferente(String turnoPreferente) {
        this.turnoPreferente = turnoPreferente;
    }
}
