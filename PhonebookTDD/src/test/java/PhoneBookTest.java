import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Set;

public class PhoneBookTest {
    // Существующие тесты...
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
    
    @Test
    public void testFindByNameExisting() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123-456-789");
        String result = phoneBook.findByName("Alice");
        assertEquals("123-456-789", result);
    }
    
    @Test
    public void testFindByNameNonExisting() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123-456-789");
        String result = phoneBook.findByName("Bob");
        assertNull(result);
    }
    
    @Test
    public void testFindByNameEmptyBook() {
        PhoneBook phoneBook = new PhoneBook();
        String result = phoneBook.findByName("Alice");
        assertNull(result);
    }
    
    // Новые тесты для printAllNames
    @Test
    public void testPrintAllNamesEmpty() {
        PhoneBook phoneBook = new PhoneBook();
        Set<String> result = phoneBook.printAllNames();
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testPrintAllNamesSingle() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123-456-789");
        Set<String> result = phoneBook.printAllNames();
        assertEquals(1, result.size());
        assertTrue(result.contains("Alice"));
    }
    
    @Test
    public void testPrintAllNamesMultipleSorted() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Charlie", "111-111-111");
        phoneBook.add("Alice", "222-222-222");
        phoneBook.add("Bob", "333-333-333");
        
        Set<String> result = phoneBook.printAllNames();
        assertEquals(3, result.size());
        
        String[] expected = {"Alice", "Bob", "Charlie"};
        String[] actual = result.toArray(new String[0]);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testPrintAllNamesAfterDuplicate() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "111-111-111");
        phoneBook.add("Bob", "222-222-222");
        phoneBook.add("Alice", "333-333-333");
        
        Set<String> result = phoneBook.printAllNames();
        assertEquals(2, result.size());
    }
}