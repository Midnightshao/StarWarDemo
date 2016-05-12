package com.example.administrator.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/5/6.
 */
public class TextGame  extends View{
    private Bitmap mBitmap;
    private Matrix matrix;
    private Camera camera;
    private TextPaint textPaint;
    private String string="姓名：邵广昊   电话 ：13718118715 职业 android程序员 姓名：邵广昊   电话 ：13718118715 职业 android程序员 姓名：邵广昊   电话 ：13718118715 职业 android程序员 姓名：邵广昊   电话 ：13718118715 职业 android程序员 姓名：邵广昊   电话 ：13718118715 职业 android程序员 姓名：邵广昊   电话 ：13718118715 职业 android程序员 姓名：邵广昊   电话 ：13718118715 职业 android程序员 姓名：邵广昊   电话 ：13718118715 职业 android程序员 姓名：邵广昊   电话 ：13718118715 职业 android程序员 姓名：邵广昊   电话 ：13718118715 职业 android程序员 姓名：邵广昊   电话 ：13718118715 职业 android程序员 姓名：邵广昊   电话 ：13718118715 职业 android程序员 姓名：邵广昊   电话 ：13718118715 职业 android程序员 姓名：邵广昊   电话 ：13718118715 职业 android程序员 ";
    private String fontType="宋体";
    private Typeface typeface;

    //刷新数量
    private int i=0;
    //x轴转动的角度
    private int x=34;
    //y轴转动的角度
    private int y=0;
    //x轴转动的角度
    private int z=0;

    public TextGame(Context context) {
        super(context);
    }

    public TextGame(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        data();
    }
    public TextGame(Context context,int x,int y,int z,String content){
            super(context);
                this.string=content;
                this.x=x;
                this.y=y;
                this.z=z;
    }
    public void init(){
        camera=new Camera();
        matrix=new Matrix();
        textPaint=new TextPaint();
        typeface=Typeface.create(fontType,Typeface.BOLD);
        initBitMap(i);
    }
    public void data(){
        camera.rotateX(x);
        camera.rotateY(y);
        camera.rotateZ(z);
        camera.translate(0,-700,100);
    }
    public void initBitMap(int i){
        mBitmap=Bitmap.createBitmap(512,1024,Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(mBitmap);
        canvas.save();
        textPaint=new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.YELLOW);
        textPaint.setTextSize(40);
        textPaint.setTypeface(typeface);
        StaticLayout staticLayout=new StaticLayout(string,textPaint,mBitmap.getWidth(), Layout.Alignment.ALIGN_CENTER,1.0f,1.5f,false);
        canvas.translate(0,300-i);
        staticLayout.draw(canvas);
        canvas.restore();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        camera.save();
        camera.getMatrix(matrix);
        camera.restore();
        matrix.postTranslate(mBitmap.getWidth()/2+350,mBitmap.getHeight()/2);
        matrix.preTranslate(-mBitmap.getWidth()/2-60,-mBitmap.getHeight()/2);
        canvas.drawBitmap(mBitmap,matrix,null);
        i=i+1;
        initBitMap(i);
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        invalidate();
    }
}
