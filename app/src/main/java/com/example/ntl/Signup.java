package com.example.ntl;

import android.app.DatePickerDialog;
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

import java.util.Calendar;

public class Signup extends Fragment {

    EditText usernametext, emailtext, phonetext, dobtext, passwordtext, passwordtext2;
    Button signupbt;
    String username,email,phone,dob,pass,confirmPass;
    TextView temail , tpass1,tpass2,tdate,tname,tphone;
    TextView error1,error2,error3,error4,error5 , error6;

    public Signup() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        usernametext = view.findViewById(R.id.usernametext);
        emailtext = view.findViewById(R.id.emailtext);
        phonetext = view.findViewById(R.id.phonetext);
        dobtext = view.findViewById(R.id.dobtext);
        passwordtext = view.findViewById(R.id.passwordtext);
        passwordtext2 = view.findViewById(R.id.passwordtext2);
        signupbt = view.findViewById(R.id.signupbt);

        temail = view.findViewById(R.id.t_email);
        tpass1 = view.findViewById(R.id.t_password);
        tpass2= view.findViewById(R.id.t_password2);
        tdate = view.findViewById(R.id.t_dob);
        tname= view.findViewById(R.id.t_username);
        tphone   = view.findViewById(R.id.t_phone);


        dobtext.setOnClickListener(v -> {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    requireContext(),
                    (view1, year1, month1, dayOfMonth) -> {
                        String selectedDate = year1 + "-" + (month1 + 1) + "-" + dayOfMonth;
                        dobtext.setText(selectedDate);
                    },
                    year, month, day
            );
            datePickerDialog.show();

        });
        usernametext.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                tname.setTypeface(null, Typeface.BOLD);
                temail.setTextColor(Color.parseColor("#899499"));
                tpass1.setTextColor(Color.parseColor("#899499"));
                tpass2.setTextColor(Color.parseColor("#899499"));
                tdate.setTextColor(Color.parseColor("#899499"));
                tphone.setTextColor(Color.parseColor("#899499"));
            } else {
                tname.setTypeface(null, Typeface.NORMAL);
                temail.setTextColor(Color.parseColor("#FDFDFD"));
                tpass1.setTextColor(Color.parseColor("#FDFDFD"));
                tpass2.setTextColor(Color.parseColor("#FDFDFD"));
                tdate.setTextColor(Color.parseColor("#FDFDFD"));
                tphone.setTextColor(Color.parseColor("#FDFDFD"));
            }
        });
        emailtext.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                temail.setTypeface(null, Typeface.BOLD);
                tname.setTextColor(Color.parseColor("#899499"));
                tpass1.setTextColor(Color.parseColor("#899499"));
                tpass2.setTextColor(Color.parseColor("#899499"));
                tdate.setTextColor(Color.parseColor("#899499"));
                tphone.setTextColor(Color.parseColor("#899499"));
            } else {
                temail.setTypeface(null, Typeface.NORMAL);
                tname.setTextColor(Color.parseColor("#FDFDFD"));
                tpass1.setTextColor(Color.parseColor("#FDFDFD"));
                tpass2.setTextColor(Color.parseColor("#FDFDFD"));
                tdate.setTextColor(Color.parseColor("#FDFDFD"));
                tphone.setTextColor(Color.parseColor("#FDFDFD"));
            }
        });
        phonetext.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                tphone.setTypeface(null, Typeface.BOLD);
                temail.setTextColor(Color.parseColor("#899499"));
                tpass1.setTextColor(Color.parseColor("#899499"));
                tpass2.setTextColor(Color.parseColor("#899499"));
                tdate.setTextColor(Color.parseColor("#899499"));
                tname.setTextColor(Color.parseColor("#899499"));
            } else {
                tphone.setTypeface(null, Typeface.NORMAL);
                temail.setTextColor(Color.parseColor("#FDFDFD"));
                tpass1.setTextColor(Color.parseColor("#FDFDFD"));
                tpass2.setTextColor(Color.parseColor("#FDFDFD"));
                tdate.setTextColor(Color.parseColor("#FDFDFD"));
                tname.setTextColor(Color.parseColor("#FDFDFD"));
            }
        });
        passwordtext.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                tpass1.setTypeface(null, Typeface.BOLD);
                temail.setTextColor(Color.parseColor("#899499"));
                tname.setTextColor(Color.parseColor("#899499"));
                tpass2.setTextColor(Color.parseColor("#899499"));
                tdate.setTextColor(Color.parseColor("#899499"));
                tphone.setTextColor(Color.parseColor("#899499"));
            } else {
                tpass1.setTypeface(null, Typeface.NORMAL);
                temail.setTextColor(Color.parseColor("#FDFDFD"));
                tname.setTextColor(Color.parseColor("#FDFDFD"));
                tpass2.setTextColor(Color.parseColor("#FDFDFD"));
                tdate.setTextColor(Color.parseColor("#FDFDFD"));
                tphone.setTextColor(Color.parseColor("#FDFDFD"));
            }
        });
        passwordtext2.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                tpass2.setTypeface(null, Typeface.BOLD);
                temail.setTextColor(Color.parseColor("#899499"));
                tpass1.setTextColor(Color.parseColor("#899499"));
                tname.setTextColor(Color.parseColor("#899499"));
                tdate.setTextColor(Color.parseColor("#899499"));
                tphone.setTextColor(Color.parseColor("#899499"));
            } else {
                tpass2.setTypeface(null, Typeface.NORMAL);
                temail.setTextColor(Color.parseColor("#FDFDFD"));
                tpass1.setTextColor(Color.parseColor("#FDFDFD"));
                tname.setTextColor(Color.parseColor("#FDFDFD"));
                tdate.setTextColor(Color.parseColor("#FDFDFD"));
                tphone.setTextColor(Color.parseColor("#FDFDFD"));
            }
        });



        error1 = view.findViewById(R.id.errortx1);
        error2 = view.findViewById(R.id.errortx2);
        error3 = view.findViewById(R.id.errortx3);
        error4 = view.findViewById(R.id.errortx4);
        error5 = view.findViewById(R.id.errortx5);
        error6 = view.findViewById(R.id.errortx6);

        signupbt.setOnClickListener(v -> {
             username = usernametext.getText().toString().trim();
             email = emailtext.getText().toString().trim();
             phone = phonetext.getText().toString().trim();
             dob = dobtext.getText().toString().trim();
             pass = passwordtext.getText().toString().trim();
             confirmPass = passwordtext2.getText().toString().trim();

           if ( true)

            {   if (username.length() == 0)
                 {
                error1.setVisibility(view.VISIBLE);
                 }
                 else
                  {
                error1.setVisibility(view.INVISIBLE);
                  }


                if (email.length()==0 || !email.contains("@" )|| email.length() <= email.indexOf("@")+5)
                {
                    error2.setVisibility(view.VISIBLE);
                }
                else
                {
                    error2.setVisibility(view.INVISIBLE);
                }


                if (phone.length() <10 )
                {
                    error3.setVisibility(view.VISIBLE);
                }
                else
                {
                    error3.setVisibility(view.INVISIBLE);
                }


                if ( dob.length()==0)
                {
                    error4.setVisibility(view.VISIBLE);
                }
                else
                {
                    error4.setVisibility(view.INVISIBLE);
                }


                if (pass.length()<8 )
                {
                    error5.setVisibility(view.VISIBLE);
                }
                else
                {
                    error5.setVisibility(view.INVISIBLE);
                }


                if (confirmPass.length() <8 ||  !confirmPass.equals(pass) )
                {
                    error6.setVisibility(view.VISIBLE);
                }
                else
                {
                    error6.setVisibility(view.INVISIBLE);
                }

            }
           else { requireActivity().getSupportFragmentManager().popBackStack();}
        });

    }
}