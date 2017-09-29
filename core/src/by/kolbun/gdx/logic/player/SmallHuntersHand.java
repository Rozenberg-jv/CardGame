package by.kolbun.gdx.logic.player;

import by.kolbun.gdx.ResourceLoader;
import by.kolbun.gdx.logic.hunters.SmallHunter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class SmallHuntersHand extends Group {

    public SmallHuntersHand(String _parent) {
        this.setName(">SmallHuntersHand");

        TextureRegion texture;
        SmallHunter newHunter;

        switch (_parent) {
            case "PlayerGreen":
                texture = ResourceLoader.getLoader().bigHuntGreen;
                break;
            case "PlayerRed":
                texture = ResourceLoader.getLoader().bigHuntRed;
                break;
            case "PlayerYellow":
                texture = ResourceLoader.getLoader().bigHuntYellow;
                break;
            case "PlayerBlue":
                texture = ResourceLoader.getLoader().bigHuntBlue;
                break;
            default:
                texture = ResourceLoader.getLoader().bigHuntGreen;
                break;
        }

        for (int i = 0; i < 3; i++) {
            newHunter = new SmallHunter(texture);
            newHunter.setPosition(i * 40 + 40, 380);
            newHunter.setName("smallHunter#" + i);
            this.addActor(newHunter);
        }
    }

}
