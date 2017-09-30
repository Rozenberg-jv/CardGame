package by.kolbun.gdx.logic.util;

import by.kolbun.gdx.logic.cards.TownCard;
import by.kolbun.gdx.logic.cards.TrophyCard;
import by.kolbun.gdx.logic.towns.Town;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

public class DragHandler extends DragListener {

    private Vector2 nPos;
    private Actor current;
    private Actor droppedOn;
    private Vector2 startPos;

    @Override
    public void dragStart(InputEvent event, float x, float y, int pointer) {
        current = event.getListenerActor();
        current.setTouchable(Touchable.disabled);
        startPos = new Vector2(current.getX(), current.getY());
    }

    @Override
    public void drag(InputEvent event, float x, float y, int pointer) {
        nPos = current.localToStageCoordinates(new Vector2(x, y));
        current.setPosition(-current.getWidth() / 2 + nPos.x, -current.getHeight() / 2 + nPos.y);
    }

    @Override
    public void dragStop(InputEvent event, float x, float y, int pointer) {
        droppedOn = event.getStage().hit(nPos.x, nPos.y, true);

        if (droppedOn != null && droppedOn instanceof TownCard && current instanceof TrophyCard) {
            Gdx.app.log(event.getListenerActor().getName(), "dragStop() on " + droppedOn.getName());
            Town droppedOnTown = (Town) droppedOn.getParent();

            if (!droppedOnTown.addUnder((TrophyCard) current)) {
                current.setPosition(startPos.x, startPos.y);
            } else {
                current.clearListeners();
                current.addListener(new ZoomClickHandler());
            }
        }
        current.setTouchable(Touchable.enabled);
    }

    private int getDroppedOnTownActor(float x) {
        /*if (x > 200 && x < 260) return 0;
        else if (x > 270 && x < 330) return 1;
        else if (x > 340 && x < 400) return 2;
        else if (x > 410 && x < 470) return 3;
        else if (x > 480 && x < 540) return 4;
        else if (x > 550 && x < 610) return 5;
        else if (x > 620 && x < 680) return 6;
        else if (x > 690 && x < 750) return 7;*/

        return (int) ((x - 200) / 70);
    }

    //TODO: дроп хантеров и их размещение
    //TODO: очередность и доступность клика андер-карт
    // TODO: валидация дропа хантеров по правилам

}
