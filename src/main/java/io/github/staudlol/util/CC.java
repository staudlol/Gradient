package io.github.staudlol.util;

/*
 * Created by Kyle
 * Project: Gradient
 * Date: 02/03/2022 - 12:06
 */

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CC {

    public static String translate(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String[] translate(String... strings) {
        return translate(Arrays.asList(strings))
                .toArray(new String[
                        strings.length
                        ]
                );
    }

    public static List<String> translate(List<String> strings) {
        return strings.stream()
                .map(CC::translate)
                .collect(Collectors.toList());
    }
}