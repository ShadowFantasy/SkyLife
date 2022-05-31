package net.shadowfantasy.skylife.block.SLAdvancedBlocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.shadowfantasy.skylife.SkyLife;

public class SifterBlock extends Block {
    private static final VoxelShape OUTLINE_SHAPE;

    public SifterBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return OUTLINE_SHAPE;
    }

    ///Sifter Register
    public static final SifterBlock SIFTER_STATION = (SifterBlock) registerSifter("sifter",
            new SifterBlock(FabricBlockSettings.of(Material.WOOD).strength(3f).nonOpaque()), ItemGroup.MISC);

    public static Block registerSifter(String name, Block block, ItemGroup group) {
        registerSifterItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(SkyLife.MOD_ID, name), block);
    }

    private static Item registerSifterItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM, new Identifier(SkyLife.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }
    ///


    static {
        VoxelShape blLeg = Block.createCuboidShape(0f,0f,0f,3f,12f,3f);
        VoxelShape brLeg = Block.createCuboidShape(13f,0f,0f,16f,12f,3f);
        VoxelShape tlLeg = Block.createCuboidShape(0f,0f,13f,3f,12f,16f);
        VoxelShape trLeg = Block.createCuboidShape(13f,0f,13f,16f,12f,16f);
        VoxelShape top = Block.createCuboidShape(0f,12f,0f,16f,15f,16f);
        OUTLINE_SHAPE = VoxelShapes.union(blLeg,brLeg,tlLeg,trLeg,top);
    }

    public static void registerSifterBlock(){
        SkyLife.LOGGER.info("Registering Sifter for " + SkyLife.MOD_ID);
    }

}
