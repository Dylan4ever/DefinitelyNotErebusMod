package erebus.core.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import erebus.ClientErebusTickHandler;
import erebus.PortalOverlayRenderer;
import erebus.ErebusMod;
import erebus.Block.TileEntityHollowLog;
import erebus.Entity.EntityBeetle;
import erebus.Entity.EntityBeetleLarva;
import erebus.Entity.EntityCentipede;
import erebus.Entity.EntityFly;
import erebus.Entity.EntityGreenfly;
import erebus.Entity.EntityMosquito;
import erebus.Entity.EntityTarantula;
import erebus.Entity.EntityVelvetWorm;
import erebus.Entity.EntityWasp;
import erebus.client.model.entity.ModelBeetle;
import erebus.client.model.entity.ModelBeetleLarva;
import erebus.client.model.entity.ModelCentipede;
import erebus.client.model.entity.ModelGreenfly;
import erebus.client.model.entity.ModelMosquito;
import erebus.client.model.entity.ModelTarantula;
import erebus.client.model.entity.ModelVelvetWorm;
import erebus.client.model.entity.ModelWasp;
import erebus.client.render.entity.RenderBeetle;
import erebus.client.render.entity.RenderBeetleLarva;
import erebus.client.render.entity.RenderCentipede;
import erebus.client.render.entity.RenderFly;
import erebus.client.render.entity.RenderGreenfly;
import erebus.client.render.entity.RenderMosquito;
import erebus.client.render.entity.RenderTarantula;
import erebus.client.render.entity.RenderVelvetWorm;
import erebus.client.render.entity.RenderWasp;
import erebus.client.render.item.HollowLogItemRenderer;
import erebus.client.render.tileentity.TileEntityRenderHollowLog;

public class ClientProxy extends CommonProxy {
	
	public static Minecraft mc = FMLClientHandler.instance().getClient();
	public Item item;

	@Override
	public void registerRenderInformation()  {  
    
		MinecraftForge.EVENT_BUS.register(new PortalOverlayRenderer());
		TickRegistry.registerTickHandler(new ClientErebusTickHandler(), Side.CLIENT);    
		RenderingRegistry.registerEntityRenderingHandler(EntityBeetleLarva.class, new RenderBeetleLarva(new ModelBeetleLarva(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBeetle.class, new RenderBeetle(new ModelBeetle(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFly.class, new RenderFly());
		//RenderingRegistry.registerEntityRenderingHandler(EntityGreenfly.class, new RenderGreenfly(new ModelGreenfly(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTarantula.class, new RenderTarantula(new ModelTarantula(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMosquito.class, new RenderMosquito(new ModelMosquito(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityVelvetWorm.class, new RenderVelvetWorm(new ModelVelvetWorm(), 0.6F, 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityWasp.class, new RenderWasp(new ModelWasp(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityCentipede.class, new RenderCentipede(new ModelCentipede(), 0.5F));

		//Special Renderer
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHollowLog.class, new TileEntityRenderHollowLog());

		MinecraftForgeClient.registerItemRenderer(ErebusMod.hollowLogAcacia.blockID, new HollowLogItemRenderer(TileEntityRenderHollowLog.hollowLogResource));
	}
}