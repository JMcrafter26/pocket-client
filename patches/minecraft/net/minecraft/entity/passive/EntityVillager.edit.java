
# Eagler Context Redacted Diff
# Copyright (c) 2023 lax1dude. All rights reserved.

# Version: 1.0
# Author: lax1dude

> CHANGE  2 : 4  @  2 : 3

~ import net.lax1dude.eaglercraft.v1_8.EaglercraftRandom;
~ 

> DELETE  3  @  3 : 4

> DELETE  1  @  1 : 3

> DELETE  4  @  4 : 20

> DELETE  3  @  3 : 6

> DELETE  9  @  9 : 12

> DELETE  4  @  4 : 5

> DELETE  6  @  6 : 7

> DELETE  7  @  7 : 8

> CHANGE  12 : 13  @  12 : 164

~ 	private static EntityVillager.ITradeList[][][][] DEFAULT_TRADE_LIST_MAP = null;

> INSERT  1 : 166  @  1

+ 	public static void bootstrap() {
+ 		DEFAULT_TRADE_LIST_MAP = new EntityVillager.ITradeList[][][][] {
+ 				{ { { new EntityVillager.EmeraldForItems(Items.wheat, new EntityVillager.PriceInfo(18, 22)),
+ 						new EntityVillager.EmeraldForItems(Items.potato, new EntityVillager.PriceInfo(15, 19)),
+ 						new EntityVillager.EmeraldForItems(Items.carrot,
+ 								new EntityVillager.PriceInfo(15, 19)),
+ 						new EntityVillager.ListItemForEmeralds(Items.bread, new EntityVillager.PriceInfo(-4, -2)) },
+ 						{ new EntityVillager.EmeraldForItems(Item.getItemFromBlock(Blocks.pumpkin),
+ 								new EntityVillager.PriceInfo(8, 13)),
+ 								new EntityVillager.ListItemForEmeralds(Items.pumpkin_pie,
+ 										new EntityVillager.PriceInfo(-3, -2)) },
+ 						{ new EntityVillager.EmeraldForItems(Item.getItemFromBlock(Blocks.melon_block),
+ 								new EntityVillager.PriceInfo(7, 12)),
+ 								new EntityVillager.ListItemForEmeralds(Items.apple,
+ 										new EntityVillager.PriceInfo(-5, -7)) },
+ 						{ new EntityVillager.ListItemForEmeralds(Items.cookie, new EntityVillager.PriceInfo(-6, -10)),
+ 								new EntityVillager.ListItemForEmeralds(Items.cake,
+ 										new EntityVillager.PriceInfo(1, 1)) } },
+ 						{ { new EntityVillager.EmeraldForItems(Items.string, new EntityVillager.PriceInfo(15, 20)),
+ 								new EntityVillager.EmeraldForItems(Items.coal, new EntityVillager.PriceInfo(16, 24)),
+ 								new EntityVillager.ItemAndEmeraldToItem(
+ 										Items.fish, new EntityVillager.PriceInfo(6, 6), Items.cooked_fish,
+ 										new EntityVillager.PriceInfo(6, 6)) },
+ 								{ new EntityVillager.ListEnchantedItemForEmeralds(Items.fishing_rod,
+ 										new EntityVillager.PriceInfo(7, 8)) } },
+ 						{ { new EntityVillager.EmeraldForItems(Item.getItemFromBlock(Blocks.wool),
+ 								new EntityVillager.PriceInfo(16, 22)),
+ 								new EntityVillager.ListItemForEmeralds(Items.shears,
+ 										new EntityVillager.PriceInfo(3, 4)) },
+ 								{ new EntityVillager.ListItemForEmeralds(
+ 										new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 0),
+ 										new EntityVillager.PriceInfo(1, 2)),
+ 										new EntityVillager.ListItemForEmeralds(
+ 												new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 1),
+ 												new EntityVillager.PriceInfo(1, 2)),
+ 										new EntityVillager.ListItemForEmeralds(
+ 												new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 2),
+ 												new EntityVillager.PriceInfo(1, 2)),
+ 										new EntityVillager.ListItemForEmeralds(
+ 												new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 3),
+ 												new EntityVillager.PriceInfo(1, 2)),
+ 										new EntityVillager.ListItemForEmeralds(
+ 												new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 4),
+ 												new EntityVillager.PriceInfo(1, 2)),
+ 										new EntityVillager.ListItemForEmeralds(
+ 												new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 5),
+ 												new EntityVillager.PriceInfo(1, 2)),
+ 										new EntityVillager.ListItemForEmeralds(
+ 												new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 6),
+ 												new EntityVillager.PriceInfo(1, 2)),
+ 										new EntityVillager.ListItemForEmeralds(
+ 												new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 7),
+ 												new EntityVillager.PriceInfo(1, 2)),
+ 										new EntityVillager.ListItemForEmeralds(
+ 												new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 8),
+ 												new EntityVillager.PriceInfo(1, 2)),
+ 										new EntityVillager.ListItemForEmeralds(
+ 												new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 9),
+ 												new EntityVillager.PriceInfo(1, 2)),
+ 										new EntityVillager.ListItemForEmeralds(
+ 												new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 10),
+ 												new EntityVillager.PriceInfo(1, 2)),
+ 										new EntityVillager.ListItemForEmeralds(
+ 												new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 11),
+ 												new EntityVillager.PriceInfo(1, 2)),
+ 										new EntityVillager.ListItemForEmeralds(
+ 												new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 12),
+ 												new EntityVillager.PriceInfo(1, 2)),
+ 										new EntityVillager.ListItemForEmeralds(
+ 												new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 13),
+ 												new EntityVillager.PriceInfo(1, 2)),
+ 										new EntityVillager.ListItemForEmeralds(
+ 												new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 14),
+ 												new EntityVillager.PriceInfo(1, 2)),
+ 										new EntityVillager.ListItemForEmeralds(
+ 												new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 15),
+ 												new EntityVillager.PriceInfo(1, 2)) } },
+ 						{ { new EntityVillager.EmeraldForItems(Items.string, new EntityVillager.PriceInfo(15, 20)),
+ 								new EntityVillager.ListItemForEmeralds(Items.arrow,
+ 										new EntityVillager.PriceInfo(-12, -8)) },
+ 								{ new EntityVillager.ListItemForEmeralds(Items.bow, new EntityVillager.PriceInfo(2, 3)),
+ 										new EntityVillager.ItemAndEmeraldToItem(Item.getItemFromBlock(Blocks.gravel),
+ 												new EntityVillager.PriceInfo(10, 10), Items.flint,
+ 												new EntityVillager.PriceInfo(6, 10)) } } },
+ 				{ { { new EntityVillager.EmeraldForItems(Items.paper, new EntityVillager.PriceInfo(24, 36)),
+ 						new EntityVillager.ListEnchantedBookForEmeralds() },
+ 						{ new EntityVillager.EmeraldForItems(Items.book, new EntityVillager.PriceInfo(8, 10)),
+ 								new EntityVillager.ListItemForEmeralds(Items.compass,
+ 										new EntityVillager.PriceInfo(10, 12)),
+ 								new EntityVillager.ListItemForEmeralds(Item.getItemFromBlock(Blocks.bookshelf),
+ 										new EntityVillager.PriceInfo(3, 4)) },
+ 						{ new EntityVillager.EmeraldForItems(Items.written_book, new EntityVillager.PriceInfo(2, 2)),
+ 								new EntityVillager.ListItemForEmeralds(Items.clock,
+ 										new EntityVillager.PriceInfo(10, 12)),
+ 								new EntityVillager.ListItemForEmeralds(Item.getItemFromBlock(Blocks.glass),
+ 										new EntityVillager.PriceInfo(-5, -3)) },
+ 						{ new EntityVillager.ListEnchantedBookForEmeralds() },
+ 						{ new EntityVillager.ListEnchantedBookForEmeralds() },
+ 						{ new EntityVillager.ListItemForEmeralds(Items.name_tag,
+ 								new EntityVillager.PriceInfo(20, 22)) } } },
+ 				{ { { new EntityVillager.EmeraldForItems(Items.rotten_flesh, new EntityVillager.PriceInfo(36, 40)),
+ 						new EntityVillager.EmeraldForItems(Items.gold_ingot, new EntityVillager.PriceInfo(8, 10)) },
+ 						{ new EntityVillager.ListItemForEmeralds(Items.redstone, new EntityVillager.PriceInfo(-4, -1)),
+ 								new EntityVillager.ListItemForEmeralds(
+ 										new ItemStack(Items.dye, 1, EnumDyeColor.BLUE.getDyeDamage()),
+ 										new EntityVillager.PriceInfo(-2, -1)) },
+ 						{ new EntityVillager.ListItemForEmeralds(Items.ender_eye, new EntityVillager.PriceInfo(7, 11)),
+ 								new EntityVillager.ListItemForEmeralds(Item.getItemFromBlock(Blocks.glowstone),
+ 										new EntityVillager.PriceInfo(-3, -1)) },
+ 						{ new EntityVillager.ListItemForEmeralds(Items.experience_bottle,
+ 								new EntityVillager.PriceInfo(3, 11)) } } },
+ 				{ { { new EntityVillager.EmeraldForItems(Items.coal, new EntityVillager.PriceInfo(16, 24)),
+ 						new EntityVillager.ListItemForEmeralds(Items.iron_helmet, new EntityVillager.PriceInfo(4, 6)) },
+ 						{ new EntityVillager.EmeraldForItems(Items.iron_ingot, new EntityVillager.PriceInfo(7, 9)),
+ 								new EntityVillager.ListItemForEmeralds(Items.iron_chestplate,
+ 										new EntityVillager.PriceInfo(10, 14)) },
+ 						{ new EntityVillager.EmeraldForItems(Items.diamond, new EntityVillager.PriceInfo(3, 4)),
+ 								new EntityVillager.ListEnchantedItemForEmeralds(Items.diamond_chestplate,
+ 										new EntityVillager.PriceInfo(16, 19)) },
+ 						{ new EntityVillager.ListItemForEmeralds(Items.chainmail_boots,
+ 								new EntityVillager.PriceInfo(5, 7)),
+ 								new EntityVillager.ListItemForEmeralds(Items.chainmail_leggings,
+ 										new EntityVillager.PriceInfo(9, 11)),
+ 								new EntityVillager.ListItemForEmeralds(Items.chainmail_helmet,
+ 										new EntityVillager.PriceInfo(5, 7)),
+ 								new EntityVillager.ListItemForEmeralds(Items.chainmail_chestplate,
+ 										new EntityVillager.PriceInfo(11, 15)) } },
+ 						{ { new EntityVillager.EmeraldForItems(Items.coal, new EntityVillager.PriceInfo(16, 24)),
+ 								new EntityVillager.ListItemForEmeralds(Items.iron_axe,
+ 										new EntityVillager.PriceInfo(6, 8)) },
+ 								{ new EntityVillager.EmeraldForItems(Items.iron_ingot,
+ 										new EntityVillager.PriceInfo(7, 9)),
+ 										new EntityVillager.ListEnchantedItemForEmeralds(Items.iron_sword,
+ 												new EntityVillager.PriceInfo(9, 10)) },
+ 								{ new EntityVillager.EmeraldForItems(Items.diamond, new EntityVillager.PriceInfo(3, 4)),
+ 										new EntityVillager.ListEnchantedItemForEmeralds(Items.diamond_sword,
+ 												new EntityVillager.PriceInfo(12, 15)),
+ 										new EntityVillager.ListEnchantedItemForEmeralds(Items.diamond_axe,
+ 												new EntityVillager.PriceInfo(9, 12)) } },
+ 						{ { new EntityVillager.EmeraldForItems(Items.coal, new EntityVillager.PriceInfo(16, 24)),
+ 								new EntityVillager.ListEnchantedItemForEmeralds(Items.iron_shovel,
+ 										new EntityVillager.PriceInfo(5, 7)) },
+ 								{ new EntityVillager.EmeraldForItems(Items.iron_ingot,
+ 										new EntityVillager.PriceInfo(7, 9)),
+ 										new EntityVillager.ListEnchantedItemForEmeralds(Items.iron_pickaxe,
+ 												new EntityVillager.PriceInfo(9, 11)) },
+ 								{ new EntityVillager.EmeraldForItems(Items.diamond, new EntityVillager.PriceInfo(3, 4)),
+ 										new EntityVillager.ListEnchantedItemForEmeralds(Items.diamond_pickaxe,
+ 												new EntityVillager.PriceInfo(12, 15)) } } },
+ 				{ { { new EntityVillager.EmeraldForItems(Items.porkchop, new EntityVillager.PriceInfo(14, 18)),
+ 						new EntityVillager.EmeraldForItems(Items.chicken, new EntityVillager.PriceInfo(14, 18)) },
+ 						{ new EntityVillager.EmeraldForItems(Items.coal, new EntityVillager.PriceInfo(16, 24)),
+ 								new EntityVillager.ListItemForEmeralds(Items.cooked_porkchop,
+ 										new EntityVillager.PriceInfo(-7, -5)),
+ 								new EntityVillager.ListItemForEmeralds(Items.cooked_chicken,
+ 										new EntityVillager.PriceInfo(-8, -6)) } },
+ 						{ { new EntityVillager.EmeraldForItems(Items.leather, new EntityVillager.PriceInfo(9, 12)),
+ 								new EntityVillager.ListItemForEmeralds(Items.leather_leggings,
+ 										new EntityVillager.PriceInfo(2, 4)) },
+ 								{ new EntityVillager.ListEnchantedItemForEmeralds(Items.leather_chestplate,
+ 										new EntityVillager.PriceInfo(7, 12)) },
+ 								{ new EntityVillager.ListItemForEmeralds(Items.saddle,
+ 										new EntityVillager.PriceInfo(8, 10)) } } } };
+ 	}
+ 

