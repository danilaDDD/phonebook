import java.util.*;

public class PhoneBook {
    private Map<String, Set<Integer>> nameToPhones = new HashMap<>();

    public void addNumber(String name, int phone){
       Set<Integer> phones = findByName(name);
       phones.add(phone);
       nameToPhones.put(name, phones);
    }

    public Set<Integer> findByName(String name){
        Set<Integer> phones = nameToPhones.get(name);
        if(phones == null)
            return new TreeSet<>();

        return phones;
    }
    // get entries order in descending order
    public Set<Map.Entry<String, Set<Integer>>> getPhoneBook(){
        Set<Map.Entry<String, Set<Integer>>> entrySet = new TreeSet<>(new EntrySetComparator());
        entrySet.addAll(nameToPhones.entrySet());

        return entrySet;
    }

    private static class EntrySetComparator implements Comparator<Map.Entry<String, Set<Integer>>>{

        @Override
        public int compare(Map.Entry<String, Set<Integer>> entry1, Map.Entry<String, Set<Integer>> entry2) {
            Integer phoneCount1 = entry1.getValue().size();
            Integer phoneCount2 = entry2.getValue().size();
            return phoneCount2.compareTo(phoneCount1);
        }
    }
}
