package pt.upskills.projeto.objects.enemies;

import pt.upskills.projeto.game.LevelChange;
import pt.upskills.projeto.rogue.utils.Position;

public class Skeleton extends Enemy {

    public Skeleton(Position position) {
        super(position, 8, 2);
    }

    @Override
    public String getName() {
        if(LevelChange.getLevel() == 0){return "Skeleton0";
        } else if(LevelChange.getLevel() == 2){return "Skeleton2";
        } else{ return "Skeleton";
        }
    }


}
