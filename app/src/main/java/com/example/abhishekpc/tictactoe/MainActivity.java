package com.example.abhishekpc.tictactoe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int myactiveplayer = 0;
    //0 for cross and 1 for circle
    //my game state
   int[] mygamestate= {2,2,2,2,2,2,2,2,2};
    int[][] winningLocations = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8},
            {2, 4, 6}};
    boolean gameOver = false;
    int scoreone=0;
    int scoretwo=0;

    public void imagetapped(View view) {

        ImageView mytapped = (ImageView) view;
        int tappedimagetag=Integer.parseInt(mytapped.getTag().toString());
        final TextView tv2=(TextView) findViewById(R.id.score2);
        final TextView tv1=(TextView) findViewById(R.id.score1);

        if (mygamestate[tappedimagetag] == 2) {
           mygamestate[tappedimagetag] = myactiveplayer;

            if (myactiveplayer == 0) {

                mytapped.setImageResource(R.drawable.x);
                mytapped.animate().rotation(360).setDuration(1000);
                myactiveplayer = 1;
            } else {
                mytapped.setImageResource(R.drawable.o);
                myactiveplayer = 0;
            }

    }else {
            Toast.makeText(getApplicationContext(), "hey, it's already played", Toast.LENGTH_SHORT).show();
        }
            String msg = "";
            for (int[] winningPosition : winningLocations) {

                if (mygamestate[winningPosition[0]] == mygamestate[winningPosition[1]]
                        && mygamestate[winningPosition[1]] == mygamestate[winningPosition[2]]
                        && mygamestate[winningPosition[0]] != 2) {


                    if (myactiveplayer == 0)

                    {

                       if (scoretwo==2) {
                           scoretwo++;
                           tv2.setText(String.valueOf(scoretwo));
                           MediaPlayer ring = MediaPlayer.create(MainActivity.this, R.raw.tada);
                           ring.start();
                           AlertDialog.Builder dialog = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));

                           dialog.setCancelable(false);
                           dialog.setTitle("Game Over");
                           dialog.setMessage("Player 2 is won...!!");
                           dialog.setPositiveButton("Quit", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialog, int id) {
                                   dialog.cancel();
                                   System.exit(0);


                               }
                           })
                                   .setNegativeButton("Reset", new DialogInterface.OnClickListener() {
                                       @Override
                                       public void onClick(DialogInterface dialog, int which) {

                                           for (int i=0; i < mygamestate.length; i++) {
                                               mygamestate[i] = 2;
                                           }
                                           scoreone=0;
                                           scoretwo=0;
                                           tv2.setText(String.valueOf(scoretwo));
                                           tv1.setText(String.valueOf(scoreone));
                                           reset(new View(getApplicationContext()));
                                           dialog.cancel();

                                       }
                                   });

                           final AlertDialog alert = dialog.create();
                           alert.show();
                       }
                       else {
                           scoretwo++;
                           tv2.setText(String.valueOf(scoretwo));
                       }


                        msg = "Player 2 Wins!";
                    }
                    if (myactiveplayer == 1) {

                        if (scoreone==2) {
                            scoreone++;
                            tv1.setText(String.valueOf(scoreone));
                            MediaPlayer ring = MediaPlayer.create(MainActivity.this, R.raw.tada);
                            ring.start();

                            AlertDialog.Builder dialog = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));

                            dialog.setCancelable(false);
                            dialog.setTitle("Game Over");
                            dialog.setMessage("Player 1 is won...!!");
                            dialog.setPositiveButton("Quit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    System.exit(0);
                                }
                            })
                                    .setNegativeButton("Reset", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                            reset(new View(getApplicationContext()));
                                        }
                                    });

                            final AlertDialog alert = dialog.create();
                            alert.show();
                        }
                        else {
                            scoreone++;
                            tv1.setText(String.valueOf(scoreone));
                        }
                        msg = "Player 1 Wins!";

                    }
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
                    gameOver = true;
                }
            }
        boolean emptySquare = false;
        for (int squareState : mygamestate) {
            if (squareState == 2) {
                emptySquare = true;
                break;
            }
        }

        if (!emptySquare && !gameOver) {
            msg="Drawn..!!!";
            gameOver = true;
            Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
        }

    }

    public void playagain(View view){

        //change game state back to 2
        for (int i=0; i < mygamestate.length; i++) {
            mygamestate[i] = 2;

        }
        //change all images to iclauncher
        myactiveplayer=0;
        ImageView whomwith = (ImageView)findViewById(R.id.imageView);
        whomwith.setImageResource(R.mipmap.ic_launcher);
        ImageView whomwith2 = (ImageView)findViewById(R.id.imageView2);
        whomwith2.setImageResource(R.mipmap.ic_launcher);
        ImageView whomwith3 = (ImageView)findViewById(R.id.imageView3);
        whomwith3.setImageResource(R.mipmap.ic_launcher);
        ImageView whomwith4 = (ImageView)findViewById(R.id.imageView4);
        whomwith4.setImageResource(R.mipmap.ic_launcher);
        ImageView whomwith5 = (ImageView)findViewById(R.id.imageView5);
        whomwith5.setImageResource(R.mipmap.ic_launcher);
        ImageView whomwith6 = (ImageView)findViewById(R.id.imageView6);
        whomwith6.setImageResource(R.mipmap.ic_launcher);
        ImageView whomwith7 = (ImageView)findViewById(R.id.imageView7);
        whomwith7.setImageResource(R.mipmap.ic_launcher);
        ImageView whomwith8 = (ImageView)findViewById(R.id.imageView8);
        whomwith8.setImageResource(R.mipmap.ic_launcher);
        ImageView whomwith9 = (ImageView)findViewById(R.id.imageView9);
        whomwith9.setImageResource(R.mipmap.ic_launcher);

//        LinearLayout linearlayout = (LinearLayout) findViewById(R.id.line1);
//        for (int i=0; i < linearlayout.getChildCount(); i++){
//            ((ImageView) linearlayout.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
//        }
//        LinearLayout linearlayout1 = (LinearLayout) findViewById(R.id.line2);
//        for (int i=0; i < linearlayout1.getChildCount(); i++){
//            ((ImageView) linearlayout1.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
//        }
//        LinearLayout linearlayout2 = (LinearLayout) findViewById(R.id.line3);
//        for (int i=0; i < linearlayout2.getChildCount(); i++){
//            ((ImageView) linearlayout2.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
//        }
    }
    public void reset(View view){
        playagain(new View(getApplicationContext()));
        scoreone=0;
        scoretwo=0;
        TextView tv1=(TextView) findViewById(R.id.score1);
        TextView tv2=(TextView) findViewById(R.id.score2);
        tv2.setText(String.valueOf(scoretwo));
        tv1.setText(String.valueOf(scoreone));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
