
public aspect Demo {

	declare parents : (@Marker *) implements Mark;
	
	after() : execution(@Marker * DemoClass.*()) {
		
	}
}
