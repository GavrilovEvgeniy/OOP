public class Main {
    public static void main(String[] args) {
        Person p = new Person.Builder().addFName("Michael").addLName("Sunboy").addCountry("Neverland").addGender("male").addAge(30).build();
        System.out.println(p);
    }
}
