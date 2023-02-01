package com.example.playerinfovtp;

public class Model
{
  private String header;
  private String desc;
  private int imgname;
//  private int courtimg;
  private String tv3;
  private String tv4;
  private String tv5;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImgname() {
        return imgname;
    }

    public void setImgname(int imgname) {
        this.imgname = imgname;
    }
//    public int getCourtimg() {
//        return courtimg;
//    }
//
//    public void setCourtimg(int courtimg) {
//        this.courtimg = courtimg;
//    }

    public String getTv3() {
        return tv3;
    }

    public void setTv3(String tv3) {
        this.tv3 = tv3;
    }

    public String getTv4() {
        return tv4;
    }

    public void setTv4(String tv4) {
        this.tv4 = tv4;
    }

    public String getTv5() {
        return tv5;
    }

    public void setTv5(String tv5) {
        this.tv5 = tv5;
    }
}
