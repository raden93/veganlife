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
		
		OreDictionary.registerOre("sheetPlastic", VeganLifeItems.bioplastic_item);
		OreDictionary.registerOre("stickPlastic", VeganLifeItems.plastic_rod_item);
		
		// Color
		OreDictionary.registerOre("dyeWhite", new ItemStack(VeganLifeItems.vegetable_oil_ink_item,1,1));
		OreDictionary.registerOre("dyeBlack", new ItemStack(VeganLifeItems.vegetable_oil_ink_item,1,0));
		
		// Mob Items
		OreDictionary.registerOre("leather", VeganLifeItems.burlap_item);
		OreDictionary.registerOre("slimeball", new ItemStack(VeganLifeItems.resin_item));
		OreDictionary.registerOre("feather", VeganLifeItems.faux_feather_item);
		OreDictionary.registerOre("spiderEye", new ItemStack(Items.SPIDER_EYE));
		OreDictionary.registerOre("spiderEye", new ItemStack(VeganLifeItems.dolls_eye_item));
		OreDictionary.registerOre("spiderEye", new ItemStack(VeganLifeItems.flase_morel_item));
		OreDictionary.registerOre("ghastTear", new ItemStack(Items.GHAST_TEAR));
		OreDictionary.registerOre("ghastTear", new ItemStack(VeganLifeItems.proof_of_suffering_item));
		
		// Wool ( work for everything except painting recipe )
		OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL));
		OreDictionary.registerOre("wool", new ItemStack(VeganLifeBlocks.kapok_block, 1, 0));
		OreDictionary.registerOre("woolWhite", new ItemStack(Blocks.WOOL, 1, 0));
		OreDictionary.registerOre("woolWhite", new ItemStack(VeganLifeBlocks.kapok_block, 1 ,0));
		OreDictionary.registerOre("woolOrange", new ItemStack(Blocks.WOOL, 1, 1));
		OreDictionary.registerOre("woolOrange", new ItemStack(VeganLifeBlocks.kapok_block, 1 ,1));
		OreDictionary.registerOre("woolMagenta", new ItemStack(Blocks.WOOL, 1 ,2));
		OreDictionary.registerOre("woolMagenta", new ItemStack(VeganLifeBlocks.kapok_block, 1 ,2));
		OreDictionary.registerOre("woolLight_blue", new ItemStack(Blocks.WOOL, 1 ,3));
		OreDictionary.registerOre("woolLight_blue", new ItemStack(VeganLifeBlocks.kapok_block, 1 ,3));
		OreDictionary.registerOre("woolYellow", new ItemStack(Blocks.WOOL, 1 ,4));
		OreDictionary.registerOre("woolYellow", new ItemStack(VeganLifeBlocks.kapok_block, 1 ,4));
		OreDictionary.registerOre("woolLime", new ItemStack(Blocks.WOOL, 1 ,5));
		OreDictionary.registerOre("woolLime", new ItemStack(VeganLifeBlocks.kapok_block, 1 ,5));
		OreDictionary.registerOre("woolPink", new ItemStack(Blocks.WOOL, 1 ,6));
		OreDictionary.registerOre("woolPink", new ItemStack(VeganLifeBlocks.kapok_block, 1 ,6));
		OreDictionary.registerOre("woolGray", new ItemStack(Blocks.WOOL, 1 ,7));
		OreDictionary.registerOre("woolGray", new ItemStack(VeganLifeBlocks.kapok_block, 1 ,7));
		OreDictionary.registerOre("woolSilver", new ItemStack(Blocks.WOOL, 1 ,8));
		OreDictionary.registerOre("woolSilver", new ItemStack(VeganLifeBlocks.kapok_block, 1 ,8));
		OreDictionary.registerOre("woolCyan", new ItemStack(Blocks.WOOL, 1 ,9));
		OreDictionary.registerOre("woolCyan", new ItemStack(VeganLifeBlocks.kapok_block, 1 ,9));
		OreDictionary.registerOre("woolPurple", new ItemStack(Blocks.WOOL, 1 ,10));
		OreDictionary.registerOre("woolPurple", new ItemStack(VeganLifeBlocks.kapok_block, 1 ,10));
		OreDictionary.registerOre("woolBlue", new ItemStack(Blocks.WOOL, 1 ,11));
		OreDictionary.registerOre("woolBlue", new ItemStack(VeganLifeBlocks.kapok_block, 1 ,11));
		OreDictionary.registerOre("woolBrown", new ItemStack(Blocks.WOOL, 1 ,12));
		OreDictionary.registerOre("woolBrown", new ItemStack(VeganLifeBlocks.kapok_block, 1 ,12));
		OreDictionary.registerOre("woolGreen", new ItemStack(Blocks.WOOL, 1 ,13));
		OreDictionary.registerOre("woolGreen", new ItemStack(VeganLifeBlocks.kapok_block, 1 ,13));
		OreDictionary.registerOre("woolRed", new ItemStack(Blocks.WOOL, 1 ,14));
		OreDictionary.registerOre("woolRed", new ItemStack(VeganLifeBlocks.kapok_block, 1 ,14));
		OreDictionary.registerOre("woolBlack", new ItemStack(Blocks.WOOL, 1 ,15));
		OreDictionary.registerOre("woolBlack", new ItemStack(VeganLifeBlocks.kapok_block, 1 ,15));

		// Pam's Harvestcraft
		OreDictionary.registerOre("cropJute", new ItemStack(VeganLifeItems.jute_stalk_item));
		OreDictionary.registerOre("foodSesameoil", new ItemStack(VeganLifeItems.vegetable_oil_item));
		
		changeVanillaRecips();
	}
	
	/* TODO: Fix Problem that wool oredict the color oredict override
	private static void registerOreDicsWoolForKapok() {
		for( int i = 0; i <= 15; i++) {
			OreDictionary.registerOre("wool", new ItemStack(VeganLifeBlocks.kapok_block,1,i));
		}
	}
	*/
	
	private static void changeVanillaRecips() {
		 // Build our list of items to replace with ore tags
        Map<ItemStack, String> replacements = new HashMap<ItemStack, String>();


        replacements.put(new ItemStack(Items.SPIDER_EYE), "spiderEye");
        replacements.put(new ItemStack(Items.GHAST_TEAR), "ghastTear");
        replacements.put(new ItemStack(Blocks.WOOL), "wool");
        for (EnumDyeColor color : EnumDyeColor.values()) {
        	replacements.put(new ItemStack(Blocks.WOOL,1,color.getMetadata()), "wool" + color.getName().substring(0, 1).toUpperCase() + color.getName().substring(1));
		}

        // Ignore recipes for the following items
        ItemStack[] exclusions = new ItemStack[] {};

        FMLLog.log.info("Starts to replace vanilla recipe ingredients with ore ingredients.");
        int replaced = 0;
        // Search vanilla recipes for recipes to replace
        for(IRecipe obj : CraftingManager.REGISTRY)
        {
        	String name = obj.getRegistryName().toString();
        	// Not contain wool is a workaround, that white kapok can create all wool items AND colonized kapok
            if((obj.getClass() == ShapedRecipes.class || obj.getClass() == ShapelessRecipes.class) && !name.contains("wool") )
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
                                    FMLLog.log.info("Invalid recipe found with multiple oredict ingredients in the same ingredient... "); //TODO: Write a dumper?
                                    skip = true;
                                    break;
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
                            //TODO: Properly fix this, Broken recipe example: Beds
                            //FMLLog.info("Invalid recipe found with ingredient that partially matches ore entries..."); //TODO: Write a dumper?
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
