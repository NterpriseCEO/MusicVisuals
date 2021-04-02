package C19307776;
import processing.core.*;
import java.util.Map;

public class ImageAnimatable extends Animatable {
	PImage img; //Sprite
	String src; // sprite image src

	public ImageAnimatable(Visuals v, String src, float x, float y, Map<String, Float> props) {
		//The sprites properties
		this.v = v;
		this.src = src;
		img = v.loadImage(src);

		//Checks if the width and height property are present
		if(props.containsKey("w") && props.containsKey("h")) {
			//Sets the width and height variables
			this.lastWidth = this.w = props.get("w");
			this.lastHeight = this.h = props.get("h");
		}else if(props.containsKey("prop")) {
			//If width / height not present, scale the image proportionally
			this.imageRatio = (float) img.width/img.height;
			this.w = this.h = props.get("prop");
		}

		this.lastX = this.x = x;
		this.lastY = this.y = y;
		//Sets the rotation value of the sprite
		if(props.containsKey("r")) {
			this.lastRotation = this.rotation = props.get("r");
		}
		if(props.containsKey("parallax")) {
			this.parallax = props.get("parallax");
		}
		//Sets the centre of the image to be the anchor point
		v.imageMode(v.CENTER);
	}

	//Animates the sprite each frame
	public void animate() {
		if(this.animateFrame()) {
			v.pushMatrix();
			v.translate(this.x+(v.mouseX*parallax), this.y+(v.mouseY*parallax));

			//Checks if rotation = 0
			if(this.rotation != 0) {
				//Rotates the sprite
				v.rotate(v.radians(this.rotation));
			}
			//Draws the shape at new dimensions / coordinates
			v.image(this.img, 0, 0, this.w*imageRatio, this.h);
			v.popMatrix();
			//Increments frame counter
		}
	}
}