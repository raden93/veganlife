package com.raden93.veganlife.integration.waila;

import java.util.List;

import com.raden93.veganlife.block.jute.BaleOfJuteBlock;
import com.raden93.veganlife.util.BlockUtil;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

public class ProviderBaleOfJute extends WailaProvider {

	@Override
	public List<String> getWailaBody(ItemStack itemStack, List<String> toolTip, IWailaDataAccessor accessor,
			IWailaConfigHandler config) {
		BaleOfJuteBlock blockRettable = (BaleOfJuteBlock) accessor.getBlock();
		float rettingPercent = BaleOfJuteBlock.getRettingStatus(accessor.getWorld(), accessor.getPosition());
		if (rettingPercent >= 1)
			toolTip.add(I18n.format("veganlife.waila.info.retting.finish"));
		else
		{
			if (BlockUtil.isBlockInOrAdjacentMaterial(accessor.getWorld(), accessor.getPosition(), Material.WATER))
				toolTip.add(
					I18n.format("veganlife.waila.format", 
								I18n.format("veganlife.waila.context.retting.title"), 
								I18n.format("veganlife.waila.content.retting.value",  Math.round(rettingPercent * 100F))));
			else
				toolTip.add(I18n.format("veganlife.waila.info.retting.nowater"));
		}
		return toolTip;
	}

}
