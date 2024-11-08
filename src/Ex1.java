import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex1 {

    public static void main(String[] args) {
        List<String> stringList = List.of(
                "teste damage teste", // middle of a phrase
                " minor damages ", // between spaces
                "heavy damage",
                "no damage");

        stringList.forEach(text ->
                System.out.println("Text: \"" + text + "\", Damage Detected: " + isDamage(text))
        );
    }
    private static final String regex = "(?<!no )damage";
    //just to do not compile always
    private static final Pattern pattern = Pattern.compile(regex);

    public static boolean isDamage(String text) {
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }


}
