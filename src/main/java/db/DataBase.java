package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    public static void init() {
        initProfile();
        initCard();
        terminalInit();
    }
    public static void initProfile() {
        String sql = "create table if not exists  profile(id serial primary key," +
                "name varchar ," +
                "surname varchar," +
                "password varchar ," +
                "phone  varchar  ," +
                "created_date timestamp default now()," +
                "status varchar default 'REGISTRATION'," +
                "role varchar default 'USER');";
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void initCard() {
        String sql = "create table if not exists  card(id serial primary key," +
                "number varchar ," +
                "exp_date varchar," +
                "amount  decimal(10,4) default 0 ," +
                "profile_id  int default null ," +
                "created_date timestamp default now()," +
                "status varchar default 'NOACTIVE')";
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void terminalInit() {
        String sql = "create table if not exists  terminal(id serial primary key," +
                "number varchar ," +
                "address varchar," +
                "created_date timestamp default now()," +
                "status varchar default 'ACTIVE')";
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/atto", "postgres", "elmurod2203");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }


}
