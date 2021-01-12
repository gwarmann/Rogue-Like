package pt.upskills.projeto.objects.artifacts;

import pt.upskills.projeto.rogue.utils.Position;

public class Hammer  extends Artifact {

    public Hammer(Position position) { super(position); }

    @Override
    public String getName() {
        return "Hammer";
    }

    @Override
    public String toString() { return "Hammer"; }

}

