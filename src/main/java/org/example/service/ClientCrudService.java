package org.example.service;

import org.example.model.Client;
import jakarta.persistence.*;

import java.util.List;

public class ClientCrudService {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("spacetravel");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Client createClient(Client client) {
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
        return client;
    }

    public Client getClientById(Long id) {
        return entityManager.find(Client.class, id);
    }

    public List<Client> getAllClients() {
        return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }

    public Client updateClient(Client client) {
        entityManager.getTransaction().begin();
        entityManager.merge(client);
        entityManager.getTransaction().commit();
        return client;
    }

    public void deleteClient(Long id) {
        entityManager.getTransaction().begin();
        Client client = entityManager.find(Client.class, id);
        if (client != null) {
            entityManager.remove(client);
        }
        entityManager.getTransaction().commit();
    }

    public void deleteTicketsByClientId(Long clientId) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Ticket t WHERE t.client.id = :clientId")
                .setParameter("clientId", clientId)
                .executeUpdate();
        entityManager.getTransaction().commit();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
