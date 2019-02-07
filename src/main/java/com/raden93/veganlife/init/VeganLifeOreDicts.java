package com.raden93.veganlife.init;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Nonnull;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;

public class VeganLifeOreDicts {
	
	public static void init() {
		
		//Drops
		OreDictionary.registerOre("rosin", VeganLifeItems.rosin_item);
		OreDictionary.registerOre("materialRosin", VeganLifeItems.rosin_item);
		
		OreDictionary.registerOre("sheetPlastic", VeganLifeItems.bioplastic_item);
		OreDictionary.registerOre("stickPlastic", VeganLifeItems.plastic_rod_item);
		
		// Color
		OreDictionary.registerOre("dyeWhite", new ItemStack(VeganLifeItems.vegetable_oil_ink_item,1,1));
		OreDictionary.registerOre("dyeBlack", new ItemStack(VeganLifeItems.vegetable_oil_ink_item,1,0));
		
		// Mining
		OreDictionary.registerOre("dustSulfur", new ItemStack(VeganLifeItems.sulfur_item));
		OreDictionary.registerOre("dustSulphur", new ItemStack(VeganLifeItems.sulfur_item));
		OreDictionary.registerOre("dustSaltpeter", new ItemStack(VeganLifeItems.saltpeter_item));
		OreDictionary.registerOre("dustNiter", new ItemStack(VeganLifeItems.saltpeter_item));
		OreDictionary.registerOre("dustNitre", new ItemStack(VeganLifeItems.saltpeter_item));
		
		// Oil
		OreDictionary.registerOre("cropSunflower", new ItemStack(VeganLifeItems.sunflower_seeds_item));
		OreDictionary.registerOre("itemWax", new ItemStack(VeganLifeItems.vegetable_wax_item));
		
		// Mob Items
		OreDictionary.registerOre("leather", VeganLifeItems.burlap_item);
		OreDictionary.registerOre("slimeball", new ItemStack(VeganLifeItems.resin_item));
		OreDictionary.registerOre("feather", VeganLifeItems.faux_feather_item);
		OreDictionary.registerOre("spiderEye", new ItemStack(Items.SPIDER_EYE));
		OreDictionary.registerOre("spiderEye", new ItemStack(VeganLifeItems.dolls_eye_item));
		OreDictionary.registerOre("spiderEye", new ItemStack(VeganLifeItems.flase_morel_item));
		OreDictionary.registerOre("ghastTear", new ItemStack(Items.GHAST_TEAR));
		OreDictionary.registerOre("ghastTear", new ItemStack(VeganLifeItems.proof_of_suffering_item));
		
		// Wool
		registerOreDicsWoolForKapok();

		// Pam's Harvestcraft
		OreDictionary.registerOre("cropJute", new ItemStack(VeganLifeItems.jute_stalk_item));
		OreDictionary.registerOre("foodOliveoil", new ItemStack(VeganLifeItems.vegetable_oil_item));
		
		// ThermalFoundation
		OreDictionary.registerOre("globRosin", new ItemStack(VeganLifeItems.rosin_item));
		
		changeVanillaRecips();
	}
	
	/**
	 * Register every wool and kapok item for his color oredict and the parent oredict "wool"
	 */
	private static void registerOreDicsWoolForKapok() {
		String[] oreDicNames = { "woolWhite", "woolOrange", "woolMagenta", "woolLight_blue", "woolYellow", "woolLime","woolPink", 
				"woolGray", "woolSilver", "woolCyan", "woolPurple", "woolBlue", "woolBrown", "woolGreen", "woolRed", "woolBlack" };
		for( int i = 0; i <= 15; i++) {
			OreDictionary.registerOre("wool", new ItemStack(VeganLifeBlocks.kapok_block,1,i));
			OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL, 1, i));
			
			OreDictionary.registerOre(oreDicNames[i], new ItemStack(VeganLifeBlocks.kapok_block,1,i));
			OreDictionary.registerOre(oreDicNames[i], new ItemStack(Blocks.WOOL, 1, i));
		}
	}
	
	private static void changeVanillaRecips() {
		 // Build our list of items to replace with ore tags
        Map<ItemStack, String> replacements = new HashMap<ItemStack, String>();
        Map<ItemStack, String> parent = new HashMap<ItemStack, String>();

        replacements.put(new ItemStack(Items.SPIDER_EYE), "spiderEye");
        replacements.put(new ItemStack(Items.GHAST_TEAR), "ghastTear");
        for (EnumDyeColor color : EnumDyeColor.values()) {
        	ItemStack woolDye = new ItemStack(Blocks.WOOL,1,color.getMetadata());
        	replacements.put(woolDye, "wool" + color.getName().substring(0, 1).toUpperCase() + color.getName().substring(1));
        	parent.put(woolDye, "wool");
		}

        // Ignore recipes for the following items
        ItemStack[] exclusions = new ItemStack[] {};

        FMLLog.log.info("Starts to replace vanilla recipe ingredients with ore ingredients.");
        int replaced = 0;
        // Search vanilla recipes for recipes to replace
        for(IRecipe obj : CraftingManager.REGISTRY)
        {
        	String name = obj.getRegistryName().toString();
            if((obj.getClass() == ShapedRecipes.class || obj.getClass() == ShapelessRecipes.class))
            {
       
                ItemStack output = obj.getRecipeOutput();
                if (!output.isEmpty() && containsMatch(false, new ItemStack[]{ output }, exclusions))
                {
                    continue;
                }

                NonNullList<Ingredient> lst = obj.getIngredients();
                for (int x = 0; x < lst.size(); x++)
                {
                    Ingredient ing = lst.get(x);
                    ItemStack[] ingredients = ing.getMatchingStacks();
                    String oreName = null;
                    boolean skip = false;

                    for (ItemStack stack : ingredients)
                    {
                        boolean matches = false;
                        for (Entry<ItemStack, String> ent : replacements.entrySet())
                        {
                            if (OreDictionary.itemMatches(ent.getKey(), stack, true))
                            {
                                matches = true;
                                if (oreName != null && !oreName.equals(ent.getValue()))
                                {
                                	// For minecraft recipes like painting. They have multi values for one ingredient with different metadata.
                                	String parentValue = parent.get(ent.getKey());
                                	if(parentValue != null && !parentValue.equals("")) {
                                		oreName = parentValue;
                                	}
                                	else {
                                		FMLLog.log.info("Invalid recipe \"" + name + 
                                				"\" found with multiple oredict ingredients in the same ingredient... ");
                                        skip = true;
                                        break;
                                	} 
                                }
                                else if (oreName == null)
                                {
                                    oreName = ent.getValue();
                                    break;
                                }
                            }
                        }
                        if (!matches && oreName != null)
                        {
                            skip = true;
                        }
                        if (skip)
                            break;
                    }
                    if (!skip && oreName != null)
                    {
                        //Replace!
                        lst.set(x, new OreIngredient(oreName));
                        replaced++;
                    }
                }
            }
        }

        FMLLog.log.info("Replaced {} ore ingredients", replaced);
    }
	
	private static boolean containsMatch(boolean strict, ItemStack[] inputs, @Nonnull ItemStack... targets)
    {
        for (ItemStack input : inputs)
        {
            for (ItemStack target : targets)
            {
                if (OreDictionary.itemMatches(target, input, strict))
                {
                    return true;
                }
            }
        }
        return false;
    }

}
