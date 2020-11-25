package com.progweb.demo.data;



import com.progweb.demo.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface MessageDAO extends JpaRepository<Message,Long> {
}
