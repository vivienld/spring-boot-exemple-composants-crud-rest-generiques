package fr.vivien.tuto.components;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Interface que doit implémenter un contrôleur afin d'effectuer des opérations de recherche sur une entité qui possède une propriété "name"
 */
public interface HasNameEntityController extends EntityController {

    /**
     * Lie la route "/" avec la méthode "GET" vers le service responsable de chercher les entités
     * dont le nom commence par le texte donné dans un interval produit par un objet de type "Pageable".
     * Si l'on cherche 25 entités par page alors on note pour les 25 premières entités page=0 et size=25
     * @param name_starts_with le paramètre de type "String" qui permet de chercher les entités dont le nom commence par sa valeur
     * @param page la page dans laquelle on cherche les entités
     * @param size le nombre d'entités que l'on cherche dans la page
     * @param <Entity> Le Type des entités que l'on cherche
     *
     * @return une liste contenant les entités trouvées
     */
    @RequestMapping(value = "", params={"name_starts_with","page","size"}, method = RequestMethod.GET)
    default <Entity> ResponseEntity<List<Entity>> findByNameStartingWith(@RequestParam String name_starts_with, @RequestParam int page, @RequestParam int size){
        return entityNotNull200ElseStatus(getService().findByNameStartingWith(name_starts_with, page,size), HttpStatus.NOT_FOUND,true);
    }

    /**
     * Lie la route "/" avec la méthode "GET" vers le service responsable de chercher les entités
     * dont le nom contient le texte donné dans un interval produit par un objet de type "Pageable".
     * Si l'on cherche 25 entités par page alors on note pour les 25 premières entités page=0 et size=25
     * @param name_contains le paramètre de type "String" qui permet de chercher les entités dont le nom contient sa valeur
     * @param page la page dans laquelle on cherche les entités
     * @param size le nombre d'entités que l'on cherche dans la page
     * @param <Entity> Le Type des entités que l'on cherche
     *
     * @return une liste contenant les entités trouvées
     */
    @RequestMapping(value = "", params={"name_contains","page","size"}, method = RequestMethod.GET)
    default <Entity> ResponseEntity<List<Entity>> findByNameContaining(@RequestParam String name_contains, @RequestParam int page,@RequestParam int size){
        return entityNotNull200ElseStatus(getService().findByNameContaining(name_contains,page,size),HttpStatus.NOT_FOUND,true);
    }

    /**
     * Lie la route "/" avec la méthode "GET" vers le service responsable de chercher les entités
     * dont le nom termine par le texte donné dans un interval produit par un objet de type "Pageable".
     * Si l'on cherche 25 entités par page alors on note pour les 25 premières entités page=0 et size=25
     * @param name_ends_with le paramètre de type "String" qui permet de chercher les entités dont le nom termine par sa valeur
     * @param page la page dans laquelle on cherche les entités
     * @param size le nombre d'entités que l'on cherche dans la page
     * @param <Entity> Le Type des entités que l'on cherche
     *
     * @return une liste contenant les entités trouvées
     */
    @RequestMapping(value = "", params={"name_ends_with","page","size"}, method = RequestMethod.GET)
    default <Entity> ResponseEntity<List<Entity>> findByNameEndingWith(@RequestParam String name_ends_with,@RequestParam int page,@RequestParam int size){
        return entityNotNull200ElseStatus(getService().findByNameEndingWith(name_ends_with,page,size),HttpStatus.NOT_FOUND,true);
    }

    /**
     * Lie la route "/" avec la méthode "GET" vers le service responsable de chercher les entités
     * dont le nom ne contient pas le texte donné dans un interval produit par un objet de type "Pageable".
     * Si l'on cherche 25 entités par page alors on note pour les 25 premières entités page=0 et size=25
     * @param name_contains_not le paramètre de type "String" qui permet de chercher les entités dont le nom ne contient pas sa valeur
     * @param page la page dans laquelle on cherche les entités
     * @param size le nombre d'entités que l'on cherche dans la page
     * @param <Entity> Le Type des entités que l'on cherche
     *
     * @return une liste contenant les entités trouvées
     */
    @RequestMapping(value = "", params={"name_contains_not","page","size"}, method = RequestMethod.GET)
    default <Entity> ResponseEntity<List<Entity>> findByNameNotContaining(@RequestParam String name_contains_not, @RequestParam int page,@RequestParam int size){
        return entityNotNull200ElseStatus(getService().findByNameNotContaining(name_contains_not,page,size),HttpStatus.NOT_FOUND,true);
    }

    /**
     *
     * @return le service responsable des opérations de recherche
     */
    HasNameService getService();
}
