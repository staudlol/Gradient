package io.github.staudlol.database.sql;

import io.github.staudlol.database.SQLDatabaseImplementation;
import lombok.Getter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Getter
public class SQLImplementation extends SQLDatabaseImplementation {

    private final DataSource dataSource;

    public SQLImplementation(String host, String database, Integer port, String username, String password, DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

    @Override
    public void closeConnection() throws SQLException {
        this.dataSource.getConnection().close();
    }
}
