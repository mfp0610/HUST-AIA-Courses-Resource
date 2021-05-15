
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;


public class Sound extends Applet
                          implements ActionListener {
   
   
    String onceFile = "file:/d:/javaex/1.aif";
    String loopFile = "file:/d:/javaex/1.mid";
    AudioClip onceClip;
    AudioClip loopClip;

    Button playOnce;
    Button stopOnce;
    Button startLoop;
    Button stopLoop;
  

    boolean looping = false;
    boolean playing = false;

    public void init() {

        try{
              onceClip= getAudioClip(new URL(onceFile));
              loopClip = getAudioClip(new URL(loopFile));
        }catch(MalformedURLException e){
       
        }

        playOnce = new Button("Play aif");
        stopOnce = new Button("Stop aif");
        stopOnce.setEnabled(false);
        playOnce.addActionListener(this);
        add(playOnce);
        stopOnce.addActionListener(this) ;
        add(stopOnce);


    
        startLoop = new Button("Loop midi");
        stopLoop = new Button("Stop Loop");
        stopLoop.setEnabled(false);
        startLoop.addActionListener(this);
        add(startLoop);
        stopLoop.addActionListener(this);
        add(stopLoop);
    }
 

    public void stop() {
        if (playing) {
        onceClip.stop();        //暂停播放
        }
        if (looping) {
            loopClip.stop();    //暂停循环播放
        }
    }

    public void start() {
        if (playing)
        {
          onceClip.play();      //重新开始播放
        }
        if (looping) {
            loopClip.loop();    //重新开始循环播放
        }
    }

    public void actionPerformed(ActionEvent event) {

        Object source = event.getSource();
        //响应play Button事件
        if (source == playOnce) {
            
            if (onceClip != null) {
                playing = true;
    //            Thread t = new Thread(new t1());
   //             t.start();
                //播放音乐文件
                onceClip.loop();
                //play按钮变灰，stop按钮可用
                stopOnce.setEnabled(true);
                playOnce.setEnabled(false);
                showStatus("Playing sound " + onceFile + ".");
            } else {
                showStatus("Sound " + onceFile + " not loaded yet.");
            }
            return;
        }

    //响应stop Button事件
        if (source == stopOnce) {
            if (playing) {
                    playing = false;
                    //暂停播放
                    onceClip.stop();
                    //play按钮可用，stop按钮变灰
                    playOnce.setEnabled(true);
                    stopOnce.setEnabled(false);
                }
                showStatus("Stopped playing sound " + onceFile + ".");
                return;
            }



        //响应loop Button事件
        if (source == startLoop) {
           
            if (loopClip != null) {
                looping = true;
                //开始声音的循环播放
                loopClip.loop();
                //loop按钮可用，stop loop按钮变灰
                stopLoop.setEnabled(true);
                startLoop.setEnabled(false);
                showStatus("Playing sound " + loopFile + " continuously.");
            } else {
                showStatus("Sound " + loopFile + " not loaded yet.");
            }
            return;
        }

        //响应stop loop Button事件
        if (source == stopLoop) {
            if (looping) {
                looping = false;
                //停止声音的循环播放
                loopClip.stop();
                //loop按钮变灰，stop loop按钮可用
                startLoop.setEnabled(true);
                stopLoop.setEnabled(false);
            }
            showStatus("Stopped playing sound " + loopFile + ".");
            return;
        }

  
    }

}
