package com.downisder.robotmania2.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.downisder.robotmania2.RobotMania;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 1200;
		config.height = 624;

		new LwjglApplication(new RobotMania(), config);
	}
}
