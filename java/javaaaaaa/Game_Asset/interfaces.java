// Movable interface
interface Movable {
    void move(int dx, int dy);  // move by dx, dy
}

// Animatable interface
interface Animatable {
    void animate(); // e.g., spinning, glowing
}

// Interactable interface
interface Interactable {
    void interact(GameAsset other);
}