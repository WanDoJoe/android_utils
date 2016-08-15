package com.utils.xutils.httpapi;

import com.yangfuhai.asimplecachedemo.R;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by Se7en_wan on 2016/4/28.
 */
public class CustomsWaitDialog extends Dialog {
    private TextView tv;

    public CustomsWaitDialog(Context context) {
        super(context, R.style.DialogTheme);
    }

    private CustomsWaitDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
        tv = (TextView) this.findViewById(R.id.tv);
        tv.setText("正在上传...");
        LinearLayout linearLayout = (LinearLayout) this.findViewById(R.id.LinearLayout);
        linearLayout.getBackground().setAlpha(210);
    }
}
