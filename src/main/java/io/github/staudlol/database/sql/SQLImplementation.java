package io.github.staudlol.database.sql;

/*
 * Created by Kyle
 * Project: Gradient
 * Date: 10/03/2022 - 13:45
 */

import io.github.staudlol.database.SQLDatabaseImplementation;
import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class SQLImplementation extends SQLDatabaseImplementation {

    private Connection connection;

    /**
     * Constructor to create a new {@link SQLDatabaseImplementation}
     * @param host           the host.
     * @param port           the port.
     * @param authentication if the authentication is enabled or not.
     * @param username       the username.
     * @param password       the password.
     * @param database       the database.
     */
    public SQLImplementation(String host, int port, boolean authentication, String username, String password, String database) {
        super(host, port, authentication, username, password, database);

        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + username + password);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return this.connection.getMetaData().getConnection();
    }

    @Override
    public void close() throws SQLException {
        this.connection.close();
    }
}
