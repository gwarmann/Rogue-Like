package pt.upskills.projeto.objects.enemies;

import pt.upskills.projeto.game.Engine;
import pt.upskills.projeto.game.LevelChange;
import pt.upskills.projeto.rogue.utils.Position;

import java.util.Random;

public class Crab extends Enemy {

    public Crab(Position position) {
        super(position, 12, 1);
    }

    public void passive() {
        Random random = new Random();
        switch (random.nextInt(2)) {
            case 0:
                if (Engine.solids.containsKey(new Position(getPosition().getX() , getPosition().getY() + 1))) {
                } else {
                    setPosition(new Position(getPosition().getX(), getPosition().getY() + 1));}
                break;
            case 1:
                if (Engine.solids.containsKey(new Position(getPosition().getX(), getPosition().getY() - 1))) {
                } else {
                    setPosition(new Position(getPosition().getX(), getPosition().getY() - 1));}
                break;
        }
    }


    @Override
    public String getName() {
        if(LevelChange.getLevel() == 0){return "Crab0";
        } else if(LevelChange.getLevel() == 2){return "Crab2";
        } else{ return "Crab";
        }
    }

}

