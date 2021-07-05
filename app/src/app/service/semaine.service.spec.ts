import { TestBed } from '@angular/core/testing';

import { SemaineService } from './semaine.service';

describe('SemaineService', () => {
  let service: SemaineService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SemaineService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
