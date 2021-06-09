package proyctosii.uma.models;

import org.springframework.context.annotation.Primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AlumnoExpediente {
    @Id
    private long Alumno_id;
    private long expedientes_NUM_EXPEDIENTE;

    public AlumnoExpediente() {
    }

    public long getAlumno_id() {
        return Alumno_id;
    }

    public void setAlumno_id(long alumno_id) {
        Alumno_id = alumno_id;
    }

    public long getExpedientes_NUM_EXPEDIENTE() {
        return expedientes_NUM_EXPEDIENTE;
    }

    public void setExpedientes_NUM_EXPEDIENTE(long expedientes_NUM_EXPEDIENTE) {
        this.expedientes_NUM_EXPEDIENTE = expedientes_NUM_EXPEDIENTE;
    }
}
