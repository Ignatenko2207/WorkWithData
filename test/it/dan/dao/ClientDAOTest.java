package it.dan.dao;

import org.junit.Ignore;
import org.junit.Test;
import it.dan.model.Client;
import static org.junit.Assert.*;

public class ClientDAOTest
{

	@Test public void saveAndGet()
	{
		Client client = new Client();

		client.setLogin("testLogin3");
		client.setPassword("12345");
		client.setFirstName("Alex");
		client.setSecondName("Ignatenko");

		ClientDAO clientDAO = new ClientDAO();
		clientDAO.save(client);

		Client clientFromDB = clientDAO.get(client.getLogin());

		assertNotNull(clientFromDB);
		assertEquals(client.getFirstName(), clientFromDB.getFirstName());

		clientDAO.delete(client.getLogin());

		Client deletedClient = clientDAO.get(client.getLogin());

		assertNull(deletedClient);
	}

	@Ignore
	@Test
	public void update()
	{
	}

	@Ignore
	@Test
	public void delete()
	{
	}
}