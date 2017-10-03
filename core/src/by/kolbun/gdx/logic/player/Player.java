package by.kolbun.gdx.logic.player;

import com.badlogic.gdx.scenes.scene2d.Group;

public class Player extends Group {

    private boolean isHuman;
    private Hand hand;
    private OwnerType owner;

    public Player(boolean isHuman, String _name, OwnerType _owner) {
        this.isHuman = isHuman;
        this.setName(_name);
        owner = _owner;
        this.hand = new Hand(_name);

        this.addActor(hand);
    }

    //gs

    public boolean isHuman() {
        return isHuman;
    }

    public Hand getHand() {
        return hand;
    }

    public OwnerType getOwner() {
        return owner;
    }
}
