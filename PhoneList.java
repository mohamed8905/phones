public class PhoneList {
    
    private ContactNode head;
    PhoneList() {head = null;}
    
    boolean isEmpty() {
        return (head == null);
    }
    void addContact(String the_name, String the_phone_number) {
        if (isEmpty()) head = new ContactNode(the_name, the_phone_number);
        else {
            ContactNode ptr = head;
            while (ptr.next!= null) ptr = ptr.next;
            ptr.next = new ContactNode(the_name, the_phone_number);
        }
        System.out.println("Contact added: " + the_name + ", " + the_phone_number);
    }
    void displayList() {
        ContactNode ptr = head;
        while (ptr != null) {
            System.out.println("\tName: " + ptr.name + ", Phone: " + ptr.phone_number);
            ptr = ptr.next;
        }
    }      
    boolean searchContact(String wanted_name) {
        ContactNode ptr = head;
        while (ptr != null && ptr.name != wanted_name) ptr = ptr.next;
        if (ptr != null) {
            return true;
        }
        return false;
    }
    String getContact(String wanted_name) {
        ContactNode ptr = head;
        while (ptr != null && ptr.name != wanted_name) ptr = ptr.next;
        return ptr.phone_number;
    }
    void updateContact(String name, String new_phone_number) {
        ContactNode ptr = head;
        while (ptr != null && ptr.name != name) ptr = ptr.next;
        if (ptr != null) {
            System.out.println("Updating contact: " + ptr.name + ", " + ptr.phone_number + " to " + new_phone_number);
            ptr.phone_number = new_phone_number;
        }
        else System.out.println("Contact with name '" + name + "' not found.");
    }
    void deleteContact(String the_name) {
        if (!isEmpty()) {
            if ((head.name == the_name)) {
                System.out.println("Deleting contact: " + head.name + ", " + head.phone_number);
                head = head.next;
            }
            else {
                ContactNode ptr = head;
                while(ptr.next != null && ptr.next.name != the_name) ptr = ptr.next;
                if(ptr.next != null){
                    System.out.println("Deleting contact: " + ptr.next.name + ", " + ptr.next.phone_number);
                    ptr.next = ptr.next.next;
                }
                else System.out.println("Contact with name '" + the_name + "' not found.");
            }     
        }
        else System.out.println("Phone list is empty.");
    }
}