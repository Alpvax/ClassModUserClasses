package alpvax.classmoduc.powers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import alpvax.classmodcore.api.powers.PowerResist;


public class PowerFireResist extends PowerResist
{
	public PowerFireResist(float multiplier)
	{
		super("Fire", multiplier);
	}

	@Override
	public boolean shouldModify(DamageSource src, EntityPlayer player)
	{
		return src.isFireDamage();
	}
}
