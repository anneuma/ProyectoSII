package proyctosii.uma.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Assignatura {
    @Id
    private long referencia;
    private String Dtype;
    private String caracter;
    private long codigo;
    private int creditos_practicos;
    private int creditos_teoricos;
    private int creditos_totales;
    private String curso;
    private String idiomas;
    private String nombre;
    private int oferta;
    private String unidata_temporal;
    private long asignatura_matricula_id;
    private String horaInicio;
    private String dia;
    private int plaza;

    public Assignatura() {
    }

    public Assignatura(long referencia, String dtype, String caracter, long codigo, int creditos_practicos, int creditos_teoricos, int creditos_totales, String curso, String idiomas, String nombre, int oferta, String unidata_temporal, long asignatura_matricula_id, String horaInicio, String dia, int plaza) {
        this.referencia = referencia;
        Dtype = dtype;
        this.caracter = caracter;
        this.codigo = codigo;
        this.creditos_practicos = creditos_practicos;
        this.creditos_teoricos = creditos_teoricos;
        this.creditos_totales = creditos_totales;
        this.curso = curso;
        this.idiomas = idiomas;
        this.nombre = nombre;
        this.oferta = oferta;
        this.unidata_temporal = unidata_temporal;
        this.asignatura_matricula_id = asignatura_matricula_id;
        this.horaInicio = horaInicio;
        this.dia = dia;
        this.plaza = plaza;
    }

    public long getReferencia() {
        return referencia;
    }

    public void setReferencia(long referencia) {
        this.referencia = referencia;
    }

    public String getDtype() {
        return Dtype;
    }

    public void setDtype(String dtype) {
        Dtype = dtype;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public int getCreditos_practicos() {
        return creditos_practicos;
    }

    public void setCreditos_practicos(int creditos_practicos) {
        this.creditos_practicos = creditos_practicos;
    }

    public int getCreditos_teoricos() {
        return creditos_teoricos;
    }

    public void setCreditos_teoricos(int creditos_teoricos) {
        this.creditos_teoricos = creditos_teoricos;
    }

    public int getCreditos_totales() {
        return creditos_totales;
    }

    public void setCreditos_totales(int creditos_totales) {
        this.creditos_totales = creditos_totales;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getOferta() {
        return oferta;
    }

    public void setOferta(int oferta) {
        this.oferta = oferta;
    }

    public String getUnidata_temporal() {
        return unidata_temporal;
    }

    public void setUnidata_temporal(String unidata_temporal) {
        this.unidata_temporal = unidata_temporal;
    }

    public long getAsignatura_matricula_id() {
        return asignatura_matricula_id;
    }

    public void setAsignatura_matricula_id(long asignatura_matricula_id) {
        this.asignatura_matricula_id = asignatura_matricula_id;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getPlaza() {
        return plaza;
    }

    public void setPlaza(int plaza) {
        this.plaza = plaza;
    }
}

