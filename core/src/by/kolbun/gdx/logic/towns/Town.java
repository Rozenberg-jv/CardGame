package by.kolbun.gdx.logic.towns;

import by.kolbun.gdx.World;
import by.kolbun.gdx.logic.cards.TownCard;
import by.kolbun.gdx.logic.cards.TrophyCard;
import by.kolbun.gdx.logic.hunters.Hunter;
import by.kolbun.gdx.logic.player.OwnerType;
import by.kolbun.gdx.logic.player.Player;
import by.kolbun.gdx.logic.util.ZoomClickHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.Map;


/**
 * Town - группа, первой добавляется карта TownCard, рисуется всегда последней,
 * добавляются карты TrophyCard, пример см. CardsHand,
 * реализовать х-координату, зависит от положения Town в массиве TownTable
 */

public class Town extends Group {
    private TownType type;

    private UnderTable under;
    private HuntersTable hunters;
    private TownCard town;

    private int xPos;

    private Player currentPlayer;

    Town(TownType _type, int _x) {
        type = _type;
        this.setName(">Town");

        xPos = _x;

        hunters = new HuntersTable();
        town = new TownCard(_type.getTexture(), _type.getX());
        under = new UnderTable();

        this.addActor(under);
        this.addActor(town);
        this.addActor(hunters);

    }

    public boolean addUnder(TrophyCard _card) {
        if (_card.getTownType() != this.getType()) {
            Gdx.app.log(this.getName(), "Попытка сброса карты под несоответствующий тип города.");
            return false;
        }

        under.addActor(_card, xPos, town.getY());
        _card.clearListeners();
        _card.addListener(new ZoomClickHandler());
        return true;
    }

    // TODO: 02.10.2017 добавлять хантеров столько, чтобы перекрыть чужих, если это возможно

    /**
     * переносим хантера
     * если этот цвет макс - значит автодобавка 1
     * если нет
     * считаем цвет, который максимальный
     * считаем сколько надо еще до преимущества (макс.друг.цвета - сколько уже есть этого цвета + 1)
     */
    public boolean addHunter(Hunter _hunter) {
        int range = isHunterAddValid();
        if (range <= 0) {
            Gdx.app.log(this.getName(), "не хватает хантеров");
            return false;
        } else {
            hunters.addMultipleActors(range, _hunter);
            return true;
        }


//        hunters.addActor(_hunter);
//        _hunter.clearListeners();
//        _hunter.addListener(new RecallHunterFromTownHandler());

    }

    // TODO: 02.10.2017 очищать листнер хантеров в городе при переходе хода
    // TODO: 03.10.2017 хэндлер возврата хантеров по клику
    // TODO: 03.10.2017 HUD хэндлер, кнопка перехода хода, меню, ...

    // TODO: 03.10.2017 почему проверка в Town???
    private int isHunterAddValid() {
        currentPlayer = World.getInstance().getCurrentPlayer();
        Map<OwnerType, Integer> mp = hunters.huntersCountByOwner();

        int max1 = -1;
        OwnerType maxOwner1 = currentPlayer.getOwner();
        for (Map.Entry<OwnerType, Integer> ent : mp.entrySet()) {
//            if (ent.getKey() == currentPlayer.getOwner()) continue;
            if (ent.getValue() > max1) {
                max1 = ent.getValue();
                maxOwner1 = ent.getKey();
            }
        }

        if (maxOwner1 == currentPlayer.getOwner()) return 1;
        if (max1 + 1 - mp.get(currentPlayer.getOwner()) > currentPlayer.getHand().getFreeHuntersCount()) return -1;
        else return (max1 + 1 - mp.get(currentPlayer.getOwner()));
    }

    public void clear() {
        hunters.clear();
        under.clear();
    }


    //gs

    public TownType getType() {
        return type;
    }

    public int getXPos() {
        return xPos;
    }

}
