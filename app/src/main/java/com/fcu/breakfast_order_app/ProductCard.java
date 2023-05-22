package com.fcu.breakfast_order_app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProductCard extends LinearLayout {
    private ImageView productImage;
    private TextView productName;
    private TextView productPrice;

    public ProductCard(Context context) {
        super(context);
        init(context);
    }

    public ProductCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ProductCard(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.product_card, this);

        productImage = findViewById(R.id.productImage);
        productName = findViewById(R.id.productName);
        productPrice = findViewById(R.id.productPrice);
    }

    public void setProductImage(int resId) {
        productImage.setImageResource(resId);
    }

    public void setProductName(String name) {
        productName.setText(name);
    }

    public void setProductPrice(int price) {
        productPrice.setText("NT " + price);
    }
}
