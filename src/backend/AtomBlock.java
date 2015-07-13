package backend;

public class AtomBlock {
	private int x;
	private int y;
	public AtomBlock(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isEqual(AtomBlock block2){
		return (block2.getX()==x && block2.getY()==y);
	}
}
