package com.yu.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;  
import com.sun.image.codec.jpeg.JPEGImageDecoder;  
import com.sun.image.codec.jpeg.JPEGImageEncoder;  

public class ImageDemo {
	
	   /** 
     * @param args 
     * @throws ParseException  
     */  
    public static void main(String[] args) throws ParseException {  
    	//蓝，比分： 441,75，Color(225, 237, 251)  "Impact",Font.PLAIN,43
        exportImg2("2 1", "C:/temp/黑色背景图.jpg", null, 441, 75);  
    }  
      
    public static void exportImg2(String showText,String mainImg, String headImg, int x, int y){  
        try {  
            //1.jpg是你的 主图片的路径  
            InputStream is = new FileInputStream(mainImg);  
            //通过JPEG图象流创建JPEG数据流解码器  
            JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);  
            //解码当前JPEG数据流，返回BufferedImage对象  
            BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();  
            //得到画笔对象  
            Graphics g = buffImg.getGraphics();  
            if(headImg != null){
            	//创建你要附加的图象。  
            	//小图片的路径  
            	ImageIcon imgIcon = new ImageIcon(headImg);   
            	//得到Image对象。  
            	Image img = imgIcon.getImage();  
            	//将小图片绘到大图片上。  
            	//5,300 .表示你的小图片在大图片上的位置。  
            	g.drawImage(img,10,10,null);  
            }
            //设置颜色。  
            g.setColor(Color.BLACK);  
            //最后一个参数用来设置字体的大小  
            Font f = new Font("Impact",Font.PLAIN,43);  
            Color mycolor = new Color(225, 237, 251);  
            g.setColor(mycolor);  
            g.setFont(f);  
            //10,20 表示这段文字在图片上的位置(x,y) .第一个是你设置的内容。  
            g.drawString(showText,x,y);  
            g.dispose();  
            OutputStream os;  
            //os = new FileOutputStream("d:/union.jpg");  
            String shareFileName = "c:/temp/test00000" + System.currentTimeMillis() + ".jpg";  
            os = new FileOutputStream(shareFileName);  
             //创键编码器，用于编码内存中的图象数据。            
            JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);  
            en.encode(buffImg);           
            is.close();  
            os.close();  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (ImageFormatException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
    }  
}
