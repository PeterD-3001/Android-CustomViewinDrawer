package be.teknyske.customviewindrawer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by cerseilannister on 13/10/16.
 */

public class RealDolmenView extends View {

    private int squareColor;
    private int labelColor;
    private String squareText;

    private Paint squarePaint;

    public RealDolmenView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        squarePaint = new Paint();
        TypedArray styledAttributes = context.getTheme().obtainStyledAttributes
                (attrs,
                R.styleable.RealDolmenView,
                0,
                0);

        squareText = styledAttributes.getString(R.styleable.RealDolmenView_squareLabel);
        squareColor = styledAttributes.getInteger(R.styleable.RealDolmenView_squareColor, 0);
        labelColor = styledAttributes.getInteger(R.styleable.RealDolmenView_labelColor,0);
        styledAttributes.recycle();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        squarePaint.setStyle(Paint.Style.FILL);
        squarePaint.setAntiAlias(true);
        squarePaint.setColor(squareColor);
        canvas.drawRect(0,0,this.getMeasuredWidth(),this.getMeasuredHeight(), squarePaint);

        squarePaint.setColor(labelColor);
        squarePaint.setTextAlign(Paint.Align.CENTER);
        squarePaint.setTextSize(50);
        canvas.drawText (squareText, this.getMeasuredWidth()/2,this.getMeasuredHeight()/2, squarePaint);

    }

    public int getSquareColor() {
        return squareColor;
    }

    public void setSquareColor(int squareColor) {
        this.squareColor = squareColor;
        // bij wijziging kleur tekening invalidateneen redraw forceren
        invalidate();
        requestLayout();
    }

    public int getLabelColor() {
        return labelColor;
    }

    public void setLabelColor(int labelColor) {
        this.labelColor = labelColor;
        invalidate();
        requestLayout();
    }

    public String getSquareText() {
        return squareText;
    }

    public void setSquareText(String squareText) {
        this.squareText = squareText;
        invalidate();
        requestLayout();
    }

    public Paint getSquarePaint() {
        return squarePaint;
    }

    public void setSquarePaint(Paint squarePaint) {
        this.squarePaint = squarePaint;
        invalidate();
        requestLayout();
    }
}


