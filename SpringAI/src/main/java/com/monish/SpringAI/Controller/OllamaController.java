package com.monish.SpringAI.Controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api")
public class OllamaController {
    private ChatClient chatClient;
    @Autowired
    private EmbeddingModel embeddingModel;

//    public OllamaController(OllamaChatModel chatModel) {
//        this.chatClient = ChatClient.create(chatModel);
//    }
    ChatMemory chatMemory= MessageWindowChatMemory.builder().build();
    public OllamaController(ChatClient.Builder builder){
        this.chatClient = builder.defaultAdvisors(MessageChatMemoryAdvisor
                                                    .builder(chatMemory)
                                                    .build())
                                    .build();
    }
    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){
        ChatResponse chatResponse=chatClient.prompt(message).call().chatResponse();
        System.out.println(chatResponse.getMetadata().getModel());
        String response = chatResponse.getResult().getOutput().getText();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/recommend")
    public String recommend(@RequestParam String type,@RequestParam int year,@RequestParam String lang){
        String temp = """
                I want to watch a {type} movie tonight with good rating,\s
                                looking  for movies around this year {year}.\s
                                The  language im looking for is {lang}.
                                Suggest one specific movie and tell me the cast and length of the movie.
                                response format should be:
                                                1. Movie Name
                                                2. basic plot
                                                3. cast
                                                4. length
                                                5. IMDB rating
                """;
        PromptTemplate promptTemplate=new PromptTemplate(temp);
        Prompt prompt=promptTemplate.create(Map.of("type",type,
                                                    "year",year,
                                                    "lang",lang));
        String response = chatClient
                            .prompt(prompt)
                            .call()
                            .content();
        return response;
    }
    @PostMapping("/embeddings")
    public float[] embeddings(@RequestParam String text){
        System.out.println("running");
        return embeddingModel.embed(text);
    }
}
