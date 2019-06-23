package com.raden93.veganlife.config;

import com.raden93.veganlife.VeganLifeConstants;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RangeDouble;
import net.minecraftforge.common.config.Config.RangeInt;
import net.minecraftforge.common.config.Config.RequiresMcRestart;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@LangKey(VeganLifeConstants.MODID + ".config.title")
@Config(modid = VeganLifeConstants.MODID)
public class VeganConfig {
	
	@Name("jute settings")
	@Comment("Customize some settings for your jute planting")
	public static final JuteConstants JUTE_CONSTANTS = new JuteConstants();
	
	@Name("other drops settings")
	@Comment("Customize some settings for other drops")
	public static final OtherConstants OTHER_CONSTANTS = new OtherConstants();
	
	@SubscribeEvent
	public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(VeganLifeConstants.MODID)) {

			// sync GUI to settings..
			ConfigManager.sync(VeganLifeConstants.MODID, Config.Type.INSTANCE);
			
			System.out.println("change value");
		}
	}
	
}