> DELETE  9  @  9 : 25

> DELETE  3  @  3 : 23

> DELETE  5  @  5 : 48

> DELETE  4  @  4 : 9

> DELETE  57  @  57 : 58

> DELETE  42  @  42 : 81

> DELETE  73  @  73 : 81

> DELETE  140  @  140 : 141

> DELETE  19  @  19 : 29

> DELETE  1  @  1 : 4

> CHANGE  94 : 95  @  94 : 95

~ 		public void modifyMerchantRecipeList(MerchantRecipeList recipeList, EaglercraftRandom random) {

> CHANGE  10 : 11  @  10 : 11

~ 		void modifyMerchantRecipeList(MerchantRecipeList var1, EaglercraftRandom var2);

> CHANGE  16 : 17  @  16 : 17

~ 		public void modifyMerchantRecipeList(MerchantRecipeList merchantrecipelist, EaglercraftRandom random) {

> CHANGE  18 : 19  @  18 : 19

~ 		public void modifyMerchantRecipeList(MerchantRecipeList merchantrecipelist, EaglercraftRandom random) {

> CHANGE  23 : 24  @  23 : 24

~ 		public void modifyMerchantRecipeList(MerchantRecipeList merchantrecipelist, EaglercraftRandom random) {

> CHANGE  26 : 27  @  26 : 27

~ 		public void modifyMerchantRecipeList(MerchantRecipeList merchantrecipelist, EaglercraftRandom random) {

> CHANGE  24 : 25  @  24 : 25

~ 		public int getPrice(EaglercraftRandom rand) {

> EOF
