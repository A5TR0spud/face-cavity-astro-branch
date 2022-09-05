package net.tigereye.facecavity;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

public class OrganSettings extends FabricItemSettings
{
    public FabricItemSettings OrganSettings() {
        return new FabricItemSettings().maxCount(1).group(FaceCavity.ORGAN_ITEM_GROUP);
    }
}
