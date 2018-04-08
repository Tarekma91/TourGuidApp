package com.example.tarek.tourguidapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InvitationActivity extends AppCompatActivity {


    @BindView(R.id.text_invitation)
    TextView textInvitation;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitation);
        ButterKnife.bind(this);
        textInvitation.setText(getString(R.string.text_invitation));


    }

    @OnClick(R.id.facebook_icon)
    public void onClickFacebookIcon() {
        Toast.makeText(getBaseContext(), getString(R.string.share_via_facebook), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.whatsapp_icon)
    public void onClickWhatsappIcon() {
        Toast.makeText(getBaseContext(), getString(R.string.share_via_whatsapp), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.gmail_icon)
    public void onClickGmailIcon() {
        Toast.makeText(getBaseContext(), getString(R.string.share_via_gmail), Toast.LENGTH_SHORT).show();
    }


}
