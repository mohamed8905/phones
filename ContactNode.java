public class ContactNode {
    
    String name; 
    String phone_number; 
    ContactNode next;
    
    ContactNode(String the_name, String the_phone_number) {
        name = the_name;  phone_number = the_phone_number;
        next = null;
    }
}