package com.raden93.veganlife.init;

import com.raden93.veganlife.VeganLifeConstants;
import com.raden93.veganlife.item.bioplastic.BioplasticItem;
import com.raden93.veganlife.item.bioplastic.PlasticRodItem;
import com.raden93.veganlife.item.bioplastic.PotatoStarchItem;
import com.raden93.veganlife.item.jute.BurlapItem;
import com.raden93.veganlife.item.jute.JuteFibreItem;
import com.raden93.veganlife.item.jute.JuteSeedsItem;
import com.raden93.veganlife.item.jute.JuteStalkItem;
import com.raden93.veganlife.item.wool.KapokTuftItem;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class VeganLifeItems {

	// Jute
	public static final JuteStalkItem jute_stalk_item = new JuteStalkItem();
	public static final JuteFibreItem jute_fibre_item = new JuteFibreItem();
	public static final JuteSeedsItem jute_seeds_item = new JuteSeedsItem();
	public static final BurlapItem burlap_item = new BurlapItem();

	// Bioplastic
	public static final PotatoStarchItem potato_starch_item = new PotatoStarchItem();
	public static final PlasticRodItem plastic_rod_item = new PlasticRodItem();
	public static final BioplasticItem bioplastic_item = new BioplasticItem();
	
	// Wool
	public static final KapokTuftItem kapok_tuft_item = new KapokTuftItem();
	
	public static void init() {
		setName(jute_stalk_item, "jutestalk");
		setName(jute_fibre_item, "jutefibre");
		setName(jute_seeds_item, "juteseeds");
		setName(burlap_item, "burlap");
		setName(potato_starch_item, "potatostarch");
		setName(plastic_rod_item, "plasticrod");
		setName(bioplastic_item, "bioplastic");
		setName(kapok_tuft_item, "kapoktuft");
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
	}
	
	public static void setName(Item item, String name) {
		item.setRegistryName(new ResourceLocation(VeganLifeConstants.MODID, name));
		item.setUnlocalizedName(name);
	}
}
