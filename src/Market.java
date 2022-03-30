public class Market {
	private int buyerMoney;

	AbleToBeItemList itemList = new AbleToBeItemList() {

		private final int MAXSIZE = 100;
		private int size = 0;
		Item [] items = new Item[MAXSIZE];
		int [] counts = new int[MAXSIZE];
		public void addItem(Item item, int count){
			int i;
			for(i = 0; i < size && items[i].getName() != item.getName(); ++ i){}
			if(i < size){
				counts[i] += count;
			}
			else if(i < MAXSIZE){
				size ++;
				items[i] = new Item(item.getName(), item.getPrice());
				counts[i] = count;
			}
			else
				throw new AddingException("Список товаров полон");
		}

		public void  addItem(Item item){
			addItem(item, 1);
		}

		public int getCountOfItemByIndex(int i){
			return counts[i];
		}

		public int findItem(String itemName) throws BuyingException {
			int i;
			for(i = 0; i < size && items[i].getName() != itemName; ++ i){}
			if(i < size)
				return i;
			throw new BuyingException("Нет такого товара");
		}

		public int getItemPrice (int index){
			return items[index].getPrice();
		}

		public Item getItem (int index){
			counts[index] --;
			return items[index];
		}
	};

	public void addItemToList (Item item, int count){
		itemList.addItem(item, count);
	}
	public void  addItemToList(Item item){
		itemList.addItem(item);
	}

	public Item sellItem(String itemName) throws BuyingException {
		int itemIndex = itemList.findItem(itemName);
		Item item;
		if(itemList.getCountOfItemByIndex(itemIndex) < 1)
			throw new BuyingException("Товар закончился");
		if(itemList.getItemPrice(itemIndex) > buyerMoney)
			throw new BuyingException("Недостаточно денег");
		item = itemList.getItem(itemIndex);
		buyerMoney -= item.getPrice();
		return item;
	}

	public void takeMoney(int money){
		buyerMoney = money;
	}

	public int getChange(){
		int change = buyerMoney;
		buyerMoney = 0;
		return change;
	}
}
