package AT.MSev.ExtraCommands.Commands.Look;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class CommandLook implements CommandExecutor {
    Plugin plugin;

    public CommandLook(Plugin plugin)
    {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length>0) {
            if (strings[0] != null) {
                Player exe = ((Player) commandSender);

                if(strings[0].equalsIgnoreCase("accept"))
                {
                    LookRequest request = LookRequest.GetFromLooked(exe);
                    if(request == null) {exe.sendMessage(ChatColor.RED + "No request found.");}
                    else
                    {
                        request.Accept();
                    }

                    return true;
                }
                else if(strings[0].equalsIgnoreCase("deny"))
                {
                    LookRequest request = LookRequest.GetFromLooked(exe);
                    if(request == null) {exe.sendMessage(ChatColor.RED + "No request found.");}
                    else
                    {
                        request.Deny();
                    }

                    return true;
                }

                Player on = Bukkit.getPlayer(strings[0]);
                if (on != null){
                    new LookRequest(exe, on, plugin);
                    return true;
                }
            }
        }
        return false;
    }


}
