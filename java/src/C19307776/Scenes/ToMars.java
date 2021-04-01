package C19307776.Scenes;
import C19307776.Scene;
import C19307776.Visuals;
import C19307776.ImageAnimatable;
import java.util.Map;
import C19307776.Properties;
import C19307776.utils.*;


public class ToMars extends Scene {
	ImageAnimatable stars;
	ImageAnimatable earth;
	ImageAnimatable starship;

	public ToMars(Visuals v) {
		this.sceneLength = 420;

		VHVW d = new VHVW(v.width, v.height);

		stars = new ImageAnimatable(v, "assets/stars.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vw(90f)));
		earth = new ImageAnimatable(v, "assets/earth.png", d.vw(50f), d.vh(100f), Map.of("prop",d.vh(150f), "r", -90f, "parallax", 0.003f));
		starship = new ImageAnimatable(v, "assets/starship_rising.png", d.vw(50f), d.vh(100f), Map.of("prop", d.vh(100f), "parallax", 0.01f));

		stars.setDuration(420);
		earth.setDuration(420);
		starship.setDuration(420);
		//earth.animateProperty(Properties.XPOS.getValue(), 1500, 0, 600);
		//earth.animateProperty(Properties.YPOS.getValue(), 0, 0, 600);
		starship.animateProperty(Map.of("property", Properties.YPOS.getValue(), "to", (int) -d.vh(20), "startTime", 0, "duration", 420), 0);
		//starship.animateProperty(Properties.ROTATION.getValue(), 36000, 0, 120);
		
		this.addToScene(stars);
		this.addToScene(earth);
		this.addToScene(starship);
	}
}
