package chap100;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);

        int value;
        Node found;
        BinaryTree tree = new BinaryTree();

        tree.insert(50);
        tree.insert(27);
        tree.insert(68);
        tree.insert(12);
        tree.insert(36);
        tree.insert(55);
        tree.insert(82);
        tree.insert(7);
        tree.insert(19);
        tree.insert(49);
        tree.insert(76);

        while (true) {
            System.out.println("-----------------------------------");
            System.out.println("1. Traverse");
            System.out.println("2. Find");
            System.out.println("3. Find min&max");
            System.out.println("4. Insert");
            System.out.println("5. Delete");
            System.out.println("6. Display Tree");
            System.out.print("Enter the number of command: ");
            int command = sc.nextInt();

            switch (command) {
                case 1:
                    System.out.println("1. Preorder");
                    System.out.println("2. Inorder");
                    System.out.println("3. Postorder");
                    System.out.print("Enter the number of type: ");
                    value = sc.nextInt();
                    tree.traverse(value);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    found = tree.find(value);

                    if (found != null) {
                        System.out.printf("Found: %s\n", found);
                    } else {
                        System.out.printf("Could not find %d\n", value);
                    }
                    break;
                case 3:
                    System.out.println("1. Find Minimum value");
                    System.out.println("2. Find Maximum value");
                    System.out.print("Enter the number of type: ");
                    value = sc.nextInt();

                    if (value == 1) {
                        found = tree.findMin();
                        System.out.printf("Found: %s\n", found);
                    } else if (value == 2){
                        found = tree.findMax();
                        System.out.printf("Found: %s\n", found);
                    }
                    break;
                case 4:
                    System.out.print("Enter integer value to insert: ");
                    value = sc.nextInt();
                    tree.insert(value);
                    System.out.println();
                    System.out.println("Insert Result");
                    tree.display();
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Enter integer value to delete: ");
                    value = sc.nextInt();

                    boolean complete = tree.delete(value);
                    if (complete) {
                        System.out.printf("Deleted %d\n", value);
                        System.out.println("Delete Result");
                        tree.display();
                    } else {
                        System.out.printf("Could not delete %d\n", value);
                    }
                    System.out.println();
                    break;
                case 6:
                    tree.display();
                    break;
                default:
                    System.out.println("Invalid entry");
            }
        }


    }


}
