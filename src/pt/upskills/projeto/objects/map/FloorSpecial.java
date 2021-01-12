package pt.upskills.projeto.objects.map;

import pt.upskills.projeto.game.LevelChange;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class FloorSpecial extends Map {

    public FloorSpecial(Position position) {
        super(position);
    }

    @Override
    public String getName() {
        if(LevelChange.getLevel() == 0){return "FloorSpecial0";
        } else if(LevelChange.getLevel() == 2){return "FloorSpecial2";
        } else{ return "FloorSpecial";
        }
    }

}

