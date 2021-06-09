package proyctosii.uma.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import proyctosii.uma.models.Matricula;

public interface MatriculaDao extends JpaRepository<Matricula,Integer> {
}
