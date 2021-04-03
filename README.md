# Music Visualiser Project

Name: Alex Nuzum

Student Number: C19307776

## Description of the assignment
This is an animation of starship launching from earth, refueling in orbit and then flying to mars.
The first song in the youtube video (listed below) is my own song named "Interesting Title". The
second song is An der Schönen Blauen Donau by Johann Strauss II.

## Instructions
- Download the repository
- Open the folder in VS Code
- Hit F5 to run
- Commands
	- C: show commands dialogue
	- ESC: close animation
	- Right key: skip scene
	- Space bar: play / pause the animation
	- S: take screenshot of the animation

## How it works
The animation is divided into multiple scenes which contain multiple animated objects.
These objects can have different properties such as width, height etc which can be animated
at different points in the scene. The music is plaued in the background and the animations
are played in sync with the music.

# What I am most proud of in the assignment
I am most proud of the scene manager and the animation system. The great thing about the scene
manager is that it has access to each animatable object in each scene. It's responsibility is to
render the correct animatable objects at the correct time in each scene. Once the scene is finished,
these animatable objects are discarded and new onces are rendered, hence allowing different scenes to
exist rather than one continuous animation.

The animation system is also really cool. Each object has animatable properties such as width, height,
x position, y position etc. These properties are added to an array. Every time the scene is rendered,
the animation system checks if a specific property is to be animated (the aniamtion's current frame is
somewhere between the first and and last frame of the animation. I think this is really cool because I
can call ````starship.animateProperty(Map.of("property", Properties.YPOS.getValue(), "to", (int) d.vh(60f), "startTime", 0, "duration", 300), 0);````
for example and it will automatically run this property animation for the desired duration (frame 0 to frame 300).

## The demo video
[![](http://img.youtube.com/vi/hmsI0MLR1Ko/0.jpg)](http://www.youtube.com/watch?v=hmsI0MLR1Ko "My video demonstration")

