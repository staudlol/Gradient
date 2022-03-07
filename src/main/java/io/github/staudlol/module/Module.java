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

    protected ModuleState moduleState = ModuleState.ENABLED;

    /**
     * Constructor to create a new {@link Module}
     *
     * @param moduleName the name of the module.
     */

    public Module(String moduleName) {
        this.moduleName = moduleName;

        ModuleRegistry.getInstance().initiateModule(this);
    }

    public void loadClass(Class... classes) {
        for (Class clazz : classes)
            this.loadClass(clazz);
    }

    public <T> void loadClass(Class<? extends T> clazz) {
        try {
            clazz.newInstance();
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception.getClass().getSimpleName() + " : " + exception.getMessage());
        }
    }
}
