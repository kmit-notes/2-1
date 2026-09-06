class Cloud extends GameAsset implements Animatable {
    public Cloud(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void render() {
        System.out.println("Rendering Cloud " + name + " at (" + x + "," + y + ")");
    }

    @Override
    public void update() {
        animate();
    }

    @Override
    public void animate() {
        x += 1; // cloud moves slowly horizontally
        System.out.println(name + " cloud moved to (" + x + "," + y + ")");
    }
}