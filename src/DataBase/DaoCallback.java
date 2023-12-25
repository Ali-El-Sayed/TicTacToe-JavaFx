package DataBase;


public interface  DaoCallback<T> {
    void onSuccess(T results);
    void onFailure(Throwable throwable);
}
