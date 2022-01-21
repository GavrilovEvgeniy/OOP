import java.util.ArrayList;
import java.util.LinkedList;

public class UseLists {

    public static void setCities() {
        LinkedList<String> cities = new LinkedList<String>();

        cities.add("Warsaw");
        cities.add("London");
        cities.add("Moscow");
        cities.add(0, "Paris");
        cities.add(0, "Chicago");
        cities.remove("London");
        cities.addFirst("Amsterdam");
        cities.addLast("Zurich");

        for (String city : cities) {
            System.out.print(city + " ");
        }
        System.out.println();

        System.out.println(cities.lastIndexOf("Warsaw"));
        System.out.println(cities.contains("London"));
        System.out.println(cities.size());
        System.out.println(cities.peekFirst());
        System.out.println(cities.peekLast());
        System.out.println();
    }

    public static void setWords() {
        ArrayList<String> words = new ArrayList<>();
        words.add("talks");
        words.add("walks");
        words.add(0, "money");
        words.add(2, "bullshit");
        words.add("big");
        words.remove(4);
        words.set(0, "Money");

        for (String word : words) {
            System.out.print(word + " ");
        }
    }

    public static void main(String[] args) {
        setCities();
        setWords();
    }
}
