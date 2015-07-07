package alpvax.racemodbasic.permission;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;


/**
 * @author Alpvax
 *
 */
public class UserClassPermission extends SimpleClassPermission
{
	private String username;

	public UserClassPermission(String name)
	{
		super(true);
		username = name;
	}

	@Override
	public boolean isAvailableInGui(EntityPlayer player)
	{
		return player.getName().equalsIgnoreCase(username) || super.isAvailableInGui(player);
	}

	@Override
	public boolean isAvailableForCommand(ICommandSender commandSender)
	{
		return commandSender.getName().equalsIgnoreCase(username) || super.isAvailableForCommand(commandSender);
	}

}
