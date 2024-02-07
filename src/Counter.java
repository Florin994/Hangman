public class Counter {
    private int maxLives;

    public Counter(int maxLives) {
        this.maxLives = maxLives;
    }

    public int getMaxLives() {
        return this.maxLives;
    }

    public void decreaseLives() {
        this.maxLives--;
    }

    public void printGame() {
        if (getMaxLives() == 5) {
            System.out.println(" ______________");
            System.out.println("| _____________|");
            System.out.println("| | /");
            System.out.println("| |/");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |       \\//\\//");
            System.out.println("| |_______///\\\\\\__");
            System.out.println("|_________________|");
            System.out.println("You have 5 tries left.");
        } else if (getMaxLives() == 4) {
            System.out.println(" ______________");
            System.out.println("| _____________|");
            System.out.println("| | /       |");
            System.out.println("| |/");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |       \\//\\//");
            System.out.println("| |_______///\\\\\\__");
            System.out.println("|_________________|");
            System.out.println("You have 4 tries left.");
        } else if (getMaxLives() == 3) {
            System.out.println(" ______________");
            System.out.println("| _____________|");
            System.out.println("| | /       |");
            System.out.println("| |/      (~_~)");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |       \\//\\//");
            System.out.println("| |_______///\\\\\\__");
            System.out.println("|_________________|");
            System.out.println("You have 3 tries left.");
        } else if (getMaxLives() == 2) {
            System.out.println(" ______________");
            System.out.println("| _____________|");
            System.out.println("| | /       |");
            System.out.println("| |/      (~_~)");
            System.out.println("| |\t     \\     /");
            System.out.println("| |       \\   /");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |       \\//\\//");
            System.out.println("| |_______///\\\\\\__");
            System.out.println("|_________________|");
            System.out.println("You have 2 tries left.");
        } else if (getMaxLives() == 1) {
            System.out.println(" ______________");
            System.out.println("| _____________|");
            System.out.println("| | /       |");
            System.out.println("| |/      (~_~)");
            System.out.println("| |\t     \\     /");
            System.out.println("| |       \\ | /");
            System.out.println("| |\t        |");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |");
            System.out.println("| |       \\//\\//");
            System.out.println("| |_______///\\\\\\__");
            System.out.println("|_________________|");
            System.out.println("You have one more try left.");
        } else if (getMaxLives() == 0) {
            System.out.println(" ______________");
            System.out.println("| _____________|");
            System.out.println("| | /       |");
            System.out.println("| |/      (~_~)");
            System.out.println("| |\t     \\     /");
            System.out.println("| |       \\ | /");
            System.out.println("| |\t        |");
            System.out.println("| |\t      /   \\");
            System.out.println("| |      /     \\");
            System.out.println("| |");
            System.out.println("| |       \\//\\//");
            System.out.println("| |_______///\\\\\\__");
            System.out.println("|_________________|");
            System.out.println();
        }
    }
}

