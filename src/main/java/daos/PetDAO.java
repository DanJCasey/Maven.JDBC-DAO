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
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE my_pets SET pet_name = ?, pet_age = ?, pet_type = ?, pet_color = ?, pet_sound = ? WHERE id = ?");
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
        PreparedStatement preparedStatement = connection.prepareStatement("Insert into my_pets values (?, ?, ?, ?, ?, DEFAULT)");
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

    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("Delete from my_pets where id = ?");
        preparedStatement.setInt(1, id);
        int result = preparedStatement.executeUpdate();
    }

    private Pet extractPetFromResultSet(ResultSet rs) throws SQLException {
        Pet pet = new Pet();
        pet.setId(rs.getInt("id"));
        pet.setAge(rs.getInt("pet_age"));
        pet.setName(rs.getString("pet_name"));
        pet.setType(rs.getString("pet_type"));
        pet.setSound(rs.getString("pet_sound"));
        pet.setColor(rs.getString("pet_color"));
        return pet;
    }


}
