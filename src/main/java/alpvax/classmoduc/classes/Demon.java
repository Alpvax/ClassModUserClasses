package alpvax.classmoduc.classes;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import alpvax.classmodcore.api.classes.SimplePlayerClass;
import alpvax.classmodcore.api.powers.PowerEntry;
import alpvax.classmodcore.api.powers.PowerFireResist;
import alpvax.classmodcore.api.powers.PowerInMaterialMoveSpeed;

public class Demon extends SimplePlayerClass
{

	public Demon(String name)
	{
		super(name);
		addPower(new PowerEntry.Passive(new PowerFireResist(0F)));
		addPower(new PowerEntry.Toggle(new PowerInMaterialMoveSpeed("Lava", 2F, Material.lava), 0));
	}

	@Override
	public void setup(EntityPlayer player)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void reset(EntityPlayer player)
	{
		// TODO Auto-generated method stub
	}

}
