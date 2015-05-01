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
		addPower(new PowerEntry(new PowerFireResist(0F)).setStartActive());
		addPower(new PowerEntry(new PowerInMaterialSelfDamage("Water", DamageSource.drown, 2F, 20, Material.water)));//1 heart every second (20 ticks)
		addPower(new PowerEntry(new PowerInMaterialMoveSpeed("Lava", 2F, Material.lava)));
	}
}
