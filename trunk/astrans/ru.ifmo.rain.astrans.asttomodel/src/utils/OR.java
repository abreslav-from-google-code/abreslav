package utils;

public class OR {

	public static final class Result<T> {
		private T obj;

		public Result(T obj) {
			this.obj = obj;
		}

		public T getObj() {
			return obj;
		}
		
		public Result<T> or(T newObj) {
			if (obj == null) {
				obj = newObj;
			}
			return this;
		}
	}
	
	public static <T> Result<T> get(T obj) {
		return new Result<T>(obj);
	}
}
