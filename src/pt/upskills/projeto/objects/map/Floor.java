package pt.upskills.projeto.objects.map;

import pt.upskills.projeto.game.LevelChange;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class Floor extends Map {

    public Floor(Position position) {
        super(position);
    }

    @Override
    public String getName() {
        if(LevelChange.getLevel() == 0){return "Floor0";
        } else if(LevelChange.getLevel() == 2){return "Floor2";
        } else if(LevelChange.getLevel() == 3){return "Floor3";
        } else{ return "Floor";
        }
    }
}
