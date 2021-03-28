package fr.vivien.tuto.components;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * interface dont doit hériter le repository qui voudrait effectuer des opérations de recherche sur une entité qui possède une propriété "name"
 */
@NoRepositoryBean
public interface HasNameRepository {
    <Entity> List<Entity> findByNameStartingWith(String name, Pageable pageable);
    <Entity> List<Entity> findByNameContaining(String name, Pageable pageable);
    <Entity> List<Entity> findByNameEndingWith(String name,Pageable pageable);
    <Entity> List<Entity> findByNameNotContaining(String name, Pageable pageable);
}
