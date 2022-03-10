package io.github.staudlol.module;

/*
 * Created by Kyle
 * Project: Gradient
 * Date: 07/03/2022 - 07:53
 */

import lombok.Getter;

import java.util.*;

@Getter
public class ModuleRegistry {

    private final Map<Class<? extends Module>, Module> moduleMap = new HashMap<>();

    private transient static ModuleRegistry instance;

    /**
     * Constructor for creating a new {@link ModuleRegistry}
     *
     * @param modules the array of modules to register.
     */

    public ModuleRegistry(Module... modules) {
        instance = this;
        Arrays.stream(modules)
                .forEach(this::initiateModule);
    }

    /**
     * Initiate a new {@link Module}
     *
     * @param module the module.
     */

    public void initiateModule(Module module) {
        this.moduleMap.put(module.getClass(), module);
    }

    /**
     * Find a {@link Module} by a {@link Class}
     *
     * @param clazz the class of the module.
     * @param <T> the type of module.
     * @return the module.
     */

    public <T extends Module> T findModule(Class<? extends T> clazz) {
        return clazz.cast(this.moduleMap.get(clazz));
    }

    public static ModuleRegistry getInstance() {
        return instance;
    }
}
