/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexaoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vinni
 */
public class Conexao {
 
public static Connection conectar() {

        try {

            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/clinica_veterinaria",
                    "root",
                    "Alpha123045@"
            );

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }
}
