package pt.upskills.projeto.objects.map;

import pt.upskills.projeto.game.Engine;
import pt.upskills.projeto.game.LevelChange;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.artifacts.Artifact;
import pt.upskills.projeto.objects.enemies.Enemy;
import pt.upskills.projeto.objects.enemies.Trap;
import pt.upskills.projeto.rogue.utils.Position;

public class Grass extends Map {

    public Grass(Position position) {
        super(position);
    }

    @Override
    public String getName() {
        if(LevelChange.getLevel() == 0){return "Grass0";
        } else if(LevelChange.getLevel() == 2){return "Grass2";
        } else{ return "Grass";
        }
    }

    public static void trampled(){
        for (ImageTile grass : Engine.tiles) {
            if (grass instanceof Grass) {
                if (Hero.getNewPosition().getX() == grass.getPosition().getX()
                        && Hero.getNewPosition().getY() == grass.getPosition().getY()) {
                    Engine.tiles.remove(grass);
                    Engine.gui.removeImage(grass);
                    Engine.tiles.add(new GrassTrampled(grass.getPosition()));
                    Engine.gui.addImage(new GrassTrampled(grass.getPosition()));
                    break;
                }
            }
        }
    }
}
