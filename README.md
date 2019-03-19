# Vegan Life

This should be an remastered version of [vegan option](https://github.com/squeek502/VeganOption) for the Minecraft Version 1.12.2. It isn't contain every feature from Vegan Option and some recipes have change.

When you have some more ideas, or want to implements some more features from Vegan Option, make a Pull-Request. I'm happy for improvements! 

## Dokumentation

Short descriptions for all veganL life items:

 - [Jute](dokumentation/jute.md)
 - [Kapok](dokumentation/kapok.md)
 - [Bioplastik](dokumentation/bioplastic.md)
 - [Vegetable oil and Ink](dokumentation/oil.md)
 - [Resin and Rosin](dokumentation/resin.md)
 - [Enderperl](dokumentation/enderperl.md)
 - [Faux Feather](dokumentation/fauxfeather.md)
 - [Fossils](dokumentation/fossils.md)
 - [Gunpowder](dokumentation/gunpowder.md)
 - [Spider Eye](dokumentation/spidereye.md)
 - [Proof of Suffering](dokumentation/suffering.md)
 - [Rabbit's Foot](dokumentation/rabbitsfoot.md)
 - [Shulker Shell](dokumentation/shulker_shell.md)

## Known Bugs:
 
 Nothing :-)

## Changelog


### 1.4.0

#### Features

- [x] Skull recipes
	- [x] Create Papermache item
	- [x] Create Blank Mob Head item
	- [x] Create recipes for skeleton, wither, zombie, steve, creeper and dragon skull
	
- [x] Blaze Rod
    - [x] Create recipe to create a Blaze Rod

#### Features

- [x] Rabbit's Foot
	- [x] Create Faux Rabbit's Foot Item
	- [x] Create Recipe for Faux Rabbit's Foot Item
	- [x] Faux Rabbit's Foot Item can be used instead of Rabbit's Foot
	
- [x] Shulker Shell
    - [x] Create Flying Endblock
    - [x] Flying Endblock can be craft with 4 Endblocks, 4 Chorus Flowers and a Soap Solution
    - [x] Flying Endblock fly when they was add to the world
    - [x] Flying Endblocks drops Shulker Shells with a little chance, dependents how long it flying 

### 1.2.0

#### Features

- [x] Encrusted Obsidian recipe use forge obsidian ore dict
- [x] Wool ore dicts renamed to correct convension: blackWool, redWool ...
- [x] Minecraft Wool recipes works now correctly with kapok, also for painting 
- [x] Change Creative Tab Icon to Burlap Texture
- [x] Added raw ender bucket and wood ash lye bucket to Creative Tab

##### Pam's Harvestcraft Integration

- [x] Vegetable Oil use now foodOliveoil ore dict
- [x] Sunflower seeds was added to the ore dict

##### Forestry 

- [x] Vegetable Wax get ore dict "itemWax"

##### Other Integration 

- [x] Sulfur get ore dicts "dustSulfur" and "dustSulphur" ( "dustSulfur" is used for gunpowder recipe )
- [x] Saltpeter get ore dicts "dustNiter", "dustNitre" and "dustSaltpeter" ( "dustSaltpeter" is used for gunpowder recipe )
- [x] Rosin get ore dicts "rosin", "materialRosin" and "globRosin"

#### Bugs

- [x] fix that mod crash server ( NoSuchMethodError: net.minecraft.item.EnumDyeColor.func )
- [x] Vegetable oil recipe use now correct ingredients  

### 1.1.0

#### Features

- [x] All wool recipes working with kapok blocks except painting recipe. You can craft for example red beds with kapok blocks.

##### Pam's Harvestcraft Integration

- [x] HarvestCraft Jute can be use instead of Jute Stalk
- [x] Vegetable Oil can be used instead of sesam oil

#### Hwyla (waila)

- [x] Added Hwyla support for jute crop
- [x] Added Hwyla support for retting bale of jute

#### Bugs

- [x] Kapok can be colorized with dye correctly
- [x] Encrusted Obsidian is in the Creation Mode Tab
- [x] Vegetable Oil Ink can be used to colorized Kapok

### 1.0.0

#### Jute

- [x] Create all Items and Blocks.
    - [x] Jute Seeds
    - [x] Jute Stalk
    - [x] Jute Fibre
    - [x] Burlap
    - [x] Bale of Jute
- [x] Create all recipes.
    - [x] Jute Stalk -> Jute Seeds
    - [x] Jute Stalk -> Bale of Jute
    - [x] Jute Fibre -> Burlap
    - [x] Jute Fibre -> String
- [x] Jute Stalk drops from Ferns.
- [x] Jute Plants growing up to Ferns.
- [x] Bales of Jute retting and drops Jute Fibers.
- [x] Burlap can be use instead of Leather.

#### Kapok

- [x] Create all Items and Blocks.
    - [x] Kapok Tuft
    - [x] Kapok
- [x] Create all recipes.
    - [x] 4 Kapok Tuft -> Kapok
    - [x] 3 Kapok Tuft -> String
- [x] Kapok tufts drop from Jungle Leaves.
- [x] Kapok can be use instead of Wool.

#### Bioplastic

- [x] Create all Items and Blocks.
    - [x] Potato Starch
    - [x] Plastic Rod
    - [x] Bioplastic
- [x] Create all recipes.
    - [x] Potato Starch -> Bioplastic
    - [x] Bioplastic -> Plastic Rod
 
#### Vegetable oil + Ink
 
 - [x] Create all Items.
 	- [x] Sunflower Seeds
 	- [x] Vegetable Oil
 	- [x] Vegetable Wax
 	- [x] Vegetable Oil Ink ( Black + White ) 
 - [x] Create all Items.
 	- [x] Sunflower Seeds
 	- [x] Vegetable Oil
 	- [x] Vegetable Wax
 	- [x] Vegetable Oil Ink ( Black + White ) 
 - [x] Create all recipes.
 	- [x] Sunflower Seeds + Piston + Bottle -> Vegetable Oil
 	- [x] Vegetable Oil -> Vegetable Wax
 	- [x] Vegetable Oil + Vegetable Wax + Rosin + Charcoal -> Black Vegetable Oil Ink
 	- [x] Vegetable Oil + Vegetable Wax + Rosin + Nether Quarz -> White Vegetable Oil Ink
 - [x] Sunflowers drops Sunflower Seeds
 - [x] Black Vegetable Oil Ink can be use instead of Ink Sac
 - [x] White Vegetable Oil Ink can be use instead of Bone Meal ( white dye )
 
#### Resin
 
 - [x] Create all Items.
 	- [x] Resin
 	- [x] Rosin
 - [x] Create all recipes.
 	- [x] Resin -> Rosin
 - [x] Resin drop from Spruce Wood
 - [x] Resin can be use instead of Slimeballs
 
#### Frozen Bubble + Raw Ender ( Ender Pearl alternative )
 
 - [x] Create all recipes.
 	- [x] Frozen Bubble + Bucket of Raw Ender -> Ender Perl
 
##### Frozen Bubble
 
 - [x] Create all Items.
 	- [x] Soap
 	- [x] Soap Solution
 	- [x] Frozen Bubble
 	- [x] Wood Ash Lye
 - [x] Create all recipes.
 	- [x] Water + 3 Charcoal -> Wood Ash Lye
 	- [x] Wood Ash Lye + Vegetable Oil + Rosin -> Soap
 	- [x] Soap + Water + Sugar + Bottle -> Soap Solution
 	- [x] Soap Solution + 8 Ice -> Frozen Bubble
 
##### Raw Ender
 
 - [x]  Create all Items and Blocks.
 	- [x] Encrusted Obsidian
 	- [x] Ender Rift
 	- [x] Raw Ender
 - [x] Create all recipes.
 	- [x] 2 Obsidian + Diamond + Emerald -> Encrusted Obsidian
 - [x] 4 Encrusted Obsidain create an Ender Rift on the center.
 - [x] Ender Rift create Raw Ender with Water on night.
 - [x] Encrusted Obsidian destroy when run on day.
 
#### Faux Feather

 - [x] Create all Items
    - [x] Faux Feather
 - [x] Create all recipes.
 	- [x] Plastic Rod + Kapok Tuft -> Faux Feather
 - [x] Faux Feather can be use instead of Feather.
 
#### Fossils

 - [x] Bones drops when mining stone.
 
#### Gunpowder

 - [x] Create all Items.
 	- [x] Saltpeter
 	- [x] Sulfur
 - [x] Create all recipes.
 	- [x] Saltpeter + Sulfur + Charcoal -> Gunpowder
 - [x] Saltpeter drops when mining Sandstone.
 - [x] Sulfur drops when mining Netherrack.
 
 
#### Doll's Eye

 - [x] Create all Items.
 	- [x] Doll's Eye
 - [x] Doll's Eye Drops from grass in temperate forest biome.
 - [x] Doll's Eye can be use instead of Spider Eye.

#### False Morel
- [x] Create all Items.
    - [x] False Morel
- [x] False Morel drops from Mycelium
- [x] False Morel can be use instead of Spider Eye

#### Proof of Suffering

 - [x] Create all Items.
 	- [x] Fragments of Suffering
 	- [x] Proof of Suffering
 - [x] Create all recipes.
 	- [x] 8 Fragments of Suffering + Gold Nugget -> Proof of Suffering
 - [x] Fragment of Suffering drops from Soul Sand
 - [x] Proof of Suffering can be use instead of Ghast Tear
 
 
