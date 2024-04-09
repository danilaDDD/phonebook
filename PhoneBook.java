import java.util.*;

public class PhoneBook {
    private Map<String, Set<Integer>> nameToPhones = new HashMap<>();

    public void add(String name, int phone){
       Set<Integer> phones = find(name);
       phones.add(phone);
       nameToPhones.put(name, phones);
    }

    public Set<Integer> find(String name){
        Set<Integer> phones = nameToPhones.get(name);
        if(phones == null)
            return new TreeSet<>();

        return phones;
    }
    // get entries order in descending order
    public List<Map.Entry<String, Set<Integer>>> getPhoneBook(){
        List<Map.Entry<String, Set<Integer>>> entryList = new ArrayList<>(nameToPhones.entrySet());
        entryList.sort(new EntrySetComparator());
        return entryList;
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
