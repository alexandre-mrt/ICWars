package ch.epfl.cs107.play.game.icwars.actor.unit;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.icwars.actor.unit.action.ActionAttack;
import ch.epfl.cs107.play.game.icwars.actor.unit.action.ActionWait;
import ch.epfl.cs107.play.game.icwars.area.ICWarsArea;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.Vector;

public class Soldat extends Unit {

    /**
     * @param area     (Area) : The Area to which belongs this unit;
     * @param faction  (Faction) : Unit's faction;
     * @param position (DiscreteCoordinates) : Unit's coordinates;
     */
    public Soldat(Area area, Faction faction, DiscreteCoordinates position) {
        super(area, faction, position, 5, 2, "Soldat", 2, 0);
        setNode(radius, position.x, position.y, area);
        sprite = new Sprite((faction == Faction.ALLIED) ? "icwars/friendlySoldier" : "icwars/enemySoldier", 1.5f, 1.5f, this, null, new Vector(-0.25f, -0.25f));
        possibleAction.add(new ActionAttack(this, (ICWarsArea) area));
        possibleAction.add(new ActionWait(this, (ICWarsArea) area));
    }

    /**
     * Changes Unit's sprite : Useful when cities change faction.
     */
    public void changeSprite(){
        sprite = new Sprite((getFaction() == Faction.ALLIED) ? "icwars/friendlySoldier" : "icwars/enemySoldier", 1.5f, 1.5f, this, null, new Vector(-0.25f, -0.25f));
    }

}
