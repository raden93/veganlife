package com.raden93.veganlife.init;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Nonnull;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
		OreDictionary.registerOre("wool", new ItemStack(Blocks.WOOL));
		OreDictionary.registerOre("wool", new ItemStack(VeganLifeBlocks.kapok_block));changeVanillaRecips();
		
		// Pam's Harvestcraft
		OreDictionary.registerOre("cropJute", new ItemStack(VeganLifeItems.jute_stalk_item));
		OreDictionary.registerOre("foodSesameoil", new ItemStack(VeganLifeItems.vegetable_oil_item));
		
		changeVanillaRecips();
	}
	
	private static void changeVanillaRecips() {
		 // Build our list of items to replace with ore tags
        Map<ItemStack, String> replacements = new HashMap<ItemStack, String>();


        replacements.put(new ItemStack(Items.SPIDER_EYE), "spiderEye");
        replacements.put(new ItemStack(Items.GHAST_TEAR), "ghastTear");
        replacements.put(new ItemStack(Blocks.WOOL), "wool");

        // Ignore recipes for the following items
        ItemStack[] exclusions = new ItemStack[]
        {
        };

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
                                    FMLLog.log.info("Invalid recipe found with multiple oredict ingredients in the same ingredient..."); //TODO: Write a dumper?
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
