package pt.upskills.projeto.objects.map;

import pt.upskills.projeto.game.LevelChange;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class WallDecorated extends Map {

    public WallDecorated(Position position) {
        super(position);
    }

    @Override
    public String getName() {
        if(LevelChange.getLevel() == 0){return "WallDecorated0";
        } else if(LevelChange.getLevel() == 2){return "WallDecorated2";
        } else{ return "WallDecorated";
        }
    }
}

