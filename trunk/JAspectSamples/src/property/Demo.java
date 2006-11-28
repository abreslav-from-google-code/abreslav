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
		
		public void setHeight(int height) {
			System.out.println("new height: " + height);
			this.height = height;
		}
	}
	
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(0, 0, 20, 20);
		rectangle.height = 10;
		rectangle.square = 0;
		System.out.println(new Rectangle(0, 0, 10, 20).square);
	}
	
}

