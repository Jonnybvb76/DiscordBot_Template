package com.name.discordbot.listener;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EventListeners extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) { // Example for the Join Event

        System.out.println(event.getUser().getAsTag() + " joined " + event.getGuild().getName() + "!");

    }

}
