package by.kolbun.gdx;

import by.kolbun.gdx.screens.GameScreen;
import com.badlogic.gdx.Game;

public class CardGame extends Game {

    private GameScreen screen;

    @Override
    public void create() {
        screen = new GameScreen();
        setScreen(screen);
    }
}
