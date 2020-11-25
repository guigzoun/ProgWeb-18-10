package com.progweb.demo.web;



import com.progweb.demo.data.MessageDAO;
import com.progweb.demo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class Messagecontroller {

    @Autowired
    private MessageDAO messageDAO;

    @GetMapping("/msg")
    public String showMessage(Model model){
       // Cherche tout les messages
        model.addAttribute("msglist", messageDAO.findAll());

        model.addAttribute("newMessage", new Message() );



        return "MesgPage";
    }

    @PostMapping("/msg")
    public String getMessage(@ModelAttribute Message newMessage){
        Message msg = new Message(newMessage.getAutor(), newMessage.getMessages(), newMessage.getDate());
        messageDAO.save(msg);

        return "redirect:msg";
    }



}

//mapping get
//mettre une url /msg/delete?id= l'id
//supp le message avec l'id