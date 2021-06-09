package proyctosii.uma.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Titulacion {
    @Id
    private long codigo;
    private int creditos;
    private String nombre;
    private long titulation_codigo;

    public Titulacion() {
    }

    public Titulacion(long codigo, int creditos, String nombre, long titulation_codigo) {
        this.codigo = codigo;
        this.creditos = creditos;
        this.nombre = nombre;
        this.titulation_codigo = titulation_codigo;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTitulation_codigo() {
        return titulation_codigo;
    }

    public void setTitulation_codigo(long titulation_codigo) {
        this.titulation_codigo = titulation_codigo;
    }
}
