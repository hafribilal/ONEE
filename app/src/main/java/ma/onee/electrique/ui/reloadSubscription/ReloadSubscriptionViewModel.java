package ma.onee.electrique.ui.reloadSubscription;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReloadSubscriptionViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;

    public ReloadSubscriptionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Reload Subscription fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
