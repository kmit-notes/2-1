class Wall extends GameAsset {
    public Wall(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void render() {
        System.out.println("Rendering Wall " + name + " at (" + x + "," + y + ")");
    }
}