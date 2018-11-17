public class Progress {

	// この辺の値は要調整
	private static final int playerCache = 100000;
	private static final int dealerCache = 100000;

	public static void main(String args[]) {
		Player player = new Player(new Wallet(playerCache));
		Dealer dealer = new Dealer(new Wallet(dealerCache));

		while (!(player.getWallet().isInsolvency() && dealer.getWallet().isInsolvency())) {
			Table table = new Table();
			table.setVisible(true); // Windowを開く
			try { // 制限時間まで待っている
				Thread.sleep(5 * 1000);
			} catch (InterruptedException e) {
			}

			table.setLock(true); // 制限時間が来たら，もう選択できない
			System.out.println("setLock(t) = " + table.getLock());

			try {
				Thread.sleep(5 * 1000);
			} catch (InterruptedException e) {
			}

			Roulette roulette = new Roulette();

			int stopAddress = roulette.getIntRouletteValue();
			Ball ball = new Ball(stopAddress);
			// Payment.calc(player, stopAddress);
			// Payment.calc(dealer, stopAddress);

			player.getCoin();
			dealer.getCoin();

			System.out.println(player.getCoin());
			System.out.println(dealer.getCoin());
		}
		// 7. 終了
		System.out.println("END");
		System.exit(0);

	}
}