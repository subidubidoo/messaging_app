package com.example.ntl;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Signin extends Fragment {


    TextView t1, t2 , toSignupTv , emailerror , passerror;
    EditText edemail, edpass;
    Button btsignin ;
    String email , password ;

    public Signin() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_signin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        t1 = view.findViewById(R.id.t1);
        t2 = view.findViewById(R.id.t_password);
        edemail = view.findViewById(R.id.emailtext);
        edpass = view.findViewById(R.id.passwordtext);
        btsignin = view.findViewById(R.id.signinbt);
        toSignupTv = view.findViewById(R.id.toSignupTv);
        btsignin = view.findViewById(R.id.signinbt);
        edemail.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                t1.setTypeface(null, Typeface.BOLD);
                t2.setTextColor(Color.parseColor("#899499"));
            } else {
                t1.setTypeface(null, Typeface.NORMAL);
                t2.setTextColor(Color.parseColor("#FDFDFD"));
            }
        });

        edpass.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                t2.setTypeface(null, Typeface.BOLD);
                t1.setTextColor(Color.parseColor("#899499"));
            } else {
                t2.setTypeface(null, Typeface.NORMAL);
                t1.setTextColor(Color.parseColor("#FDFDFD"));
            }
        });
        emailerror = view.findViewById(R.id.erroremailtx);
        passerror = view.findViewById(R.id.errorpasstx);

        btsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password = edpass.getText().toString().trim();
                email = edemail.getText().toString().trim();
                if (true)
                {
                    if (email.length() == 0 || !email.contains("@") || email.length() < email.indexOf("@")+5)
                    {
                        emailerror.setVisibility(view.VISIBLE);
                    }
                    else { emailerror.setVisibility(view.INVISIBLE);}

                    if (password.length()<8)
                    {
                        passerror.setVisibility(view.VISIBLE);
                    }
                    else { passerror.setVisibility(view.INVISIBLE);}
                }
            }
        });
        toSignupTv.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, new Signup())
                    .addToBackStack(null)
                    .commit();
        });
    }
}