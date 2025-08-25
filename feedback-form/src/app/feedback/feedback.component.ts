import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-feedback',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
  ],
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css'],
})
export class FeedbackComponent {
  feedbackForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.feedbackForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      message: ['', [Validators.required, Validators.minLength(10)]],
    });
  }

  onSubmit() {
    if (this.feedbackForm.valid) {
      console.log('Feedback Submitted ✅', this.feedbackForm.value);
      alert('Thank you for your feedback!');
      this.feedbackForm.reset();
    }
  }
}