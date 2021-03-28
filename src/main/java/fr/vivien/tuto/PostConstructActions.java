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
                "snoopy", "tina", "sam", "sally", "ulysse", "chipie", "rocky", "roxane", "max", "princesse", "lady",
                "oscar", "ugo", "tequila", "simba", "ramses", "teddy", "titus", "maya", "tania", "samy", "filou",
                "tomy", "lucky", "junior", "socrate", "vanille", "gribouille", "choupette", "nina", "sandy", "saphir",
                "tara", "lola", "romeo", "roxy", "stella", "prince", "belle", "tom", "tyson", "pacha", "reglisse",
                "scotty", "rusty", "caramel", "roxanne", "benji", "milou", "paco", "sacha", "tommy", "caline", "oliver",
                "sultan", "theo", "rex", "scott", "nougat", "roucky", "samba", "tess", "théo", "luna", "nicky",
                "praline", "titeuf", "topaze", "enzo", "kenzo", "noisette", "ruby", "saxo", "oceane", "sweety", "tessy",
                "titan", "voyou", "charly", "leo", "spike", "stan", "suzy", "tango", "léo", "perle", "prisca", "sissi",
                "whisky", "dolly", "popeye", "rita", "taz", "titi", "fanny", "felix", "nala", "roméo", "toby",
                "twist"
        ).stream().forEach(name-> {
            Animal animal = new Animal();
            animal.setName(name);
            repository.save(animal);
        });
    }

}
