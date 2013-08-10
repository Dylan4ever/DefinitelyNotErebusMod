package erebus.client.render.entity;

import net.minecraft.util.MathHelper;

public class AnimationMathHelper
{
	public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float h;
    
    public AnimationMathHelper()
    {
		b = 0.0F;
        c = 0.0F;
        h = 1.0F;
    }
    
    //this simulates a swing.
	public float swing(float speed, float max)
	{   
    	e = b;
        d = c;
        c = (float)((double)c + 4 * 0.8F);

        if (c < 0.0F)
        {
            c = 0.0F;
        }

        if (c > speed)
        {
            c = speed;
        }

        if (h < speed)
        {
            h = speed;
        }

        h = (float)((double)h * 0.8F);
        b += h * 0.5F;
        
        float f1 = e + (b - e);
        float f2 = d + (c - d);
        float f3 = (MathHelper.sin(f1) + 0.5F) * f2 * max;
        return f3;
	}
}