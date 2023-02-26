package container;

import controller.AdminController;
import controller.ProfileController;
import repository.CardRepository;
import repository.ProfileRepository;
import repository.TerminalRepository;
import service.CardService;
import service.ProfileService;
import service.TerminalService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ComponentContainer {
    public static TerminalRepository terminalRepository;
    public static ProfileRepository profileRepository;
    public static TerminalService terminalService ;
    public static Scanner intScanner = new Scanner(System.in);
    public static Scanner stringScanner = new Scanner(System.in);
    public static ProfileService profileService;
    public static ProfileController profileController ;
    public static AdminController adminController ;
    public static CardRepository cardRepository ;
    public static CardService cardService ;
    static {
        profileRepository = new ProfileRepository();
        terminalService = new TerminalService();
        terminalRepository = new TerminalRepository();
        cardService = new CardService();
        cardRepository = new CardRepository();
        profileService = new ProfileService();
        profileController = new ProfileController();
        adminController = new AdminController();
    }
    public static int getAction() {
        System.out.print("Action >> ");
        /*agar menuda raqam tanlamasdan harf yoki belgi tanlasa exception tashlaydi*/
        try {
            return ComponentContainer.intScanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error");
        }
        return 0;
    }

}
