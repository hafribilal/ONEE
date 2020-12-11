package ma.onee.electrique.ui.reloadSubscription;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ma.onee.electrique.R;

public class ReloadSubscriptionFragment extends Fragment {

    private ReloadSubscriptionViewModel reloadSubscriptionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        reloadSubscriptionViewModel =
                ViewModelProviders.of(this).get(ReloadSubscriptionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_reload_subscription, container, false);
//        final TextView textView = root.findViewById(R.id.text_gallery);
//        reloadSubscriptionViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

       return root;
    }

}
