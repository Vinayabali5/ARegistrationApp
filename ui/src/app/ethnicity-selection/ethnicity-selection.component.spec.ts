import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EthnicitySelectionComponent } from './ethnicity-selection.component';

describe('EthnicitySelectionComponent', () => {
  let component: EthnicitySelectionComponent;
  let fixture: ComponentFixture<EthnicitySelectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EthnicitySelectionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EthnicitySelectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
