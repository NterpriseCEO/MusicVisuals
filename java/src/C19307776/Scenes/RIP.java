package C19307776.Scenes;
import C19307776.Scene;
import C19307776.Visuals;
import C19307776.ImageAnimatable;
import C19307776.TextAnimatable;
import C19307776.utils.*;
import java.util.Map;

/*
	A scene commemorating all the starships that have crashed or exploded
*/

public class RIP extends Scene{
	ImageAnimatable sn8;
	ImageAnimatable sn9_10;
	ImageAnimatable sn11;
	TextAnimatable rip;
	TextAnimatable rip2;
	ImageAnimatable backdrop;

	public RIP(Visuals v) {
		this.sceneLength = 1800;

		VHVW d = new VHVW(v.width, v.height);

		backdrop = new ImageAnimatable(v, "assets/hiriseCollage.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vh(100f)));
		sn8 = new ImageAnimatable(v, "assets/sn8.png", d.vw(18f), d.vh(50f), Map.of("prop", (float) d.vh(40f), "parallax", 0.001f));
		sn9_10 = new ImageAnimatable(v, "assets/sn9_10.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vh(35f), "parallax", 0.001f));
		sn11 = new ImageAnimatable(v, "assets/sn11.png", d.vw(80f), d.vh(50f), Map.of("prop", (float) d.vh(35f), "parallax", 0.001f));
		rip = new TextAnimatable(v, "Dedicated to our fallen soldiers", d.vw(6f), new int[]{255, 255, 255}, d.vw(50f), d.vh(15f), 0, 0.003f);
		rip2 = new TextAnimatable(v, "May youse rest in pieces :(", d.vw(6f), new int[]{255, 255, 255}, d.vw(50f), d.vh(85f), 0, 0.003f);

		sn8.setDuration(1800);
		sn9_10.setDuration(1800);
		sn11.setDuration(1800);
		rip.setDuration(1800);
		rip2.setDuration(1800);
		backdrop.setDuration(1800);

		this.addToScene(backdrop);
		this.addToScene(sn8);
		this.addToScene(sn9_10);
		this.addToScene(sn11);
		this.addToScene(rip);
		this.addToScene(rip2);
	}
}
