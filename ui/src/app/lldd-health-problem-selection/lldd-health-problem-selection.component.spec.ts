import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LlddHealthProblemSelectionComponent } from './lldd-health-problem-selection.component';

describe('LlddHealthProblemSelectionComponent', () => {
  let component: LlddHealthProblemSelectionComponent;
  let fixture: ComponentFixture<LlddHealthProblemSelectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LlddHealthProblemSelectionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LlddHealthProblemSelectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
