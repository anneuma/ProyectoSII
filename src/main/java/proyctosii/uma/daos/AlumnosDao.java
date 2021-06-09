package proyctosii.uma.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import proyctosii.uma.models.Alumno;

import java.util.List;

public interface AlumnosDao extends JpaRepository<Alumno,Integer> { }
