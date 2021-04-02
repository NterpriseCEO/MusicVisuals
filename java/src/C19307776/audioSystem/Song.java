package C19307776.audioSystem;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Song {
	//Store current position
	Long currentFrame;
	Clip clip;

	//status of clip
	String status;
	int animationLength = 0;
	private static boolean paused = false;

	AudioInputStream audioInputStream;

	//Constructor to init streams and clip - takes file path as a parameter
	public Song(String filePath, int animationLength) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		//create AudioInputStream object
		audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

		this.animationLength = animationLength;

		//creates reference to clip
		clip = AudioSystem.getClip();
		//this opens the audioInputStream to the clip
		clip.open(audioInputStream);
	}

	//Skips to a certain part of the song
	public void skipTo(int s) {
		clip.setMicrosecondPosition(s*1000000);
	}

	//Checks if the video is paused
	public boolean getPaused() {
		return paused;
	}

	//Plays the audio clip
	public void play() {
		paused = false;
		clip.start();
	}
	//Pauses the audio clip
	public void pause() {
		paused = true;
		clip.stop();
	}
	//Toggles whether or not the video is paused
	public void toggle() {
		paused = !paused;
		if(clip.isActive()) {
			clip.stop();
		}else {
			clip.start();
		}
	}
}