package alpvax.classmoduc.core;

import alpvax.classmodcore.api.classes.PlayerClassRegistry;
import alpvax.classmoduc.classes.Demon;
import alpvax.classmoduc.permission.UserClassPermission;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author Alpvax
 *
 */
@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION)
public class CMUserClasses
{
	@Instance(ModInfo.MOD_ID)
	public static CMUserClasses instance;

	/*@SidedProxy(clientSide = "alpvax.classmodcore.network.ClientProxy", serverSide = "alpvax.classmodcore.network.CommonProxy")
	public static CommonProxy proxy;

	public static AlpPacketManager packetHandler;*/
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		instance = this;
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		PlayerClassRegistry.registerPlayerClass(new Demon("user.demon").setDisplayName("Demon"), new UserClassPermission("Alpvax"));
		//TODO:PlayerClassRegistry.registerPlayerClass(new Dwarf(), "user", new UserClassPermission("Alpvax"));
		//TODO:PlayerClassRegistry.registerPlayerClass(new EndSpawn(), "user", new UserClassPermission("Alpvax"));
		//TODO:PlayerClassRegistry.registerPlayerClass(new WereWolf(), "user", new UserClassPermission("Alpvax"));
		//TODO:PlayerClassRegistry.registerPlayerClass(new Wraith(), "user", new UserClassPermission("Alpvax"));
	}
}
