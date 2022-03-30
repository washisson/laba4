public interface Buyable {
	public void goToMarket(Market market);
	public Item buy(String itemName) throws Exception;
}
