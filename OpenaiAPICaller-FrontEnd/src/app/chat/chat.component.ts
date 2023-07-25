import { Component } from '@angular/core';
import { ChatService } from '../chat.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent {
  prompt: string = '';
  response: string = '';

  constructor(private chatService: ChatService) { }

  sendPrompt(): void {
    if (!this.prompt.trim()) return;

    this.chatService.chat(this.prompt).subscribe(
      (response: string) => {
        this.response = response; // Set the response as plain text
      },
      (error: any) => {
        console.error('Error occurred while calling the API:', error);
      }
    );
  }
}
