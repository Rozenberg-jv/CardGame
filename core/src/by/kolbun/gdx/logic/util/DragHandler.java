package by.kolbun.gdx.logic.util;

import by.kolbun.gdx.logic.cards.TownCard;
import by.kolbun.gdx.logic.cards.TrophyCard;
import by.kolbun.gdx.logic.hunters.Hunter;
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
        current.toFront();
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

        if (droppedOn instanceof TownCard) {
            if (current instanceof TrophyCard) {
                dropTrophy();
            } else if (current instanceof Hunter) {
                dropHunter();
            }
        } else {
            current.setPosition(startPos.x, startPos.y);
        }

        current.setTouchable(Touchable.enabled);
    }

    private void dropTrophy() {
        Gdx.app.log(current.getName(), "dragStop() on " + droppedOn.getName());

        if (((Town) droppedOn.getParent()).addUnder((TrophyCard) current)) {

        } else {
            current.setPosition(startPos.x, startPos.y);
        }
    }

    private void dropHunter() {
        Gdx.app.log(current.getName(), "dragStop() on " + droppedOn.getName());

        ((Town) droppedOn.getParent()).addHunter((Hunter) current);
    }

    //TODO: дроп хантеров и их размещение
    //очередность и доступность клика андер-карт
    // TODO: валидация дропа хантеров по правилам

}
