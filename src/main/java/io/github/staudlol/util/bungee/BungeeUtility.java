package io.github.staudlol.util.bungee;

/*
 * Created by Kyle
 * Project: Gradient
 * Date: 07/03/2022 - 18:13
 */

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import io.github.staudlol.GradientPlugin;
import lombok.experimental.UtilityClass;
import org.bukkit.entity.Player;

@UtilityClass
public class BungeeUtility {

    public static void sendPlayerToServer(Player player, String server) {
        final ByteArrayDataOutput dataOutput = ByteStreams.newDataOutput();

        try {
            dataOutput.writeUTF("Connect");
            dataOutput.writeUTF(server);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        player.sendPluginMessage(GradientPlugin.getPlugin(GradientPlugin.class), "BungeeCord", dataOutput.toByteArray());
    }
}
