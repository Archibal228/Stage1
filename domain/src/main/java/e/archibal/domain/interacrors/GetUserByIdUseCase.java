package e.archibal.domain.interacrors;




import javax.inject.Inject;

import e.archibal.domain.entity.UserEntity;
import e.archibal.domain.executor.PostExecutionThread;
import e.archibal.domain.executor.ThreadExecutor;
import e.archibal.domain.repository.UserRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;



public class GetUserByIdUseCase extends BaseUseCase {
    private UserRepository userRepository;

    @Inject
    public GetUserByIdUseCase(PostExecutionThread postExecutionThread, UserRepository userRepository) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public Observable<UserEntity> get(String id) {
        return userRepository.getUser(id).subscribeOn(threadExecution).observeOn(postExecutionThread);
    }


}
