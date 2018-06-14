import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MessageComponent } from './message.component';

describe('MessageComponent', () => {
  let component: MessageComponent;
  let fixture: ComponentFixture<MessageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
<<<<<<< HEAD:src/app/components/message/message.component.spec.ts
      declarations: [ MessageComponent ]
=======
      declarations: [FeedbackCriteriaComponent]
>>>>>>> aebec2c7317cfda80ae1fa7188997cd86cc0042c:src/app/components/feedback-criteria/feedback-criteria.component.spec.ts
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MessageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
