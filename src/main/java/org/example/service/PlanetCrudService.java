package org.example.service;

import org.example.model.Planet;
import jakarta.persistence.*;
import java.util.List;

public class PlanetCrudService {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("spacetravel");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Planet createPlanet(Planet planet) {
        entityManager.getTransaction().begin();
        entityManager.persist(planet);
        entityManager.getTransaction().commit();
        return planet;
    }

    public Planet getPlanetById(String id) {
        return entityManager.find(Planet.class, id);
    }

    public List<Planet> getAllPlanets() {
        return entityManager.createQuery("SELECT p FROM Planet p", Planet.class).getResultList();
    }

    public Planet updatePlanet(Planet planet) {
        entityManager.getTransaction().begin();
        entityManager.merge(planet);
        entityManager.getTransaction().commit();
        return planet;
    }

    public void deletePlanet(String id) {
        entityManager.getTransaction().begin();
        Planet planet = entityManager.find(Planet.class, id);
        if (planet != null) {
            entityManager.remove(planet);
        }
        entityManager.getTransaction().commit();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
