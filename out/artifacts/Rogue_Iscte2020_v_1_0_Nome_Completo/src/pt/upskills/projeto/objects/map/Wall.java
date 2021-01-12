package pt.upskills.projeto.objects.map;

import pt.upskills.projeto.game.LevelChange;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class Wall extends Map {

    public Wall(Position position) {
        super(position);
    }

    @Override
    public String getName() {
        if(LevelChange.getLevel() == 0){return "Wall0";
        } else if(LevelChange.getLevel() == 2){return "Wall2";
        } else if(LevelChange.getLevel() == 3){return "Wall3";
        } else{ return "Wall";
        }
    }

}
