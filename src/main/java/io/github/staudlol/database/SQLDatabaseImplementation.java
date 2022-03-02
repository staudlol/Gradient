package io.github.staudlol.database;

/*
 * Created by Kyle
 * Project: Gradient
 * Date: 02/03/2022 - 12:35
 */

import java.sql.Connection;
import java.sql.SQLException;

public abstract class SQLDatabaseImplementation {

    public void createTable(String table, String column) throws SQLException {
        try (Connection connection = this.getConnection()) {
            connection.createStatement()
                    .execute("CREATE TABLE IF NOT EXISTS " + table + " (" + column + ")");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public abstract Connection getConnection() throws SQLException;
}
