package cryptographyalgorithms;

import java.util.Scanner;

/**
 * @author Basel Obaid
 */
public class Main {

    public static void main(String[] args) {

        Algorithm algo = null;
        boolean flag = true;
        int check;

        while (flag) {
            System.out.println("Hi, enter the type of cipher algorithm: \n1- AES.\n2- DES.\n3- 3TDES.\n4-close.");
            Scanner inputType = new Scanner(System.in);
            switch (inputType.nextShort()) {
                case 1: {
                    algo = new AESAlgorithm();
                    break;
                }

                case 2: {
                    algo = new DESAlgorithm();
                    break;
                }

                case 3: {
                    algo = new TripleDESAlgorithm();
                    break;
                }

                case 4: {
                    flag = true;
                    break;
                }
                default: {
                    System.out.println("incorrect!");
                    continue;
                }
            }
            System.out.print("enter your message: ");
            Scanner input = new Scanner(System.in);
            // to take the plain text 
            algo.setPlainText(input.nextLine());
            // to encrypt the text
            String cipherText = algo.encrypt();
            System.out.println("the cipher text is: " + cipherText);

            System.out.println("if you want to decrypt a message enter 1, if not enter 0");
            Scanner number = new Scanner(System.in);
            check = number.nextInt();

            if (check == 0) {
                flag = false;
            } else {
                System.out.println("enter the cipher text : ");
                Scanner cipher = new Scanner(System.in);
                String pText = cipher.nextLine();
                String plainText = algo.decrypt(pText);
                System.out.println("the cipher text is: " + plainText);
            }
        }

    }

}
