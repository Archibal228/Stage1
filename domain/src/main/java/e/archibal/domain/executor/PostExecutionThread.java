package e.archibal.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by Archibal on 16.03.2018.
 */
public interface PostExecutionThread {
     Scheduler getScheduler();
}
