package controller;

import container.ComponentContainer;
import db.DataBase;
import main.java.dto.Profile;

import java.util.InputMismatchException;

public class MainController {
    public void start() {
        DataBase.init();
        while (true){
            menu();
            int action = getAction();
            switch (action){
                case 1->{
                        login();
                }
                case 2->{
                    registration();
                }
                case 0->{
                    System.exit(0);
                }
            }

        }
    }

    private void registration() {
        System.out.print("Enter name >> ");
        String name = ComponentContainer.stringScanner.next();
        System.out.print("Enter surname >> ");
        String surname = ComponentContainer.stringScanner.next();
        System.out.print("Enter phone >> ");
        String phone = ComponentContainer.stringScanner.next();
        System.out.print("Enter password >> ");
        String password = ComponentContainer.stringScanner.next();
        Profile profile = new Profile(name,surname,phone,password);
        ComponentContainer.profileService.registration(profile);

    }

    private void login() {
        System.out.print("Enter phone :");
        String phone = ComponentContainer.stringScanner.next();
        System.out.print("Enter password :");
        String password = ComponentContainer.stringScanner.next();



    }

    private int getAction() {
        System.out.print("Action >> ");
        /*agar menuda raqam tanlamasdan harf yoki belgi tanlasa exception tashlaydi*/
        try {
            return ComponentContainer.intScanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Error");
        }
        return 0;
    }
    private void menu() {
        System.out.println("1.Login");
        System.out.println("2.Registration");
        System.out.println("0.Exit");
    }
}
