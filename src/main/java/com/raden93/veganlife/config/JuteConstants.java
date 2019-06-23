package com.raden93.veganlife.config;

import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RangeInt;

public class JuteConstants {
	@Name("Bale of jute stages")
	@RangeInt(min = 1, max = 3)
	@Comment("Stages before the jute bale is retted. More stages need more time")
	public int JUTE_BALE_RETTING_STAGES = 3;
	
	@Name("Bale of jute hard mode")
	@Comment("The stages of bale of jute change only with a chance of 50%")
	public boolean JUTE_BALE_RETTING_HARDMODE = false;
	
	@Name("Droprate: Jute Fiber Base")
	@RangeInt(min = 0, max = 16)
	@Comment("Number of Jute Fiber that will surely drop everytime.")
	public int JUTE_FIBER_BASE_DROPS = 8;
	
	@Name("Droprate: Jute Fiber Random")
	@RangeInt(min = 0, max = 16)
	@Comment("Number of Jute Fiber that will maybe drop. The range is between 0 and your configuration.")
	public int JUTE_FIBER_RANDOM_DROPS = 8;
	
	@Name("Droprate: Jute Stalk Base")
	@RangeInt(min = 0, max = 5)
	@Comment("Number of Jute Stalk that will surely drop everytime.")
	public int JUTE_STALK_BASE_DROPS = 1;
	
	@Name("Droprate: Jute Stalk Random")
	@RangeInt(min = 0, max = 5)
	@Comment("Number of Jute Stalk that will maybe drop. The range is between 0 and your configuration.")
	public int JUTE_STALK_RANDOM_DROPS = 2;
}
