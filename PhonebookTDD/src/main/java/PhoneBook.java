import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> nameToNumber;
    private Map<String, String> numberToName;
    
    public PhoneBook() {
        nameToNumber = new HashMap<>();
        numberToName = new HashMap<>();
    }
    
    public int add(String name, String number) {
        if (nameToNumber.containsKey(name)) {
            return nameToNumber.size();
        }
        
        nameToNumber.put(name, number);
        numberToName.put(number, name);
        return nameToNumber.size();
    }
    
    public String findByNumber(String number) {
        return numberToName.get(number);
    }
}