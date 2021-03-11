package com.example.kotlint.foundation;

import android.widget.Button;
import android.widget.TextView;

class JavaClassCompare {
    public static void main(String[] args) {
        Button[] buttons = new Button[2];
        TextView[] textViews = buttons;
    }
}
