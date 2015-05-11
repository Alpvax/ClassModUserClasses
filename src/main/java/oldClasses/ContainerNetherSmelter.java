package alpvax.classmod.common;

import alpvax.classmod.block.TileEntityNetherSmelter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerNetherSmelter extends Container
{
    private TileEntityNetherSmelter tileentity;
    private int lastCookTime = 0;
    private int lastBurnTime = 0;

    public ContainerNetherSmelter(InventoryPlayer par1InventoryPlayer, TileEntityNetherSmelter tile)
    {
        tileentity = tile;
        addSlotToContainer(new Slot(tile, 0, 55, 28));
        //addSlotToContainer(new Slot(tile, 1, 56, 53));
        addSlotToContainer(new SlotFurnace(par1InventoryPlayer.player, tile, 1, 127, 29));
        int var3;

        for (var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                addSlotToContainer(new Slot(par1InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (var3 = 0; var3 < 9; ++var3)
        {
            addSlotToContainer(new Slot(par1InventoryPlayer, var3, 8 + var3 * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, tileentity.cookEnergy);
        par1ICrafting.sendProgressBarUpdate(this, 1, (int)tileentity.heat);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int var1 = 0; var1 < crafters.size(); ++var1)
        {
            ICrafting var2 = (ICrafting)crafters.get(var1);

            if (lastCookTime != tileentity.cookEnergy)
            {
                var2.sendProgressBarUpdate(this, 0, tileentity.cookEnergy);
            }

            if (lastBurnTime != (int)tileentity.heat)
            {
                var2.sendProgressBarUpdate(this, 1, (int)tileentity.heat);
            }
        }

        lastCookTime = tileentity.cookEnergy;
        lastBurnTime = (int)tileentity.heat;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            tileentity.cookEnergy = par2;
        }

        if (par1 == 1)
        {
            tileentity.heat = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return tileentity.isUseableByPlayer(par1EntityPlayer);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack var3 = null;
        Slot var4 = (Slot)inventorySlots.get(par2);

        if (var4 != null && var4.getHasStack())
        {
            ItemStack var5 = var4.getStack();
            var3 = var5.copy();

            if (par2 == 1)
            {
                if (!mergeItemStack(var5, 2, 38, true))
                {
                    return null;
                }

                var4.onSlotChange(var5, var3);
            }
            else if (par2 != 0)
            {
                if (FurnaceRecipes.smelting().getSmeltingResult(var5) != null)
                {
                    if (!mergeItemStack(var5, 0, 1, false))
                    {
                        return null;
                    }
                }
                /*else if (TileEntityNetherSmelter.isItemFuel(var5))
                {
                    if (!mergeItemStack(var5, 1, 2, false))
                    {
                        return null;
                    }
                }*/
                else if (par2 >= 2 && par2 < 29)
                {
                    if (!mergeItemStack(var5, 29, 38, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 29 && par2 < 38 && !mergeItemStack(var5, 2, 29, false))
                {
                    return null;
                }
            }
            else if (!mergeItemStack(var5, 2, 38, false))
            {
                return null;
            }

            if (var5.stackSize == 0)
            {
                var4.putStack((ItemStack)null);
            }
            else
            {
                var4.onSlotChanged();
            }

            if (var5.stackSize == var3.stackSize)
            {
                return null;
            }

            var4.onPickupFromSlot(par1EntityPlayer, var5);
        }

        return var3;
    }
}
