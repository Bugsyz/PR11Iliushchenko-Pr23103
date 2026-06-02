import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import com.example.pr11.R;

public class SpaceView extends View {
    private final Paint mPaint = new Paint();
    private final Rect mRect = new Rect();
    private Bitmap mBitmap;

    public SpaceView(Context context) {
        super(context);
        Resources res = this.getResources();
        mBitmap = BitmapFactory.decodeResource(res, R.drawable.rocket);
        if (mBitmap == null) {
            android.util.Log.e("SpaceView", "Не удалось загрузить изображение rocket.png");
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLACK);
        canvas.drawPaint(mPaint);

        mPaint.setColor(Color.WHITE);
        for (int i = 0; i < 100; i++) { // 100 звёзд
            float x = (float) (Math.random() * width);
            float y = (float) (Math.random() * height);
            canvas.drawPoint(x, y, mPaint);
        }

        mPaint.setColor(Color.RED);
        canvas.drawCircle(width / 4f, height / 2f, 40, mPaint);

        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(3 * width / 4f, height / 3f, 50, mPaint);

        mPaint.setColor(Color.YELLOW);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        canvas.drawCircle(width / 2f, 2 * height / 3f, 60, mPaint);
        canvas.drawCircle(width / 2f, 2 * height / 3f, 65, mPaint);
        canvas.drawCircle(width / 2f, 2 * height / 3f, 70, mPaint);

        mPaint.setColor(Color.CYAN);
        mPaint.setTextSize(36);
        mPaint.setStyle(Paint.Style.FILL);
        String text = "Космос ждёт нас!";
        float textX = width / 2f - mPaint.measureText(text) / 2f;
        float textY = height - 50;
        canvas.drawText(text, textX, textY, mPaint);

        if (mBitmap != null) {
            canvas.drawBitmap(mBitmap, width - mBitmap.getWidth(), height - mBitmap.getHeight() - 160, mPaint);
        } else {
            mPaint.setColor(Color.RED);
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawRect(width - 60, height - 60, width, height, mPaint);
        }
    }

    public Rect getmRect() {
        return mRect;
    }
}