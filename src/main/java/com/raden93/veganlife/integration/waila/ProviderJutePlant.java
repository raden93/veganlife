package com.raden93.veganlife.integration.waila;

import java.util.List;

import com.raden93.veganlife.block.jute.JuteCropBlock;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ProviderJutePlant implements IWailaDataProvider {
	
	@Override
	public List<String> getWailaHead(ItemStack itemStack, List<String> toolTip, IWailaDataAccessor accessor, IWailaConfigHandler config)
	{
		return toolTip;
	}
	
	@Override
	public List<String> getWailaTail(ItemStack itemStack, List<String> toolTip, IWailaDataAccessor accessor, IWailaConfigHandler config)
	{
		return toolTip;
	}
	
	@Override
	public List<String> getWailaBody(ItemStack itemStack, List<String> toolTip, IWailaDataAccessor accessor, IWailaConfigHandler config)
	{
		if (config.getConfig("general.showcrop"))
		{
			float growthValue = ((JuteCropBlock) accessor.getBlock()).getCurrentStateInProcent(accessor.getWorld(), accessor.getPosition(), accessor.getBlockState());
			growthValue = Math.round(growthValue * 100.0F);
			if (growthValue < 100)
				toolTip.add(I18n.format("veganlife.waila.format", I18n.format("veganlife.waila.context.growth.title"), I18n.format("veganlife.waila.context.growth.value", growthValue)));
			else
				toolTip.add(I18n.format("veganlife.waila.format"));
		}

		return toolTip;
	}
	
	@Override
	public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, BlockPos pos)
	{
		return null;
	}
	
	@Override
	public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config)
	{
		return null;
	}
	
	public static void callbackRegister(IWailaRegistrar register) {
		register.registerBodyProvider(new ProviderJutePlant(), JuteCropBlock.class);
	}

}
