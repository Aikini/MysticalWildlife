package lykrast.mysticalwildlife.client.render;

import lykrast.mysticalwildlife.common.entity.EntityYagaHog;
import lykrast.mysticalwildlife.common.util.ResourceUtil;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderYagaHog extends RenderLiving<EntityYagaHog> {
	private static final ResourceLocation NORMAL = ResourceUtil.getEntityTexture("yaga_hog"),
			DIRTY = ResourceUtil.getEntityTexture("yaga_hog_dirt");
    public static final Factory FACTORY = new Factory();
	
	public RenderYagaHog(RenderManager renderManagerIn)
	{
		super(renderManagerIn, new ModelPig(), 0.7F);
        this.addLayer(new LayerEyesYagaHog(this));
	}

    @Override
    protected ResourceLocation getEntityTexture(EntityYagaHog entity)
    {
        return entity.isDirty() ? DIRTY : NORMAL;
    }

    public static class Factory implements IRenderFactory<EntityYagaHog> {

        @Override
        public Render<? super EntityYagaHog> createRenderFor(RenderManager manager) {
            return new RenderYagaHog(manager);
        }

    }

}
