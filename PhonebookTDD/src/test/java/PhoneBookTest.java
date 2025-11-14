import org.junit.Test;
import static org.junit.Assert.*;

public class PhoneBookTest {
    // Существующие тесты для add...
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
    
    // Новые тесты для findByNumber
    @Test
    public void testFindByNumberExisting() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123-456-789");
        String result = phoneBook.findByNumber("123-456-789");
        assertEquals("Alice", result);
    }
    
    @Test
    public void testFindByNumberNonExisting() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123-456-789");
        String result = phoneBook.findByNumber("999-999-999");
        assertNull(result);
    }
    
    @Test
    public void testFindByNumberEmptyBook() {
        PhoneBook phoneBook = new PhoneBook();
        String result = phoneBook.findByNumber("123-456-789");
        assertNull(result);
    }
}