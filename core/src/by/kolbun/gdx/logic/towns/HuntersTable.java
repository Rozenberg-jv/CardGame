package by.kolbun.gdx.logic.towns;

import by.kolbun.gdx.World;
import by.kolbun.gdx.logic.hunters.Hunter;
import by.kolbun.gdx.logic.player.BigHuntersHand;
import by.kolbun.gdx.logic.player.OwnerType;
import by.kolbun.gdx.logic.player.SmallHuntersHand;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.SnapshotArray;

import java.util.HashMap;
import java.util.Map;

import static by.kolbun.gdx.logic.player.OwnerType.*;

public class HuntersTable extends Group {

    private int count;
    private final int radius = 20;
    private Array<Vector2> pos;
    private double deltaRad;

    public HuntersTable() {
        this.setName(">HuntersTable");
        count = 0;
    }

    @Override
    public void addActor(Actor _actor) {
        super.addActor(_actor);
        sortChildren();

        ((Hunter) _actor).toggleTexture();
        _actor.clearListeners();
        _actor.setTouchable(Touchable.disabled);
        _actor.setSize(10, 10);

        count++;
        pos = calculatePos();

        for (int i = 0; i < this.getChildren().size; i++) {
            this.getChildren().get(i).setPosition(pos.get(i).x, pos.get(i).y);
        }
    }

    private void sortChildren() {
        SnapshotArray<Actor> a = this.getChildren();
        for (int i = a.size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (((Hunter) a.get(j)).getOwner().ordinal() > ((Hunter) a.get(j + 1)).getOwner().ordinal()) {
                    this.swapActor(j, j + 1);
                }
            }
        }
    }

    void addMultipleActors(int range, Hunter hunter) {
        this.addActor(hunter);
        BigHuntersHand bigHuntersHand;
        SmallHuntersHand smallHuntersHand;

        for (int i = 0; i < range - 1; i++) {
            bigHuntersHand = World.getInstance().getCurrentPlayer().getHand().getBigHunters();
            smallHuntersHand = World.getInstance().getCurrentPlayer().getHand().getSmallHunters();
            if (bigHuntersHand.getChildren().size != 0) {
                addActor(bigHuntersHand.getChildren().get(0));
            } else if (smallHuntersHand.getChildren().size != 0) {
                addActor(smallHuntersHand.getChildren().get(0));
            }
        }
    }

    // TODO: 02.10.2017 по центру поинтов сделать круг, цвет которого отражает хозяина города

    private Array<Vector2> calculatePos() {
        pos = new Array<Vector2>();
        deltaRad = (2 * Math.PI) / count;
        for (int i = 0; i < count; i++) {
            pos.add(new Vector2(
                    (float) Math.cos(deltaRad * i + Math.PI / 2) * radius + ((Town) getParent()).getXPos() + 25
                    , (float) Math.sin(deltaRad * i + Math.PI / 2) * radius + 80
            ));
        }

        return pos;
    }

    public Map<OwnerType, Integer> huntersCountByOwner() {
        OwnerType tmpOwner;
        Map<OwnerType, Integer> map = new HashMap<>();
        map.put(GREEN, 0);
        map.put(RED, 0);
        map.put(YELLOW, 0);
        map.put(BLUE, 0);
        for (Actor hnt : this.getChildren()) {
            tmpOwner = ((Hunter) hnt).getOwner();
            switch (tmpOwner) {
                case GREEN:
                    map.put(tmpOwner, map.get(tmpOwner) + 1);
                    break;
                case RED:
                    map.put(tmpOwner, map.get(tmpOwner) + 1);
                    break;
                case YELLOW:
                    map.put(tmpOwner, map.get(tmpOwner) + 1);
                    break;
                case BLUE:
                    map.put(tmpOwner, map.get(tmpOwner) + 1);
                    break;
            }
        }

        return map;
    }

    public void refresh() {
        count = 0;
    }


    public Town getTown() {
        return (Town) this.getParent();
    }
}
