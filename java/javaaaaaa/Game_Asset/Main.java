import java.util.*;

public class GameSimulation {
    public static void main(String[] args) {
        List<GameAsset> assets = new ArrayList<>();

        Player player = new Player("Hero", 0, 0);
        Coin coin = new Coin("Gold", 10, 5);
        Wall wall = new Wall("Stone", 15, 7);
        Cloud cloud = new Cloud("Fluffy", 3, 2);

        assets.add(player);
        assets.add(coin);
        assets.add(wall);
        assets.add(cloud);

        System.out.println("--- Initial Rendering ---");
        for (GameAsset asset : assets) {
            asset.render();
        }

        System.out.println("\n--- Frame Update ---");
        for (GameAsset asset : assets) {
            asset.update();
        }

        System.out.println("\n--- Simulate Player Movement and Interactions ---");
        player.move(10, 5); // moves to coin
        player.interact(coin); // collects coin
        player.move(5, 2); // moves to wall
        player.interact(wall); // hits wall

        System.out.println("\n--- Final Rendering ---");
        for (GameAsset asset : assets) {
            asset.render();
        }
    }
}