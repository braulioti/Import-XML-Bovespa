import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ImportXMLBovespa {

    public static void main(String[] args) throws IOException {
        ImportXMLToDatabase loadXML = new ImportXMLToDatabase();

        if (args.length > 0) {
            Connection con = loadConnection(args[0], args[1], args[2]);
            loadXML.setFolder(args[3]);
            loadXML.setConnection(con);
            loadXML.importa();
        }
    }

    private static Connection loadConnection(String connection, String user, String password) {
        String driver = "org.postgresql.Driver";

        try {
            Class.forName(driver);
            StringBuilder url = new StringBuilder();
            url.append("jdbc:postgresql://").append(connection);

            return DriverManager.getConnection(url.toString(), user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
