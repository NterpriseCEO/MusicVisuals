package C19307776.Scenes;
import C19307776.Scene;
import C19307776.Visuals;
import C19307776.ImageAnimatable;
import java.util.Map;
import C19307776.Properties;
import C19307776.utils.*;

/*
	A top-down view of the bellyflop maneuver on Earth
*/

public class BellyFlop2 extends Scene {
	ImageAnimatable starship;
	ImageAnimatable water;

	public BellyFlop2(Visuals v) {
		this.sceneLength = 300;

		VHVW d = new VHVW(v.width, v.height);

		water = new ImageAnimatable(v, "assets/water.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vw(100f), "parallax", 0.001f));
		starship = new ImageAnimatable(v, "assets/starship_bellyflop2.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vh(40f), "parallax", 0.003f));

		water.setDuration(300);
		starship.setDuration(300);

		water.animateProperty(Map.of("property", Properties.SCALE.getValue(), "to", (int) d.vh(10f), "startTime", 0, "duration", 300), 0);
		starship.animateProperty(Map.of("property", Properties.SCALE.getValue(), "to", (int) -d.vh(10f), "startTime", 0, "duration", 300), 0);

		this.addToScene(water);
		this.addToScene(starship);
	}
}
