package io.github.staudlol.util.bukkit;

/*
 * Created by Kyle
 * Project: Gradient
 * Date: 12/03/2022 - 23:39
 */

import io.github.staudlol.util.CC;
import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;

@UtilityClass
public class BukkitLogger {

    public void sendMessage(String message) {
        Bukkit.getConsoleSender().sendMessage(CC.translate(message));
    }
}
