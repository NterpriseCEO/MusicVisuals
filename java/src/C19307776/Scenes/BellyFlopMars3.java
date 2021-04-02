package C19307776.Scenes;
import C19307776.Scene;
import C19307776.Visuals;
import C19307776.ImageAnimatable;
import java.util.Map;
import C19307776.Properties;
import C19307776.utils.*;

/*
	A bottom-up view of the bellyflop maneuver on Mars
*/

public class BellyFlopMars3 extends Scene {
	ImageAnimatable starship;
	ImageAnimatable background;

	public BellyFlopMars3(Visuals v) {
		this.sceneLength = 300;

		VHVW d = new VHVW(v.width, v.height);

		background = new ImageAnimatable(v, "assets/martianAtmosphere.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vw(300f), "parallax", 0.001f));
		starship = new ImageAnimatable(v, "assets/starship_bellyflop.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vh(30f), "parallax", 0.003f));

		background.setDuration(300);
		starship.setDuration(300);

		starship.animateProperty(Map.of("property", Properties.SCALE.getValue(), "to", (int) d.vh(40f), "startTime", 0, "duration", 300), 0);

		this.addToScene(background);
		this.addToScene(starship);
	}
}
