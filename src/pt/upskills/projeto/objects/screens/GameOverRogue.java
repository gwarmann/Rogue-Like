package pt.upskills.projeto.objects.screens;

import pt.upskills.projeto.rogue.utils.Position;

public class GameOverRogue extends Screen {

    public GameOverRogue(Position position) {
        super(position);
    }

    @Override
    public String getName() {
        return "GameOverRogue";
    }

}
