package com.example;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class JoinTeam implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        

        Player p = (Player) sender;

        //p.setDisplayName(ChatColor.GOLD + p.getName());

        switch(args[0]){
            case "purple":
               p.setDisplayName(ChatColor.DARK_PURPLE + p.getName() + ChatColor.RESET);
               p.setPlayerListName(ChatColor.DARK_PURPLE + p.getName() + ChatColor.RESET);
               break;
            case "red":
               p.setDisplayName(ChatColor.RED + p.getName() + ChatColor.RESET); 
               p.setPlayerListName(ChatColor.RED + p.getName() + ChatColor.RESET);
               break;
            case "blue":
               p.setDisplayName(ChatColor.BLUE + p.getName() + ChatColor.RESET);
               p.setPlayerListName(ChatColor.BLUE + p.getName() + ChatColor.RESET);
               break;
            case "yellow":
               p.setDisplayName(ChatColor.YELLOW + p.getName() + ChatColor.RESET); 
               p.setPlayerListName(ChatColor.YELLOW + p.getName() + ChatColor.RESET);
               break;
            case "green":
               p.setDisplayName(ChatColor.GREEN + p.getName() + ChatColor.RESET);
               p.setPlayerListName(ChatColor.GREEN + p.getName() + ChatColor.RESET);
               
               break;
            case "aqua":
               p.setDisplayName(ChatColor.AQUA + p.getName() + ChatColor.RESET);
               p.setPlayerListName(ChatColor.AQUA + p.getName() + ChatColor.RESET);
               break;
            case "gray":
               p.setDisplayName(ChatColor.GRAY + p.getName() + ChatColor.RESET);
               p.setPlayerListName(ChatColor.GRAY + p.getName() + ChatColor.RESET);
               break;
            default:
                p.sendMessage("Color Not Found");
        }



        return false;
    }
    
}
