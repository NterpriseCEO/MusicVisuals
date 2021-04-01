package C19307776.Scenes;
import C19307776.Scene;
import C19307776.Visuals;
import C19307776.ImageAnimatable;
import java.util.Map;
import C19307776.Properties;
import C19307776.utils.*;


public class Transfer extends Scene {
	ImageAnimatable stars;
	ImageAnimatable earth;
	ImageAnimatable mars;
	ImageAnimatable starship;

	public Transfer(Visuals v) {
		this.sceneLength = 600;

		VHVW d = new VHVW(v.width, v.height);

		stars = new ImageAnimatable(v, "assets/stars.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vw(90f)));
		earth = new ImageAnimatable(v, "assets/earth.png", d.vw(10f), d.vh(65f), Map.of("prop",d.vh(10f), "parallax", 0.003f));
		mars = new ImageAnimatable(v, "assets/mars.png", d.vw(90f), d.vh(35f), Map.of("prop",d.vh(5.3f), "parallax", 0.003f));
		starship = new ImageAnimatable(v, "assets/starship_rising.png", d.vw(40f), d.vh(50f), Map.of("prop", d.vh(10f), "r", 80f, "parallax", 0.01f));

		stars.setDuration(600);
		earth.setDuration(600);
		mars.setDuration(600);
		starship.setDuration(600);

		earth.animateProperty(Map.of("property", Properties.ROTATION.getValue(), "to", (int) 90, "startTime", 0, "duration", 600), 0);
		earth.animateProperty(Map.of("property", Properties.ROTATION.getValue(), "to", (int) 95, "startTime", 0, "duration", 600), 0);
		earth.animateProperty(Map.of("property", Properties.YPOS.getValue(), "to", (int) d.vh(67f), "startTime", 0, "duration", 600), 0);
		mars.animateProperty(Map.of("property", Properties.YPOS.getValue(), "to", (int) d.vh(37f), "startTime", 0, "duration", 600), 0);

		starship.animateProperty(Map.of("property", Properties.YPOS.getValue(), "to", (int) d.vh(40), "startTime", 0, "duration", 600), 0);
		starship.animateProperty(Map.of("property", Properties.XPOS.getValue(), "to", (int) d.vw(60f), "startTime", 0, "duration", 600), 0);

		this.addToScene(stars);
		this.addToScene(earth);
		this.addToScene(mars);
		this.addToScene(starship);
	}
}
