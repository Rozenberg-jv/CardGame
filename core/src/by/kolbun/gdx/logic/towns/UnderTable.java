package by.kolbun.gdx.logic.towns;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class UnderTable extends Group {

    public UnderTable() {
        this.setName(">UnderTable");

    }

    @Override
    public void addActor(Actor actor) {
        super.addActorAt(0, actor);
    }

// TODO: 30.09.2017 внести смену листнера в метод addUnder + на этапе инициализации


}
