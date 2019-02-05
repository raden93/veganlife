package com.raden93.veganlife.integration.waila;

import java.util.List;

import com.raden93.veganlife.block.jute.JuteCropBlock;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

public class ProviderJutePlant extends WailaProvider  {

	@Override
	public List<String> getWailaBody(ItemStack itemStack, List<String> toolTip, IWailaDataAccessor accessor,
			IWailaConfigHandler config) {
		if (config.getConfig("general.showcrop"))
		{
			float growthValue = ((JuteCropBlock) accessor.getBlock()).getCurrentStateInProcent(accessor.getWorld(), accessor.getPosition(), accessor.getBlockState());
			growthValue = Math.round(growthValue * 100.0F);
			if (growthValue < 100)
				toolTip.add(I18n.format("veganlife.waila.format", I18n.format("veganlife.waila.context.growth.title"), I18n.format("veganlife.waila.context.growth.value", growthValue)));
		}

		return toolTip;
	}
}
