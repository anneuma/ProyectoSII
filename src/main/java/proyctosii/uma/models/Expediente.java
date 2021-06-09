package proyctosii.uma.models;

import javax.persistence.*;

@Entity
public class Expediente {
    @Id
    private long num_expediente;
    private boolean activo;
    private long nota_media_provisional;
    @ManyToOne
    @JoinColumn(columnDefinition = "ENCUESTAS_ID")
    private Encuesta encuesta;

    public Expediente() {
    }

    public long getNum_expediente() {
        return num_expediente;
    }

    public void setNum_expediente(long num_expediente) {
        this.num_expediente = num_expediente;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public long getNota_media_provisional() {
        return nota_media_provisional;
    }

    public void setNota_media_provisional(long nota_media_provisional) {
        this.nota_media_provisional = nota_media_provisional;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }



    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }
}
