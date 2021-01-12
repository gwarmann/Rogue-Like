package pt.upskills.projeto.objects.map;

import pt.upskills.projeto.game.LevelChange;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class BookShelves extends Map {

    public BookShelves(Position position) {
        super(position);
    }

    @Override
    public String getName() {
        if(LevelChange.getLevel() == 0){return "BookShelves0";
        } else if(LevelChange.getLevel() == 2){return "BookShelves2";
        } else{ return "BookShelves";
        }
    }


}
