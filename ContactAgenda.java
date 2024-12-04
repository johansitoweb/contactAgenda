import java.util.ArrayList;  
import java.util.Scanner;  

class Contact {  
    String name;  
    String phoneNumber;  

    Contact(String name, String phoneNumber) {  
        this.name = name;  
        this.phoneNumber = phoneNumber;  
    }  
}  

public class ContactAgenda {  
    private static ArrayList<Contact> contacts = new ArrayList<>();  
    private static Scanner scanner = new Scanner(System.in);  

    public static void main(String[] args) {  
        int option;  
        do {  
            System.out.println("\n--- Agenda de Contactos ---");  
            System.out.println("1. Agregar contacto");  
            System.out.println("2. Listar contactos");  
            System.out.println("3. Buscar contacto");  
            System.out.println("0. Salir");  
            System.out.print("Elige una opción: ");  
            option = scanner.nextInt();  
            scanner.nextLine();  // Consumir nueva línea  

            switch (option) {  
                case 1:  
                    addContact();  
                    break;  
                case 2:  
                    listContacts();  
                    break;  
                case 3:  
                    searchContact();  
                    break;  
                case 0:  
                    System.out.println("Saliendo...");  
                    break;  
                default:  
                    System.out.println("Opción inválida. Intenta nuevamente.");  
            }  
        } while (option != 0);  
    }  

    private static void addContact() {  
        System.out.print("Nombre: ");  
        String name = scanner.nextLine();  
        System.out.print("Número de teléfono: ");  
        String phoneNumber = scanner.nextLine();  
        contacts.add(new Contact(name, phoneNumber));  
        System.out.println("Contacto agregado exitosamente.");  
    }  

    private static void listContacts() {  
        System.out.println("--- Lista de Contactos ---");  
        for (Contact contact : contacts) {  
            System.out.println("Nombre: " + contact.name + ", Teléfono: " + contact.phoneNumber);  
        }  
    }  

    private static void searchContact() {  
        System.out.print("Nombre del contacto a buscar: ");  
        String name = scanner.nextLine();  
        for (Contact contact : contacts) {  
            if (contact.name.equalsIgnoreCase(name)) {  
                System.out.println("Contacto encontrado: " + contact.name + ", Teléfono: " + contact.phoneNumber);  
                return;  
            }  
        }  
        System.out.println("Contacto no encontrado.");  
    }  
}