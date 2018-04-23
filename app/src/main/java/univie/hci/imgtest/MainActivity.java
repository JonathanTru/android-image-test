package univie.hci.imgtest;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Seat[] seats;
    private ImageView seatingChart;
    private TextView debug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seats = new Seat[]{
                new Seat(new Point(20, 20), new Point(90,70), "topLeft"),
                new Seat(new Point(100, 20), new Point(170, 70), "topRight"),
                new Seat(new Point(20, 90), new Point(90, 140), "bottomLeft")
        };

        debug = (TextView) this.findViewById(R.id.debug);
        seatingChart = (ImageView) this.findViewById(R.id.seatingChart);


        seatingChart.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                handleTouchOnImage(view, event);
                return true;
            }
        });
    }


    private void handleTouchOnImage(View view, MotionEvent event){
        int originalWidth = 228;
        int originalHeight = 248;
        // WARNING! older Android versions apparently gave the coordinates of the screen
        // and not the coordinates of the touch event on the image
        // scaling the coordinates based off of original size and display size
        int touchX = (int) event.getX() * originalWidth / seatingChart.getWidth();
        int touchY = (int) event.getY() * originalHeight / seatingChart.getHeight();

        Point touch = new Point(touchX, touchY);
        Seat clickedSeat = null;
        for(Seat s : seats){
            if( s.isWithinShape(touch)){
                clickedSeat = s;
            }
        }

        if( clickedSeat != null){
            Log.w("SeatInfo", "Seat got clicked! " + clickedSeat);
            debug.setText("you selected " + clickedSeat.getName());

        } else {
            Log.w("SeatInfo", "NO SEAT GOT CLICKED!");
        }
        Log.w("Info", "touchX " + touchX);
        Log.w("Info", "touchY " + touchY);
    }

}
