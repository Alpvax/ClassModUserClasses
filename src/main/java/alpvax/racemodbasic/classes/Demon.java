package alpvax.racemodbasic.classes;

import alpvax.racemod.api.powers.PowerEntry;
import alpvax.racemod.api.powers.PowerInMaterialMoveSpeed;
import alpvax.racemod.api.powers.PowerInMaterialSelfDamage;
import alpvax.racemod.api.powers.PowerOblivious;
import alpvax.racemod.api.powers.PowerPackAggro;
import alpvax.racemod.api.powers.PowerRandBlock;
import alpvax.racemod.api.race.SimpleRace;
import alpvax.racemodbasic.powers.PowerFireResist;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;


public class Demon extends SimpleRace
{

	public Demon(String name)
	{
		super(name);
		addPower(new PowerEntry(new PowerFireResist(0F)).setStartActive());
		addPower(new PowerEntry(new PowerInMaterialSelfDamage("Water", DamageSource.drown, 2F, 20, Material.water)).setStartActive());//1 heart every second (20 ticks)
		addPower(new PowerEntry(new PowerInMaterialMoveSpeed("Lava", 1.5F, Material.lava)));
		addPower(new PowerEntry(new PowerRandBlock("Demonic Spawning", 16D, 1F / 3000F){
			@Override
			public void doEffect(EntityPlayer player, World world, BlockPos pos, int ticksActive)
			{
				int i = 0;
				while(world.getBlockState(pos).getBlock().isAir(world, pos))
				{
					i--;
					pos = pos.down();
				}
				if(world.isSideSolid(pos.down(), EnumFacing.UP) && i >= 2)
				{
					Entity e = new EntityPigZombie(world);
					if(player.getRNG().nextInt(1000) == 0 && i >= 3)
					{
						EntitySkeleton e1 = new EntitySkeleton(world);
						e1.setSkeletonType(1);
						e1.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
						e1.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
						e1.setCombatTask();
						e = e1;
					}
					world.spawnEntityInWorld(e);
				}
			}
		}).setStartActive());
		addPower(new PowerEntry(new PowerRandBlock("Demonic Fire", 16D, 0.005F){
			@Override
			public void doEffect(EntityPlayer player, World world, BlockPos pos, int ticksActive)
			{
				if(world.getBlockState(pos).getBlock().isReplaceable(world, pos) && Blocks.fire.canPlaceBlockAt(world, pos))
				{
					world.setBlockState(pos, Blocks.fire.getDefaultState());
				}
			}
		}).setStartActive());
		addPower(new PowerEntry(new PowerRandBlock("Demonic Netherrack", 16D, 1F / 200F){
			@Override
			public void doEffect(EntityPlayer player, World world, BlockPos pos, int ticksActive)
			{
				Block block = world.getBlockState(pos).getBlock();
				if(block.isReplaceable(world, pos) || OreDictionary.itemMatches(new ItemStack(Blocks.stone, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(block), false))
				{
					world.setBlockState(pos, Blocks.netherrack.getDefaultState());
				}
			}
		}).setStartActive());
		addPower(new PowerEntry(new PowerPackAggro("ZombiePigman", 16D){
			@Override
			public boolean shouldAggro(EntityLiving entity, EntityLivingBase target)
			{
				return entity instanceof EntityPigZombie && !(target instanceof EntityPigZombie);
			}
		}).setStartActive());
		addPower(new PowerEntry(new PowerOblivious("PigZombie and WitherSkeleton"){//TODO:Oblivious
			@Override
			public boolean canEntityTargetPlayer(EntityLiving entity, EntityPlayer player)
			{
				return !(entity instanceof EntityPigZombie || entity instanceof EntitySkeleton && ((EntitySkeleton)entity).getSkeletonType() == 1);
			}
		}).setStartActive());
	}
}
