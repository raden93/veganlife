package com.raden93.veganlife.init;

import com.raden93.veganlife.VeganLifeConstants;
import com.raden93.veganlife.item.bioplastic.BioplasticItem;
import com.raden93.veganlife.item.bioplastic.PlasticRodItem;
import com.raden93.veganlife.item.bioplastic.PotatoStarchItem;
import com.raden93.veganlife.item.enderperl.FrozenBubbleItem;
import com.raden93.veganlife.item.enderperl.SoapItem;
import com.raden93.veganlife.item.enderperl.SoapSolutionItem;
import com.raden93.veganlife.item.jute.BurlapItem;
import com.raden93.veganlife.item.jute.JuteFibreItem;
import com.raden93.veganlife.item.jute.JuteSeedsItem;
import com.raden93.veganlife.item.jute.JuteStalkItem;
import com.raden93.veganlife.item.mining.SaltpeterItem;
import com.raden93.veganlife.item.mining.SulfurItem;
import com.raden93.veganlife.item.mobitems.DollsEyeItem;
import com.raden93.veganlife.item.mobitems.FragmentOfSufferingItem;
import com.raden93.veganlife.item.mobitems.ProofOfSufferinggItem;
import com.raden93.veganlife.item.mobitems.FauxFeatherItem;
import com.raden93.veganlife.item.mobitems.FragmentOfSufferingItem;
import com.raden93.veganlife.item.mobitems.ProofOfSufferinggItem;
import com.raden93.veganlife.item.oil.SunflowerSeedsItem;
import com.raden93.veganlife.item.oil.VegetableOilInkItem;
import com.raden93.veganlife.item.oil.VegetableOilItem;
import com.raden93.veganlife.item.oil.VegetableWaxItem;
import com.raden93.veganlife.item.slimeballs.ResinItem;
import com.raden93.veganlife.item.slimeballs.RosinItem;
import com.raden93.veganlife.item.wool.KapokTuftItem;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

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
	
	// Slimeballs
	public static final ResinItem resin_item = new ResinItem();
	public static final RosinItem rosin_item = new RosinItem();
	
	// Mining Drops
	public static final SaltpeterItem saltpeter_item = new SaltpeterItem();
	public static final SulfurItem sulfur_item = new SulfurItem();
	
	// mob items
	public static final DollsEyeItem dolls_eye_item = new DollsEyeItem();
	public static final FragmentOfSufferingItem fragment_of_suffering_item = new FragmentOfSufferingItem();
	public static final ProofOfSufferinggItem proof_of_suffering_item = new ProofOfSufferinggItem();
	public static final FauxFeatherItem faux_feather_item = new FauxFeatherItem();
	
	// vegetable oil
	public static final SunflowerSeedsItem sunflower_seeds_item = new SunflowerSeedsItem();
	public static final VegetableOilItem vegetable_oil_item = new VegetableOilItem();
	public static final VegetableWaxItem vegetable_wax_item = new VegetableWaxItem();
	public static final VegetableOilInkItem vegetable_oil_ink_item = new VegetableOilInkItem();
	
	//enderperl
	public static final SoapItem soap_item = new SoapItem();
	public static final SoapSolutionItem soap_solution_item = new SoapSolutionItem();
	public static final FrozenBubbleItem frozen_bubble_item = new FrozenBubbleItem();
	
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
	}
	
	public static void setName(Item item, String name) {
		item.setRegistryName(new ResourceLocation(VeganLifeConstants.MODID, name));
		item.setUnlocalizedName(name);
	}
}
