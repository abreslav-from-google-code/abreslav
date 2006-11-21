package property;

public class Demo {

	static class Rectangle {
		
		public @Property int x;
		public @Property int y;
		public @Property int width;
		public @Property int height;
		public @ReadOnly @Property int square;
		
		public Rectangle(int x, int y, int w, int h) {
			this.x = x;
			this.y = y;
			width = w;
			height = h;
		}
		
		public int getSquare() {
			return width * height;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Rectangle(0, 0, 10, 20).square);
	}
	
}

