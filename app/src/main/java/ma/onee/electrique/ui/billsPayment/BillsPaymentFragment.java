package ma.onee.electrique.ui.billsPayment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import ma.onee.electrique.PaymentFragment;
import ma.onee.electrique.R;

public class BillsPaymentFragment extends Fragment {

    private BillsPaymentViewModel billsPaymentViewModel;
    Button btn_Next2PaymentFromBillsPay;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        billsPaymentViewModel =
                ViewModelProviders.of(this).get(BillsPaymentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_bills_payment, container, false);
        btn_Next2PaymentFromBillsPay = root.findViewById(R.id.btn_Next2PaymentFromBillsPay);

        btn_Next2PaymentFromBillsPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new PaymentFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_bills_payment, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
//        
        return root;
    }
}