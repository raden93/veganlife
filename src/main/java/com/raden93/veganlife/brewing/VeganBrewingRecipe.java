package com.raden93.veganlife.brewing;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.common.brewing.BrewingRecipe;

public class VeganBrewingRecipe extends BrewingRecipe {
	
	 private ItemStack input;
	 private ItemStack ingredient;
	 private ItemStack output;

	public VeganBrewingRecipe(ItemStack input, ItemStack ingredient, ItemStack output) {
		super(input, ingredient, output);
		this.input = input;
		this.ingredient = ingredient;
		this.output = output;
	}
	
	@Override
    public boolean isInput(@Nonnull ItemStack stack)
    {
        return PotionUtils.getPotionFromItem(stack) == PotionUtils.getPotionFromItem(input);
    }
	
	@Override
    public boolean isIngredient(@Nonnull ItemStack stack)
    {
		return stack.getItem().equals(ingredient.getItem());
    }
	
	 @Nonnull
	 @Override
	 public ItemStack getOutput(@Nonnull ItemStack input, @Nonnull ItemStack ingredient)
	 {
	     if (isInput(input) && isIngredient(ingredient)) 
	    	 return output;
	     return ItemStack.EMPTY;
	 }

}
