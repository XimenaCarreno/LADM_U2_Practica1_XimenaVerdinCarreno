package mx.tecnm.tepic.ladm_u2_practica1

import android.R.attr.bitmap
import android.graphics.*
import android.os.CountDownTimer
import android.view.View


class Lienzo(p: MainActivity): View(p)
{
    var xC = 170f
    var yC = 200f

    var xC2 = 1100f
    var yC2 = 200f

    var calx1=-300f
    var caly1=1000f
    var incrementoX1 = 5
    var contador1=true

    var calx2=700f
    var caly2=800f
    var incrementoX2 = 5
    var contador2=1

    var imax=-125f
    var imay=-2000f
    var incrementoim=0.05f


    val iglesia = BitmapFactory.decodeResource(resources, R.drawable.church1)
    val tumba = BitmapFactory.decodeResource(resources, R.drawable.grave2)
    val cal1 = BitmapFactory.decodeResource(resources, R.drawable.calaveras1)
    val cal2 = BitmapFactory.decodeResource(resources, R.drawable.calaveras2)
    val imagen = BitmapFactory.decodeResource(resources, R.drawable.imagen)
    var rcal1=Bitmap.createScaledBitmap(cal1, 700 /*Ancho*/, 700 /*Alto*/, true /* filter*/)
    var rcal2=Bitmap.createScaledBitmap(cal2, 700 /*Ancho*/, 700 /*Alto*/, true /* filter*/)
    var rcalim=Bitmap.createScaledBitmap(imagen, 700 /*Ancho*/, 700 /*Alto*/, true /* filter*/)


    //Variable para el movimiento
    var trabajando=false

    //Timer de la animación
    val timer = object : CountDownTimer(200000, 20000){
        override fun onTick(millisUntilFinished: Long) {
            calx1+=incrementoX1
            if(calx1<=-700||calx1>=1200)
            {
                incrementoX1 *=-1
            }
        }
        override fun onFinish() {
            start()
        }
    }

    val timer2 = object : CountDownTimer(200000, 20000){
        override fun onTick(millisUntilFinished: Long) {
            calx2-=incrementoX2
            if(calx2<=-700||calx2>=1200)
            {
                incrementoX2 *=-1
            }
            invalidate()
        }
        override fun onFinish() {
            start()
        }
    }

