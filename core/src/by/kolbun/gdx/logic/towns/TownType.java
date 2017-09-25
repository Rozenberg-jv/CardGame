package by.kolbun.gdx.logic.towns;

import by.kolbun.gdx.ResourceLoader;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public enum TownType {
    NUL(ResourceLoader.getLoader()) {
        @Override
        public TextureRegion getTexture() {
            return ress.town0;
        }

        @Override
        public int getX() {
            return 200;
        }
    },
    CAP(ResourceLoader.getLoader()) {
        @Override
        public TextureRegion getTexture() {
            return ress.townC;
        }

        @Override
        public int getX() {
            return 270;
        }
    },
    ONE(ResourceLoader.getLoader()) {
        @Override
        public TextureRegion getTexture() {
            return ress.town1;
        }

        @Override
        public int getX() {
            return 340;
        }
    },
    TWO(ResourceLoader.getLoader()) {
        @Override
        public TextureRegion getTexture() {
            return ress.town2;
        }

        @Override
        public int getX() {
            return 410;
        }
    },
    THR(ResourceLoader.getLoader()) {
        @Override
        public TextureRegion getTexture() {
            return ress.town3;
        }

        @Override
        public int getX() {
            return 480;
        }
    },
    FOR(ResourceLoader.getLoader()) {
        @Override
        public TextureRegion getTexture() {
            return ress.town4;
        }

        @Override
        public int getX() {
            return 550;
        }
    },
    FIV(ResourceLoader.getLoader()) {
        @Override
        public TextureRegion getTexture() {
            return ress.town5;
        }

        @Override
        public int getX() {
            return 620;
        }
    },
    SIX(ResourceLoader.getLoader()) {
        @Override
        public TextureRegion getTexture() {
            return ress.town6;
        }

        @Override
        public int getX() {
            return 690;
        }
    };


    TownType(ResourceLoader _ress) {
        ress = _ress;
    }

    transient ResourceLoader ress;

    public abstract TextureRegion getTexture();
    public abstract int getX();
}
