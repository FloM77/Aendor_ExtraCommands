package AT.MSev.ExtraCommands;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityDismountEvent;

public class Handler implements Listener {
    // CommandSit despawn
    @EventHandler
    public void OnStandUp(EntityDismountEvent e)
    {
        if(e.getDismounted().getType().equals(EntityType.ARROW))
        {
            e.getDismounted().remove();
        }
    }
}
