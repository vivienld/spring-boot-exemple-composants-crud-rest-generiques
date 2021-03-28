package fr.vivien.tuto;

import fr.vivien.tuto.animal.Animal;
import fr.vivien.tuto.animal.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/** Fichier de configuration possédant un méthode appellée après la construction du projet springboot et insérant des animaux en base de données */
@Configuration
public class PostConstructActions {

    @Autowired
    AnimalRepository repository;

    @PostConstruct
    public void generateData(){
        Arrays.asList(
                "fido","titi","panpan","felix","riri","fifi","loulou","donald","mickey"
        ).stream().forEach(name-> {
            Animal animal = new Animal();
            animal.setName(name);
            repository.save(animal);
        });
    }

}
