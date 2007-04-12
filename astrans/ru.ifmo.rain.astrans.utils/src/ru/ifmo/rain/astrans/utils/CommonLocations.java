/**
 * 
 */
package ru.ifmo.rain.astrans.utils;

enum CommonLocations implements DifferenceLocation {
	VALUE("Objects differ"), 
	VALUES("The same object is mapped to two or more different objects"), 
	CLASS("Classes differ"),
	LIST_LENGTH("List lengths differ"),
	DIFFERENT_FEATURES("Features in feature map differ");
	
	private final String comment;

	private CommonLocations(final String comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return comment;
	}
}