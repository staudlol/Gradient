package io.github.staudlol.database.mongo;

/*
 * Created by Kyle
 * Project: Gradient
 * Date: 02/03/2022 - 12:22
 */

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import io.github.staudlol.database.DatabaseImplementation;
import lombok.Getter;
import org.bukkit.Bukkit;

import java.util.Collections;
import java.util.logging.Level;

@Getter
public class MongoImplementation extends DatabaseImplementation {

    private final MongoClient mongoClient;

    /**
     * Constructor to create a new {@link DatabaseImplementation}
     *
     * @param host           the host.
     * @param port           the port.
     * @param authentication if the authentication is enabled or not.
     * @param username       the username.
     * @param password       the password.
     * @param database       the database.
     */
    public MongoImplementation(String host, int port, boolean authentication, String username, char[] password, String database) {
        super(host, port, authentication, username, password, database);

        final ServerAddress serverAddress = new ServerAddress(host, port);

        if (authentication) {
            this.mongoClient = new MongoClient(
                    serverAddress, Collections.singletonList(MongoCredential.createCredential(
                            username,
                            database,
                            password
                    )));
        } else {
            this.mongoClient = new MongoClient(serverAddress);
        }
    }

    @Override
    public void disconnect() {
        Bukkit.getLogger().log(Level.SEVERE, "[Gradient] The Mongo Implementation is disconnecting...");
    }
}
