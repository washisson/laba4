import java.util.Objects;

public abstract class Humanoid {
	protected String name;
	protected int x = 0, y = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void say(String words){
		System.out.println(name + ": " + words);
	}

	public void move(int x){
		this.x += x;
	}

	@Override
	public String toString() {
		return "Гуманоид " + name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Humanoid humanoid = (Humanoid) o;
		return x == humanoid.x && y == humanoid.y && Objects.equals(name, humanoid.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, x, y);
	}
}
