package by.kolbun.gdx.logic.player;

import by.kolbun.gdx.ResourceLoader;
import by.kolbun.gdx.logic.hunters.SmallHunter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;

import static by.kolbun.gdx.logic.player.OwnerType.*;

public class SmallHuntersHand extends Group {

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
            newHunter.setPosition(i * 40 + 40, 380);
            newHunter.setName("smallHunter#" + i);
            this.addActor(newHunter);
        }
    }

}
