package pt.upskills.projeto.objects.enemies;

import pt.upskills.projeto.game.Engine;
import pt.upskills.projeto.game.LevelChange;
import pt.upskills.projeto.rogue.utils.Position;

public class Chest extends Enemy {

    public Chest(Position position) {
        super(position, 1, 0);
    }

    @Override
    public String getName() {
        if(LevelChange.getLevel() == 0){return "Chest0";
        } else if(LevelChange.getLevel() == 2){return "Chest2";
        } else{ return "Chest";
        }
    }

    public void movement() {
        enemies.put(getPosition(), this);
    }
}
