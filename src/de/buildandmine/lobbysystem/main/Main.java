package de.buildandmine.lobbysystem.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import de.buildandmine.lobbysystem.utils.PlayerManager;

public class Main extends JavaPlugin{
	
	private static Plugin main;

	public void onEnable() {
		main = this;
		getCommand("setspawn").setExecutor(new setspawn());
		Bukkit.getPluginManager().registerEvents(new PlayerManager(), this);
	}
}
