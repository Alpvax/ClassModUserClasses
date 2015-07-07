package alpvax.racemodbasic.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;


public class TileEntityForge extends TileEntity implements IInventory
{

	@Override
	public String getName()
	{
		return null;// TODO Auto-generated method stub
	}

	@Override
	public boolean hasCustomName()
	{
		return false;// TODO Auto-generated method stub
	}

	@Override
	public IChatComponent getDisplayName()
	{
		return null;// TODO Auto-generated method stub
	}

	@Override
	public int getSizeInventory()
	{
		return 0;// TODO Auto-generated method stub
	}

	@Override
	public ItemStack getStackInSlot(int index)
	{
		return null;// TODO Auto-generated method stub
	}

	@Override
	public ItemStack decrStackSize(int index, int count)
	{
		return null;// TODO Auto-generated method stub
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index)
	{
		return null;// TODO Auto-generated method stub
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 0;// TODO Auto-generated method stub
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return false;// TODO Auto-generated method stub
	}

	@Override
	public void openInventory(EntityPlayer player)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void closeInventory(EntityPlayer player)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		return false;// TODO Auto-generated method stub
	}

	@Override
	public int getField(int id)
	{
		return 0;// TODO Auto-generated method stub
	}

	@Override
	public void setField(int id, int value)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public int getFieldCount()
	{
		return 0;// TODO Auto-generated method stub
	}

	@Override
	public void clear()
	{
		// TODO Auto-generated method stub
	}

	public void setCustomInventoryName(String displayName)
	{
		// TODO Auto-generated method stub
	}

}
