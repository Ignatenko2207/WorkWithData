package it.dan;

import it.dan.dao.ClientDAO;
import it.dan.model.Client;

public class ApplicationRunner
{

    public static void main(String[] args) {

        Client client = new Client();

        String name = "Alex";
        client.setLogin("testLogin2");
        client.setPassword("12345");
        client.setFirstName(name);
        client.setSecondName("Ignatenko");

        ClientDAO clDao = new ClientDAO();
        clDao.save(client);
        clDao.delete(name);


    }
}
