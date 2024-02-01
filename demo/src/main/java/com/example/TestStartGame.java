package com.example;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.omg.PortableInterceptor.DISCARDING;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.WorldBorder;


public class TestStartGame implements CommandExecutor {
    

    int Length_Of_Initial_Grace_Period;
    int Initial_Length_Of_Border;
    int Number_Of_Sections = 4;
    int Time_Between_Sections;
    int Break_Between_Sections;   

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        Player playersender = (Player) sender;

        System.out.println("something happened");

        readFromFile();

        Location[] pos = {null, null, null, null, null, null, null};

        Random rand = new Random();

        World w = playersender.getWorld();
        //#region TELEPORTING
        for(int i = 0; i != pos.length; i++)
        {
            int x = rand.nextInt(Initial_Length_Of_Border - 10);
            int z = rand.nextInt(Initial_Length_Of_Border - 10);
            int y = 200;

            

            Location loc = new Location(w, x, y,z);

            pos[i] = loc;

            System.out.println(loc);
        }

        for(Player player : Bukkit.getOnlinePlayers())
        {   
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 500, 1000));
            player.setHealth(20);
            player.setFoodLevel(20);
            System.out.println(player.getDisplayName());

            if(player.getDisplayName().contains("§5"))
            {
                player.teleport(pos[0]);
            }
            else if(player.getDisplayName().contains("§c"))
            {
                player.teleport(pos[1]);
            }
            else if(player.getDisplayName().contains("§9"))
            {
                player.teleport(pos[2]);
            }
            else if(player.getDisplayName().contains("§e"))
            {
                player.teleport(pos[3]);
            }
            else if(player.getDisplayName().contains("§7"))
            {
                player.teleport(pos[4]);
            }
            else if(player.getDisplayName().contains("§b"))
            {
                player.teleport(pos[5]);
            }
            else if(player.getDisplayName().contains("§a"))
            {
                player.teleport(pos[6]);
            }
            else{
                playersender.sendMessage(player.getName() + " is not on a team");
            }
        }
        //#endregion
        


        System.out.println(String.format("%d %d %d %d %d", Length_Of_Initial_Grace_Period, Initial_Length_Of_Border, Number_Of_Sections, Time_Between_Sections, Break_Between_Sections));

        //#region WORLD BORDER
        WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();
        wb.reset();
        wb.setCenter(0,0);
        wb.setDamageAmount(.5);
        wb.setDamageBuffer(0);
        wb.setSize(Initial_Length_Of_Border * 2);
        wb.setWarningDistance(100);
        //#endregion


        //#region SCOREBOARD
        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
        board.clearSlot(DisplaySlot.SIDEBAR);

        Objective obj = board.getObjective("Timer");
        obj.unregister();

        obj = board.registerNewObjective("Timer", "dummy");

        //Objective obj = board.registerNewObjective("Timer", "dummy");
        obj.setDisplayName("Timer");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        //#endregion
        
        playersender.sendMessage("Everything Seems to Work");
        return true;

    }

    private void readFromFile(){
        try {
            String text = Files.readAllLines(Paths.get("Game_Settings.txt")).get(0);
            String[] arr = text.split(" ");
            Length_Of_Initial_Grace_Period = Integer.parseInt(arr[0]);
            Initial_Length_Of_Border = Integer.parseInt(arr[1]);
            Number_Of_Sections = Integer.parseInt(arr[2]);
            Time_Between_Sections = Integer.parseInt(arr[3]);
            Break_Between_Sections = Integer.parseInt(arr[4]);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e);
        }
    }
}