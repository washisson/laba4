public class main {
	public static void main(String[] args) {
		Human malish = new Human("Малыш");
		HumanWthPropeller karlson = new HumanWthPropeller("Карлсон");
		Moneybox moneybox = new Moneybox();
		Market market = new Market();

		try {
			market.addItemToList(new Item("Леденец", 10), 10);
			market.addItemToList(new Item("Kit-Kat", 100), 1);
			market.addItemToList(new Item("Засахаренный орешек", 1), 500);
			market.addItemToList(new Item("Шоколадка", 50), 5);
		}catch (AddingException e){
			System.out.println(e.getMessage());
		}

		malish.say("Привет");
		karlson.say("Даров");

		for(int i = 0; i < 3; ++ i){
			moneybox.addCoin(Coin.ER5);
			moneybox.addCoin(Coin.ER25);
			moneybox.addCoin(Coin.ER10);
		}

		malish.takeMoneybox(moneybox);

		malish.takeAllCoinsFromMoneybox();

		malish.goToMarket(market);

		for(int i = 0; i < 5; ++ i) {
			try {
				malish.buy("Леденец");
			}
			catch (BuyingException e){
				System.out.println(e.getMessage());
				malish.say("У меня не вышло купить " + "Леденец");
			}
		}

		for(int i = 0; i < 25; ++ i) {
			try {
				malish.buy("Засахаренный орешек");
			}
			catch (BuyingException e){
				System.out.println(e.getMessage());
				malish.say("У меня не вышло купить " + "Засахаренный орешек");
			}
		}

		for(int i = 0; i < 2; ++ i) {
			try {
				malish.buy("Мороженое");
			}
			catch (BuyingException e){
				System.out.println(e.getMessage());
				malish.say("У меня не вышло купить " + "Мороженое");
			}
		}

		try {
			malish.buy("Шоколадка");
		}
		catch (BuyingException e){
			System.out.println(e.getMessage());
			malish.say("У меня не вышло купить " + "Шоколадка");
		}

	}
}
