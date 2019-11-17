
/** Game class, this is where the game is run */
public class Main {


    public static void main(String[] args) {
        // Generates all default items
        Item items = new Item();
        Location locations = new Location();

        // TODO: Ask user for name, handle exceptions
        String name = "John";
        Player player = new Player(name);

        println(playerInfoString(player.getHp(), player.name));

        gameLoop(player);

        println("Game Over");
    }

    private static void gameLoop(Player player){
        while (player.getHp() > 0 && Enemy.VeryAngryMan.getHp() > 0){
            // game
            if(player.currentLocation.key == true){
                println("There's a key in the room, pick it up? y/n");
                player.pickup(Location.keyRoom);
            }else if (player.currentLocation.potions > 0) {
                println("There's x5 potions, pick it up? y/n");
                player.pickup(Location.potionRoom);
            }
            Main.println("Press n to move north, press w to move west, s to south and e to east" + " your HP is currently " + player.getHp() + " press P to use potions to regain up to 20HP");
            player.move();
        }
    }

    private static String playerInfoString(int hp, String name) {
        return String.format("Hello %s, you currently have %d HP", name, hp);
    }

    /** Convenience function over std out */
    public static void println(String toPrint){
        System.out.println(toPrint);
    }
}
