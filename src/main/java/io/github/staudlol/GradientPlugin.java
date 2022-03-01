package io.github.staudlol;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class GradientPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        this.load();
    }

    @Override
    public void onDisable() {
        this.unload();
    }

    public abstract void load();

    public abstract void unload();
}
