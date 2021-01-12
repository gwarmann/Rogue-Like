package pt.upskills.projeto.objects.artifacts;

import pt.upskills.projeto.rogue.utils.Position;

public class GoodMeat extends Artifact {

    public GoodMeat(Position position) { super(position); }

    @Override
    public String getName() {
        return "GoodMeat";
    }

    @Override
    public String toString() { return "GoodMeat"; }
}
