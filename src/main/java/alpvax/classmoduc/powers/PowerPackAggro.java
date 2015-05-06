package alpvax.classmoduc.powers;

import java.util.Iterator;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import alpvax.classmodcore.api.powers.DummyPower;
import alpvax.classmodcore.api.powers.IPower.IPowerEventListener;


public abstract class PowerPackAggro extends DummyPower implements IPowerEventListener<LivingAttackEvent>
{
	private double radius;

	public PowerPackAggro(String displayType, double radius)
	{
		super(displayType, "Pack AOE Aggro");
		this.radius = radius;
	}

	@Override
	public void listenToEvent(LivingAttackEvent e, EntityPlayer player)
	{
		if(e.source.getEntity() instanceof EntityLivingBase)
		{
			EntityLivingBase target = (EntityLivingBase)e.source.getEntity();
			@SuppressWarnings("unchecked")
			Iterator<EntityLiving> iterator = player.worldObj.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB(player.posX, player.posY, player.posZ, player.posX + 1.0D, player.posY + 1.0D, player.posZ + 1.0D).expand(2 * radius, 2 * radius, 2 * radius)).iterator();

			while(iterator.hasNext())
			{
				EntityLiving entity = iterator.next();

				if(entity.getAttackTarget() == null && player.getDistanceSqToEntity(entity) <= radius * radius && shouldAggro(entity, target))
				{
					entity.setAttackTarget(target);
				}
			}
		}
	}


	public abstract boolean shouldAggro(EntityLiving entity, EntityLivingBase target);
}
