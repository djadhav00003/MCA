import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class MemoryChallenge {

    static class MemoryGame {
        private List<Integer> numberSequence;
        private int sequenceLength;
        private int displayDuration;

        public MemoryGame(int sequenceLength, int displayDuration) {
            this.sequenceLength = sequenceLength;
            this.displayDuration = displayDuration;
            this.numberSequence = new ArrayList<>();
        }

        public void generateSequence() {
            Random random = new Random();
            for (int i = 0; i < sequenceLength; i++) {
                numberSequence.add(random.nextInt(100));
            }
        }

        public void showSequence() {
            System.out.println("Please memorize the following numbers: ");
            for (int number : numberSequence) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

        public void hideSequence(Runnable onSequenceHiddenCallback, CountDownLatch latch) {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clearConsole();
                    System.out.println("The numbers are hidden now. Please enter them in the same order.");
                    if (onSequenceHiddenCallback != null) {
                        onSequenceHiddenCallback.run();
                    }
                    latch.countDown();
                }
            }, displayDuration);
        }

        public boolean isSequenceCorrect(List<Integer> userSequence) {
            return numberSequence.equals(userSequence);
        }

        public List<Integer> getNumberSequence() {
            return numberSequence;
        }

        private void clearConsole() {
            try {
                String operatingSystem = System.getProperty("os.name");
                if (operatingSystem.contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class GameUI {
        private MemoryGame memoryGame;
        private Scanner scanner;

        public GameUI() {
            scanner = new Scanner(System.in);
        }

        public void startGame() {
            int numberCount = 0;
            while (true) {
                try {
                    System.out.print("How many numbers would you like to memorize? ");
                    numberCount = scanner.nextInt();
                    if (numberCount < 1) {
                        System.out.println("Please enter a number greater than 0.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid entry. Please enter a valid integer.");
                    scanner.next(); 
                }
            }

            int displayDuration = Math.max(numberCount * 1000, 1000);

            memoryGame = new MemoryGame(numberCount, displayDuration);
            memoryGame.generateSequence();
            memoryGame.showSequence();

            CountDownLatch latch = new CountDownLatch(1);

            memoryGame.hideSequence(() -> {
                List<Integer> userSequence = getUserInput();
                if (memoryGame.isSequenceCorrect(userSequence)) {
                    System.out.println("Well done! You remembered all the numbers correctly.");
                } else {
                    System.out.println("Incorrect. The correct sequence was: " + memoryGame.getNumberSequence());
                }
            }, latch);

            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private List<Integer> getUserInput() {
            List<Integer> userSequence = new ArrayList<>();
            int totalNumbers = memoryGame.getNumberSequence().size();
            System.out.println("Re-enter the numbers in the same order:");

            while (userSequence.size() < totalNumbers) {
                try {
                    System.out.print("Number " + (userSequence.size() + 1) + ": ");
                    userSequence.add(scanner.nextInt());
                } catch (InputMismatchException e) {
                    System.out.println("Invalid entry. Please input an integer.");
                    scanner.next(); 
                }
            }
            return userSequence;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameUI gameUI = new GameUI();
        boolean keepPlaying = true;

        while (keepPlaying) {
            System.out.println("1. Start the challenge");
            System.out.println("2. Exit the game");
            System.out.print("Your choice: ");
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    gameUI.startGame();
                    break;
                case 2:
                    System.out.println("Thanks for playing. Goodbye!");
                    keepPlaying = false;
                    break;
                default:
                    System.out.println("Invalid option. Choose 1 to start or 2 to exit.");
            }
        }

        scanner.close();
    }
}
