package com.quotespot.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/quotes")
@CrossOrigin(origins = "*")
public class QuoteController {

    private final List<String> quotes = new ArrayList<>();

    // Constructor: preload some quotes
    public QuoteController() {
        quotes.add("Stay hungry, stay foolish – Steve Jobs");
        quotes.add("Code is like humor. When you have to explain it, it’s bad – Cory House");
        quotes.add("First, solve the problem. Then, write the code – John Johnson");
        quotes.add("ALL IZZ WELL -RANCHO");
        quotes.add("1 RANDOM QUOTE -R");
        quotes.add("2 RANDOM QUOTE -R");
        quotes.add("3 RANDOM QUOTE -R");
//        2 QUOTES ADDED ABOVE

    }

    // GET → return 5 random quotes
    @GetMapping
    public List<String> getRandomQuotes() {

        return new ArrayList<>(quotes);
    }

    // POST → add new quote
    @PostMapping
    public String addQuote(@RequestBody String quote) {

        if (quote == null || quote.trim().isEmpty()) {
            return "Quote cannot be empty";
        }

        quotes.add(quote.trim());

        return "Quote added successfully";
    }
}

