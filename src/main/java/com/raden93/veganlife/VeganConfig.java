package com.raden93.veganlife;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RangeInt;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@LangKey(VeganLifeConstants.MODID + ".config.title")
@Config(modid = VeganLifeConstants.MODID)
public class VeganConfig {
	
	@Name("jute settings")
	@Comment("Customize some settings for your jute planting")
	public static final Constants constants = new Constants();
	
	public static class Constants {
		@Name("Bale of jute stages")
		@RangeInt(min = 1, max = 3)
		@Comment("Stages before the jute bale is retted. More stages need more time")
		public int jute_bale_retting_stages = 3;
		
		@Name("Bale of jute hard mode")
		@Comment("The stages of bale of jute change only with a chance of 50%")
		public boolean jute_bale_retting_hardmode = false;
	}
	
	@SubscribeEvent
	public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(VeganLifeConstants.MODID)) {

			// sync GUI to settings..
			ConfigManager.sync(VeganLifeConstants.MODID, Config.Type.INSTANCE);
			
			System.out.println("change value");
		}
	}
	
}
