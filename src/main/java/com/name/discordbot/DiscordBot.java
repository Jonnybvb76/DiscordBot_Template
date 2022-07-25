package com.name.discordbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;
import java.awt.*;

public class DiscordBot {

    public static final Color primaryColor = new Color(0x3676C4);
    public static final Color attentionColor = new Color(0xEC5555);
    public static final Color successColor = new Color(0x7FEE8E);
    public static final Color defaultColor = new Color(0x23272A);

    public static Guild guild; // test Guild where your first commands will be loaded

    public static DiscordBot INSTANCE;
    private final ShardManager shardManager;
    public static JDA jda;

    public static void main(String[] args) {


        System.out.println("[Discord] Starting bot..");
        try {
            new DiscordBot();
        } catch (LoginException | IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

    public DiscordBot() throws LoginException, IllegalArgumentException {

        DiscordBot.INSTANCE = this;

        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder
                .createDefault("TOKEN") // Set Token
                .enableIntents(GatewayIntent.GUILD_MEMBERS) // Enable Intents
                .addEventListeners(new Setup()) // Add Setup Listener
                .setActivity(Activity.listening("Never gonna give you up")) // Set Bot Activity
                .setStatus(OnlineStatus.ONLINE); // Set the Status of the Bot

        this.shardManager = builder.build();
        jda = shardManager.retrieveApplicationInfo().getJDA();
    }

    public JDA getJDA() {
        return jda;
    }

    public ShardManager getShardManager() {
        return this.shardManager;
    }

}
