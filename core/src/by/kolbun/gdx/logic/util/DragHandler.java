package by.kolbun.gdx.logic.util;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

public class DragHandler extends DragListener {

    private Vector2 nPos;
    private Actor current;

    @Override
    public void drag(InputEvent event, float x, float y, int pointer) {
        current = event.getListenerActor();
        nPos = current.localToStageCoordinates(new Vector2(x, y));
        current.setPosition(-current.getWidth() / 2 + nPos.x, -current.getHeight() / 2 + nPos.y);
    }

    @Override
    public void dragStop(InputEvent event, float x, float y, int pointer) {

    }
}
