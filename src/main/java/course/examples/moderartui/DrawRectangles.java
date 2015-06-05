package course.examples.moderartui;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

/**
 * Class for creating and updating custom view
 */
public class DrawRectangles extends View {

    // declare variable for gradually changing color
    private int colorVal;

    public DrawRectangles(Context context, AttributeSet attributeSet)
    {
        super(context, attributeSet);
    }


    // draw custom view
    @Override
    protected void onDraw(Canvas canvas)
    {
        Paint paint = new Paint();
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();
        super.onDraw(canvas);
        int padding = canvas.getWidth()/50;
        paint.setColor(Color.MAGENTA - colorVal);
        canvas.drawRect(2 * padding, 2 * padding, canvasWidth / 2 - padding, canvasHeight / 2 - padding, paint);
        paint.setColor(Color.parseColor("teal") - colorVal);
        canvas.drawRect(canvasWidth / 3 + padding, canvasHeight / 2 + padding, 2 * canvasWidth / 3 - padding, canvasHeight - 10 * padding, paint);
        paint.setColor(Color.YELLOW - colorVal);
        canvas.drawRect(canvasWidth / 2 + padding, 2 * padding, canvasWidth - 2 * padding, canvasHeight/2 - padding, paint);
        paint.setColor(Color.WHITE);
        canvas.drawRect(2 * padding, canvasHeight / 2 + padding, canvasWidth / 3 - padding, canvasHeight - 10 * padding, paint);
        paint.setColor(Color.GREEN - colorVal);
        canvas.drawRect(2 * canvasWidth/3 + padding, canvasHeight/2 + padding, canvasWidth - 2 * padding, canvasHeight - 10 * padding, paint );
    }

    // use change color variable for updating custom view
    public void changeColor(int value)
    {
        colorVal = value;
        invalidate();
    }

}

