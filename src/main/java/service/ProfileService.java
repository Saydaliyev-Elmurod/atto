package service;

import container.ComponentContainer;
import main.java.dto.Profile;

public class ProfileService {

    public void registration(Profile profile) {
        //check
        if (profile.getPassword().length() < 6) {
            System.out.println("Iltimos password 6 yoki undan ortiq belgidan iborat bolsin");
            return;
        }
        // bu profile oldin qoshilganmi yoqmi tekshiramiz phone unique bolishi kerak
        Profile profile1 = ComponentContainer.profileRepository.getProfileByPhone(profile.getPhone());
        if (profile1 != null) {
            System.out.println("Bu numerdan allaqachon royxatdan otilgan");
            return;
        }
        ComponentContainer.profileRepository.registration(profile);
    }
}
