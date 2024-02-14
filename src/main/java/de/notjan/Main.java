package de.notjan;

import de.notjan.commands.StatsCommand;
import de.notjan.files.Config;
import de.notjan.files.ConfigKey;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {
        Config config = new Config("config.yml");

        JDA jda = JDABuilder.createLight((String) config.get(ConfigKey.TOKEN), EnumSet.noneOf(GatewayIntent.class))
                .setStatus(OnlineStatus.ONLINE)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
                .addEventListeners(new StatsCommand())
                .build();

        CommandListUpdateAction commands = jda.updateCommands();

        commands.addCommands(
                Commands.slash("stats", "Show stats of your Skyblock profile")
                        .addOption(OptionType.STRING, "username", "Enter your Minecraft username", true)).queue();

        commands.queue();
    }
}