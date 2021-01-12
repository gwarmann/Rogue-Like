package pt.upskills.projeto.objects.enemies;

import pt.upskills.projeto.game.Engine;
import pt.upskills.projeto.game.LevelChange;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.rogue.utils.Position;

public class Trap extends Enemy {

    public Trap(Position position) {
        super(position, 1, 2);
    }

    @Override
    public String getName(){
        if(LevelChange.getLevel() == 0){return "Trap0";
        } else if(LevelChange.getLevel() == 2){return "Trap2";
        } else{ return "Trap";
        }
    }


    public void movement() {
        if(Hero.getNewPosition().getX() == this.getPosition().getX()
                && Hero.getNewPosition().getY() == this.getPosition().getY()){
            Hero.danoRecebido(this.getDano());
            setHealth(-1);
        }

    }


}
