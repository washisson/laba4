public interface AbleToBeItemList {
	public void addItem(Item item, int count);
	public void  addItem(Item item);
	public int findItem(String itemName) throws BuyingException;
	public int getCountOfItemByIndex(int i);
	public int getItemPrice (int index);
	public Item getItem (int index);
}
