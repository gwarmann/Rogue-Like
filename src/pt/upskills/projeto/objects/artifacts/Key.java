package pt.upskills.projeto.objects.artifacts;


import pt.upskills.projeto.rogue.utils.Position;

public class Key extends Artifact {

    public Key(Position position) { super(position); }

    @Override
    public String getName() {
        return "Key";
    }

    @Override
    public String toString() { return "Key"; }
}
