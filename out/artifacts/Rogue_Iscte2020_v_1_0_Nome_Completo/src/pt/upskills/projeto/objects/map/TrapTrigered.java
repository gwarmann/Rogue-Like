package pt.upskills.projeto.objects.map;

import pt.upskills.projeto.game.LevelChange;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class TrapTrigered extends Map {

    public TrapTrigered(Position position) {
        super(position);
    }

    @Override
    public String getName(){
        if(LevelChange.getLevel() == 0){return "TrapTrigered0";
        } else if(LevelChange.getLevel() == 2){return "TrapTrigered2";
        } else{ return "TrapTrigered";
        }
    }

}

