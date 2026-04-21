package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainCrearEmpleado {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword())) {
            System.out.println("Conectado!");

            Statement statement = connection.createStatement();

            String sql = "CREATE TABLE empleado (" +
                    "id NUMBER PRIMARY KEY, " +
                    "nombre VARCHAR2(100), " +
                    "salario NUMBER(10, 2))";
            statement.executeUpdate(sql);
            System.out.println("TABLA EMPLEADO CREADO");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}