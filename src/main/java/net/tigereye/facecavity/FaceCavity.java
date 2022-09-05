package net.tigereye.facecavity;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.tigereye.chestcavity.ChestCavity;
import net.tigereye.chestcavity.config.CCConfig;
import net.tigereye.facecavity.registration.FCItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FaceCavity implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("facecavity");
	public static final String MODID = "facecavity";

	public static final ItemGroup ORGAN_ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MODID, "organs"),
			() -> new ItemStack(FCItems.BRAIN));

	@Override
	public void onInitialize() {
		LOGGER.info("Face Cavity has started loading!");
		if (ChestCavity.config != null) {
			LOGGER.info("Chest Cavity's has detected Chest Cavity's config!");
			init();
		} else {
			LOGGER.warn("Face Cavity has not detected Chest Cavity's config...");
			ChestCavity.config = new CCConfig();
			LOGGER.info("Face Cavity has created a dummy config to prevent errors");
			init();
		}
	}

	private void init() {
		LOGGER.info("Face Cavity has started loading!");
		FCItems.RegisterFaceCavityItems();
		LOGGER.info("Face Cavity has finished loading!");
	}
}
