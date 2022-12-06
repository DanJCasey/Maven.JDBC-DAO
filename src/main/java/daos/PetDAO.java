package daos;

import models.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAO implements dao{
    Connection connection = Connect.getConnection();


    public Pet findById(int id) {
        return null;
    }

    public List<Pet> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from my_pets");
        List<Pet> petList = new ArrayList<Pet>();

        while(resultSet.next()){
            petList.add(extractPetFromResultSet(resultSet));
        }
        return petList;
    }

    public Pet update(Pet pet) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE pet SET name = ?, age = ?, type = ?, color = ?, sound = ? WHERE id = ?");
        preparedStatement.setString(1, pet.getName());
        preparedStatement.setInt(2, pet.getAge());
        preparedStatement.setString(3, pet.getType());
        preparedStatement.setString(4, pet.getColor());
        preparedStatement.setString(5, pet.getSound());
        preparedStatement.setInt(6, pet.getId());
        int result = preparedStatement.executeUpdate();
        if(result == 1) return pet;
        return null;
    }

    public Pet create(Pet pet) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("Insert into my_pets values (default, ?, ?)");
        preparedStatement.setString(1, pet.getName());
        preparedStatement.setInt(2, pet.getAge());
        preparedStatement.setString(3, pet.getType());
        preparedStatement.setString(4, pet.getColor());
        preparedStatement.setString(5, pet.getSound());
        return null;
    }

    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("Delete from my_pets where id = ?");
        preparedStatement.setInt(1, id);
        int result = preparedStatement.executeUpdate();
    }

    private Pet extractPetFromResultSet(ResultSet rs) throws SQLException {
        Pet pet = new Pet();
        pet.setId(rs.getInt("id"));
        pet.setAge(rs.getInt("age"));
        pet.setName(rs.getString("name"));
        pet.setType(rs.getString("type"));
        pet.setSound(rs.getString("sound"));
        return pet;
    }


}
