import { TestBed } from '@angular/core/testing';
import { LLDDHealthProblemService } from './lldd-health-problem.service.service';


describe('LLDDHealthProblemService', () => {
  let service: LLDDHealthProblemService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LLDDHealthProblemService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
