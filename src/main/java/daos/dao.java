package daos;

import models.Pet;

import java.sql.SQLException;
import java.util.List;

public interface dao {
    Pet findById(int id);
    List<Pet> findAll() throws SQLException;
    Pet update(Pet dto) throws SQLException;
    Pet create(Pet dto) throws SQLException;
    void delete(int id) throws SQLException;

}
