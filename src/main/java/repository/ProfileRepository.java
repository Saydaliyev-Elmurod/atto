package repository;

import db.DataBase;
import main.java.dto.Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileRepository {

    public void registration(Profile profile) {
        String sql = "insert into profile(name,surname,phone,password) " +
                "values(?,?,?,?)";
        try {
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, profile.getName());
            statement.setString(2, profile.getSurname());
            statement.setString(3, profile.getPhone());
            statement.setString(4, profile.getPassword());
            int n = statement.executeUpdate();
            if (n==1){
                System.out.println("Successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Profile getProfileByPhone(String phone) {
        String sql = "select * from profile " +
                "where phone = ?";
        try {
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, phone);
            ResultSet set = statement.executeQuery();
            Profile profile = null;
            if (set.next()) {
                profile = new Profile();
                profile.setName(set.getString("name"));
                profile.setSurname(set.getString("surname"));
                profile.setPhone(set.getString("phone"));
                profile.setPassword(set.getString("password"));
            }
            return profile;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;


    }
}
