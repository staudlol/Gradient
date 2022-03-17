package io.github.staudlol.util.symbol;

/*
 * Created by Kyle
 * Project: Gradient
 * Date: 17/03/2022 - 01:26
 */


import lombok.experimental.UtilityClass;
import org.apache.commons.lang.StringEscapeUtils;

@UtilityClass
public class Symbol {

    public static final String DOT;
    public static final String FEATHERED_ARROW;
    public static final String RIGHT_ARROW;
    public static final String ARROW;
    public static final String CIRCLE_STAR;
    public static final String TEARDROP_ASTERISK;
    public static final String RADIOACTIVE;
    public static  final String FLOWER;

    static {
        DOT = StringEscapeUtils.unescapeJava("\\u2022");
        FEATHERED_ARROW = StringEscapeUtils.unescapeJava("\\u27B3");
        RIGHT_ARROW = StringEscapeUtils.unescapeJava("\\u25B6");
        ARROW = StringEscapeUtils.unescapeJava("\\u27A4");
        CIRCLE_STAR = StringEscapeUtils.unescapeJava("\\u272A");
        TEARDROP_ASTERISK = StringEscapeUtils.unescapeJava("\\u2743");
        RADIOACTIVE = StringEscapeUtils.unescapeJava("\\u2622");
        FLOWER = StringEscapeUtils.unescapeJava("\\u2055");
    }
}