package libs;


import java.sql.*;

import org.apache.log4j.Logger;


/**
 * Created by sergii.ivashko on 27.04.2018.
 */


public class DBHelper {

    Logger log;

    public DBHelper ()
    {
        log = Logger.getLogger(getClass());
    }


    public void setDefaultPass () {
        try (Connection conn = this.connect())
        {
            String sqlQuery = "UPDATE DtoUser SET PasswordHash = 'AQAAAAEAACcQAAAAENWSy21jh5S73jVaoQsPEAsr/8U0nsRdcy3lmSa624E+8o/tfiLyWVrnQc8hOJe5Xg==' WHERE UserName = 'admin'";
            Statement stmt = conn.createStatement();
            // update
            stmt.executeUpdate(sqlQuery);
            // commit
            conn.commit();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }


    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://WebConsole//nxdb.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}



