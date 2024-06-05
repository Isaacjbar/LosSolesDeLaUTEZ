import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Escenas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID de la escena (puede contener números y letras): ");
        String id = scanner.nextLine();

        System.out.print("Ingrese el título de la escena: ");
        String tituloEscena = scanner.nextLine();

        saveToDatabase(id, tituloEscena);
    }

    private static void saveToDatabase(String id, String tituloEscena) {
        String URL = "jdbc:mysql://localhost:3306/Escenas2";
        String USER = "root";
        String PASSWORD = "root";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO esce (id, titulo_escena) VALUES (?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, id);
                statement.setString(2, tituloEscena);
                statement.executeUpdate();
                System.out.println("Datos guardados correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }
}
