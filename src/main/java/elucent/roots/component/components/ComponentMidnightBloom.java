package elucent.roots.component.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.google.common.collect.Lists;

import elucent.roots.PlayerManager;
import elucent.roots.RegistryManager;
import elucent.roots.RootsNames;
import elucent.roots.Util;
import elucent.roots.component.ComponentBase;
import elucent.roots.component.ComponentEffect;
import elucent.roots.component.EnumCastType;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class ComponentMidnightBloom extends ComponentBase{
	Random random = new Random();
	public ComponentMidnightBloom(){
		super("midnightbloom","Time Stop",RegistryManager.verdantSprig,18);	
	}
	
	@Override
	public void doEffect(World world, Entity caster, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.SPELL){
			ArrayList<EntityLivingBase> targets = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(x-(3.0+size)*6.0,y-(3.0+size)*6.0,z-(3.0+size)*6.0,x+(3.0+size)*6.0,y+(3.0+size)*6.0,z+(3.0+size)*6.0));
			for (int i = 0; i < targets.size(); i ++){
				if (targets.get(i).getUniqueID() != caster.getUniqueID()){
					Util.addTickTracking(targets.get(i));
					targets.get(i).getEntityData().setInteger(RootsNames.TAG_SPELL_SKIP_TICKS, 80+40*(int)potency);
				}
			}
		}
	}
	
	@Override
	public void doEffect(World world, UUID casterId, Vec3d direction, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.SPELL){
			ArrayList<EntityLivingBase> targets = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(x-(3.0+size)*6.0,y-(3.0+size)*6.0,z-(3.0+size)*6.0,x+(3.0+size)*6.0,y+(3.0+size)*6.0,z+(3.0+size)*6.0));
			for (int i = 0; i < targets.size(); i ++){
				if (targets.get(i).getUniqueID() != casterId){
					Util.addTickTracking(targets.get(i));
					targets.get(i).getEntityData().setInteger(RootsNames.TAG_SPELL_SKIP_TICKS, 80+40*(int)potency);
				}
			}
		}
	}
}
