package AT.MSev.ExtraCommands.Commands.Look;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class LookRequest {
    Player Looker, Looked;
    Plugin plugin;

    public static ArrayList<LookRequest> All = new ArrayList<LookRequest>();

    public LookRequest(Player looker, Player looked, Plugin plugin) {
        Looker = looker;
        Looked = looked;
        this.plugin = plugin;

        All.add(this);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                Timeout();
            }
        }, (15L * 20L));

        looker.sendMessage(ChatColor.GREEN + "Request sent!");
        looked.sendMessage(ChatColor.GREEN + looker.getDisplayName() + " wants to look in your inventory. Type \"/look accept\" to accept his request!");
    }

    void Timeout() {
        if (!Completed()) {
            All.remove(this);

            Looker.sendMessage(ChatColor.YELLOW + "Your look request timed out.");
            Looked.sendMessage(ChatColor.YELLOW + Looker.getDisplayName() + "s look request timed out.");
        }
    }

    void Deny()
    {
        if(!Completed())
        {
            All.remove(this);

            Looker.sendMessage(ChatColor.RED + "Your look request got denied.");
            Looked.sendMessage(ChatColor.RED + "You denied " + Looker.getDisplayName() + "s look request.");
        }
    }

    void Accept()
    {
        if(!Completed())
        {
            All.remove(this);

            Looker.sendMessage(ChatColor.GREEN + "Your look request got accepted.");
            Looked.sendMessage(ChatColor.GREEN + "You accepted " + Looker.getDisplayName() + "s look request.");

            Inventory clone = getInventory(Looked);
            ReadOnlyInventory roi = new ReadOnlyInventory(clone, plugin);
            Looker.openInventory(roi.Inventory);
        }
    }

    Boolean Completed() {
        if (All.contains(this)) {
            return false;
        }
        return true;
    }

    public static LookRequest GetFromLooked(Player looked)
    {
        for(LookRequest lr : All)
        {
            if(lr.Looked.equals(looked))
            {
                return lr;
            }
        }
        return null;
    }

    Inventory getInventory(Player player)
    {
        Inventory copy = Bukkit.createInventory(null, InventoryType.PLAYER);
        copy.setContents(player.getInventory().getContents());
        return copy;
    }

}
