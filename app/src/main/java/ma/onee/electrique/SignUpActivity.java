package ma.onee.electrique;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import ma.onee.electrique.ui.login.LoginActivity;

import static java.lang.Thread.sleep;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final RadioGroup rGroup_Gender = findViewById(R.id.rGroup_Gender);
        final EditText txt_LastName = findViewById(R.id.txt_LastName);
        final EditText txt_FirstName = findViewById(R.id.txt_FirstName);
        final EditText txt_Email = findViewById(R.id.txt_Email);
        final EditText txt_Password = findViewById(R.id.txt_Password);
        final EditText txt_ConfirmPassword = findViewById(R.id.txt_ConfirmPassword);
        final CheckBox cBox_Terms = findViewById(R.id.cBox_Terms);
        final Button signup_Submite = findViewById(R.id.signup_Submite);


        final TextView txt_SpannableTerms = findViewById(R.id.txt_SpannableTerms);
        ClickableSpan clickableSpan_terms = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(SignUpActivity.this, "Terms", Toast.LENGTH_SHORT).show();
            }
        };
        SpannableString ss = new SpannableString(txt_SpannableTerms.getText());
        ss.setSpan(clickableSpan_terms,0,txt_SpannableTerms.getText().length() , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txt_SpannableTerms.setText(ss);
        txt_SpannableTerms.setMovementMethod(LinkMovementMethod.getInstance());

        signup_Submite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gender(rGroup_Gender)!=null){
                    if (isValidEmail(txt_Email.getText()))
                    {
                        if (txt_Password.getText().toString().equals(txt_ConfirmPassword.getText().toString())){
                            if (cBox_Terms.isChecked()){
                                try {
                                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                                    Snackbar.make(v, "Confirmer votre email", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                    sleep(3000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(mainActivity);
                                //Complete and destroy signup activity once successful
                                String txt = gender(rGroup_Gender).getText().toString()+txt_LastName.getText()+" "+txt_FirstName.getText();
                                Toast.makeText(SignUpActivity.this, "Bonjour "+txt, Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            else {cBox_Terms.setChecked(true);}
                        }
                        else {Toast.makeText(SignUpActivity.this, "Confirmer le Mot de Pass", Toast.LENGTH_SHORT).show();txt_ConfirmPassword.setText("");}
                    }
                     else {Toast.makeText(SignUpActivity.this, "Invalide Email", Toast.LENGTH_SHORT).show();}
                }
                else {Toast.makeText(SignUpActivity.this, "Civilite", Toast.LENGTH_SHORT).show();}
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent loginActivity = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(loginActivity);
        finish();
    }
    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
    public RadioButton gender(RadioGroup rg)
    {
        return findViewById(rg.getCheckedRadioButtonId());
    }
}
