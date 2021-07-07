import { TestBed } from '@angular/core/testing';

import { FichePaieService } from './fiche-paie.service';

describe('FichePaieService', () => {
  let service: FichePaieService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FichePaieService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
