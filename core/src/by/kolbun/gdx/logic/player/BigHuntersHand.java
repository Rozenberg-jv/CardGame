package by.kolbun.gdx.logic.player;

import by.kolbun.gdx.ResourceLoader;
import by.kolbun.gdx.logic.hunters.BigHunter;
import by.kolbun.gdx.logic.hunters.Hunter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.SnapshotArray;

import static by.kolbun.gdx.logic.player.OwnerType.*;

public class BigHuntersHand extends Group {

    private Array<Vector2> pos = new Array<Vector2>();

    public BigHuntersHand(String _parent) {
        setName("BigHuntersHand");

        BigHunter newHunter;
        TextureRegion texture;
        TextureRegion back;
        OwnerType owner;


        switch (_parent) {
            case "PlayerGreen":
                texture = ResourceLoader.getLoader().bigHuntGreen;
                back = ResourceLoader.getLoader().huntPointGreen;
                owner = GREEN;
                break;
            case "PlayerRed":
                texture = ResourceLoader.getLoader().bigHuntRed;
                back = ResourceLoader.getLoader().huntPointRed;
                owner = RED;
                break;
            case "PlayerYellow":
                texture = ResourceLoader.getLoader().bigHuntYellow;
                back = ResourceLoader.getLoader().huntPointYellow;
                owner = YELLOW;
                break;
            case "PlayerBlue":
                texture = ResourceLoader.getLoader().bigHuntBlue;
                back = ResourceLoader.getLoader().huntPointBlue;
                owner = BLUE;
                break;
            default:
                texture = ResourceLoader.getLoader().bigHuntGreen;
                back = ResourceLoader.getLoader().huntPointGreen;
                owner = GREEN;
                break;
        }


        for (int i = 0; i < 6; i++) {
            newHunter = new BigHunter(texture, back, owner);
//            newHunter.setPosition(i * 50 + 20, 420);
            newHunter.setName("bigHunter#" + i);
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
                    i % 2 == 0 ? 30 : 35,
                    420 - 25 * i
            ));
        }
    }

}
