package start;

import models.facades.IModel;
import models.facades.ModelImpl;
import presenter.Presenter;
import views.exceptions.ViewException;
import views.facades.IView;
import views.facades.ViewConsoleImpl;

public class Main {

    public static void main(String[] args) throws ViewException {
        IModel model = new ModelImpl();
        IView view = new ViewConsoleImpl();

        Presenter presenteur = new Presenter(model, view);

        presenteur.start();
    }
}
