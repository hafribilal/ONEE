package ma.onee.electrique.ui.consumptionHistory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConsumptionHistoryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ConsumptionHistoryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}