package C19307776;
import java.util.Random;

import C19307776.Scenes.*;
import C19307776.audioSystem.*;
import processing.core.*;

public class Animation extends Visuals {
	SceneManager scenes;
	Song donau;
	int time = 0;

	int cx, cy;

	//For checking if the commands dialogue box is shown on screen
	boolean commandsShown = false;

	//The command icon and the commands dialogue box
	PImage command;
	PImage commands;

	public Animation() {
		
	}

	public void settings() {
		//Creates a fullscreen window
		fullScreen(P3D);
		//size(500, 300);
	}

	public void setup() {
		hint(DISABLE_TEXTURE_MIPMAPS);
		background(0);

		cx = width/2;
		cy = height/2;
		println(cx, cy);

		command = loadImage("assets/showCommands.png");
		commands = loadImage("assets/commands.png");

		//Scaling the commands dialogue box
		command.resize(width/7, 0);
		commands.resize(width/3, 0);

		//Inits the scene manager
		scenes = new SceneManager();
		//Adds scenes to the animation
		scenes.addScene(new Intro(this));
		scenes.addScene(new RIP(this));
		scenes.addScene(new Takeoff(this));
		scenes.addScene(new TakeOff2(this));
		scenes.addScene(new Curvature(this));
		scenes.addScene(new BoosterSep(this));
		scenes.addScene(new BoosterReturn(this));
		scenes.addScene(new BoosterLanding(this));
		scenes.addScene(new EarthSystem(this));
		scenes.addScene(new Takeoff(this));
		scenes.addScene(new StarshipRefuel(this));
		scenes.addScene(new BellyFlop1(this));
		scenes.addScene(new BellyFlop2(this));
		scenes.addScene(new BellyFlop3(this));
		scenes.addScene(new StarshipLanding(this));
		scenes.addScene(new ToMars(this));
		scenes.addScene(new Transfer(this));
		scenes.addScene(new MartianApproach(this));
		scenes.addScene(new BellyFlopMars1(this));
		scenes.addScene(new BellyFlopMars2(this));
		scenes.addScene(new BellyFlopMars3(this));
		scenes.addScene(new StarshipLandingMars(this));
		scenes.addScene(new CityBuildLapse(this));
		scenes.setCurrentScene(0);

		//Loads and plays the music
		try {
			donau = new Song("assets/donau.wav", scenes.animationLength());
			donau.play();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void keyPressed() {
		//Skips to next scene if right arrow is pressed
		if(keyCode == RIGHT) {
			//Checks if current scene is not last scene and skips to the next one
			if(!scenes.isPaused() && scenes.getCurrentScene()+1 != scenes.getAmount()) {
				donau.skipTo(scenes.sceneEndPosition());
				scenes.nextScene();
			}
		}
		//Toggles pause on the animation if the commands dialogue not shown
		if(keyCode == ' ' && !commandsShown) {
			scenes.setPaused(!scenes.isPaused());
			donau.toggle();
		}
		//Toggles the visibility of the command dialogue
		if(key == 'c' && !scenes.isPaused()) {
			scenes.setPaused(!scenes.isPaused());
			donau.toggle();
			commandsShown = !commandsShown;
		}
		//Takes and saves a screenshot of the current scene frame
		if(key == 's' && !commandsShown) {
			Random rand = new Random();
			boolean paused = donau.getPaused();
			/*
				The animation is paused for a frame when a screenshot is taken.
				Enough screenshots would desynchronize the music and the animation.
				Therefore the music is paused for the duration of the screenshot to prevent this
			*/
			donau.pause();
			//Saves the screenshot with a random number as the filename
			saveFrame("../screenshots/"+rand.nextInt(1000000)+".png");

			//Continues the music if it was playing beforehand
			if(!paused) {
				donau.play();
			}
		}
	}

	public void draw() {
		//Draws the current scene

		//if the animation isn't paused
		if(!scenes.isPaused()) {
			background(0);
			scenes.animateScene();
			if(frameCount%60 == 0) {
				println(++time);
			}
		}

		//Draw either the command icon or the commands dialogue box
		if(commandsShown) {
			image(commands, cx, cy);
		}else {
			imageMode(CORNER);
			image(command, 0, 0);
			imageMode(CENTER);
		}
	}
}
