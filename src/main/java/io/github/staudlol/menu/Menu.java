package io.github.staudlol.menu;

/*
 * Created by Kyle
 * Project: Gradient
 * Date: 07/03/2022 - 21:26
 */

import lombok.Data;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Data
public abstract class Menu {

    private final static ConcurrentHashMap<UUID, Menu> menus = new ConcurrentHashMap<>();

    private final String title;
    private final int rows;

    private final Player player;
    private final Inventory inventory;

    /**
     * Constructor to create a new {@link Menu}
     *
     * @param player the player.
     * @param title the title of the menu.
     * @param rows the amount of rows in the menu.
     */

    public Menu(Player player, String title, int rows) {
        this.player = player;
        this.title = title;
        this.rows = rows;
        this.inventory = Bukkit.createInventory(null, rows * 9, title);
    }
}
