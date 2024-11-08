public class Ex7 {

    public static void main(String[] args) {
        System.out.println("for null: a >>> " + whichBoolean(null));
        System.out.println("for true: b >>> " + whichBoolean(true));
        System.out.println("for false: c >>> " + whichBoolean(false));
    }

    public static String whichBoolean(Boolean type){
        if (type == null) {
            return "a";
        } else if (type) {
            return "b";
        } else {
            return "c";
        }
    }

}
