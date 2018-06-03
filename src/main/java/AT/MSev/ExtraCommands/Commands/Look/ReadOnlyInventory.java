package AT.MSev.ExtraCommands.Commands.Look;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;

import static org.bukkit.Bukkit.getServer;

public class ReadOnlyInventory implements Listener {
    public Inventory Inventory;

    public ReadOnlyInventory(Inventory pi, Plugin plugin)
    {
        Inventory = pi;
        getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    void OnClick(InventoryClickEvent e)
    {
        if(e.getClickedInventory() == null) return;
        if(e.getClickedInventory().equals(Inventory))
        {
            e.setCancelled(true);
            if(e.getCursor()!=null) {
                e.getCursor().setType(Material.AIR);
            }
        }
    }


}
