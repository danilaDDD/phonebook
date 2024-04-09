public class Main {
    public static void main(String[] args) {
        checkPhoneBook();
    }

    private static void checkPhoneBook(){
        PhoneBook phoneBook = new PhoneBook();
        String name1 = "Ivanov";
        String name2 = "Dmitriy";
        String name3 = "Peter";
        String name4 = "Igor";

        phoneBook.add(name1, 6666);
        phoneBook.add(name1, 6666);

        phoneBook.add(name2, 6666);
        phoneBook.add(name2, 9999);

        phoneBook.add(name3, 6666);
        phoneBook.add(name3, 9999);
        phoneBook.add(name3, 5555);

        System.out.printf("find by name %s: %s\n", name1, phoneBook.find(name1));
        System.out.printf("find by name %s: %s\n", name2, phoneBook.find(name2));
        System.out.printf("find by name %s: %s\n", name3, phoneBook.find(name3));
        System.out.printf("find by name %s: %s\n", name4, phoneBook.find(name4));
        System.out.printf("get all phone book %s", phoneBook.getPhoneBook());


        // find by name Ivanov: [6666]
        // find by name Dmitriy: [6666, 9999]
        // find by name Peter: [5555, 6666, 9999]
        // find by name Igor: []
        // get all phone book [Peter=[5555, 6666, 9999], Dmitriy=[6666, 9999], Ivanov=[6666]]
    }
}
