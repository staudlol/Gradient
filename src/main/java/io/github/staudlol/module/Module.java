package io.github.staudlol.module;

/*
 * Created by Kyle
 * Project: Gradient
 * Date: 07/03/2022 - 07:52
 */

import lombok.Getter;

@Getter
public abstract class Module implements ModuleController {

    protected String moduleName;

    /**
     * Constructor to create a new {@link Module}
     *
     * @param moduleName the name of the module.
     */

    public Module(String moduleName) {
        this.moduleName = moduleName;
    }
}
