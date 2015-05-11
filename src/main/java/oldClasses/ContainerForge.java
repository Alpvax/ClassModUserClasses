package alpvax.classmod.common;

import alpvax.classmod.block.TileEntityForge;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerForge extends Container
{
    private TileEntityForge forge;
    private int lastCookTime = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;

    public ContainerForge(InventoryPlayer par1InventoryPlayer, TileEntityForge tileentity)
    {
        forge = tileentity;
        for(int i = 0; i < 5; ++i)
        {
            for(int j = 0; j < 5; ++j)
            {
                this.addSlotToContainer(new Slot(tileentity, j + i * 5, 8 + j * 18, 8 + i * 18));
            }
        }
        for(int i = 0; i < 2; ++i)
        {
            for(int j = 0; j < 2; ++j)
            {
                this.addSlotToContainer(new SlotFurnace(par1InventoryPlayer.player, tileentity, 25 + j + i * 2, 135 + j * 26, 27 + i * 26));
            }
        }
        addSlotToContainer(new Slot(tileentity, 29, 106, 62));

        for(int i = 0; i < 3; ++i)
        {
            for(int j = 0; j < 9; ++j)
            {
                addSlotToContainer(new Slot(par1InventoryPlayer, j + i * 9 + 9, 15 + j * 18, 105 + i * 18));
            }
        }
        for(int i = 0; i < 9; ++i)
        {
            addSlotToContainer(new Slot(par1InventoryPlayer, i, 15 + i * 18, 163));
        }
    }

    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, forge.cookTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, forge.burnTime);
        par1ICrafting.sendProgressBarUpdate(this, 2, forge.currentBurnTime);
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

            if (lastCookTime != forge.cookTime)
            {
                var2.sendProgressBarUpdate(this, 0, forge.cookTime);
            }

            if (lastBurnTime != forge.burnTime)
            {
                var2.sendProgressBarUpdate(this, 1, forge.burnTime);
            }

            if (lastItemBurnTime != forge.currentBurnTime)
            {
                var2.sendProgressBarUpdate(this, 2, forge.currentBurnTime);
            }
        }

        lastCookTime = forge.cookTime;
        lastBurnTime = forge.burnTime;
        lastItemBurnTime = forge.currentBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            forge.cookTime = par2;
        }

        if (par1 == 1)
        {
            forge.burnTime = par2;
        }

        if (par1 == 2)
        {
            forge.currentBurnTime = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return forge.isUseableByPlayer(par1EntityPlayer);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
    	//TODO: fix Shift-Click behaviour
        ItemStack var3 = null;
        /*Slot var4 = (Slot)inventorySlots.get(par2);

        if (var4 != null && var4.getHasStack())
        {
            ItemStack var5 = var4.getStack();
            var3 = var5.copy();

            if (par2 == 2)
            {
                if (!mergeItemStack(var5, 3, 39, true))
                {
                    return null;
                }

                var4.onSlotChange(var5, var3);
            }
            else if (par2 != 1 && par2 != 0)
            {
                if (FurnaceRecipes.smelting().getSmeltingResult(var5) != null)
                {
                    if (!mergeItemStack(var5, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(var5))
                {
                    if (!mergeItemStack(var5, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 3 && par2 < 30)
                {
                    if (!mergeItemStack(var5, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 30 && par2 < 39 && !mergeItemStack(var5, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!mergeItemStack(var5, 3, 39, false))
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
        }*/

        return var3;
    }
}
