public enum Coin {
	ER5 (5),
	ER10 (10),
	ER25 (25);

	private final int nominal;

	Coin(int i) {
		nominal = i;
	}

	public static Coin getCoinOfNominal(int nominal){
		for(Coin coin: Coin.values()){
			if(coin.getNominal() == nominal)
				return coin;
		}
		throw new RuntimeException("Монеты с номиналом " + nominal + " эре нет.");
	}

	public int getNominal(){
		return nominal;
	}

	@Override
	public String toString(){
		return nominal + " эре";
	}
}
