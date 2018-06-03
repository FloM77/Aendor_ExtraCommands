package AT.MSev.ExtraCommands;

import AT.MSev.ExtraCommands.Commands.Look.CommandLook;
import AT.MSev.ExtraCommands.Commands.CommandSit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class ExtraCommands extends JavaPlugin {
    public static NamespacedKey key;
    @Override
    public void onEnable() {
        key = new NamespacedKey(this, this.getDescription().getName());

        this.getCommand("Sit").setExecutor(new CommandSit());
        this.getCommand("Look").setExecutor(new CommandLook(this));

        getServer().getPluginManager().registerEvents(new Handler(), this);
    }
    @Override
    public void onDisable() {

    }
}
