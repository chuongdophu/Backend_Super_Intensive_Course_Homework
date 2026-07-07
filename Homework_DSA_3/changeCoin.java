public class changeCoin {
    public static void main(String[] args) {
        int money = 33;

        int totalCoins = changeCoins(money);

        System.out.println("Your money: " + money + ", the total change coin is: " + totalCoins);
    }

    public static int changeCoins(int money) {
        int[] coins = { 20, 10, 5, 1 };
        int coinCount = 0;

        System.out.println("--- THE DETAIL OF COINS ---");
        for (int coin : coins) {
            if (money == 0)
                break;

            int count = money / coin;

            if (count > 0) {
                System.out.println("Coin $" + coin + " K: " + count + " coins");
            }

            coinCount += count;
            money %= coin;
        }
        System.out.println("\n--- THE TOTAL COINS ---");
        System.out.println("Total coins: " + coinCount);

        return coinCount;
    }
}