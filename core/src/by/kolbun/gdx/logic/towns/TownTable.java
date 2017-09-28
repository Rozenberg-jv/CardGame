package by.kolbun.gdx.logic.towns;

import by.kolbun.gdx.logic.cards.TrophyCard;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;

public class TownTable extends Group {

//    private final int[] xCoords = {};

    public TownTable() {
        this.setName(">TownTable");
        initTownTable();
    }

    private Town tmpTown;
    private void initTownTable() {
        for (TownType type : TownType.values()) {
            tmpTown = new Town(type, type.getX(), type.getTexture());
            this.addActor(tmpTown);
        }
    }

    public void putCard(TrophyCard _card, Town _town) {
        if (_card.getTownType() == _town.getType()) {
            Gdx.app.log(getName(), "putCard()");

            _town.addUnder(_card);
        }
    }

    //gs

}
