package alpvax.classmoduc.classes;

import alpvax.classmodcore.api.classes.SimplePlayerClass;
import alpvax.classmodcore.api.powers.PowerEntry;
import alpvax.classmodcore.api.powers.PowerMineSpeed;
import alpvax.classmodcore.api.powers.PowerReach;


public class Dwarf extends SimplePlayerClass
{
	public Dwarf(String id)
	{
		super(id);
		addPower(new PowerEntry(new PowerReach(-1F)).setStartActive());
		addPower(new PowerEntry(new PowerMineSpeed(1.2F, "pickaxe")).setStartActive());
		/*TODO: Prospect, MineEscape, Nightvision, Oblivious, Height
		addPower(ClassMod.lesserKey, new PowerProspect(5, 1, 3));
		//powerMap.put(ClassMod.greaterKey, new PowerMineEscape(60, 15, 1.5F));
		nightVision = 0.5F;
		setOblivious(EntitySpider.class);
		setHeight(player, 1F);*/
	}
}
