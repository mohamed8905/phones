public class HashTable {

    private final int Size;
    private PhoneList [] Table;

    HashTable(int Size) {
        this.Size = Size;
        Table = new PhoneList[Size];
        for (int i = 0; i < Size; i++) {
            Table[i] = new PhoneList();
        }
    }

    void Insert(String name, String phone) {
        int hashIndex = (int)calc_hash(name, Size);
        if (Table[hashIndex].searchContact(name) == true && Table[hashIndex].getContact(name) == phone) {
            System.out.println("Contact exists");
        }
        else Table[hashIndex].addContact(name, phone);
    }

    void Search(String name) {
        int hashIndex = (int)calc_hash(name, Size);
        if (Table[hashIndex].searchContact(name) == true) {
            System.out.println("Contact found: Name: " + name + ", Phone: " + Table[hashIndex].getContact(name));
        }
        else System.out.println("Contact not found");
    }

    void Delete(String name) {
        int hashIndex = (int)calc_hash(name, Size);
        Table[hashIndex].deleteContact(name);
    }

    void update(String name, String new_phone_number){
        int hashIndex = (int)calc_hash(name, Size);
        Table[hashIndex].updateContact(name, new_phone_number);
    }

    void Display(){
        for (int i = 0; i < Size; i++) {
            if (Table[i] != null && !Table[i].isEmpty()) {
                System.out.println("index no." + i + " : ");
                Table[i].displayList();
            }
        }
    }

    public static long calc_hash(String key, int table_size) {
        int i, l = key.length();
        long hash = 0;
        for (i = 0; i < l; i++) {
            hash += Character.getNumericValue(key.charAt(i));
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        if (hash > 0) return hash % table_size;
        else return -hash % table_size;
    }
       
}