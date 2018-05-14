package it.dan;

import it.dan.dao.ClientDAO;
import it.dan.model.Client;

public class ApplicationRunner
{

    public static void main(String[] args) {

        Client client = new Client();

        client.setLogin("testLogin");
        client.setPassword("12345");
        client.setFirstName("Alex");
        client.setSecondName("Ignatenko");

        ClientDAO.save(client);
    }
}
