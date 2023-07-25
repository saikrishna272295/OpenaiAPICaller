package com.sai.dto;

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
public class Message {
	private String role;
	private String content;
}
