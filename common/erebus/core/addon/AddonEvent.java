package erebus.core.addon;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.event.Event;

/**
 * @author ProPercivalalb These events are fired during FML's @PostInit to
 *         manage mod addons
 */
public class AddonEvent extends Event {

	public Configuration config;

	public AddonEvent(Configuration config) {
		this.config = config;
	}

	// Fired in order of appearance
	public static class FMLPre extends AddonEvent {
		public FMLPre(Configuration config) {
			super(config);
		}
	}

	public static class FMLInit extends AddonEvent {
		public FMLInit(Configuration config) {
			super(config);
		}
	}

	public static class Pre extends AddonEvent {
		public Pre(Configuration config) {
			super(config);
		}
	}

	public static class Init extends AddonEvent {
		public Init(Configuration config) {
			super(config);
		}
	}

	public static class Post extends AddonEvent {
		public Post(Configuration config) {
			super(config);
		}
	}

}
