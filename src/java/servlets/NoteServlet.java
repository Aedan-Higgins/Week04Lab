/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Beans.Note;
/**
 *
 * @author 789648
 */
@WebServlet(name = "NoteServlet", urlPatterns = {"/NoteServlet"})
public class NoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        String path = getServletContext().getRealPath("/WEB-INF/note.txt"); // why did I put this out here? I don't know
        HttpSession session = request.getSession();
        if (session.getAttribute("note") == null) { // why do I do things
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            Note note = new Note(br.readLine(),br.readLine());
            session.setAttribute("note", note); // still not sure why I did this
            br.close();
        }
        if (request.getParameter("edit") == "") { // apparently comparing strings the normal way makes netbeans angry
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request,response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/shownote.jsp").forward(request,response);
        }
    } // this may look awful but infact it's actually is complete trash! wait..
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt"); // at least it makes more sense here
        PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter(path,false)));
        Note note = new Note((String)request.getParameter("title"),(String)request.getParameter("val"));
        pr.write(note.getTitle());
        pr.write(note.getMsg());
        pr.close();
        request.getSession().setAttribute("note",note); // all that session garbage for this, I still don't know what I achieved
        getServletContext().getRequestDispatcher("/WEB-INF/shownote.jsp").forward(request,response);
        
    }// I'm not sure if we're allowed to use sessions or not but in my infinite sleep deprived "wisdom" I have decided to

    @Override
    public String getServletInfo() {
        return "Servlet"; // yes
    }

}