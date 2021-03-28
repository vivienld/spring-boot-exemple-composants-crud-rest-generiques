package fr.vivien.tuto.animal;

import fr.vivien.tuto.components.HasNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** AnimalService implémente HasNameService et doit obligatoirement implémenter la méthode getRepository
 * pour que HasNameService sache quel est le repository qui possède les méthodes de recherche sur le nom de l'animal.
 *
 * */
@Service
public class AnimalService implements HasNameService {

    @Autowired AnimalRepository repository;

    /** AnimalRepository doit être un enfant de HasNameRepository */
    @Override
    public AnimalRepository getRepository() {
        return repository;
    }
}
