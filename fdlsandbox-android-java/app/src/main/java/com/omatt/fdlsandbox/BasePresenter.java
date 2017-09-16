package com.omatt.fdlsandbox;

/**
 * Created by omarmatthew on 6/27/17.
 */

public interface BasePresenter<T>{

    /**
     * Binds presenter with a view when resumed. The Presenter will perform initialization here.
     *
     * @param view the view associated with this presenter
     */
    void takeView(T view);

    /**
     * Drops the reference to the view when destroyed
     */
    void dropView();

}
