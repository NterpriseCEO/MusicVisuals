package C19307776.Scenes;
import C19307776.ImageAnimatable;
import C19307776.Scene;
import C19307776.Visuals;
import C19307776.Properties;
import java.util.Map;
import C19307776.utils.*;

public class StarshipLandingMars extends Scene {
	ImageAnimatable background;
	ImageAnimatable engines1;
	ImageAnimatable engines2;
	ImageAnimatable engines3;
	ImageAnimatable[] exhaustClouds = new ImageAnimatable[22];

	public StarshipLandingMars(Visuals v) {
		this.sceneLength = 360;

		//Intialise viewport units
		VHVW d = new VHVW(v.width, v.height);

		background = new ImageAnimatable(v, "assets/marsSurface.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vw(90f), "parallax", 0.001f));
		engines1 = new ImageAnimatable(v, "assets/landing1engine.png", d.vw(65f), -d.vh(5f), Map.of("prop", (float) d.vw(40), "r", -90f, "parallax", 0.001f));
		engines2 = new ImageAnimatable(v, "assets/landing2engine.png", d.vw(62f), d.vh(4f), Map.of("prop", (float) d.vw(40), "r", -90f, "parallax", 0.001f));
		engines3 = new ImageAnimatable(v, "assets/landing3engine.png", d.vw(61.25f), d.vh(8.5f), Map.of("prop", (float) d.vw(40), "r", -90f, "parallax", 0.001f));

		//Sets the duration of that sprites appear on the screen
		background.setDuration(360);
		engines1.setDuration(30);
		engines2.setDuration(30, 15);
		engines3.setDuration(45, 315);

		//Sprite animations
		engines1.animateProperty(Map.of("property", Properties.YPOS.getValue(), "to", (int) d.vh(4f), "startTime", 0, "duration", 30), 0);
		engines1.animateProperty(Map.of("property", Properties.XPOS.getValue(), "to", (int) d.vw(62f), "startTime", 0, "duration", 30), 0);

		engines2.animateProperty(Map.of("property", Properties.YPOS.getValue(), "to", (int) d.vh(8.5f), "startTime", 0, "duration", 15), 0);
		engines2.animateProperty(Map.of("property", Properties.XPOS.getValue(), "to", (int) d.vw(61.25f), "startTime", 0, "duration", 15), 0);
		
		engines3.animateProperty(Map.of("property", Properties.YPOS.getValue(), "to", (int) d.vh(50f), "startTime", 0, "duration", 105), 0);
		engines3.animateProperty(Map.of("property", Properties.XPOS.getValue(), "to", (int) d.vw(50f), "startTime", 0, "duration", 105), 0);

		engines3.animateProperty(Map.of("property", Properties.ROTATION.getValue(), "to", (int) 10f, "startTime", 0, "duration", 120), 0);

		engines3.animateProperty(Map.of("property", Properties.YPOS.getValue(), "to", (int) d.vh(65f), "startTime", 105, "duration", 180), 0);

		engines3.animateProperty(Map.of("property", Properties.ROTATION.getValue(), "to", (int) 0f, "startTime", 105, "duration", 60), 0);

		//Adding sprites to the scene
		this.addToScene(background);
		this.addToScene(engines1);
		this.addToScene(engines2);
		this.addToScene(engines3);

		for(int i = 0; i < 11; i++) {
			exhaustClouds[i] = new ImageAnimatable(v, "assets/launch_cloud/frame"+i+".png", d.vw(50f), d.vh(75f), Map.of("prop", (float) d.vw(10f), "parallax", 0.001f));
			exhaustClouds[i].setDuration(180+(i*15), 15);
			this.addToScene(exhaustClouds[i]);
		}
	}
}
