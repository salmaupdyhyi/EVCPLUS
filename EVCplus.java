import java.util.Scanner;

public class EVCplus {
    public static final String CORRECT_PIN = "2025";
    public static double balance = 500;
    public static double billBalance = 50;
    public static double bankBalance = 7000;
    public static final int BANK_PIN_NUMBER = 1313;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        if (!validateUSSDCode(input)) return;
        if (!validatePin(input)) return;

        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = input.nextInt();

            switch (choice) {
                case 1 -> showBalance();
                case 2 -> kaarkaHadalka(input);
                case 3 -> bixibil(input);
                case 4 -> transferEVCPlus(input);
                case 5 -> showSummary();
                case 6 -> salaamBankMenu(input);
                case 7 -> maareynta(input);
                case 8 -> handleBillPayment(input);
                default -> System.out.println("Doorasho khaldan!");
            }
        }
    }

    public static boolean validateUSSDCode(Scanner input) {
        System.out.println("Geli koodka USSD (*770#):");
        return input.nextLine().equals("*770#");
    }

    public static boolean validatePin(Scanner input) {
        System.out.print("Geli PIN-kaaga: ");
        return input.nextLine().equals(CORRECT_PIN);
    }
    //SO bandhigida menu ga ugu wayn
    public static void displayMainMenu() {
        System.out.println("\n------ EVC PLUS ------");
        System.out.println("1. Tus Haraaga");
        System.out.println("2. Kaarka Hadalka");
        System.out.println("3. Bixi Biil");
        System.out.println("4. U wareeji EVC");
        System.out.println("5. Warbixin Kooban");
        System.out.println("6. Salaam Bank");
        System.out.println("7. Maareynta");
        System.out.println("8. BillPayment ");
        System.out.print("Dooro: ");
    }
    //option 1 tus haragaaga
    public static void showBalance() {
        System.out.println("Itus haragaga Haraaga: $" + balance);
    }
    // option 2 kaarka hadalka
    public static void kaarkaHadalka(Scanner input) {
        while (true) {
            System.out.println("\n=== Kaarka hadalka ===");
            System.out.println("1. Ku Shubo Airtime");
            System.out.println("2. Ugu Shub Airtime");
            System.out.println("3. MIFI Packages");
            System.out.println("4. Ku shubo Internet");
            System.out.println("5. Ugu shub qof kale (MMT)");
            System.out.println("0. Back");

            System.out.print("Dooro ikhtiyaar: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("\n== Ku Shubo Airtime ==");
                    System.out.print("Geli qadarka: ");
                    double amount = input.nextDouble();
                    input.nextLine();
                    System.out.println("Waxaad ku shubatay " + amount + " units.");
                }
                case 2 -> {
                    System.out.println("\n== Ugu Shub Airtime ==");
                    System.out.print("Geli lambarka qofka: ");
                    String number = input.nextLine();
                    System.out.print("Geli qadarka: ");
                    double amount = input.nextDouble();
                    input.nextLine();
                    System.out.println("Waxaad ugu shubtay " + amount + " qofka " + number);
                }
                case 3 -> {
                    System.out.println("\n== MIFI Packages ==");
                    String[] packages = {"5GB - 5 maalmood", "10GB - 10 maalmood", "20GB - 30 maalmood"};
                    for (int i = 0; i < packages.length; i++) {
                        System.out.println((i + 1) + ". " + packages[i]);
                    }
                    System.out.print("Dooro xirmo: ");
                    int x = input.nextInt();
                    input.nextLine();
                    if (x >= 1 && x <= packages.length) {
                        System.out.println(" " + packages[x - 1] + " ayaa laguu shubay.");
                    } else {
                        System.out.println(" Doorasho aan sax aheyn.");
                    }
                }
                case 4 -> {
                    System.out.println("\n== Ku Shubo Internet ==");
                    System.out.print("Geli qadarka MB: ");
                    int mb = input.nextInt();
                    input.nextLine();
                    System.out.println(" " + mb + "MB ayaa laguu shubay.");
                }
                case 5 -> {
                    System.out.println("\n== Ugu shub qof kale (MMT) ==");
                    System.out.print("Geli lambarka qofka: ");
                    String num = input.nextLine();
                    System.out.print("Geli qadarka: ");
                    double am = input.nextDouble();
                    input.nextLine();
                    System.out.println("" + am + " ayaa loo shubay qofka " + num + " adigoo adeegsanaya MMT.");
                }
                case 0 -> {
                    System.out.println("Waxaa lagaa saaray Kaarka Hadalka menu.");
                    return;
                }
                default -> System.out.println("Fadlan dooro ikhtiyaar sax ah.");
            }
        }
    }
    //option 3 bixi billka
    public static void bixibil(Scanner input) {
        System.out.print("Lacagta Biilka: $");
        double amount = input.nextDouble();

        if (balance >= amount) {
            balance -= amount;
            System.out.println("Waxaad bixisay $" + amount);
        } else {
            System.out.println("Haraag kugu filan");
        }
    }
        //option 4  uwareji evcplus
    public static void transferEVCPlus(Scanner input) {
        System.out.print("Lambarka: ");
        int number = input.nextInt();

        System.out.print("Lacagta: $");
        double amount = input.nextDouble();

        if (balance >= amount) {
            balance -= amount;
            System.out.println("Waxaad $" + amount + " u wareejisay " + number);
        } else {
            System.out.println("Haraag kugu filan");
        }
    }
    //option 5 warbixin koban
    public static void showSummary() {
        String[] names = {"Haraaga", "Biilka", "Bangiga"};
        double[] amounts = {balance, billBalance, bankBalance};
        System.out.println("Warbixin Kooban");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": $" + amounts[i]);
        }
    }
    //Option 6 salaam bank
    public static void salaamBankMenu(Scanner input) {
        System.out.print("Geli PIN-ka Bangiga: ");
        int enteredPin = input.nextInt();

        if (enteredPin == BANK_PIN_NUMBER) {
            String[] options = {
                    "1. Itus Haraagaaga",
                    "2. Lacag Dhigasho",
                    "3. Lacag Qaado",
                    "4. Ka wareeji EVCP-lus",
                    "5. Ka wareeji Account-kaga",
                    "6. Ka bax"
            };

            boolean bankRunning = true;
            while (bankRunning) {
                System.out.println("\n------ Salaam Bank ------");
                for (int i = 0; i < options.length; i++) {
                    System.out.println(options[i]);
                }

                System.out.print("Dooro: ");
                int bankChoice = input.nextInt();

                switch (bankChoice) {
                    case 1 -> System.out.println("Haraaga Bangiga: $" + bankBalance);
                    case 2 -> {
                        System.out.print("Geli lacagta aad dhigaysid: ");
                        double deposit = input.nextDouble();
                        bankBalance += deposit;
                        System.out.println("Waad dhigatay $" + deposit);
                    }
                    case 3 -> {
                        System.out.print("Geli lacagta aad qaadanaysid: ");
                        double withdraw = input.nextDouble();
                        if (bankBalance >= withdraw) {
                            bankBalance -= withdraw;
                            System.out.println("Waad qaadatay $" + withdraw);
                        } else {
                            System.out.println("Haraag kugu filan ma jiro!");
                        }
                    }
                    case 4 -> transferFromEVCPToBank(input);
                    case 5 -> transferFromBankToEVCP(input);
                    case 6 -> {
                        System.out.println("Waad ka baxday Salaam Bank");
                        bankRunning = false;
                    }
                    default -> System.out.println("Doorasho khaldan!");
                }
            }
        } else {
            System.out.println("PIN khaldan!");
        }
    }

    public static void transferFromEVCPToBank(Scanner input) {
        System.out.print("Geli lacagta aad rabto inaad ka wareejiso EVCPlus: ");
        double amount = input.nextDouble();

        if (balance >= amount) {
            balance -= amount;
            bankBalance += amount;
            System.out.println("$" + amount + " ayaa laga wareejiyay EVCPlus kuna dhacay Bangiga.");
        } else {
            System.out.println("Haraag EVCPlus kugu filan ma jiro.");
        }
    }

    public static void transferFromBankToEVCP(Scanner input) {
        System.out.print("Geli lacagta aad rabto inaad ka wareejiso Bangiga: ");
        double amount = input.nextDouble();

        if (bankBalance >= amount) {
            bankBalance -= amount;
            balance += amount;
            System.out.println("$" + amount + " ayaa laga wareejiyay Bangiga kuna dhacay EVCPlus.");
        } else {
            System.out.println("Haraag Bangi kugu filan ma jiro.");
        }
    }
    //option 7 mareynta
    public static void maareynta(Scanner akhri) {
        int doorasho;
        do {
            System.out.println("Maareynta");
            System.out.println("1. Bedel lambarka sirta ah");
            System.out.println("2. Bedel luqadda");
            System.out.println("3. Wargelin Mobile lumay");
            System.out.println("4. Xiro lacag");
            System.out.println("5. Soo celi lacag khaldan");
            System.out.println("0. Ka noqo");

            System.out.print("Fadlan dooro mid: ");
            doorasho = akhri.nextInt();

            switch (doorasho) {
                case 1 -> bedelLambarSir(akhri);
                case 2 -> bedelLuqad(akhri);
                case 3 -> mobileLumay();
                case 4 -> xiroLacag(akhri);
                case 5 -> celiLacagKhaldan(akhri);
                case 0 -> System.out.println("Waxaad ku noqotay menu-ga hore.");
                default -> System.out.println("Fadlan dooro tiro sax ah.");
            }
        } while (doorasho != 0);
    }

    public static void bedelLambarSir(Scanner akhri) {
        System.out.print("Geli lambarka sirta cusub: ");
        String lambarCusub = akhri.next();
        System.out.println("Lambarka sirta waa la bedelay si guul ah: " + lambarCusub);
    }

    public static void bedelLuqad(Scanner akhri) {
        String[] luqado = {"Soomaali", "English"};
        System.out.println("Dooro luqadda:");
        for (int i = 0; i < luqado.length; i++) {
            System.out.println((i + 1) + ". " + luqado[i]);
        }
        int luqad = akhri.nextInt();
        if (luqad == 1) {
            System.out.println("Luqaddaada hadda waa Soomaali.");
        } else if (luqad == 2) {
            System.out.println("Your language is now English.");
        } else {
            System.out.println("Doorasho aan sax ahayn.");
        }
    }

    public static void mobileLumay() {
        System.out.println("Wargelin: Mobile-ka lumay waa la xiray. Fadlan la xiriir adeegga macaamiisha.");
    }

    public static void xiroLacag(Scanner akhri) {
        System.out.print("Geli lacagta aad rabto inaad xirto: ");
        double lacag = akhri.nextDouble();
        System.out.println("Waxaad xirtay lacag dhan $" + lacag);
    }

    public static void celiLacagKhaldan(Scanner akhri) {
        System.out.print("Geli lambarka qofka aad si khaldan ugu dirtay: ");
        String lambarKhaldan = akhri.next();
        System.out.print("Geli lacagta khaldan: ");
        double lacagKhaldan = akhri.nextDouble();
        System.out.println("Codsiga soo celinta $" + lacagKhaldan + " ee " + lambarKhaldan + " waa la diiwaangeliyey.");
    }
    //billpeyment
    public static void handleBillPayment(Scanner input) {
        int billChoice;
        do {
            System.out.println("\n*** Bixi Biil ***");
            System.out.println("1. Itus Haraaga Bill-ka");
            System.out.println("2. Wada bixi Bill-ka");
            System.out.println("3. Qayb ka bixi Bill-ka");
            System.out.println("4. Ka laabo");

            System.out.print("Fadlan dooro (1-4): ");
            billChoice = input.nextInt();

            switch (billChoice) {
                case 1 -> System.out.println("Haraaga Bill-kaagu waa: $" + billBalance);
                case 2 -> {
                    if (balance >= billBalance) {
                        balance -= billBalance;
                        billBalance = 0;
                        System.out.println("Bill-ka si buuxda waad u bixisay.");
                    } else {
                        System.out.println("Ma haysid lacag kugu filan.");
                    }
                }
                case 3 -> {
                    System.out.print("Fadlan geli lacagta aad rabto inaad ka bixiso: ");
                    double partAmount = input.nextDouble();
                    if (partAmount > 0 && partAmount <= balance && partAmount <= billBalance) {
                        balance -= partAmount;
                        billBalance -= partAmount;
                        System.out.println("Waxaad ka bixisay $" + partAmount + ". Haraaga Bill-kaagu hadda waa $" + billBalance);
                    } else {
                        System.out.println("Lacagta la geliyay waa khaldan.");
                    }
                }
                case 4 -> System.out.println("Waad ka laabatay Bill Bixinta.");
                default -> System.out.println("Fadlan dooro 1 ilaa 4.");
            }
        } while (billChoice != 4);
    }
}