package org.example;
import org.example.model.Client;
import org.example.model.Planet;
import org.example.service.ClientCrudService;
import org.example.service.PlanetCrudService;
import org.flywaydb.core.Flyway;

public class Main {

    public static void migrate() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:C:\\Users\\mrbob\\Desktop\\Dz-12-course\\stdb", "sa", "123")
                .locations("filesystem:src/main/resources/db/migration")
                .load();
        flyway.migrate();
    }


    public static void main(String[] args) {


        migrate();

        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();


        org.example.model.Client newClient = new org.example.model.Client();
        newClient.setName("Elon Musk");
        clientCrudService.createClient(newClient);


        org.example.model.Client client = clientCrudService.getClientById(1L);
        System.out.println(client.getName());


        client.setName("Elon R. Musk");
        clientCrudService.updateClient(client);


        clientCrudService.getAllClients().forEach(c -> System.out.println(c.getName()));


        Planet newPlanet = new Planet();
        planetCrudService.deletePlanet("MOON");
        newPlanet.setId("MOON");
        newPlanet.setName("Moon");
        planetCrudService.createPlanet(newPlanet);


        Planet planet = planetCrudService.getPlanetById("MOON");
        System.out.println(planet.getName());

        clientCrudService.deleteTicketsByClientId(1L);


        clientCrudService.deleteClient(1L);
        planetCrudService.deletePlanet("MOON");


        clientCrudService.close();
        planetCrudService.close();

    }
}
