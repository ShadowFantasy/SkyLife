package net.shadowfantasy.skylife;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.shadowfantasy.skylife.block.SLAdvancedBlocks.SifterBlock;

public class SkyLifeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(SifterBlock.SIFTER_STATION, RenderLayer.getCutout());
    }
}
