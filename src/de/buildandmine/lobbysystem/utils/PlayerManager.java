package de.buildandmine.lobbysystem.utils;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import de.buildandmine.core.main.Main;

public class PlayerManager implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.getPlayer().getInventory().clear();
		e.getPlayer().teleport(Main.getAPI().getPositions().getLocation("Spawn"));
		e.getPlayer().setFoodLevel(200);
	}
	
	@EventHandler
	public void onHunger(FoodLevelChangeEvent e) {
		e.setCancelled(true);
		e.setFoodLevel(200);
	}
	
	@EventHandler
	public void onSpawn(EntitySpawnEvent e) {
		if(!e.getEntityType().equals(EntityType.PLAYER)||!e.getEntityType().equals(EntityType.ARMOR_STAND)) {
			e.setCancelled(true);
		}
	}
	
	public void onPlayerDeath(PlayerDeathEvent e) {
		e.getEntity().teleport(Main.getAPI().getPositions().getLocation("Spawn"));
	}
	
	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		e.setDroppedExp(0);
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if(e.getEntityType().equals(EntityType.PLAYER)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		e.setCancelled(true);
	}
	@EventHandler
	public void onPlacE(BlockPlaceEvent e) {
		e.setBuild(true);
	}
}
