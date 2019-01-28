package com.raden93.veganlife.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class VeganLifeRecipes {
	
	public static void registerSmelting() {
		GameRegistry.addSmelting(VeganLifeItems.potato_starch_item, new ItemStack(VeganLifeItems.bioplastic_item, 2), 0.35f);
		GameRegistry.addSmelting(VeganLifeItems.resin_item, new ItemStack(VeganLifeItems.rosin_item, 1), 0.2f);
		GameRegistry.addSmelting(VeganLifeItems.vegetable_oil_item, new ItemStack(VeganLifeItems.vegetable_wax_item, 1), 0.2f);
	}
	
	public static void registerRecipes() {
		addRecipe("woodashlye", FluidUtil.getFilledBucket(new FluidStack(VeganLifeBlocks.wood_ash_lye_fluid, 1)), new Ingredient[]{ Ingredient.fromStacks(new ItemStack(Items.COAL, 3,1)), Ingredient.fromStacks(new ItemStack(Items.WATER_BUCKET))});
	}
	
	private static void addRecipe(String name, ItemStack output, Ingredient[] input)
	{
		ResourceLocation locName  = new ResourceLocation("veganlife:" + name);
		ResourceLocation group = null;
		GameRegistry.addShapelessRecipe(locName, group, output, input);
	}

}
