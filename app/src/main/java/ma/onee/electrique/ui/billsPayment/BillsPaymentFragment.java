package ma.onee.electrique.ui.billsPayment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import ma.onee.electrique.R;

public class BillsPaymentFragment extends Fragment {

    private BillsPaymentViewModel billsPaymentViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        billsPaymentViewModel =
                ViewModelProviders.of(this).get(BillsPaymentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_bills_payment, container, false);
//        final TextView textView = root.findViewById(R.id.text_gallery);
//        billsPaymentViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}