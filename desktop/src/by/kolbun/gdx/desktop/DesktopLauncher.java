package by.kolbun.gdx.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import by.kolbun.gdx.CardGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Card Boss Game";
		config.width = 800;
		config.height = 480;
		config.resizable = false;

		new LwjglApplication(new CardGame(), config);
	}
}
