package by.kolbun.gdx.logic.hunters;

import by.kolbun.gdx.World;
import by.kolbun.gdx.logic.player.OwnerType;
import by.kolbun.gdx.logic.player.Player;
import by.kolbun.gdx.logic.util.DragHandler;
import by.kolbun.gdx.logic.GameActor;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Comparator;

public class Hunter extends GameActor {

    private TextureRegion front;
    private TextureRegion back;
    private OwnerType owner;

    public Hunter(TextureRegion _texture, TextureRegion _back, OwnerType _owner) {
        super(_texture);
        front = _texture;
        back = _back;
        owner = _owner;
        this.addListener(new DragHandler());
    }


    public void toggleTexture() {
        if (texture == front) {
            texture = back;
        } else {
            texture = front;
        }
    }


    //gs


    public OwnerType getOwner() {
        return owner;
    }

    public void sendBackToPlayer() {
        texture = front;

        Player playerTo = World.getInstance().getPlayerByOwner(owner);

        playerTo.getHand().getBigHunters().addActor(this);
    }

    /*public static final Comparator<Actor> COMPARE_BY_OWNER = new Comparator<Actor>() {
        private int getOwnersNum(OwnerType owner) {
            switch (owner) {
                case GREEN:
                    return 1;
                case RED:
                    return 2;
                case YELLOW:
                    return 3;
                case BLUE:
                    return 4;
                default:
                    return 0;
            }
        }

        @Override
        public int compare(Actor o1, Actor o2) {
//            if (getOwnersNum(o1.getOwner()) == 0) return 0;
//            return ((Hunter) o1).getOwner().toString() - ((Hunter) o2).getOwner().toString();
            return ((Hunter) o1).getOwner().toString().compareTo(((Hunter) o2).getOwner().toString());
        }
    };*/
}
