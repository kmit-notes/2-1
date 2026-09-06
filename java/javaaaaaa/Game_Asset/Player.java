class Player extends GameAsset implements Movable, Animatable, Interactable {

    public Player(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void render() {
        System.out.println("Rendering Player " + name + " at (" + x + "," + y + ")");
    }

    @Override
    public void update() {
        animate(); // player can animate each tick
    }

    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
        System.out.println(name + " moved to (" + x + "," + y + ")");
    }

    @Override
    public void animate() {
        System.out.println(name + " is animating (running/walking).");
    }

    @Override
    public void interact(GameAsset other) {
        if (other instanceof Coin) {
            Coin c = (Coin) other;
            System.out.println(name + " collected coin " + c.name);
            c.collected = true; // Coin disappears
        } else if (other instanceof Wall) {
            System.out.println(name + " hit a wall at (" + other.getX() + "," + other.getY() + ")");
            // Optionally block movement
        }
    }
}