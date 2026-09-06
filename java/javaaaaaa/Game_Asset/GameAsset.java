abstract class GameAsset {
    protected String name;
    protected int x, y;  // coordinates

    public GameAsset(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public abstract void render(); // must implement

    public void update() {
        // default: do nothing, can be overridden
    }

    public int getX() { return x; }
    public int getY() { return y; }
}