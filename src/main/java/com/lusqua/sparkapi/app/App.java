package com.lusqua.sparkapi.app;

import org.bukkit.plugin.java.JavaPlugin;
import static spark.Spark.*;
import org.bukkit.Bukkit;


public final class App extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new Thread(() -> {
            get("/hello", (req, res) -> {
                res.type("application/json");
                return "{Requests: Hello, World!}";
            });
            get("players", (req,res)-> {
                res.type("application/json");
                return "{'Players':"+ Bukkit.getOnlinePlayers() + "}";
            });
        }).start();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
