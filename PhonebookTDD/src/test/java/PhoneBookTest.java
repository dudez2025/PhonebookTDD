import org.junit.Test;
import static org.junit.Assert.*;

public class PhoneBookTest {
    @Test
    public void testAddFirstContact() {
        PhoneBook phoneBook = new PhoneBook();
        int result = phoneBook.add("Alice", "123-456-789");
        assertEquals(1, result);
    }
    
    @Test
    public void testAddMultipleContacts() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123-456-789");
        int result = phoneBook.add("Bob", "987-654-321");
        assertEquals(2, result);
    }
    
    @Test
    public void testAddDuplicateName() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123-456-789");
        int result = phoneBook.add("Alice", "999-999-999");
        assertEquals(1, result);
    }
}