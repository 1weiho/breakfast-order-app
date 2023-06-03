package com.fcu.breakfast_order_app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProductPreview extends LinearLayout {

    private ImageView productImage;
    private TextView productName;
    private TextView productPrice;

    public ProductPreview(Context context) {
        super(context);
        init(context);
    }

    public ProductPreview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ProductPreview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.product_preview, this);

        productImage = findViewById(R.id.product_image);
        productName = findViewById(R.id.product_name);
        productPrice = findViewById(R.id.product_price);
    }

    public void setProductImage(int resId) {
        productImage.setImageResource(resId);
    }

    public void setProductName(String name) {
        productName.setText(name);
    }

    public void setProductPrice(String price) {
        productPrice.setText(price);
    }
}