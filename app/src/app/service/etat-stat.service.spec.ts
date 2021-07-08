import { TestBed } from '@angular/core/testing';

import { EtatStatService } from './etat-stat.service';

describe('EtatStatService', () => {
  let service: EtatStatService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EtatStatService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
