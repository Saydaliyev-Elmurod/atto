package service;

import container.ComponentContainer;
import dto.Card;
import enums.CardStatus;
import main.java.dto.Profile;

import java.util.List;

public class CardService {

    public void createCard(String number, String exp_date) {
        //check
        //>>>>>>
        ComponentContainer.cardRepository.createCard(number, exp_date);
    }

    public void updateCardByNumber(String number, String exp_date) {
        Card card = ComponentContainer.cardRepository.getCard(number);
        if (card == null || !card.getExp_date().equals(exp_date)) {
            System.out.println("Card not found");
        } else {
            System.out.print("Enter new card number : ");
            String newCardNum = ComponentContainer.stringScanner.next();
            System.out.print("Enter new card exp_date : ");
            String new_exp_date = ComponentContainer.stringScanner.next();
            Card card1 = ComponentContainer.cardRepository.getCard(newCardNum);
            if (card1 == null) {
                ComponentContainer.cardRepository.updateCardByNumber(card, newCardNum, new_exp_date);
                System.out.println("Successfully");
            } else {
                System.out.println("This card already exists");
            }
        }
    }

    public void changeCardStatus(String numCard, String exp_date) {
        Card card = ComponentContainer.cardRepository.getCard(numCard);
        if (card == null || !card.getExp_date().equals(exp_date)) {
            System.out.println("Card not found");
        } else {
            if (card.getStatus().equals(CardStatus.BLOCK)) {
                card.setStatus(CardStatus.ACTIVE);
            } else if (card.getStatus().equals(CardStatus.ACTIVE)) {
                card.setStatus(CardStatus.BLOCK);
            }
            ComponentContainer.cardRepository.updateCardStatus(card);

        }
    }

    public void deleteCard(String numCard, String expDate) {
        Card card = ComponentContainer.cardRepository.getCard(numCard);
        if (card == null || (!card.getExp_date().equals(expDate))) {
            System.out.println("Card not found");
            return;
        }
        ComponentContainer.cardRepository.deleteCard(card);
    }

    public List<Card> cardListUser(Profile profile) {
     return  ComponentContainer.cardRepository.cardListUser(profile);
    }
}
