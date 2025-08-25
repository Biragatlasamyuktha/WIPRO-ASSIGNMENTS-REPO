import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  feedbackForm: FormGroup;
  submitted = false;

  constructor(private fb: FormBuilder) {
    this.feedbackForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      subject: ['', [Validators.required, Validators.minLength(5)]],
      comments: ['', [Validators.required, Validators.minLength(10)]]
    });
  }

  get f() {
    return this.feedbackForm.controls;
  }

  onSubmit() {
    this.submitted = true;
    if (this.feedbackForm.valid) {
      console.log(this.feedbackForm.value); // prints in console
      alert('Feedback submitted successfully!');
      this.feedbackForm.reset();
      this.submitted = false;
    }
  }
}