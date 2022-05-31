package net.shadowfantasy.skylife;

import net.fabricmc.api.ModInitializer;
import net.shadowfantasy.skylife.block.SLAdvancedBlocks.SifterBlock;
import net.shadowfantasy.skylife.block.SLBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkyLife implements ModInitializer {
	public static  final String MOD_ID = "skylife";
	public static final Logger LOGGER = LoggerFactory.getLogger("skylife");

	@Override
	public void onInitialize() {
		SLBlocks.registerModBlocks();
		SifterBlock.registerSifterBlock();

		LOGGER.info("Hello Fabric world!");
	}
}
