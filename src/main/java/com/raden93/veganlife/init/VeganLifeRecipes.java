package com.raden93.veganlife.init;

import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class VeganLifeRecipes {
	
	public static void registerSmelting() {
		GameRegistry.addSmelting(VeganLifeItems.potato_starch_item, new ItemStack(VeganLifeItems.bioplastic_item, 2), 0.35f);
		GameRegistry.addSmelting(VeganLifeItems.resin_item, new ItemStack(VeganLifeItems.rosin_item, 1), 0.2f);
		GameRegistry.addSmelting(VeganLifeItems.vegetable_oil_item, new ItemStack(VeganLifeItems.vegetable_wax_item, 1), 0.2f);	
	}
	
	public static void registerRecipes() {
		// ------------ recipe: water + charcoal => wood ash lye bucket
		Ingredient[] ingredients =  new Ingredient[]{ 
				Ingredient.fromStacks(new ItemStack(Items.COAL, 1,1)),
				Ingredient.fromStacks(new ItemStack(Items.COAL, 1,1)),
				Ingredient.fromStacks(new ItemStack(Items.COAL, 1,1)),
				Ingredient.fromStacks(new ItemStack(Items.WATER_BUCKET))};
		
		addRecipe("woodashlye", FluidUtil.getFilledBucket(new FluidStack(VeganLifeBlocks.wood_ash_lye_fluid, 1)), ingredients);
		
		// ------------ recipe: Wood Ash Lye + Vegetable Oil + Rosin => Soap
		//TODO: use foodOliveoil oredict instead of vegetable oil
		Ingredient[] ingredientsSoap =  new Ingredient[]{ 
				Ingredient.fromStacks(FluidUtil.getFilledBucket(new FluidStack(VeganLifeBlocks.wood_ash_lye_fluid, 1))),
				Ingredient.fromStacks(new ItemStack(VeganLifeItems.vegetable_oil_item)),
				Ingredient.fromStacks(new ItemStack(VeganLifeItems.rosin_item))};
		
		addRecipe("soap", new ItemStack(VeganLifeItems.soap_item), ingredientsSoap);
		
		// ------------ recipe: Raw Ender + FrozenBubble => Enderperl
		Ingredient[] ingredientsEnderperl =  new Ingredient[]{ 
				Ingredient.fromStacks(FluidUtil.getFilledBucket(new FluidStack(VeganLifeBlocks.raw_ender_fluid,1))),
				Ingredient.fromStacks(new ItemStack(VeganLifeItems.frozen_bubble_item))};
		
		addRecipe("enderperl", new ItemStack(Items.ENDER_PEARL), ingredientsEnderperl);
		
		addKapokColorRecipes();
	}
	
	private static void addRecipe(String name, ItemStack output, Ingredient[] input)
	{
		ResourceLocation locName  = new ResourceLocation("veganlife:" + name);
		ResourceLocation group = null;
		GameRegistry.addShapelessRecipe(locName, group, output, input);
	}
	
	private static void addKapokColorRecipes() {
		for (EnumDyeColor color : EnumDyeColor.values()) {
			Ingredient[] ingredientsKapok;
			ingredientsKapok =  new Ingredient[]{ 
					Ingredient.fromStacks(new ItemStack(VeganLifeBlocks.kapok_block,1, OreDictionary.WILDCARD_VALUE)),
					Ingredient.fromStacks(new ItemStack(Items.DYE,1,color.getMetadata()))};
			
			addRecipe("kapok" + color.getDyeColorName(), new ItemStack(VeganLifeBlocks.kapok_block, 1, 15 - color.getMetadata()), ingredientsKapok);
		}
	}

}
