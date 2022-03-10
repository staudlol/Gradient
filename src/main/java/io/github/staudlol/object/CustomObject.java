package io.github.staudlol.object;

/*
 * Created by Kyle
 * Project: Gradient
 * Date: 10/03/2022 - 22:09
 */

import org.bukkit.entity.Player;

public abstract class CustomObject {

    /**
     * Spawn a custom object using the {@link Player}'s data.
     *
     * @param player the player to use.
     * @return the success rate.
     */

    public abstract boolean spawn(Player player);
}
