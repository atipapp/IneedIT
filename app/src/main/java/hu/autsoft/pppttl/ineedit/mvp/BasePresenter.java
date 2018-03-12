package hu.autsoft.pppttl.ineedit.mvp;

/**
 * Created by pppttl on 2018. 03. 12..
 */

public abstract class BasePresenter<V, I> {
    protected V view;
    protected I interactor;

    public void attachView(V view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

    public void attachInteractor(I interactor) {
        this.interactor = interactor;
    }

    public void detachInteractor() {
        this.interactor = null;
    }
}
