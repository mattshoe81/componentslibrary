package standard;

public interface Standard<T> {

    public void clear();

    public void transferFrom(T source);

    public T newInstance();
}
