import java.util.Scanner;

class Animal {
   void speak() {
      System.out.println("Animal speaks.");
   }
}

class Dog extends Animal {
   void speak() {
      System.out.println("Aw aw aw.");
   }
}

class Cat extends Animal {
   void speak() {
      System.out.println("Meow meow meow.");
   }
}

class Cow extends Animal {
   void speak() {
      System.out.println("Moo moo mooo.");
   }
}

class Fox extends Animal {

   void speak() {
      System.out.println("Ding ding ding.");
   }
}

public class AnimalSound {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
   
      System.out.println("============ Activity One: What does the animal say? ============");
      System.out.println("Select an animal:");
      System.out.println("1. Dog");
      System.out.println("2. Cat");
      System.out.println("3. Cow");
      System.out.println("4. Fox");
      System.out.println("");
      System.out.print("Enter selected number: ");
      int choice = scanner.nextInt();
   
      Animal selectedAnimal;
   
      switch (choice) {
         case 1:
            selectedAnimal = new Dog();
            break;
         case 2:
            selectedAnimal = new Cat();
            break;
         case 3:
            selectedAnimal = new Cow();
            break;
         case 4:
            selectedAnimal = new Fox();
            break;
         default:
            System.out.println("Invalid choice.");
            return;
      }
      
      System.out.print("Animal: ");
      selectedAnimal.speak();
   
      scanner.close();
   }
}