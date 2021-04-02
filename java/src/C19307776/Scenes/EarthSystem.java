package C19307776.Scenes;
import C19307776.ImageAnimatable;
import C19307776.Scene;
import C19307776.Visuals;
import C19307776.Properties;
import java.util.Map;
import C19307776.utils.*;

/*
	Starship moving accross the screen
*/

public class EarthSystem extends Scene{
	ImageAnimatable stars;
	ImageAnimatable earth;
	ImageAnimatable starship;

	public EarthSystem(Visuals v) {
		this.sceneLength = 420;

		VHVW d = new VHVW(v.width, v.height);

		stars = new ImageAnimatable(v, "assets/stars.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vw(90f)));
		earth = new ImageAnimatable(v, "assets/earth.png", d.vw(50f), d.vh(50f), Map.of("prop",d.vh(75f), "parallax", 0.003f));
		starship = new ImageAnimatable(v, "assets/starship_upperstage.png", d.vw(50f), d.vh(50f), Map.of("prop", d.vh(25f), "r", 90f, "parallax", 0.01f));

		stars.setDuration(420);
		earth.setDuration(420);
		starship.setDuration(420);

		//Animate starship moving from point across the screen in front of earth
		starship.animateProperty(Map.of("property", Properties.XPOS.getValue(), "to", (int) d.vw(60f), "startTime", 0, "duration", 420), 0);
		
		this.addToScene(stars);
		this.addToScene(earth);
		this.addToScene(starship);
	}
}
