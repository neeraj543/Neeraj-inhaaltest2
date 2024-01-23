import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class Room
{
    public static final String NORTH = "north";
    public static final String EAST = "east";
    public static final String SOUTH = "south";
    public static final String WEST = "west";
    public static final String UP = "up";
    public static final String DOWN = "down";
    private String description;
//    private HashMap<String, Room> exits;
    private HashMap<Direction, Room> exits;

    private ArrayList<Item> items;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<>();
    }

    public Item getItem(String itemName) {
        Item findItem = null;
        for(Item item : items) {
            if(itemName.equals(item.getName())) {
                findItem = item;
            }
        }
        if(findItem!=null) items.remove(findItem);
        return findItem;
    }

//    public void setExit(String direction, Room room) {
//        exits.put(direction, room);
//    }
    public void setExit(Direction direction, Room room) {
        exits.put(direction, room);
    }


    public Room getExit(String direction) {
        return exits.get(direction);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    public String getExitString() {
        String exitString = "Exits: ";
        for(Direction direction : exits.keySet()) {
            exitString += direction + " ";
        }
        return exitString;
    }

    public String getItemString() {
        String itemString = "";
        for(Item item : items) {
            itemString += System.lineSeparator() + "  " + item.toString();
        }
        return itemString;
    }

    public String getFullDescription() {
        String returnString = getDescription();
        if(!items.isEmpty()) {
            returnString += " which contains" + getItemString();
        }
        returnString += System.lineSeparator() + getExitString();
        return returnString;
    }

    public void setItem(Item item) {
        items.add(item);
    }

}
