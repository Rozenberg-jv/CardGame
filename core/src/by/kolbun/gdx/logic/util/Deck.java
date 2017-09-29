package by.kolbun.gdx.logic.util;

import by.kolbun.gdx.ResourceLoader;
import by.kolbun.gdx.logic.cards.TrophyCard;
import by.kolbun.gdx.logic.towns.TownType;
import com.badlogic.gdx.utils.Array;

import static by.kolbun.gdx.logic.cards.TrophyType.*;
import static by.kolbun.gdx.logic.towns.TownType.*;

public class Deck {
    private ResourceLoader ress;

    private Array<TrophyCard> deck;

    public Deck(Deck origin) {
        ress = ResourceLoader.getLoader();
        deck = new Array<TrophyCard>();
        deck.addAll(origin.getDeck());
    }

    public Deck(int _playersCount) {
        ress = ResourceLoader.getLoader();
        deck = new Array<TrophyCard>();

        switch (_playersCount) {
            case 4:
                initializeDeck4();
                break;
            default:
                break;
        }
    }

    private void initializeDeck4() {
        deck.add(new TrophyCard(MONEY0, NUL, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(MONEY1, NUL, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(MONEY2, NUL, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(MONEY3, NUL, ress.priceCardTest, ress.cardBack));

        deck.add(new TrophyCard(MONEY3, ONE, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(MONEY3, ONE, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(PASS1, ONE, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(PASS2, ONE, ress.priceCardTest, ress.cardBack));

        deck.add(new TrophyCard(MONEY1, TWO, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(MONEY2, TWO, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(MONEY3, TWO, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(MONEY4, TWO, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(KILL, TWO, ress.priceCardTest, ress.cardBack));

        deck.add(new TrophyCard(MONEY2, THR, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(MONEY3, THR, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(KILL, THR, ress.priceCardTest, ress.cardBack));

        deck.add(new TrophyCard(MONEY1, FOR, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(MONEY2, FOR, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(MONEY3, FOR, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(DENY, FOR, ress.priceCardTest, ress.cardBack));

        deck.add(new TrophyCard(MONEY1, FIV, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(MONEY2, FIV, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(MONEY3, FIV, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(PASS1, FIV, ress.priceCardTest, ress.cardBack));

        deck.add(new TrophyCard(MONEY3, SIX, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(PASS2, SIX, ress.priceCardTest, ress.cardBack));
        deck.add(new TrophyCard(KILL, SIX, ress.priceCardTest, ress.cardBack));
    }

    public void shuffle() {
        deck.shuffle();
    }


    //gs

    public TrophyCard getRandomByTown(TownType _town) {
        TrophyCard chosen = null;
        for (TrophyCard card : deck) {
            if (card.getTownType() == _town) {
                chosen = card;
                break;
            }
        }
        deck.removeValue(chosen, true);
        return chosen;
    }

    public Array<TrophyCard> getDeck() {
        return deck;
    }

    public TrophyCard popCard() {
        return deck.pop();
    }
}
