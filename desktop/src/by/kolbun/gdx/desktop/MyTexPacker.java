package by.kolbun.gdx.desktop;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class MyTexPacker {
    public static void main(String[] args) {
        TexturePacker.process("desktop/images", "desktop/atlases", "atlas");
    }

}
