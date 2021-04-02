package C19307776.Scenes;
import C19307776.Scene;
import C19307776.Visuals;
import C19307776.ImageAnimatable;
import java.util.Map;
import C19307776.Properties;
import C19307776.utils.*;

/*
	Animation of starship flying upwards (away from earth).
*/

public class ToMars extends Scene {
	ImageAnimatable stars;
	ImageAnimatable earth;
	ImageAnimatable starship;
	ImageAnimatable flame;

	public ToMars(Visuals v) {
		this.sceneLength = 420;

		VHVW d = new VHVW(v.width, v.height);

		stars = new ImageAnimatable(v, "assets/stars.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vw(90f)));
		earth = new ImageAnimatable(v, "assets/earth.png", d.vw(50f), d.vh(100f), Map.of("prop",d.vh(150f), "r", -90f, "parallax", 0.003f));
		starship = new ImageAnimatable(v, "assets/starship_rising.png", d.vw(50f), d.vh(100f), Map.of("prop", d.vh(100f), "parallax", 0.001f));
		flame = new ImageAnimatable(v, "assets/flames.png", d.vw(50.05f), d.vh(155f), Map.of("prop", (float) d.vw(10f), "parallax", 0.001f));

		stars.setDuration(420);
		earth.setDuration(420);
		starship.setDuration(420);
		flame.setDuration(420);

		//Animates starship from the bottom of the screen to the top
		starship.animateProperty(Map.of("property", Properties.YPOS.getValue(), "to", (int) -d.vh(20), "startTime", 0, "duration", 420), 0);
		flame.animateProperty(Map.of("property", Properties.YPOS.getValue(), "to", (int) d.vh(35), "startTime", 0, "duration", 420), 0);
		
		this.addToScene(stars);
		this.addToScene(earth);
		this.addToScene(flame);
		this.addToScene(starship);
	}
}
