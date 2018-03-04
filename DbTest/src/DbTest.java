import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DbTest {
    public static void main(String[] args) {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:hsqldb:file:testing.db", "sa", "");
            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "DROP TABLE EMPLOYEE IF EXISTS");
            statement.executeUpdate("CREATE TABLE EMPLOYEE( "
                    + "NAME VARCHAR(255), FAMILYNAME "
                    + "VARCHAR(255) )");
            statement.executeUpdate("INSERT INTO EMPLOYEE "
                    + "VALUES( ’Jan’, ’Kowalski’ )");
            statement.executeUpdate("INSERT INTO EMPLOYEE "
                    + "VALUES( ’Arkadiusz’, ’Nowak’ )");
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM EMPLOYEE");
            while (resultSet.next()) {
                System.out.println("Pracownik: "
                        + resultSet.getString("NAME")
                        + " " + resultSet.getString("FAMILYNAME"));
            }
            statement.execute("SHUTDOWN COMPACT");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Zakończone");
    }
}