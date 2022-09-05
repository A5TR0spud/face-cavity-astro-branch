package net.tigereye.facecavity.registration;

import net.tigereye.facecavity.FaceCavity;
import net.tigereye.facecavity.items.BrainItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tigereye.chestcavity.registration.CCFoodComponents;
import net.tigereye.facecavity.items.FaceOpenerItem;

public class FCItems {
    public static Item FACE_OPENER = registerItem("face_opener", new FaceOpenerItem());
    public static Item BRAIN = registerItem("brain",
            new BrainItem(new FabricItemSettings().maxCount(1).group(FaceCavity.ORGAN_ITEM_GROUP).food(FCFoodComponents.HUMAN_BRAIN_FOOD_COMPONENT)));
    public static Item EYE = registerItem("eye",
            new Item(new FabricItemSettings().maxCount(1).group(FaceCavity.ORGAN_ITEM_GROUP).food(CCFoodComponents.HUMAN_MUSCLE_FOOD_COMPONENT)));
    public static Item TONGUE = registerItem("tongue",
            new Item(new FabricItemSettings().maxCount(1).group(FaceCavity.ORGAN_ITEM_GROUP).food(CCFoodComponents.HUMAN_MUSCLE_FOOD_COMPONENT)));
    public static Item SKULL_PLATE = registerItem("skull_plate",
            new Item(new FabricItemSettings().maxCount(4).group(FaceCavity.ORGAN_ITEM_GROUP)));
    public static Item TOOTH = registerItem("tooth",
            new Item(new FabricItemSettings().maxCount(4).group(FaceCavity.ORGAN_ITEM_GROUP)));
    public static Item EAR_DRUM = registerItem("ear_drum",
            new Item(new FabricItemSettings().maxCount(1).group(FaceCavity.ORGAN_ITEM_GROUP)));
    public static Item JAW_MUSCLE = registerItem("jaw_muscle",
            new Item(new FabricItemSettings().maxCount(8).group(FaceCavity.ORGAN_ITEM_GROUP).food(CCFoodComponents.HUMAN_MUSCLE_FOOD_COMPONENT)));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier("facecavity", name), item);
    }
    public static void RegisterFaceCavityItems() {
        FaceCavity.LOGGER.info("Loading Face Cavity items!");
    }
}
