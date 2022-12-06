package daos;

import models.Pet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class PetDAOTest {
    PetDAO petDAO;

    @Before
    public void init(){
        petDAO = new PetDAO();
    }
    @Test
    public void findAllTest() throws SQLException {
        List<Pet> petList = petDAO.findAll();
        Assert.assertNotNull(petList);
    }

    @Test
    public void updateTest() throws SQLException {
        String expected = "mitty";

        Pet pet = new Pet ( "mitty", 2, "cat", "gray", "meow", 1);
        petDAO.update(pet);
        String actual = petDAO.findAll().get(0).getName();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void createTest() throws SQLException {
        int expected = petDAO.findAll().size() + 1;
        Pet pet = new Pet("Jacques", 4, "axolotl", "pink", "burp burp", 6);
        petDAO.create(pet);
        int actual = petDAO.findAll().size();

        Assert.assertEquals(expected,actual);


    }

    @Test
    public void deleteTest() throws SQLException {

        Pet pet = new Pet("d", 1, "fish", "blue", "glub", 7);
        petDAO.create(pet);
        int expected = petDAO.findAll().size() - 1;
        petDAO.delete(7);
        int actual = petDAO.findAll().size();
        Assert.assertEquals(expected, actual);
    }
}
