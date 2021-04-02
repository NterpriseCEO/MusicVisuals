package C19307776.Scenes;
import C19307776.ImageAnimatable;
import C19307776.TextAnimatable;
import C19307776.Scene;
import C19307776.Visuals;
import java.util.Map;
import C19307776.utils.*;

/*
	Animation of city being built and the out title
*/

public class CityBuildLapse extends Scene{
	ImageAnimatable baseBuildup1;
	ImageAnimatable baseBuildup2;
	ImageAnimatable baseBuildup3;
	ImageAnimatable baseBuildup4;
	ImageAnimatable baseBuildup5;
	TextAnimatable thanks;
	TextAnimatable escape;
	ImageAnimatable marsCity;

	public CityBuildLapse(Visuals v) {
		this.sceneLength = 48000;

		VHVW d = new VHVW(v.width, v.height);

		baseBuildup1 = new ImageAnimatable(v, "assets/base_buildup.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vw(90f), "parallax", 0.001f));
		baseBuildup2 = new ImageAnimatable(v, "assets/base_buildup2.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vw(90f), "parallax", 0.001f));
		baseBuildup3 = new ImageAnimatable(v, "assets/base_buildup3.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vw(90f), "parallax", 0.001f));
		baseBuildup4 = new ImageAnimatable(v, "assets/base_buildup4.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vw(90f), "parallax", 0.001f));
		baseBuildup5 = new ImageAnimatable(v, "assets/base_buildup5.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vw(90f), "parallax", 0.001f));
		thanks = new TextAnimatable(v, "Thanks for watching!", d.vw(8f), new int[]{0, 0, 0}, d.vw(50f), d.vh(50f), 0, 0.003f);
		escape = new TextAnimatable(v, "Press ESC to exit", d.vw(4f), new int[]{0, 0, 0}, d.vw(50f), d.vh(57f), 0, 0.003f);
		marsCity = new ImageAnimatable(v, "assets/marsCity.png", d.vw(50f), d.vh(50f), Map.of("prop", (float) d.vw(100f), "parallax", 0.001f));

		baseBuildup1.setDuration(60);
		baseBuildup2.setDuration(60, 60);
		baseBuildup3.setDuration(120, 60);
		baseBuildup4.setDuration(180, 60);
		baseBuildup5.setDuration(240, 60);
		thanks.setDuration(300, 47700);
		escape.setDuration(300, 47700);
		marsCity.setDuration(300, 47700);

		this.addToScene(baseBuildup1);
		this.addToScene(baseBuildup2);
		this.addToScene(baseBuildup3);
		this.addToScene(baseBuildup4);
		this.addToScene(baseBuildup5);
		this.addToScene(marsCity);
		this.addToScene(thanks);
		this.addToScene(escape);
	}
}
