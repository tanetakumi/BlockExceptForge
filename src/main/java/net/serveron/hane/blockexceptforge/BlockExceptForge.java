package net.serveron.hane.blockexceptforge;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public final class BlockExceptForge extends Plugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("[BlockExceptForge] 起動");
    }

    @Override
    public void onDisable() {
        System.out.println("[BlockExceptForge] 終了");
    }

    @EventHandler
    public void onPluginMessage(PluginMessageEvent e) {
        if(e.getTag().equalsIgnoreCase("minecraft:brand")){
            if(e.getSender() instanceof ProxiedPlayer){
                String brand = new String(e.getData()).trim();
                if(!brand.equalsIgnoreCase("forge")){
                    e.getSender().disconnect(new TextComponent("はね鯖ランチャーより参加してください。\nランチャ―以外での複数回のログインはBAN対象です。"));
                }
            }
        }
    }
}
