import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> nameToNumber;
    
    public PhoneBook() {
        nameToNumber = new HashMap<>();
    }
    
    public int add(String name, String number) {
        if (nameToNumber.containsKey(name)) {
            return nameToNumber.size();
        }
        
        nameToNumber.put(name, number);
        return nameToNumber.size();
    }
    
    public String findByNumber(String number) {
        return null; // Заглушка
    }
}