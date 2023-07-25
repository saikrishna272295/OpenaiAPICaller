package com.sai.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sai Krishna
 *
 * All rights preserved.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatResponse {
	
	private List<Choice> choices;

    // constructors, getters and setters
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Choice {

        private int index;
        private Message message;

        // constructors, getters and setters
    }
}
