package domain.framework.ui.command;

public interface UICommand<T> {

    void execute(T uiCommandData);

}