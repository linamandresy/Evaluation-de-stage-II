import { TestBed } from '@angular/core/testing';

import { MajorationService } from './majoration.service';

describe('MajorationService', () => {
  let service: MajorationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MajorationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
