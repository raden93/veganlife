package com.raden93.veganlife.init;

import com.raden93.veganlife.VeganLifeConstants;
import com.raden93.veganlife.item.BaseVeganItem;
import com.raden93.veganlife.item.ContainerVeganItem;
import com.raden93.veganlife.item.InkVeganItem;
import com.raden93.veganlife.item.SeedsVeganItem;
import com.raden93.veganlife.item.SoapVeganItem;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class VeganLifeItems {

	// Jute
	public static final BaseVeganItem jute_stalk_item = new BaseVeganItem();
	public static final BaseVeganItem jute_fibre_item = new BaseVeganItem();
	public static final BaseVeganItem burlap_item = new BaseVeganItem();
	public static final SeedsVeganItem jute_seeds_item = new SeedsVeganItem(VeganLifeBlocks.jute_crop_block);

	// Bioplastic
	public static final BaseVeganItem potato_starch_item = new BaseVeganItem();
	public static final BaseVeganItem plastic_rod_item = new BaseVeganItem();
	public static final BaseVeganItem bioplastic_item = new BaseVeganItem();
	
	// Wool
	public static final BaseVeganItem kapok_tuft_item = new BaseVeganItem();
	
	// Slimeballs
	public static final BaseVeganItem resin_item = new BaseVeganItem();
	public static final BaseVeganItem rosin_item = new BaseVeganItem();
	
	// Mining Drops
	public static final BaseVeganItem saltpeter_item = new BaseVeganItem();
	public static final BaseVeganItem sulfur_item = new BaseVeganItem();
	
	// mob items
	public static final BaseVeganItem dolls_eye_item = new BaseVeganItem();
	public static final BaseVeganItem fragment_of_suffering_item = new BaseVeganItem();
	public static final BaseVeganItem proof_of_suffering_item = new BaseVeganItem();
	public static final BaseVeganItem faux_feather_item = new BaseVeganItem();
	public static final BaseVeganItem flase_morel_item = new BaseVeganItem();
	public static final BaseVeganItem faux_rabbit_foot_item = new BaseVeganItem();
	
	// vegetable oil
	public static final BaseVeganItem sunflower_seeds_item = new BaseVeganItem();
	public static final BaseVeganItem vegetable_wax_item = new BaseVeganItem();
	public static final InkVeganItem vegetable_oil_ink_item = new InkVeganItem();
	public static final ContainerVeganItem vegetable_oil_item = new ContainerVeganItem(Items.GLASS_BOTTLE);
	
	// enderperl
	public static final BaseVeganItem frozen_bubble_item = new BaseVeganItem();
	public static final ContainerVeganItem soap_solution_item = new ContainerVeganItem(Items.GLASS_BOTTLE);
	public static final SoapVeganItem soap_item = new SoapVeganItem();
	
	//mob-head
	public static final BaseVeganItem paper_mache = new BaseVeganItem();
	public static final BaseVeganItem blank_mob_head = new BaseVeganItem(1);
	
	public static void init() {
		setName(jute_stalk_item, "jutestalk");
		setName(jute_fibre_item, "jutefibre");
		setName(jute_seeds_item, "juteseeds");
		setName(burlap_item, "burlap");
		setName(potato_starch_item, "potatostarch");
		setName(plastic_rod_item, "plasticrod");
		setName(bioplastic_item, "bioplastic");
		setName(kapok_tuft_item, "kapoktuft");
		setName(resin_item, "resin");
		setName(rosin_item, "rosin");
		setName(saltpeter_item, "saltpeter");
		setName(sulfur_item, "sulfur");
		setName(dolls_eye_item, "dollseye");
		setName(fragment_of_suffering_item, "fragmentofsuffering");
		setName(proof_of_suffering_item, "proofofsuffering");
		setName(faux_feather_item, "fauxfeather");
		setName(sunflower_seeds_item, "sunflowerseeds");
		setName(vegetable_oil_item, "vegetableoil");
		setName(vegetable_wax_item, "vegetablewax");
		setName(vegetable_oil_ink_item, "vegetableoilink");
		setName(soap_item, "soap");
		setName(soap_solution_item, "soapsolution");
		setName(frozen_bubble_item, "frozenbubble");
		setName(flase_morel_item, "falsemorel");
		setName(faux_rabbit_foot_item, "fauxrabbitfoot");
		setName(paper_mache, "papermache");
		setName(blank_mob_head, "blankmobhead");
	}
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(jute_stalk_item);
		registry.register(jute_fibre_item);
		registry.register(jute_seeds_item);
		registry.register(burlap_item);
		registry.register(potato_starch_item);
		registry.register(plastic_rod_item);
		registry.register(bioplastic_item);
		registry.register(kapok_tuft_item);
		registry.register(resin_item);
		registry.register(rosin_item);
		registry.register(saltpeter_item);
		registry.register(sulfur_item);
		registry.register(dolls_eye_item);
		registry.register(fragment_of_suffering_item);
		registry.register(proof_of_suffering_item);
		registry.register(faux_feather_item);
		registry.register(sunflower_seeds_item);
		registry.register(vegetable_oil_item);
		registry.register(vegetable_wax_item);
		registry.register(vegetable_oil_ink_item);
		registry.register(soap_item);
		registry.register(soap_solution_item);
		registry.register(frozen_bubble_item);
		registry.register(flase_morel_item);
		registry.register(faux_rabbit_foot_item);
		registry.register(paper_mache);
		registry.register(blank_mob_head);
	}
	
	public static void setName(Item item, String name) {
		item.setRegistryName(new ResourceLocation(VeganLifeConstants.MODID, name));
		item.setUnlocalizedName(name);
	}
}
