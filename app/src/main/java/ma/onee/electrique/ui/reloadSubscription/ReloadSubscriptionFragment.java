package ma.onee.electrique.ui.reloadSubscription;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ma.onee.electrique.PaymentFragment;
import ma.onee.electrique.R;

public class ReloadSubscriptionFragment extends Fragment {

    private ReloadSubscriptionViewModel reloadSubscriptionViewModel;
    Button btn_Next2PaymentFromReloadSubs;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        reloadSubscriptionViewModel =
                ViewModelProviders.of(this).get(ReloadSubscriptionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_reload_subscription, container, false);
        btn_Next2PaymentFromReloadSubs = root.findViewById(R.id.btn_Next2PaymentFromReloadSubs);
//        final TextView textView = root.findViewById(R.id.text_gallery);
//        reloadSubscriptionViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        btn_Next2PaymentFromReloadSubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new PaymentFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_reload_subscription, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
       return root;
    }

}
