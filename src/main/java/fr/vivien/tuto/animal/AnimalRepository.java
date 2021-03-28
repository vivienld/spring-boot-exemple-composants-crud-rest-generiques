package fr.vivien.tuto.animal;

import fr.vivien.tuto.components.HasNameRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** AnimalRepository étend JpaRepository et HasNameRepository pour s'enrirchir de ses méthodes */
@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long>, HasNameRepository {
}
