package me.orbitboyzz.smpcore;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class SmpCore extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("SmpCore enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("SmpCore disabled.");
    }

    // Greets each player as they join. Delete this if you don't want it.
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(
                Component.text("Welcome to the Llama SMP!", NamedTextColor.GOLD));
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
                             @NotNull String label, @NotNull String[] args) {
        if (!command.getName().equalsIgnoreCase("smp")) {
            return false;
        }
        sender.sendMessage(Component.text("Llama SMP - Season 1", NamedTextColor.GOLD));
        sender.sendMessage(Component.text(
                "Players online: " + getServer().getOnlinePlayers().size(), NamedTextColor.YELLOW));
        return true;
    }
}
