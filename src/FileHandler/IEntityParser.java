package FileHandler;

public interface IEntityParser <E> {
	public E parse(String entity, String seperator);

}
