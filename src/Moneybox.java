import java.util.Stack;

public class Moneybox {
	private Humanoid user;
	private Stack <Coin> coins;

	public Moneybox(){
		coins = new Stack<>();
	}

	public void setUser(Humanoid user) {
		this.user = user;
	}

	public  String getUserName(){
		return user.getName();
	}

	public void addCoin(Coin coin){
		coins.add(coin);
	}

	public Coin getCoin(){
		if (!coins.empty()) {
			return coins.pop();
		}
		return null;
	}

	public boolean empty(){
		return coins.empty();
	}

	@Override
	public String toString() {
		if(user == null)
			return "Копилка с " + coins.size();
		return "Копилка с " + coins.size() + " монетами, хозяин которой - " + user.name;
	}
}
