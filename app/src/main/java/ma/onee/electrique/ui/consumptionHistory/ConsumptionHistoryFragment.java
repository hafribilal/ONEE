package ma.onee.electrique.ui.consumptionHistory;

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

public class ConsumptionHistoryFragment extends Fragment {

    private ConsumptionHistoryViewModel consumptionHistoryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        consumptionHistoryViewModel =
                ViewModelProviders.of(this).get(ConsumptionHistoryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_consumption_history, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        consumptionHistoryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}