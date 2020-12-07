package ma.onee.electrique.ui.billsPayment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BillsPaymentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BillsPaymentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}