package C19307776.Scenes;
import C19307776.Scene;
import C19307776.ShapeAnimatable;
import C19307776.TextAnimatable;
import C19307776.Visuals;
import C19307776.utils.*;
import java.util.Map;

import C19307776.ImageAnimatable;
import C19307776.Properties;

/*
	The intro title for the animation.
*/

public class Intro extends Scene {
	TextAnimatable title;
	ShapeAnimatable panel;
	ImageAnimatable backdrop;
	
	public Intro(Visuals v) {
		this.sceneLength = 1800;

		VHVW d = new VHVW(v.width, v.height);

		title = new TextAnimatable(v, "Starship to Mars", d.vw(6f), new int[]{255, 255, 255}, d.vw(100f), d.vh(53f), 0, 0);
		panel = new ShapeAnimatable(v, new int[]{255, 50, 50}, -d.vw(50f), d.vh(50f), Map.of("w", (float) d.vw(60f), "h", (float) d.vh(15f)));
		backdrop = new ImageAnimatable(v, "assets/hiriseCollage.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vh(100f)));

		title.setDuration(1800);
		panel.setDuration(1800);
		backdrop.setDuration(1800);

		//Animate the text and text plaque from left ot right and vice versa
		title.animateProperty(Map.of("property", Properties.XPOS.getValue(), "to", (int) d.vw(50f), "startTime", 0, "duration", 300), 0);
		panel.animateProperty(Map.of("property", Properties.XPOS.getValue(), "to", (int) d.vw(50f), "startTime", 0, "duration", 300), 0);

		this.addToScene(backdrop);
		this.addToScene(panel);
		this.addToScene(title);
	}
}
