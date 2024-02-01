package com.example;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.*;

public class PluginMain extends JavaPlugin{
    @Override
    public void onEnable()
    {
        getLogger().info("plugin is running");
        this.getCommand("start").setExecutor(new StartGame());
        this.getCommand("ping").setExecutor(new tpa());
        this.getCommand("jointeam").setExecutor(new JoinTeam());
        this.getCommand("teststart").setExecutor(new TestStartGame());

        File fr = new File("Game_Settings.txt");

        try {
           if(fr.createNewFile()){
                FileWriter myWriter = new FileWriter("Game_Settings.txt");
                myWriter.write("60 2000 4 30 10");
                myWriter.close();
           }
        } catch (IOException e) {
            System.out.println(e);
        }

        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
        board.clearSlot(DisplaySlot.SIDEBAR);

    }

    @Override
    public void onDisable()
    {
        getLogger().info("plugin is disable");
    }


}
