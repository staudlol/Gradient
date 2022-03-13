package io.github.staudlol.util.number;

/*
 * Created by Kyle
 * Project: Gradient
 * Date: 13/03/2022 - 00:23
 */

import lombok.experimental.UtilityClass;

@UtilityClass
public class DateUtility {

    public String formatNumber(int number) {
        int millis = number * 1000;
        int seconds = millis / 1000 % 60;
        int minutes = millis / 60000 % 60;
        int hours = millis / 3600000 % 24;

        return (hours > 0 ? hours + ":" : "") + (minutes < 10 ? "0" + minutes : minutes) + ":" + (seconds < 10 ? "0" + seconds : seconds);
    }
}
