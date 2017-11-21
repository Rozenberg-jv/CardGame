package by.kolbun.gdx.logic.player;

import by.kolbun.gdx.ResourceLoader;
import by.kolbun.gdx.logic.hunters.SmallHunter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.SnapshotArray;

import static by.kolbun.gdx.logic.player.OwnerType.*;

public class SmallHuntersHand extends Group {

    private Array<Vector2> pos = new Array<Vector2>();

    public SmallHuntersHand(String _parent) {
        setName(">SmallHuntersHand");

        TextureRegion texture;
        TextureRegion back;
        SmallHunter newHunter;
        OwnerType owner;

        switch (_parent) {
            case "PlayerGreen":
                texture = ResourceLoader.getLoader().smallHuntGreen;
                back = ResourceLoader.getLoader().huntPointGreen;
                owner = GREEN;
                break;
            case "PlayerRed":
                texture = ResourceLoader.getLoader().smallHuntRed;
                back = ResourceLoader.getLoader().huntPointRed;
                owner = RED;
                break;
            case "PlayerYellow":
                texture = ResourceLoader.getLoader().smallHuntYellow;
                back = ResourceLoader.getLoader().huntPointYellow;
                owner = YELLOW;
                break;
            case "PlayerBlue":
                texture = ResourceLoader.getLoader().smallHuntBlue;
                back = ResourceLoader.getLoader().huntPointBlue;
                owner = BLUE;
                break;
            default:
                texture = ResourceLoader.getLoader().smallHuntGreen;
                back = ResourceLoader.getLoader().huntPointGreen;
                owner = GREEN;
                break;
        }

        for (int i = 0; i < 3; i++) {
            newHunter = new SmallHunter(texture, back, owner);
            newHunter.setName("smallHunter#" + i);
            this.addActor(newHunter);
        }
    }

    @Override
    protected void childrenChanged() {
        calculatePos();
        SnapshotArray<Actor> children = this.getChildren();
        Actor actor;
        for (int i = 0; i < children.size; i++) {
            actor = children.get(i);
            actor.setPosition(pos.get(i).x, pos.get(i).y);
        }
    }

    private void calculatePos() {
        pos.clear();

        for (int i = 0; i < this.getChildren().size; i++) {
            pos.add(new Vector2(
                    i % 2 == 0 ? 80 : 85,
                    420 - 20 * i
            ));
        }
    }

}
