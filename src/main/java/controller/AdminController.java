package controller;

import container.ComponentContainer;
import dto.Card;
import dto.Terminal;
import main.java.dto.Profile;

import javax.print.Doc;
import javax.tools.DocumentationTool;
import java.util.List;


public class AdminController {
    public void start(main.java.dto.Profile profile) {
boolean admin = true;
        while (admin) {
            adminMenu();
            int action = ComponentContainer.getAction();
            switch (action) {
                case 1 -> {
                    boolean b = true;
                    while (b) {
                        cardMenu();
                        int cardAction = ComponentContainer.getAction();
                        switch (cardAction) {
                            case 1 -> {
                                createCard();
                            }
                            case 2 -> {
                                cardList();
                            }
                            case 3 -> {
                                updateCard();
                            }
                            case 4 -> {
                                changeCardStatus();
                            }
                            case 5 -> {
                                deleteCard();
                            }
                            case 0 -> {
                                b = false;
                            }
                        }

                    }
                }
                case 2 -> {
                    boolean b = true;
                    terminalMenu();
                    int cardAction = ComponentContainer.getAction();
                    switch (cardAction) {
                        case 1 -> {
                            createTerminal();
                        }
                        case 2 -> {
                            terminalList();
                        }
                        case 3 -> {
                            updateTerminal();
                        }
                        case 4 -> {
                            changeTerminalStatus();
                        }
                        case 5 -> {
                            deleteTerminal();
                        }
                        case 0 -> {
                            b = false;
                        }
                    }
                }
                case 3 -> {
                    boolean b = true;
                    profileMenu();
                    int profileAction = ComponentContainer.getAction();
                    switch (profileAction) {
                        case 1 -> {
                            profileList();
                        }
                        case 2 -> {
                            changeProfileStatus();
                        }
                        case 0 -> {
                            b = false;
                        }
                    }
                }
                case 4 -> {
//                    transaction();
                }
                case 5 -> {
//                    statistic();
                }
                case 0->{
                    admin = false;
                }
//                case 6->{
//                    createTerminal();
//                }
//                case 7->{
//                    terminalList();
//                }
//                case 8->{
//                    updateTerminal();
//                }
//                case 9->{
//                    changeTerminalStatus();
//                }
//                case 10->{
//                    deleteTerminal();
//                }

            }
        }

    }

    private void changeProfileStatus() {
        System.out.print("Enter phone profile  : ");
        String phone = ComponentContainer.stringScanner.next();
        ComponentContainer.profileService.changeProfileStatus(phone);
    }

    private void profileList() {
       List<Profile>  profileList =  ComponentContainer.profileService.profileList();
       profileList.forEach(System.out::println);
    }

    private void profileMenu() {
        System.out.println("1.Profile List\n" +
                "2.Change Profile Status\n" +
                "0.Exit\n");
    }

    private void deleteTerminal() {
        System.out.print("Enter TERMINAL card :");
        String numTerminal = ComponentContainer.stringScanner.next();
        System.out.print("Enter address  : ");
        String address = ComponentContainer.stringScanner.next();
        ComponentContainer.terminalService.deleteTerminal(numTerminal, address);

    }

    private void changeTerminalStatus() {
        System.out.print("Enter number terminal");
        String numCard = ComponentContainer.stringScanner.next();
        System.out.print("Enter address : ");
        String address = ComponentContainer.stringScanner.next();
        ComponentContainer.terminalService.changeCardStatus(numCard, address);
    }

    private void updateTerminal() {
        System.out.print("Enter terminal number : ");
        String number = ComponentContainer.stringScanner.next();
        System.out.print("Enter terminal address  : ");
        String address = ComponentContainer.stringScanner.next();
        ComponentContainer.terminalService.updateTerminalByNumber(number, address);
    }

    private void terminalList() {
        List<Terminal> cardList = ComponentContainer.terminalRepository.terminalList();
        cardList.forEach(System.out::println);
    }

    private void createTerminal() {
        System.out.print("Enter Terminal number : ");
        String number = ComponentContainer.stringScanner.next();
        System.out.print("Enter Terminal address : ");
        String address = ComponentContainer.stringScanner.next();
        ComponentContainer.terminalService.createTerminal(number, address);

    }

    private void terminalMenu() {
        System.out.println("1.Create Terminal \n" +
                "    2. Terminal List\n" +
                "    3. Update Terminal \n" +
                "    4. Change Terminal Status\n" +
                "    5. Delete" +
                "0.Exit\n");
    }

    private void deleteCard() {
        System.out.println("Enter number card");
        String numCard = ComponentContainer.stringScanner.next();
        System.out.println("Enter exp_date  : ");
        String exp_date = ComponentContainer.stringScanner.next();
        ComponentContainer.cardService.deleteCard(numCard, exp_date);
    }

    private void changeCardStatus() {
        System.out.print("Enter number card");
        String numCard = ComponentContainer.stringScanner.next();
        System.out.print("Enter exp_date  : ");
        String exp_date = ComponentContainer.stringScanner.next();
        ComponentContainer.cardService.changeCardStatus(numCard, exp_date);

    }

    private void updateCard() {
        System.out.print("Enter card number : ");
        String number = ComponentContainer.stringScanner.next();
        System.out.print("Enter exp_date  : ");
        String exp_date = ComponentContainer.stringScanner.next();
        ComponentContainer.cardService.updateCardByNumber(number, exp_date);

    }

    private void cardList() {
        List<Card> cardList = ComponentContainer.cardRepository.cardList();
        cardList.forEach(System.out::println);
    }

    private void createCard() {
        System.out.print("Enter Card number : ");
        String number = ComponentContainer.stringScanner.next();
        System.out.print("Enter Card number : ");
        String exp_date = ComponentContainer.stringScanner.next();
        ComponentContainer.cardService.createCard(number, exp_date);
    }

    private void cardMenu() {
        System.out.println("1. Create Card\n" +
                "2. Card List\n" +
                "3. Update Card \n" +
                "4. Change Card status\n" +
                "5. Delete Card\n" +
                "0.Exit\n");
    }

    private void adminMenu() {
        System.out.println("1.Card \n" +
                "2.Terminal\n" +
                "3.Profile\n" +
                "4.Transaction\n" +
                "5.Statistic\n" +
                "0.Exit\n");

    }
}
