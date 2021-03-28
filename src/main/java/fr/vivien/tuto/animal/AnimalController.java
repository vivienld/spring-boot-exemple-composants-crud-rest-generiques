package fr.vivien.tuto.animal;

import fr.vivien.tuto.components.HasNameEntityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AnimalController est un contrôleur REST et sa route racine est "/animal".
 * Il implémente HasNameEntityController et s'enrichit donc de ses méthodes
 * */
@RestController
@RequestMapping("/animal")
public class AnimalController implements HasNameEntityController {

    @Autowired AnimalService service;

    /** AnimalService doit être un enfant de HasNameService */

    @Override
    public AnimalService getService() {
        return service;
    }
}
