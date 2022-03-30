public class HumanWthPropeller extends Humanoid implements Flyable {

	public HumanWthPropeller(){
		this("NoName");
	}
	public HumanWthPropeller(String name){
		this.name = name;
	}
	@Override
	public void move(int x, int y) {
		this.move(x);
		this.y += y;
	}

	@Override
	public String toString() {
		return "Карлосообразный " + name;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}
}
