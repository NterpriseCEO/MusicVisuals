package C19307776.Scenes;
import java.util.Map;

import C19307776.ImageAnimatable;
import C19307776.Visuals;
import C19307776.Scene;
import C19307776.Properties;
import C19307776.utils.*;

/*
	Animation of starship arching over before going fully orbital.
*/

public class Curvature extends Scene {
	ImageAnimatable stars;
	ImageAnimatable earth;
	ImageAnimatable starship;
	ImageAnimatable flame;

	public Curvature(Visuals v) {
		this.sceneLength = 660;

		VHVW d = new VHVW(v.width, v.height);

		stars = new ImageAnimatable(v, "assets/stars.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vw(90f)));
		earth = new ImageAnimatable(v, "assets/earth.png", d.vw(50f) ,  d.vh(250f), Map.of("prop", d.vw(200f), "parallax", 0.001f));
		starship = new ImageAnimatable(v, "assets/full_starship.png", d.vw(50f), d.vh(70f), Map.of("prop", (float) d.vh(5f), "parallax", 0.003f));
		flame = new ImageAnimatable(v, "assets/flames.png", d.vw(58.5f), d.vh(40f), Map.of("prop", (float) d.vw(0.3f), "r", 90f, "parallax", 0.003f));

		//Starship rising
		starship.animateProperty(Map.of("property", Properties.YPOS.getValue(), "to", (int) d.vh(40f), "startTime", 0, "duration", 300), 0);
		starship.animateProperty(Map.of("property", Properties.XPOS.getValue(), "to", (int) d.vw(60f), "startTime", 0, "duration", 300), 0);

		//Starship rotating rotating to horizontal and growing in size
		starship.animateProperty(Map.of("property", Properties.ROTATION.getValue(), "to", (int) 90f, "startTime", 0, "duration", 300), 0);
		starship.animateProperty(Map.of("property", Properties.SCALE.getValue(), "to", (int)  d.vh(90f), "startTime", 300, "duration", 300), 0);
		starship.animateProperty(Map.of("property", Properties.XPOS.getValue(), "to", (int) d.vw(45f), "startTime", 300, "duration", 300), 0);

		//Starship exhaust appearing once it is big enough to make out on the screen
		flame.animateProperty(Map.of("property", Properties.XPOS.getValue(), "to", (int) d.vw(15.76f), "startTime", 0, "duration", 300), 0);
		flame.animateProperty(Map.of("property", Properties.SCALE.getValue(), "to", (int) d.vw(5f), "startTime", 0, "duration", 300), 0);

		//Earth getting smaller as starship gets bigger
		earth.animateProperty(Map.of("property", Properties.SCALE.getValue(), "to", (int) d.vw(100f), "startTime", 300, "duration", 300), 0);
		earth.animateProperty(Map.of("property", Properties.YPOS.getValue(), "to", (int) d.vh(300f), "startTime", 300, "duration", 300), 0);

		stars.setDuration(900);
		earth.setDuration(900);
		starship.setDuration(900);
		flame.setDuration(300, 900);

		this.addToScene(stars);
		this.addToScene(earth);
		this.addToScene(starship);
		this.addToScene(flame);
	}
}
