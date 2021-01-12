package pt.upskills.projeto.objects.artifacts;

import pt.upskills.projeto.rogue.utils.Position;

public class SkullKey extends Artifact {

    public SkullKey(Position position) { super(position); }

    @Override
    public String getName() {
        return "SkullKey";
    }

    @Override
    public String toString() { return "SkullKey"; }
}
