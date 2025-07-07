import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PollComponent } from './poll/poll.component';

@Component({
  selector: 'app-root',
  imports: [PollComponent],
  templateUrl: './app.html',
  // styleUrl: './app.css',
  standalone:true
})
export class App {
  protected title = 'poll-app';
}
