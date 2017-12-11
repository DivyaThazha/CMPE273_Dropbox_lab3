package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class

public class Files {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String filename;

    private String imgname;

    private String username;

    private String parentfolder;

    private String filetype;

    private String img;

    public Files(String filename, String imgname, String username, String parentfolder, String filetype, String img) {
        this.filename = filename;
        this.imgname = imgname;
        this.username = username;
        this.parentfolder = parentfolder;
        this.filetype = filetype;
        this.img = img;
    }

    public Files() {
    }


    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public String getParentfolder() {
        return parentfolder;
    }

    public void setParentfolder(String parentfolder) {
        this.parentfolder = parentfolder;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }



}
