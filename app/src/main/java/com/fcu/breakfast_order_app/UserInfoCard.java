package com.fcu.breakfast_order_app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UserInfoCard extends LinearLayout {

    private ImageView UserProfileImage;
    private TextView UserName;
    private TextView UserPhone;
    private TextView pointCount;

    public UserInfoCard(Context context) {
        super(context);
        init(context);
    }

    public UserInfoCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public UserInfoCard(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.user_info_card, this);

        UserProfileImage = findViewById(R.id.userProfileImage);
        UserName = findViewById(R.id.userName);
        UserPhone = findViewById(R.id.userPhone);
        pointCount = findViewById(R.id.pointCount);
    }

    public void setUserProfileImage(int resId) {
        UserProfileImage.setImageResource(resId);
    }

    public void setUserName(String name) {
        UserName.setText(name);
    }

    public void setUserPhone(String phone) {
        UserPhone.setText(phone);
    }

    public void setPointCount(int point) {
        pointCount.setText(point + "點");
    }
}
