package alpvax.racemodbasic.classes;

import alpvax.racemod.api.powers.PowerEntry;
import alpvax.racemod.api.powers.PowerMineSpeed;
import alpvax.racemod.api.powers.PowerOblivious;
import alpvax.racemod.api.powers.PowerReach;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;


public class Dwarf extends SimplePlayerClass
{
	public Dwarf(String id)
	{
		super(id);
		addPower(new PowerEntry(new PowerReach(-1F)).setStartActive());
		addPower(new PowerEntry(new PowerMineSpeed(1.2F, "pickaxe")).setStartActive());
		addPower(new PowerEntry(new PowerOblivious(""){
			@Override
			public boolean canEntityTargetPlayer(EntityLiving entity, EntityPlayer player)
			{
				return !(entity instanceof EntitySpider);
			}
		}));
		/*TODO: Prospect, MineEscape, Nightvision, Oblivious, Height
		addPower(ClassMod.lesserKey, new PowerProspect(5, 1, 3));
		//powerMap.put(ClassMod.greaterKey, new PowerMineEscape(60, 15, 1.5F));
		nightVision = 0.5F;
		setHeight(player, 1F);*/
	}
}
