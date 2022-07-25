package com.name.discordbot;

import com.name.discordbot.commands.SayCommand;
import com.name.discordbot.listener.EventListeners;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.jetbrains.annotations.NotNull;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Setup extends ListenerAdapter {

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        DiscordBot.guild = DiscordBot.INSTANCE.getShardManager().getGuildById("971791531742756956"); // Set the test Guild where your first commands will be loaded
        events();
        commands();
        ZoneId zoneid = ZoneId.of("Europe/Paris"); // Set The Timezone
        System.out.println("[Discord] Bot started at " + ZonedDateTime.now(zoneid).format(DateTimeFormatter.ofPattern("HH:mm:ss (dd/MM/yyyy)")));
    }

    private static void events() {
        ShardManager shardManager = DiscordBot.INSTANCE.getShardManager();
        shardManager.addEventListener(new EventListeners()); // Register Event Class
    }

    public static void commands() {

        CommandListUpdateAction commands = DiscordBot.guild.updateCommands();

        commands.addCommands(Commands.slash("say", "can say anything as your bot") // Add Command
                .addOption(OptionType.STRING, "content", "message content", true) // Add Option for the Command
                .addOption(OptionType.CHANNEL, "channel", "target message channel to send in", false)
        ).queue();

        DiscordBot.INSTANCE.getShardManager().addEventListener(new SayCommand()); // Register Command

        System.out.println("[Discord] Commands loaded");
    }

}
