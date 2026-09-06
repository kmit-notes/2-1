class A {
    public static A a = null; // Singleton instance
    public static A a1 = null;
    static int counter = 0;

    private A() {
        System.out.println("Constructor called");
    }

    public static A getInstance() {
        if (counter < 2) {
            if (a == null) {
                a = new A();
                counter++;
                return a;
            } else if (a1 == null) {
                a1 = new A();
                counter++;
                return a1;
            }
        }
        return a;
    }