package net.tigereye.facecavity.registration;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tigereye.chestcavity.registration.CCFoodComponents;
import net.tigereye.facecavity.FaceCavity;
import net.tigereye.facecavity.OrganSettings;
import net.tigereye.facecavity.items.BrainItem;
import net.tigereye.facecavity.items.FaceOpenerItem;

import java.util.ArrayList;
import java.util.List;

public class FCItems {
    /*public static Item FACE_OPENER = registerItem("face_opener", new FaceOpenerItem());
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
    }*/

     public static Item FACE_OPENER = new FaceOpenerItem();


     public static Item BRAIN = new BrainItem(new OrganSettings().food(FCFoodComponents.HUMAN_BRAIN_FOOD_COMPONENT));

     public static Item EYE = new Item(new OrganSettings().food(CCFoodComponents.HUMAN_MUSCLE_FOOD_COMPONENT));

     public static Item TONGUE = new Item(new OrganSettings().food(CCFoodComponents.HUMAN_MUSCLE_FOOD_COMPONENT));

     public static Item SKULL_PLATE = new Item(new OrganSettings().maxCount(4));

     public static Item TOOTH = new Item(new OrganSettings().maxCount(4));

     public static Item EAR_DRUM = new Item(new OrganSettings());

     public static Item JAW_MUSCLE = new Item(new OrganSettings().maxCount(8).food(CCFoodComponents.HUMAN_MUSCLE_FOOD_COMPONENT));

     public static void registerItem(Item ITEM, String id) {
        Registry.register(Registry.ITEM, new Identifier("facecavity", id), ITEM);
     }

     public static void register() {
          registerItem(FACE_OPENER, "face_opener");
          registerItem(BRAIN, "brain");
          registerItem(EYE, "eye");
          registerItem(TONGUE, "tongue");
          registerItem(SKULL_PLATE, "skull_plate");
          registerItem(TOOTH, "tooth");
          registerItem(EAR_DRUM, "ear_drum");
          registerItem(JAW_MUSCLE, "jaw_muscle");
     }

}
