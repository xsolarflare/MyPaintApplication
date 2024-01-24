package com.example.mypaintapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.mypaintapplication.R;

public class MyView extends View {

    private Paint paint;
    private float x, y;
    private Path path;
    private Map<Path, Paint> pathMap;
    private short radius;
    private short width;


    public MyView(Context context) {
        super(context);
        init();

    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    private void init() {
        x = 300;
        y = 150;
        radius = 30;
        width = 20;

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(width);
        paint.setStyle(Paint.Style.STROKE);

        path = new Path();
        path.setLastPoint(0, 0);
        pathMap = new HashMap<>();
        pathMap.put(path, paint);

    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        //super.onDraw(canvas);

        canvas.drawColor(getResources().getColor(R.color.dark));

       for (Map.Entry<Path, Paint> entry: pathMap.entrySet()) {
           canvas.drawPath(entry.getKey(), entry.getValue());
       }

        canvas.drawCircle( x, y, radius, paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        x = event.getX();
        y = event.getY();

        path.lineTo(x, y);

        invalidate();
        return true;
    }

    public void setPaint(int color) {
        paint = new Paint();

        paint.setStrokeWidth(width);
        paint.setStyle(Paint.Style.STROKE);

        paint.setColor(color);

        path = new Path();
        path.setLastPoint(x, y);
        pathMap.put(path, paint);

        //invalidate();
    }

    /*public void cancelLastPath() {
        pathMap.remove(path);
    }*/

}
