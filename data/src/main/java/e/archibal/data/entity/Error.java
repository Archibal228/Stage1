package e.archibal.data.entity;

import java.util.concurrent.Executor;

/**
 * Created by Archibal on 02.04.2018.
 */

public class Error extends Exception {

    private ErrorType friendlyError;

    public Error(ErrorType friendlyError) {
        this.friendlyError = friendlyError;
    }

    public ErrorType getFriendlyError() {
        return friendlyError;
    }
}
