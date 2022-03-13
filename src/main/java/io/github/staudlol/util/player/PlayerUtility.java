package io.github.staudlol.util.player;

/*
 * Created by Kyle
 * Project: Gradient
 * Date: 12/03/2022 - 23:42
 */

import lombok.experimental.UtilityClass;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.lang.reflect.InvocationTargetException;

@UtilityClass
public class PlayerUtility {

    public void playSound(Player player, String sound) {
        player.playSound(player.getLocation(), Sound.valueOf(sound), 2F, 2F);
    }

    public void playEffect(Player player, Effect effect) {
        player.playEffect(player.getLocation(), Effect.valueOf(effect.name()), 20);
    }

    public void clearInventory(Player player) {
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
        player.setExp(0);
        player.setFoodLevel(20);
        player.setHealth(20);
        player.getActivePotionEffects()
                .stream()
                .map(PotionEffect::getType)
                .forEach(player::removePotionEffect);
        player.setGameMode(GameMode.SURVIVAL);
    }

    public int getPing(Player player) {
        try {
            final Object entityPlayer = player.getClass().getMethod("getHandle").invoke(player);
            return (int) entityPlayer.getClass().getField("ping").get(entityPlayer);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | NoSuchFieldException exception) {
            exception.printStackTrace();
        }
        return 0;
    }
}
