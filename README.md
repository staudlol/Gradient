# Gradient
``DISCLAIMER: If you run into any issues feel free to make a pull request or contact me on discord @ Staud#5412``

# Implementing Gradient

```java
public class ExamplePlugin extends GradientPlugin {
    
    @Override
    public void load() {
        
    }

    @Override
    public void unload() {

    }
}
```
# Module

```java
public class TestModule extends Module  {

    public TestModule() {
        super("test-module");
    }
}
```
# How to register a Module
```java
public class ExamplePlugin extends GradientPlugin {
    
    private final ModuleRegistry moduleRegistry = new ModuleRegistry();

    @Override
    public void load() {
        this.moduleRegistry.initiateModule(new TestModule());
    }

    @Override
    public void unload() {

    }
}
```
# Custom Object
```java
public class TestObject implements CustomObject {

    /**
     * Spawn a custom object using the {@link Player}'s data.
     *
     * @param player the player to use.
     * @return the success rate.
     */
    @Override
    public boolean spawn(Player player) {
        final Location location = player.getLocation();
        final Wolf wolf = location.getWorld().spawn(location, Wolf.class);

        wolf.setSitting(true);
        return true;
    }
}
```
# Registering a Custom Object
```java
public class ObjectRegister {

    private final CustomObject[] objects = new CustomObject[] {
            new TestObject()
    };
}
```

# Using this in your plugins
Feel free to use this API in your plugins. However, please give me credit if you plan to re-sell this within premium plugins. Thank you ✔️
