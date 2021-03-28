package fr.vivien.tuto.components;

import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Interface de service que doit implémenter un service afin d'effectuer des opérations de recherche
 * sur une entité possédant une propriété "name" via son repository
 */
public interface HasNameService {
    /**
     * Cherche les entités dont le nom commence par la valeur donnée dans une liste produite par un objet de type "Pageable"
     * @param str le texte dont les entités sont sensées commencer
     * @param page le numéro de la page dont on veut les résultats
     * @param size le nombre d'entités dans la page
     * @param <Entity> le type de l'entité recherchée
     * @return une liste des entités trouvées
     */
    default <Entity> List<Entity> findByNameStartingWith(String str, int page, int size){
        return getRepository().findByNameStartingWith(str, PageRequest.of(page,size));
    }

    /**
     * Cherche les entités dont le nom contient la valeur donnée dans une liste produite par un objet de type "Pageable"
     * @param str le texte dont les entités contiennent cette valeur
     * @param page le numéro de la page dont on veut les résultats
     * @param size le nombre d'entités dans la page
     * @param <Entity> le type de l'entité recherchée
     * @return une liste des entités trouvées
     */
    default <Entity> List<Entity> findByNameContaining(String str, int page, int size){
        return getRepository().findByNameContaining(str, PageRequest.of(page,size));
    }

    /**
     * Cherche les entités dont le nom termine par la valeur donnée dans une liste produite par un objet de type "Pageable"
     * @param str le texte dont les entités sont sensées terminer
     * @param page le numéro de la page dont on veut les résultats
     * @param size le nombre d'entités dans la page
     * @param <Entity> le type de l'entité recherchée
     * @return une liste des entités trouvées
     */
    default <Entity> List<Entity> findByNameEndingWith(String str,int page, int size){
        return getRepository().findByNameEndingWith(str,PageRequest.of(page,size));
    }

    /**
     * Cherche les entités dont le nom ne contient pas la valeur donnée dans une liste produite par un objet de type "Pageable"
     * @param str le texte dont les entités ne contiennent pas la valeur
     * @param page le numéro de la page dont on veut les résultats
     * @param size le nombre d'entités dans la page
     * @param <Entity> le type de l'entité recherchée
     * @return une liste des entités trouvées
     */
    default <Entity> List<Entity> findByNameNotContaining(String str, int page, int size){
        return getRepository().findByNameNotContaining(str, PageRequest.of(page,size));
    }

    /**
     * @return le repository responsable de lier l'entité avec la base de données qui possède les méthodes de recherche sur la propriété "name" de son entité liée
     */
    HasNameRepository getRepository();
}
