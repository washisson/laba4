import java.util.Objects;

public class Human extends Humanoid implements AbleToUseMoneybox, Buyable {
	private Moneybox moneybox;
	private Market market;
	private Wallet wallet = new Wallet();

	private class Wallet{

		private int money = 0;
		public void addMoney(int money){
			this.money += money;
		}

		public void addCoin(Coin coin){
			money += coin.getNominal();
		}

		public int getMoney(){
			int m = money;
			money = 0;
			return m;
		}

	}
	public Human(){
		this("NoName");
	}

	public Human(String name){
		this.name = name;
	}

//	public Human(String name, int money){}
	@Override
	public void takeMoneybox(Moneybox moneybox) {
		if(moneybox != null)
			this.moneybox = moneybox;
		else
			say("Я не могу взять несуществующую копилку!");
	}

	@Override
	public void takeCoinFromMoneybox() {
		Coin coin = moneybox.getCoin();
		say("Я достал монету " + coin);
		wallet.addCoin(coin);
	}

	@Override
	public void takeAllCoinsFromMoneybox() {
		while (!moneybox.empty()){
			takeCoinFromMoneybox();
		}
	}

	@Override
	public void addCoinToMoneybox(Coin coin) {
		moneybox.addCoin(coin);
	}

	@Override
	public void goToMarket(Market market) {
		this.market = market;
	}

	@Override
	public Item buy(String itemName) throws BuyingException {
		Item item;
		market.takeMoney(wallet.getMoney());
		item = market.sellItem(itemName);
		wallet.addMoney(market.getChange());
		say("я купил " + item);
		return item;
	}

	@Override
	public String toString() {
		return "Человек " + name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Human human = (Human) o;
		return Objects.equals(moneybox, human.moneybox);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), moneybox);
	}
}
