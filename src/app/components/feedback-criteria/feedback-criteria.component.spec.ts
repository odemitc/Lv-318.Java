import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FeedbackCriteriaComponent } from './feedback-criteria.component';

describe('FeedbackCriteriaComponent', () => {
  let component: FeedbackCriteriaComponent;
  let fixture: ComponentFixture<FeedbackCriteriaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [FeedbackCriteriaComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FeedbackCriteriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
