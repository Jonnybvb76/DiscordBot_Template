package com.name.discordbot.commands;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import javax.annotation.Nonnull;

public class SayCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@Nonnull SlashCommandInteractionEvent event) {
        if (event.getName().equals("say")) {
            String content = null;
            TextChannel channel = null;

            for (OptionMapping option : event.getOptions()) {
                switch (option.getName()) {
                    case "content":
                        content = option.getAsString();
                        break;
                    case "channel":
                        if(option.getAsChannel().getType().equals(ChannelType.TEXT)) {
                            channel = (TextChannel) option.getAsChannel();
                        }
                        break;
                }
            }
            assert content != null;
            if(channel != null) {
                channel.sendMessage(content).queue();
            } else {
                event.getChannel().sendMessage(content).queue();
            }
            event.reply("Successfully send message!").setEphemeral(true).queue();
        }
    }
}
