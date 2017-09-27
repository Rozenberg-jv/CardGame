package by.kolbun.gdx.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.*;

public class DraggHandler extends InputListener {
    private static final Vector2 tmpCoords = new Vector2();

    public boolean handle(Event e) {
        if (!(e instanceof InputEvent)) return false;
        InputEvent event = (InputEvent) e;

        event.toCoordinates(event.getListenerActor(), tmpCoords);

        switch (event.getType()) {
            case touchDown:
                return touchDown(event, tmpCoords.x, tmpCoords.y, event.getPointer(), event.getButton());
            case touchUp:
                touchUp(event, tmpCoords.x, tmpCoords.y, event.getPointer(), event.getButton());
                return true;
            case touchDragged:
                touchDragged(event, tmpCoords.x, tmpCoords.y, event.getPointer());
                return true;
        }
        return false;
    }

    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        current = event.getListenerActor();

        Gdx.app.log(current.getName(), "touchDown() x:" + x + ", y:" + y);
        return true;
    }

    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                Gdx.app.log(getName(), "touchUp()");
    }

    Vector2 nPos;
    Actor current;

    public void touchDragged(InputEvent event, float x, float y, int pointer) {
        current = event.getListenerActor();
        nPos = current.localToStageCoordinates(new Vector2(x, y));
        current.setPosition(-current.getWidth() / 2 + nPos.x, -current.getHeight() / 2 + nPos.y);
//                Gdx.app.log("BigHunter", "touchDragged() x:" + x + ", y:" + y);
//                Gdx.app.log("BigHunter", "current " + localToStageCoordinates(new Vector2(x, y)).toString());
    }
}
