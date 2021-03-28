package fr.vivien.tuto.components;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface EntityController {

    /**
     * Renvoie une réponse 200 si l'entité fournie n'est pas nulle  accompagnée de celle-ci ou pas sinon un code Http choisi
     * @param entity l'entité dont on vérifie la nullité
     * @param status le statut htttp à renvoyer si l'entité est nulle
     * @param returnEntity définit si l'on renvoie l'entité dans le corps de la réponse
     * @return la réponse correspondante
     */
    default <Entity> ResponseEntity<Entity> entityNotNull200ElseStatus(Entity entity, HttpStatus status, boolean returnEntity){
        ResponseEntity<Entity> responseError =ResponseEntity.status(status).build();
        ResponseEntity<Entity> responseOk = !returnEntity
                ? ResponseEntity.ok().build()
                : ResponseEntity.ok(entity);

        return entity == null ? responseError : responseOk;
    }
}
