package by.kolbun.gdx.logic.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class ZoomClickHandler extends InputListener {

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        Gdx.app.log(event.getListenerActor().getName(), "touched down with ZoomClickHandler");
        return true;
    }
}
