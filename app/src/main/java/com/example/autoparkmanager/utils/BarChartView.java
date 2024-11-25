package com.example.autoparkmanager.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class BarChartView extends View {

    private String[] labels;
    private int[] data;
    private Paint barPaint;
    private Paint textPaint;

    public BarChartView(Context context, String[] labels, int[] data) {
        super(context);
        this.labels = labels;
        this.data = data;

        barPaint = new Paint();
        barPaint.setColor(Color.BLUE);
        barPaint.setStyle(Paint.Style.FILL);

        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(36f);
        textPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (labels == null || data == null || labels.length != data.length) {
            canvas.drawText("No hay datos disponibles", 50, 50, textPaint);
            return;
        }

        int width = getWidth();
        int height = getHeight();

        int barWidth = width / (data.length * 2);
        int maxData = 0;

        for (int value : data) {
            if (value > maxData) {
                maxData = value;
            }
        }

        int x = barWidth;
        for (int i = 0; i < data.length; i++) {
            int barHeight = (int) ((data[i] / (float) maxData) * (height * 0.7));
            canvas.drawRect(x, height - barHeight, x + barWidth, height, barPaint);
            canvas.drawText(labels[i], x, height - barHeight - 10, textPaint);
            x += barWidth * 2;
        }
    }
}

