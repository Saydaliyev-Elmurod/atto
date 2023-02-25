package container;

import repository.ProfileRepository;
import service.ProfileService;

import java.util.Scanner;

public class ComponentContainer {
    public static Scanner intScanner = new Scanner(System.in);
    public static Scanner stringScanner = new Scanner(System.in);
    public static ProfileService profileService;
    public static ProfileRepository profileRepository;
    static {
        profileService = new ProfileService();
        profileRepository = new ProfileRepository();
    }

}
