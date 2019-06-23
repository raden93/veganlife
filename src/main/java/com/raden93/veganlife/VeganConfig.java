package com.raden93.veganlife;

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
	public static final Constants constants = new Constants();
	
	@Name("other drops settings")
	@Comment("Customize some settings for other drops")
	public static final OtherConstants OTHER_CONSTANTS = new OtherConstants();
	
	public static class Constants {
		@Name("Bale of jute stages")
		@RangeInt(min = 1, max = 3)
		@Comment("Stages before the jute bale is retted. More stages need more time")
		public int jute_bale_retting_stages = 3;
		
		@Name("Bale of jute hard mode")
		@Comment("The stages of bale of jute change only with a chance of 50%")
		public boolean jute_bale_retting_hardmode = false;
		
		@Name("Droprate: Jute Fiber Base")
		@RangeInt(min = 0, max = 16)
		@Comment("Number of Jute Fiber that will surely drop everytime.")
		public int jute_fiber_base_drops = 8;
		
		@Name("Droprate: Jute Fiber Random")
		@RangeInt(min = 0, max = 16)
		@Comment("Number of Jute Fiber that will maybe drop. The range is between 0 and your configuration.")
		public int jute_fiber_random_drops = 8;
		
		@Name("Droprate: Jute Stalk Base")
		@RangeInt(min = 0, max = 5)
		@Comment("Number of Jute Stalk that will surely drop everytime.")
		public int jute_stalk_base_drops = 1;
		
		@Name("Droprate: Jute Stalk Random")
		@RangeInt(min = 0, max = 5)
		@Comment("Number of Jute Stalk that will maybe drop. The range is between 0 and your configuration.")
		public int jute_stalk_random_drops = 2;
	}
	
	public static class OtherConstants {
		@Name("Dropchance: Bones from Stone")
		@RangeDouble(min = 0, max = 1)
		@Comment("Chance a bone drop from a stone. 1 is 100%, 0 is 0%")
		@RequiresMcRestart
		public double DROPCHANCE_BONE_FROM_STONE = 0.02d;
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
