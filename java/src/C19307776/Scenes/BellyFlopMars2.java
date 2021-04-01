package C19307776.Scenes;
import C19307776.Scene;
import C19307776.Visuals;
import C19307776.ImageAnimatable;
import java.util.Map;
import C19307776.Properties;
import C19307776.utils.*;

public class BellyFlopMars2 extends Scene {
	ImageAnimatable starship;
	ImageAnimatable ground;

	public BellyFlopMars2(Visuals v) {
		this.sceneLength = 300;

		VHVW d = new VHVW(v.width, v.height);

		ground = new ImageAnimatable(v, "assets/marsTerrain.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vw(100f), "parallax", 0.001f));
		starship = new ImageAnimatable(v, "assets/starship_bellyflop2.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vh(40f), "parallax", 0.003f));

		ground.setDuration(300);
		starship.setDuration(300);

		ground.animateProperty(Map.of("property", Properties.SCALE.getValue(), "to", (int) d.vh(10f), "startTime", 0, "duration", 300), 0);
		starship.animateProperty(Map.of("property", Properties.SCALE.getValue(), "to", (int) -d.vh(10f), "startTime", 0, "duration", 300), 0);

		this.addToScene(ground);
		this.addToScene(starship);
	}
}
