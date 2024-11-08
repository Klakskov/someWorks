public class Ex4 {

    public static void main(String[] args) {

        Clothing ex4 = new Clothing("testsName", "testDesc", 15.00, "testMaterial", 15);
        System.out.println(ex4.toString());
    }

    public static class Clothing extends Product {
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

    public static class Product {
        String name;
        String description;
        double price;

        public Product(String name, String desc, double price) {
            this.name = name;
            this.description = desc;
            this.price = price;
        }

        public final double getPriceWithTax() {
            return price * 1.19;
        }

        public String toString() {
            return name + " _ " + description + " _ " + price + " EUR";
        }
    }

}
