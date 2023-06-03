package com.fcu.breakfast_order_app;

import static java.lang.Integer.parseInt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CartItem extends LinearLayout {
    private int total = 0;
    private ImageView cartItemImage;
    private TextView cartItemName;
    private TextView cartItemPrice;
    private ImageButton cartItemMinus;
    private TextView cartItemNumber;
    private ImageButton cartItemPlus;
    private ImageView cartItemIcon;
    private TextView cartItemDelete;
    private LinearLayout delectProductBtn;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public CartItem(Context context) {
        super(context);
        init(context);
    }

    public CartItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CartItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.cart_item, this);

        cartItemImage = findViewById(R.id.cartItem_image);
        cartItemName = findViewById(R.id.cartItem_name);
        cartItemPrice = findViewById(R.id.cartItem_price);
        cartItemMinus = findViewById(R.id.cartItem_minus);
        cartItemNumber = findViewById(R.id.cartItem_number);
        cartItemPlus = findViewById(R.id.cartItem_plus);
        cartItemIcon = findViewById(R.id.cartItem_icon);
        cartItemDelete = findViewById(R.id.cartItem_delete);
        delectProductBtn = findViewById(R.id.delectProductBtn);

        cartItemPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count;
                count = Integer.parseInt(cartItemNumber.getText().toString());
                count++;
                cartItemNumber.setText(String.valueOf(count));
                updateTotalPriceForPlus();
            }
        });

        cartItemMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count;
                count = Integer.parseInt(cartItemNumber.getText().toString());
                if (count > 0) {
                    count--;
                    cartItemNumber.setText(String.valueOf(count));
                    updateTotalPriceForMinus();
                }
            }
        });

        delectProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteProduct();
            }
        });

    }

    public void setCartImage(int resId) {
        cartItemImage.setImageResource(resId);
    }

    public void setCartName(String name) {
        cartItemName.setText(name);
    }

    public void setCartPrice(int price) {
        cartItemPrice.setText("NT" + price);
    }

    public void setCartNumber(int number) {
        cartItemNumber.setText(String.valueOf(number));
    }

    public void updateTotalPriceForPlus() {
        CartPageActivity CartPageActivity = (CartPageActivity) getContext();
        CartPageActivity.total += Integer.parseInt(this.cartItemPrice.getText().toString().replace("NT", ""));
        CartPageActivity.cart_total_price.setText("總計:NT " + CartPageActivity.total);
    }

    public void updateTotalPriceForMinus() {
        CartPageActivity CartPageActivity = (CartPageActivity) getContext();
        CartPageActivity.total -= Integer.parseInt(this.cartItemPrice.getText().toString().replace("NT", ""));
        CartPageActivity.cart_total_price.setText("總計:NT " + CartPageActivity.total);
    }

    public void deleteProduct() {
        CartPageActivity CartPageActivity = (CartPageActivity) getContext();
        CartPageActivity.total -= Integer.parseInt(this.cartItemPrice.getText().toString().replace("NT", "")) * Integer.parseInt(this.cartItemNumber.getText().toString());
        CartPageActivity.cart_total_price.setText("總計:NT " + CartPageActivity.total);
        CartPageActivity.removeCartItem(this);
    }

}