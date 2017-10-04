package by.kolbun.gdx.logic.towns;

import by.kolbun.gdx.logic.cards.TrophyCard;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.SnapshotArray;

public class TownTable extends Group {

    public TownTable() {
        this.setName(">TownTable");
        initTownTable();
    }

    private void initTownTable() {
        Town tmpTown;
        for (TownType type : TownType.values()) {
            tmpTown = new Town(type, type.getX());
            this.addActor(tmpTown);
        }
    }

    public void putCard(TrophyCard _card, Town _town) {
        if (_card.getTownType() == _town.getType()) {
            Gdx.app.log(getName(), "putCard()");

            _town.addUnder(_card);
        }
    }

    public void resetNewRound() {
        SnapshotArray<Actor> a = this.getChildren();
        for (int i = 0; i < a.size; i++) {
            a.get(i).clear();
            /*if (((Town) a.get(i)).getType() == TownType.CAP) {
                this.swapActor(i, i + 1);
            }*/
        }
    }

    //gs

}
