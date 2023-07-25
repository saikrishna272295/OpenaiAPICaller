import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ChatService {
  private apiUrl = 'http://localhost:9999/chat';

  constructor(private http: HttpClient) { }

  chat(prompt: string): Observable<string> {
    const params = new HttpParams().set('prompt', prompt);

    return this.http.get(this.apiUrl, { params: params, responseType: 'text' });
  }
}
