package com.raden93.veganlife.config;

import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RangeDouble;
import net.minecraftforge.common.config.Config.RequiresMcRestart;

public class OtherConstants {
	@Name("Dropchance: Resin from Spruce Wood")
	@RangeDouble(min = 0, max = 1)
	@Comment("Chance a resin item drop from a spruce wood block. 1 is 100%, 0 is 0%")
	@RequiresMcRestart
	public double DROPCHANCE_RESIN_FROM_SPRUCE = 0.01d;
	
	@Name("Dropchance: Kapok from Jungle Leaf")
	@RangeDouble(min = 0, max = 1)
	@Comment("Chance a kapok tuft drop from a jungle leaf. 1 is 100%, 0 is 0%")
	@RequiresMcRestart
	public double DROPCHANCE_KAPOK_FROM_JUNGLE = 0.07d;
	
	@Name("Dropchance: Bones from Stone")
	@RangeDouble(min = 0, max = 1)
	@Comment("Chance a bone drop from a stone. 1 is 100%, 0 is 0%")
	@RequiresMcRestart
	public double DROPCHANCE_BONE_FROM_STONE = 0.02d;
	
	@Name("Dropchance: Sulfur from Neatherrack")
	@RangeDouble(min = 0, max = 1)
	@Comment("Chance a sulfur drop from a neatherrack. 1 is 100%, 0 is 0%")
	@RequiresMcRestart
	public double DROPCHANCE_SULFUR_FROM_NEATHERRACK = 0.02d;
	
	@Name("Dropchance: Saltpeter from Sandstone")
	@RangeDouble(min = 0, max = 1)
	@Comment("Chance a saltpeter drop from a sandstone. 1 is 100%, 0 is 0%")
	@RequiresMcRestart
	public double DROPCHANCE_SALTPETER_FROM_SANDSTONE = 0.02d;
	
	@Name("Dropchance: Fragment from Soul-Sand")
	@RangeDouble(min = 0, max = 1)
	@Comment("Chance a fragment of suffering drop from soul sand. 1 is 100%, 0 is 0%")
	@RequiresMcRestart
	public double DROPCHANCE_FRAGMENT_FROM_SOULSAND = 0.05d;
	
	@Name("Dropchance: False Morel from Mycelium")
	@RangeDouble(min = 0, max = 1)
	@Comment("Chance a false morel drop from mycelium. 1 is 100%, 0 is 0%")
	@RequiresMcRestart
	public double DROPCHANCE_FALSE_MOREL_FROM_MYCELIUM = 0.15d;
	
	@Name("Dropchance: Dolls'Eye from Gras")
	@RangeDouble(min = 0, max = 1)
	@Comment("Chance a dolls'eye drop from gras. 1 is 100%, 0 is 0%")
	@RequiresMcRestart
	public double DROPCHANCE_DOLLS_EYE_FROM_GRAS = 0.01d;
}