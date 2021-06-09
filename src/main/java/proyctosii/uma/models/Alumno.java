package proyctosii.uma.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Alumno {

    @Id
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email_i;
    private String email_p;
    private int movil;
    private String provincia;
    private long telefono;
    private String cp;
    private String dni;
    private String direccion;
    public String getLocalidad() {
        return localidad;
    }

    private String localidad;

    public Alumno(int id, String nombre, String apellido1, String apellido2, String direction, String email_i, String email_p, int movil, String provincia, long telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email_i = email_i;
        this.email_p = email_p;
        this.movil = movil;
        this.provincia = provincia;
        this.telefono = telefono;
    }

    public Alumno() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }



    public String getEmail_i() {
        return email_i;
    }

    public void setEmail_i(String email_i) {
        this.email_i = email_i;
    }

    public String getEmail_p() {
        return email_p;
    }

    public void setEmail_p(String email_p) {
        this.email_p = email_p;
    }

    public int getMovil() {
        return movil;
    }

    public void setMovil(int movil) {
        this.movil = movil;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setLocalidad(String localidad) {
        this.localidad=localidad;
    }
}

