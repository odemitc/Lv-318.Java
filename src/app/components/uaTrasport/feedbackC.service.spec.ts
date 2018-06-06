import { TestBed, inject } from '@angular/core/testing';

import { FeedbackCService } from './feedbackC.service';

describe('FeedbackCService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FeedbackCService]
    });
  });

  it('should be created', inject([FeedbackCService], (service: FeedbackCService) => {
    expect(service).toBeTruthy();
  }));
});
