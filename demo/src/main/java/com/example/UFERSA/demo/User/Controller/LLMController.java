package com.example.UFERSA.demo.User.Controller;


import com.example.UFERSA.demo.User.Models.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
public class LLMController {

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
        // Em uma aplicação real, isso buscaria de um banco de dados.
        // Para este exemplo, retornamos uma mensagem padrão.
        return ResponseEntity.ok(new Message(id, "GET: Esta é uma mensagem padrão."));
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        // Retornando uma lista padrão.
        List<Message> messages = List.of(
                new Message(1L, "GET ALL: Primeira mensagem."),
                new Message(2L, "GET ALL: Segunda mensagem.")
        );
        return ResponseEntity.ok(messages);
    }

    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message newMessage) {
        // Em uma aplicação real, você salvaria a newMessage e ela obteria um novo ID.
        // Simularemos isso criando um novo objeto com um ID fixo.
        Message createdMessage = new Message(99L, "POST: " + newMessage.content());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdMessage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable Long id, @RequestBody Message updatedMessage) {
        // Em uma aplicação real, você encontraria o recurso pelo 'id' e o atualizaria.
        // Simularemos isso retornando uma nova mensagem incorporando ambos.
        Message responseMessage = new Message(id, "PUT: " + updatedMessage.content());
        return ResponseEntity.ok(responseMessage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        // Em uma aplicação real, você excluiria o recurso com o 'id' fornecido.
        // Em caso de sucesso, retornamos uma resposta sem corpo.
        return ResponseEntity.noContent().build();
    }

}
