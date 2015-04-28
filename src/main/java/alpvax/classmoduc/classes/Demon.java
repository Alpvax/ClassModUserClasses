package alpvax.classmoduc.classes;

import net.minecraft.block.material.Material;
import net.minecraft.util.DamageSource;
import alpvax.classmodcore.api.classes.SimplePlayerClass;
import alpvax.classmodcore.api.powers.PowerEntry;
import alpvax.classmodcore.api.powers.PowerFireResist;
import alpvax.classmodcore.api.powers.PowerInMaterialMoveSpeed;
import alpvax.classmodcore.api.powers.PowerInMaterialSelfDamage;


public class Demon extends SimplePlayerClass
{

	public Demon(String name)
	{
		super(name);
		addPower(new PowerEntry.Passive(new PowerFireResist(0F)));
		addPower(new PowerEntry.Passive(new PowerInMaterialSelfDamage("Water", DamageSource.drown, 2F, 20, Material.water)));//1 heart every second
		addPower(new PowerEntry.Toggle(new PowerInMaterialMoveSpeed("Lava", 2F, Material.lava), 0));
	}
}
