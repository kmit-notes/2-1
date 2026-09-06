class Coin extends GameAsset implements Animatable, Interactable {
    boolean collected = false;

    public Coin(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void render() {
        if (!collected)
            System.out.println("Rendering Coin " + name + " at (" + x + "," + y + ")");
    }

    @Override
    public void update() {
        if (!collected)
            animate();
    }

    @Override
    public void animate() {
        System.out.println(name + " is spinning!");
    }

    @Override
    public void interact(GameAsset other) {
        // Interaction handled by player
    }
}