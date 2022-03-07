package io.github.staudlol.module;

/*
 * Created by Kyle
 * Project: Gradient
 * Date: 07/03/2022 - 07:53
 */

import lombok.Getter;

import java.util.HashMap;

@Getter
public class ModuleRegistry {

    private transient static ModuleRegistry instance;

    public HashMap<Module, ModuleState> moduleStateHashMap = new HashMap<>();

    public static void setInstance(ModuleRegistry instance) {
        ModuleRegistry.instance = instance;
    }

    /**
     * Initiate a new {@link Module}
     *
     * @param module the module.
     */

    public void initiateModule(Module module) {
        this.moduleStateHashMap.put(module, module.getModuleState());
    }

    /**
     * Get the {@link ModuleState} of a {@link Module}
     *
     * @param module the module.
     * @return the state of the module.
     */

    public ModuleState getState(Module module) {
        return this.moduleStateHashMap.get(module);
    }

    public static ModuleRegistry getInstance() {
        return instance;
    }
}
