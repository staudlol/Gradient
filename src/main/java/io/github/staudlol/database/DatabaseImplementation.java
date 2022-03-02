package io.github.staudlol.database;

/*
 * Created by Kyle
 * Project: Gradient
 * Date: 02/03/2022 - 12:06
 */

import lombok.Builder;

@Builder
public abstract class DatabaseImplementation {

    private final String host;
    private final int port;

    private boolean authentication;

    private final String username;
    private final char[] password;
    private final String database;

    /**
     * Constructor to create a new {@link DatabaseImplementation}
     *
     * @param host the host.
     * @param port the port.
     * @param authentication if the authentication is enabled or not.
     * @param username the username.
     * @param password the password.
     * @param database the database.
     */

    public DatabaseImplementation(String host, int port, boolean authentication, String username, char[] password, String database) {
        this.host = host;
        this.port = port;
        this.authentication = authentication;
        this.username = username;
        this.password = password;
        this.database = database;
    }

    public abstract void disconnect();
}
