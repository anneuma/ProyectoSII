package proyctosii.uma.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import proyctosii.uma.models.Expediente;

public interface ExpedienteDao extends JpaRepository<Expediente,Integer> {
}
