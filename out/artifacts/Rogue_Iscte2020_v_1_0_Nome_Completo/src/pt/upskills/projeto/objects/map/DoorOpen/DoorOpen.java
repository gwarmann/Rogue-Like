package pt.upskills.projeto.objects.map.DoorOpen;

import pt.upskills.projeto.objects.map.Map;
import pt.upskills.projeto.rogue.utils.Position;

public abstract class DoorOpen extends Map {

    public DoorOpen(Position position) {
        super(position);
    }

    @Override
    public String getName() {
        return "DoorOpen";
    }

}
