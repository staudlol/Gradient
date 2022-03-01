package io.github.staudlol.database;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class SQLDatabaseImplementation {

    public abstract Connection getConnection() throws SQLException;

    public abstract void closeConnection() throws SQLException;

    public void createTable(String table, String column) {
        try (Connection connection = this.getConnection()) {
            connection.createStatement()
                    .execute("CREATE TABLE IF NOT EXISTS " + table + " (" + column + ")");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
