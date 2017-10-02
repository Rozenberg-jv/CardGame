package by.kolbun.gdx.logic.towns;

import by.kolbun.gdx.logic.hunters.Hunter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Array;

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

        ((Hunter) _actor).toggleTexture();
        _actor.setSize(10, 10);

        count++;
        pos = calculatePos();

        for (int i = 0; i < this.getChildren().size; i++) {
            this.getChildren().get(i).setPosition(pos.get(i).x, pos.get(i).y);
        }
    }

    private Array<Vector2> calculatePos() {
        pos = new Array<Vector2>();
        deltaRad = (2 * Math.PI) / count;
        for (int i = 0; i < count; i++) {
            pos.add(new Vector2((float) Math.cos(deltaRad * i + Math.PI / 2) * radius + ((Town) getParent()).getXPos() + 25
                    , (float) Math.sin(deltaRad * i + Math.PI / 2) * radius + 80));
        }

        return pos;
    }

    public void refresh() {
        count = 0;
    }
}
