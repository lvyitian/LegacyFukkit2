package org.bukkit.craftbukkit.entity;

import net.minecraft.entity.passive.SheepEntity;
import org.bukkit.DyeColor;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;

public class CraftSheep extends CraftAnimals implements Sheep {
    public CraftSheep(CraftServer server, SheepEntity entity) {
        super(server, entity);
    }

    public DyeColor getColor() {
        return DyeColor.getByWoolData((byte) getHandle().getColor().getId());
    }

    public void setColor(DyeColor color) {
        getHandle().setColor(net.minecraft.util.DyeColor.getColorById(color.getWoolData()));
    }

    public boolean isSheared() {
        return getHandle().isSheared();
    }

    public void setSheared(boolean flag) {
        getHandle().setSheared(flag);
    }

    @Override
    public SheepEntity getHandle() {
        return (SheepEntity) entity;
    }

    @Override
    public String toString() {
        return "CraftSheep";
    }

    public EntityType getType() {
        return EntityType.SHEEP;
    }
}