    val timer3 = object : CountDownTimer(2000,100){
        override fun onTick(millisUntilFinished: Long) {
            imay+=incrementoim
            invalidate()
        }
        override fun onFinish() {
            start()
            if(incrementoim>100)
            {
                this.cancel()
            }
        }
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        val p= Paint()

        c.drawARGB(255, 3, 19, 79)

        //Cielo
        //Luna
        p.setColor(Color.argb(255, 199, 208, 248))
        c.drawCircle(600f, 200f, 200f, p)
        p.setColor(Color.argb(255, 3, 19, 79))
        c.drawCircle(750f, 150f, 200f, p)
        //Nube1
        p.setColor(Color.argb(255, 130, 130, 130))
        c.drawCircle(xC, yC, 80f, p)
        c.drawCircle(xC - 100, yC + 50, 80f, p)
        c.drawCircle(xC + 100, yC + 50, 80f, p)
        c.drawCircle(xC, yC + 50, 80f, p)
        p.setColor(Color.argb(255, 155, 155, 155))
        c.drawCircle(xC, yC + 50, 80f, p)
        c.drawCircle(xC - 90, yC + 100, 80f, p)
        c.drawCircle(xC + 90, yC + 100, 80f, p)
        c.drawCircle(xC, yC + 100, 80f, p)

        //Nube2
        p.setColor(Color.argb(255, 130, 130, 130))
        c.drawCircle(xC2, yC2, 80f, p)
        c.drawCircle(xC2 - 100, yC2 + 50, 80f, p)
        c.drawCircle(xC2 + 100, yC2 + 50, 80f, p)
        c.drawCircle(xC2, yC2 + 50, 80f, p)
        p.setColor(Color.argb(255, 155, 155, 155))
        c.drawCircle(xC2, yC2 + 50, 80f, p)
        c.drawCircle(xC2 - 90, yC2 + 100, 80f, p)
        c.drawCircle(xC2 + 90, yC2 + 100, 80f, p)
        c.drawCircle(xC2, yC2 + 100, 80f, p)

        //Nube3
        p.setColor(Color.argb(255, 130, 130, 130))
        c.drawCircle(xC + 100, yC + 100, 80f, p)
        c.drawCircle(xC, yC + 150, 80f, p)
        c.drawCircle(xC + 200, yC + 150, 80f, p)
        c.drawCircle(xC + 100, yC + 150, 80f, p)
        p.setColor(Color.argb(255, 155, 155, 155))
        c.drawCircle(xC + 100, yC + 150, 80f, p)
        c.drawCircle(xC + 10, yC + 200, 80f, p)
        c.drawCircle(xC + 200, yC + 200, 80f, p)
        c.drawCircle(xC + 100, yC + 200, 80f, p)

        //Nube4
        p.setColor(Color.argb(255, 130, 130, 130))
        c.drawCircle(xC2 - 200, yC2 + 150, 80f, p)
        c.drawCircle(xC2 - 300, yC2 + 200, 80f, p)
        c.drawCircle(xC2 - 100, yC2 + 200, 80f, p)
        c.drawCircle(xC2 - 200, yC2 + 200, 80f, p)
        p.setColor(Color.argb(255, 155, 155, 155))
        c.drawCircle(xC2 - 200, yC2 + 200, 80f, p)
        c.drawCircle(xC2 - 300, yC2 + 250, 80f, p)
        c.drawCircle(xC2 - 100, yC2 + 250, 80f, p)
        c.drawCircle(xC2 - 200, yC2 + 250, 80f, p)

        //Tierra
        p.setColor(Color.argb(255, 43, 5, 3))
        c.drawRect(700f, 1000f, 1080f, 1680f, p)//Camino derecho
        c.drawRect(0f, 1000f, 400f, 1680f, p)//Camino izquierdo

        p.setColor(Color.argb(200, 234, 162, 33))
        c.drawRect(400f, 1000f, 700f, 1680f, p)//camino de cempasuchil

        //Iglesia
        p.setColor(Color.argb(255, 20, 118, 36))
        c.drawBitmap(iglesia, 230f, 345f, p)


        //Arboles
        p.setColor(Color.argb(255, 127, 57, 20))
        c.drawRect(100f, 700f, 150f, 1100f, p)//Arbol1
        p.setColor(Color.argb(255, 13, 79, 24))
        c.drawOval(0f, 400f, 250f, 900f, p)
        p.setColor(Color.argb(108, 20, 118, 36))
        c.drawOval(50f, 450f, 200f, 890f, p)

        p.setColor(Color.argb(255, 127, 57, 20))
        c.drawRect(300f, 600f, 350f, 1000f, p)//Arbol2
        p.setColor(Color.argb(255, 13, 79, 24))
        c.drawOval(200f, 300f, 450f, 800f, p)
        p.setColor(Color.argb(108, 20, 118, 36))
        c.drawOval(250f, 350f, 400f, 790f, p)

        p.setColor(Color.argb(255, 127, 57, 20))
        c.drawRect(900f, 800f, 950f, 1150f, p)//Arbol5
        p.setColor(Color.argb(255, 13, 79, 24))
        c.drawOval(700f, 650f, 1200f, 950f, p)
        p.setColor(Color.argb(108, 20, 118, 36))
        c.drawOval(600f, 750f, 900f, 950f, p)
        c.drawOval(950f, 800f, 1150f, 1000f, p)

        p.setColor(Color.argb(108, 240, 240, 240))
        c.drawRect(0f, 900f, 1080f, 1150f, p)//niebla
        p.setColor(Color.argb(255, 240, 240, 240))

        //Tumbas
        c.drawBitmap(tumba, 230f, 1100f, p)
        c.drawBitmap(tumba, 0f, 1100f, p)
        c.drawBitmap(tumba, 150f, 1200f, p)
        c.drawBitmap(tumba, 30f, 1300f, p)
        c.drawBitmap(tumba, 200f, 1400f, p)

        c.drawBitmap(tumba, 930f, 1100f, p)
        c.drawBitmap(tumba, 700f, 1100f, p)
        c.drawBitmap(tumba, 850f, 1200f, p)
        c.drawBitmap(tumba, 730f, 1300f, p)
        c.drawBitmap(tumba, 900f, 1400f, p)

        //Esqueletos
        c.drawBitmap(rcal2,calx2,caly2,p)
        c.drawBitmap(rcal1,calx1,caly1,p)
        c.drawBitmap(imagen,imax,imay,p)

        timer.start()
        timer2.start()
        timer3.start()



    }
}