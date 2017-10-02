package by.kolbun.gdx.logic.towns;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class UnderTable extends Group {

    public UnderTable() {
        this.setName(">UnderTable");

    }

    public void addActor(Actor actor, float _x, float _y) {
        actor.setPosition(_x, _y + 20 * (this.getChildren().size + 1));
        super.addActorAt(0, actor);
    }


}
