package controller;

import container.ComponentContainer;
import dto.Card;
import main.java.dto.Profile;

import java.util.List;

public class ProfileController {
    public void start(Profile profile) {
        while (true) {
            userMenu();
            int action = ComponentContainer.getAction();
            switch (action) {
                case 1 -> {
                    addCard(profile);
                }
                case 2->{
                    cardList(profile);
                }
            }
        }

    }

    private void cardList(Profile profile) {
      List<Card> cardList =  ComponentContainer.cardService.cardListUser(profile);
      cardList.forEach(System.out::println);
    }

    private void addCard(main.java.dto.Profile profile) {
        System.out.print("Enter Card Number:");
        String numCard = ComponentContainer.stringScanner.next();
        System.out.print("Enter card data : ");
        String cardExp_date = ComponentContainer.stringScanner.next();
        ComponentContainer.profileService.addCard(profile,numCard,cardExp_date);
    }

    private void userMenu() {
        System.out.print("1.Add card" +
                "2.Card List" +
                "3.Change Card Status" +
                "4.Delete Card" +
                "5.ReFill" +
                "6.Transaction" +
                "7.Make Payment" +
                "0.Exit");
    }
}
