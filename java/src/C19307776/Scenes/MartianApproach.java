package C19307776.Scenes;
import C19307776.Scene;
import C19307776.Visuals;
import C19307776.ImageAnimatable;
import java.util.Map;
import C19307776.Properties;
import C19307776.utils.*;


public class MartianApproach extends Scene {
	ImageAnimatable stars;
	ImageAnimatable mars;
	ImageAnimatable starship;

	public MartianApproach(Visuals v) {
		this.sceneLength = 900;

		VHVW d = new VHVW(v.width, v.height);

		stars = new ImageAnimatable(v, "assets/stars.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vw(90f)));
		mars = new ImageAnimatable(v, "assets/mars.png", d.vw(90f), d.vh(50f), Map.of("prop", d.vh(50f), "parallax", 0.003f));
		starship = new ImageAnimatable(v, "assets/starship_upperstage.png", d.vw(20f), d.vh(50f), Map.of("prop", d.vh(30f), "r", 90f, "parallax", 0.01f));

		stars.setDuration(900);
		mars.setDuration(900);
		starship.setDuration(900);

		mars.animateProperty(Map.of("property", Properties.SCALE.getValue(), "to", (int) d.vh(150f), "startTime", 0, "duration", 600), 0);
		mars.animateProperty(Map.of("property", Properties.XPOS.getValue(), "to", (int) d.vw(20f), "startTime", 0, "duration", 600), 0);

		starship.animateProperty(Map.of("property", Properties.XPOS.getValue(), "to", (int) d.vw(40f), "startTime", 0, "duration", 600), 0);

		this.addToScene(stars);
		this.addToScene(mars);
		this.addToScene(starship);
	}
}
