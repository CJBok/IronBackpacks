package main.ironbackpacks.items.upgrades;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.ironbackpacks.items.ItemBase;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lwjgl.input.Keyboard;

import java.util.List;

public abstract class ItemUpgradeBase extends ItemBase{

    public int typeID;
    public String[] tooltip;

    public ItemUpgradeBase(String unlocName, String textureName, int typeID, String... descriptions) {
        super(unlocName, textureName);
        setMaxStackSize(16);
        this.typeID = typeID;
        this.tooltip = descriptions;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
            for (String line : this.tooltip) {
                list.add(line);
            }
        }else{
            list.add("Hold shift for more info.");
        }
    }

    public int getTypeID(){
        return this.typeID;
    }

}