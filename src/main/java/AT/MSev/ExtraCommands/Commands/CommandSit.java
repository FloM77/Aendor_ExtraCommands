package AT.MSev.ExtraCommands.Commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CommandSit implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = ((Player)commandSender);
        World world = player.getWorld();
        if(command.getName().equals("Sit"))
        {
            Entity sitOn = world.spawnEntity(player.getLocation().clone().add(0,-0.5,0), EntityType.ARROW);
            sitOn.setGravity(false);
            sitOn.addPassenger(player);
            return true;
        }
        return false;
    }
}
