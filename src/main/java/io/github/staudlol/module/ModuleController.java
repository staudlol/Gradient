package io.github.staudlol.module;

/*
 * Created by Kyle
 * Project: Gradient
 * Date: 07/03/2022 - 07:53
 */

import java.io.IOException;

public interface ModuleController {

    default void moduleEnable() throws IOException {}

    default void moduleDisable() {}
}
