package org.example;
import java.util.Scanner;
import org.example.UserDAO;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception{

                Scanner sc = new Scanner(System.in);
                UserDAO dao = new UserDAO();

                while (true) {
                    System.out.println("\n--- MENU ---");
                    System.out.println("1. Insert User");
                    System.out.println("2. Show Users");
                    System.out.println("3. Update User");
                    System.out.println("4. Delete User");
                    System.out.println("5. Exit");
                    int ch = sc.nextInt();

                    switch (ch) {
                        case 1:
                            System.out.print("Enter firstname: ");
                            String fname = sc.next();
                            System.out.print("Enter lastname: ");
                            String lname = sc.next();
                            System.out.print("Enter email: ");
                            String email = sc.next();
                            System.out.print("Enter password: ");
                            String pass = sc.next();
                            dao.insertuser(fname, lname,email,pass);
                            break;
                       case 2:
                            dao.getUsers().forEach(System.out::println);
                            break;
                        case 3:
                            System.out.print("Enter email: ");
                            String emails = sc.next();
                            System.out.print("First New name: ");
                            String fnewName = sc.next();
                            System.out.print("Last new name:  ");
                            String lnewname = sc.next();
                            dao.updateUser(fnewName, lnewname, emails);
                            break;
                        case 4:
                            System.out.print("Enter emailid: ");
                            String em = sc.next();
                            dao.deleteUser(em);
                            break;
                        case 5:
                            System.exit(0);
                    }
                }
            }
        }

