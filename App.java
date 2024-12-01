public class App {
    public static void main(String[] args) {
        HashTable table = new HashTable(1009);
        
        System.out.println(HashTable.calc_hash("Sam Doe", 1009));
        System.out.println(HashTable.calc_hash("John Smith", 1009));
        System.out.println(HashTable.calc_hash("Lisa Smith", 1009));

        System.out.println();

        table.Insert("Sam Doe", "+1-555-1234");
        table.Insert("Sam Doe", "+1-555-1234");
        table.Insert("Sam Doe", "+1-556-1234");
        table.Insert("John Smith", "+1-555-8976");
        table.Insert("Lisa Smith", "+1-555-5030");

        table.Search("Sam Doe");
        table.update("John Smith", "+1-555-9512");
        
        table.Display();
    }
}