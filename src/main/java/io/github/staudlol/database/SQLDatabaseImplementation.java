package io.github.staudlol.database;

/*
 * Created by Kyle
 * Project: Gradient
 * Date: 02/03/2022 - 12:35
 */

import lombok.Builder;

import java.sql.Connection;
import java.sql.SQLException;

@Builder
public abstract class SQLDatabaseImplementation {

    private final String host;
    private final int port;

    private boolean authentication;

    private final String username;
    private final String password;
    private final String database;

    /**
     * Constructor to create a new {@link SQLDatabaseImplementation}
     *
     * @param host the host.
     * @param port the port.
     * @param authentication if the authentication is enabled or not.
     * @param username the username.
     * @param password the password.
     * @param database the database.
     */

    public SQLDatabaseImplementation(String host, int port, boolean authentication, String username, String password, String database) {
        this.host = host;
        this.port = port;
        this.authentication = authentication;
        this.username = username;
        this.password = password;
        this.database = database;
    }

    public void createTable(String table, String column) throws SQLException {
        try (Connection connection = this.getConnection()) {
            connection.createStatement()
                    .execute("CREATE TABLE IF NOT EXISTS " + table + " (" + column + ")");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public abstract Connection getConnection() throws SQLException;

    public abstract void close() throws SQLException;
}
