/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
/**
 *
 * @author 789648
 */
public class Note implements Serializable {
    private String title;
    private String msg;
    
    public Note() { // This never gets called so I don't even know why I bothered with the title
        this.title = "New Note"; 
        this.msg = "";
        
    } 
    public Note(String title, String msg) {
        this.title = title;
        this.msg = msg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String toString() {
        return "Note"; // yes
    }
}
