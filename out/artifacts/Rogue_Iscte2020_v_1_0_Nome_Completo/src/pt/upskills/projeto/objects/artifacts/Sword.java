package pt.upskills.projeto.objects.artifacts;

import pt.upskills.projeto.rogue.utils.Position;

public class Sword  extends Artifact {

    public Sword(Position position) { super(position); }

    @Override
    public String getName() {
        return "Sword";
    }

    @Override
    public String toString() { return "Sword"; }

}

