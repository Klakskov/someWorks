public class Clothing extends Product {
    private String material;
    private int size;

    public Clothing(String name, String desc, double price, String material, int size) {
        super(name, desc, price);
        this.material = material;
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + " _ " + this.material + " _ " + this.size;
    }
}
