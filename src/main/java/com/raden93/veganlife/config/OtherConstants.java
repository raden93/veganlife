package com.raden93.veganlife.config;

import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RangeDouble;
import net.minecraftforge.common.config.Config.RequiresMcRestart;

public class OtherConstants {
	@Name("Dropchance: Bones from Stone")
	@RangeDouble(min = 0, max = 1)
	@Comment("Chance a bone drop from a stone. 1 is 100%, 0 is 0%")
	@RequiresMcRestart
	public double DROPCHANCE_BONE_FROM_STONE = 0.02d;
}
